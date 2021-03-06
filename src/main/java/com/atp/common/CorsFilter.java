package com.atp.common;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/10 11 52
 */
@Component
public class CorsFilter implements Filter{
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        System.out.println("*********************************过滤器被使用**************************");
        chain.doFilter(req, res);
    }
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
