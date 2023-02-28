package com.k1m743hyun.springsecurity.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.io.IOUtils;

import static com.k1m743hyun.springsecurity.util.XSSUtils.stripXSS;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    private byte[] rawData;
    private HttpServletRequest request;
    private ResettableServletInputStream servletStream;

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
        this.servletStream = new ResettableServletInputStream();
    }

    public void resetInputStream(byte[] newRawData) {
        servletStream.stream = new ByteArrayInputStream(newRawData);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader());
            servletStream.stream = new ByteArrayInputStream(rawData);
        }

        return servletStream;
    }

    @Override
    public BufferedReader getReader() throws IOException {

        if (rawData == null) {
            rawData = IOUtils.toByteArray(this.request.getReader());
            servletStream.stream = new ByteArrayInputStream(rawData);
        }

        return new BufferedReader(new InputStreamReader(servletStream));
    }

    private class ResettableServletInputStream extends ServletInputStream {

        private InputStream stream;

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener listener) {

        }
    }

    @Override
    public String[] getParameterValues(String parameter) {

        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }

        for (int i = 0; i < values.length; i++) {
            values[i] = stripXSS(values[i]);
        }

        return values;
    }

    @Override
    public String getParameter(String parameter) {
        return stripXSS(super.getParameter(parameter));
    }

    @Override
    public Enumeration getHeaders(String requestHeader) {

        List result = new ArrayList<>();

        Enumeration headers = super.getHeaders(requestHeader);
        while (headers.hasMoreElements()) {
            for (String token : headers.nextElement().toString().split(",")) {
                result.add(stripXSS(token));
            }
        }

        return Collections.enumeration(result);
    }
}
