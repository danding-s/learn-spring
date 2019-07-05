package com.learn.controller;

import com.learn.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.put("title", "spring boot 学习");
        Author author = new Author();
        author.setName("sun");
        author.setEmail("511145685@qq.com");
        System.out.println("hello world!");
        map.put("author", author);
        map.put("desc", "一起学习spring boot");
        return "index";
    }

    @PostMapping("/login")
    public String login() {
        Ajax
    }
}
