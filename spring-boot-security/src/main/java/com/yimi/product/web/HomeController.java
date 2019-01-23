package com.yimi.product.web;

import com.yimi.product.dto.DateResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController {

    @RequestMapping("/seckill")
    public String index(Model model) {
        DateResult<String> msg = new DateResult(true, "请求成功！");
        model.addAttribute("msg", msg);
        return "index";
    }

    @PreAuthorize("hasAuthority('userInfo:view')")
    @GetMapping("/list")
    public String list() {
        return "user/list";
    }

    @PreAuthorize("hasAuthority('userInfo:add')")
    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @PreAuthorize("hasAuthority('userInfo:del')")
    @GetMapping("/detail")
    public String detail() {
        return "user/detail";
    }

}