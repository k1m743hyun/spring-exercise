package com.k1m743hyun.springsecurity.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.text.StringEscapeUtils;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter) {

        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }

        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
        }

        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        return StringEscapeUtils.escapeHtml4(super.getParameter(parameter));
    }

    @Override
    public Enumeration getHeaders(String name) {

        List result = new ArrayList<>();
        Enumeration headers = super.getHeaders(name);
        while (headers.hasMoreElements()) {
            String header = headers.nextElement().toString();
            String[] tokens = header.split(",");
            for (String token : tokens) {
                result.add(StringEscapeUtils.escapeHtml4(token));
            }
        }

        return Collections.enumeration(result);
    }
}
