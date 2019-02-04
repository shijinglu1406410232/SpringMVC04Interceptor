package com.sjl.interceptor;

import com.sjl.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {
        //获取请求的URL  方法getRequestURI   获取地址栏上的除了localhost:8080的全部
        String url=request.getRequestURI();
        System.out.println("url:"+url);
        //URL:除了login.jsp是可以公开的，其它的URL都进行拦截控制
        if (url.indexOf("/login")>=0){
            return true;
        }

        //获取session中用户的信息，如果session已经存在，则表示该用户已经存在，曾经登录过，也放行  否则重新转发到登录页面，不再后续执行
        HttpSession session=request.getSession();
        //需要强转，因为原本是Obj类型，而这里需要User类型，思考一下，并回忆一下该方法的使用
        User user=(User)session.getAttribute("USER_SESSION");
        System.out.println("user:"+user);

        //判断是否有用户数据，如果有，则返回true，继续向下执行
        if (user!=null){
            return true;
        }

        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg","您还没有登录，请先登录!");
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        //这里直接用return终止了，因为该用户未登录
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object o,
                                Exception e) throws Exception {

    }
}
