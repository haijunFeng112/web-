package com.xd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author hjfeng
 * @date 2020--07--06  16:29
 */
@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "index";
    }
}
