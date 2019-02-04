package com.sjl.Controller;

import com.sjl.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
@Controller
public class UserController {
    /**
     * 向登录页面跳转
     * */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    /**
     * 用户登录
     * */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        //这个是Spring下的Model       org.springframework.ui.Model

        //获取用户名和密码
        // 为什么不是getParamter()来获取参数?
        // 这种方法是不是绑定前端页面和popj类，而popj类是不是也和数据库相关联
        String username=user.getUsername();
        String password=user.getPassword();

        //此处模拟从数据库中获取用户名和密码后进行判断         如果是数字是不是用==

                                                     //明明输入的是数字，int型，可这里为什么是String型
        if (username!=null && username.equals("曹梦雪") && password !=null && password.equals("123456")){
            //把对象添加到Session
            session.setAttribute("USER_SESSION",user);
            //重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录!");
        return "login";
    }

    /**
     * 向用户主页跳转
     * */
    @RequestMapping(value = "/main")
    public String toMain(){
        return "main";
    }

    /**
     * 退出登录
     * */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清除Session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
