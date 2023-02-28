package com.k1m743hyun.springsecurity.filter;

import com.k1m743hyun.springsecurity.util.XSSUtils;
import com.k1m743hyun.springsecurity.wrapper.XSSRequestWrapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        XSSRequestWrapper requestWrapper = new XSSRequestWrapper((HttpServletRequest) request);

        String body = IOUtils.toString(requestWrapper.getReader());
        if (!StringUtils.isBlank(body)) {
            requestWrapper.resetInputStream(XSSUtils.stripXSS(body).getBytes());
        }

        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
