package com.yimi.product.web;

import com.yimi.product.dto.DateResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/seckill")
    public String index(Model model) {
        DateResult<String> msg = new DateResult(true, "请求成功！");
        model.addAttribute("msg", msg);
        return "index";
    }
}