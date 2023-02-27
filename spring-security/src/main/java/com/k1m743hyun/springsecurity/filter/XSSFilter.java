package com.k1m743hyun.springsecurity.filter;

import com.k1m743hyun.springsecurity.wrapper.XSSRequestWrapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class XSSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // XSSRequestWrapper wrappedRequest = new XSSRequestWrapper((HttpServletRequest) request);
        // chain.doFilter(wrappedRequest, response);
        chain.doFilter(request, response);
    }
}
