package com.xd.controller;

/**
 * @author hjfeng
 * @date 2020--07--06  14:31
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController {

    private static HashMap<String ,String> loginMsg = new HashMap<String ,String>();

    @PostMapping("/login")
    public HashMap login(HttpServletRequest request, HttpServletResponse response,
                                                       HttpSession session, Model model) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        HashMap map = new HashMap<>();

        String pwd  = loginMsg.get(name);
        System.out.println(pwd);
        if (pwd == null){
            map.put("status",false);
            map.put("msg","用户不存在请先注册");
        }else if (!pwd.equals(password)){
            map.put("status",false);
            map.put("msg","密码错误");
        }else {
            map.put("status",true);
            session.setAttribute("username",name);
        }

        return map;
    }

    @PostMapping("/register")
    public HashMap register(HttpServletRequest request, HttpServletResponse response,
                                                       HttpSession session, Model model) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        HashMap map = new HashMap<>();
        boolean b = loginMsg.containsKey(name);
        System.out.println(name+b);

        if (!b){
            map.put("status",true);
            loginMsg.put(name,password);
            System.out.println(loginMsg);
        }else {
            map.put("status",false);
            map.put("msg","该用户已注册");
        }

        return map;

    }




}
