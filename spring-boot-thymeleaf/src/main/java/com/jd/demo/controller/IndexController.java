package com.jd.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuting
 * @date 2018/08/08
 */
@Controller
public class IndexController {

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("message","Hello World!!!");
        return "index";
    }

}
