package com.mango.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {


    @GetMapping("/test")
    public String test(HttpServletRequest request, Model model) {
        String parameter = request.getParameter("123");
        System.out.println(parameter);


        return "test";
    }






}
