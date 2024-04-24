package com.gb;

import jakarta.servlet.*;

import java.io.IOException;




public class TimerFilter implements Filter {

    @Timer
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Time Filter is working");
    }

}
