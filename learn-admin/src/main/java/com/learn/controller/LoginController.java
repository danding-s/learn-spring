package com.learn.controller;

import com.learn.common.ResultGenerator;
import com.learn.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.shiro.subject.Subject;

@RestController
public class LoginController {

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.put("title", "spring boot 学习");
        User user = new User();
        user.setUsername("sun");
        user.setEmail("511145685@qq.com");
        System.out.println("hello world!");
        map.put("author", user);
        map.put("desc", "一起学习spring boot");
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return ResultGenerator.genFailResult("登录失败，用户名或密码错误！");
        }
        return String.valueOf(ResultGenerator.genSuccessResult());
    }
}
