package com.sjl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest httpServletRequest,
                             javax.servlet.http.HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        System.out.println("CustomInterceptor...preHandle");
        return true;
    }

    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest httpServletRequest,
                           javax.servlet.http.HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("CustomInterceptor...postHandle");
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest httpServletRequest,
                                javax.servlet.http.HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception {

        System.out.println("CustomInterceptor...afterCompletion");

    }
}
