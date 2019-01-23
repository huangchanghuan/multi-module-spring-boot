package com.yimi.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        System.out.println("登陆页面");
        return "login.html";
    }


    @RequestMapping("/success.html")
    public String success() {
        System.out.println("登陆成功");
        return "success.html";
    }

    @RequestMapping("/logout.html")
    public String logout() {
        System.out.println("登出页面");
        return "logout.html";
    }
    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

}
