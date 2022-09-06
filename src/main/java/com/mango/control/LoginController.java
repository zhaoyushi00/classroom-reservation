package com.mango.control;


import com.mango.constant.WebConstant;
import com.mango.dao.BaseDao;
import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    StudentServiceImpl service;

    @Autowired
    BaseDao baseDao;

    @GetMapping({"/","login"})
    public String login() {
        return "login";
    }

    @GetMapping("/logincheck")
    public String check(@RequestParam("username") String s_id, @RequestParam("password") String psw, Model model, HttpServletRequest request) {


        Student student = service.getStudentById(s_id);
        if (student == null) {
            model.addAttribute("msg","该用户不存在!");
            return "login";
        }else {
            if (psw.equals(student.getPassword())) {
                HttpSession session = request.getSession();

                session.setAttribute(WebConstant.LOGIN_USER,student);
                if (student.getS_id().equals("admin")) {
                    return "redirect:index";
                }else {
                    return "redirect:student_index";
                }
            } else {
                model.addAttribute("msg","用户或密码错误!");
                return "login";
            }
        }
    }

    public void getConstantData() {

    }


}
