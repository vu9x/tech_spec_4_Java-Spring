package vn.vt;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;



@Slf4j
public class TimerFilter implements Filter {

    @Timer
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("request: {}", httpServletRequest.getServletPath());

        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        log.info("response: url: {}, status: {}", httpServletRequest.getServletPath(), httpServletResponse.getStatus());

    }

}
