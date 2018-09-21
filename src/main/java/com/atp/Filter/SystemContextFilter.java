package com.atp.Filter;

import com.atp.common.CRCHttpServletRequest;
import com.atp.common.SystemContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/9/21 14 36
 */
@Component
public class SystemContextFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String contextRealPath = filterConfig.getServletContext().getRealPath("/");
        SystemContext.setRealPath(contextRealPath);
        logger.info("[" + SystemContextFilter.class.getSimpleName() + "] - init - [" + toString() + "] - [contextRealPath: " + contextRealPath + "]");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        request = new CRCHttpServletRequest(request);
        SystemContext.setRequest((HttpServletRequest) request);
        SystemContext.setResponse((HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("[" + SystemContextFilter.class.getSimpleName() + "] - destroy - [" + toString() + "]");
    }
}
