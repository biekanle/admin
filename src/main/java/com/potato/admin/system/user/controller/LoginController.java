package com.potato.admin.system.user.controller;

import com.potato.admin.system.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {


    @Autowired
    SysUserService sysUserService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {

        sysUserService.queryData();
        return "login";
    }
}
