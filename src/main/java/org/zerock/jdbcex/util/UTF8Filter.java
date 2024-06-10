package org.zerock.jdbcex.util;

import java.io.IOException;


import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns= "/*")
@Log4j2
public class UTF8Filter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        log.info("UTF8 filter~~~~~");

        HttpServletRequest req = (HttpServletRequest)request;

        req.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}