package com.mango.control;


import com.mango.constant.WebConstant;
import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SettingController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/personal_settings")
    public String personal_settings(HttpServletRequest request,Model model) {

        Student loginUser = CommonUtil.getLoginUser(request);
        Student student = studentService.getStudentById(loginUser.getS_id());
//        System.out.println(student);
        model.addAttribute("login_user",student);

        return "settings/personal_settings";
    }


    @GetMapping("/updateStudentInfo")
    public String updateStudentInfo(HttpServletRequest request) {
        System.out.println("进入了更新信息");
        Student student = new Student();

//        注入学生学号
        student.setS_id(CommonUtil.getLoginUser(request).getS_id());

        String s_name = request.getParameter("s_name");
        if (!"".equals(s_name) && s_name != null) {
            student.setS_name(s_name);
        }
//        System.out.println(s_name);

        String s_year = request.getParameter("s_year");
        if (!"".equals(s_year) && s_year != null) {
            student.setS_year(s_year);
        }
//        System.out.println(s_year);

        String s_major = request.getParameter("s_major");
        if (!"".equals(s_major) && s_major != null) {
            student.setS_major(s_major);
        }
//        System.out.println(s_major);


        String s_class = request.getParameter("s_class");
        if (!"".equals(s_class) && s_class != null) {
            student.setS_class(s_class);
        }
//        System.out.println(s_class);


        String s_phone_number = request.getParameter("s_phone_number");
        if (!"".equals(s_phone_number) && s_phone_number != null) {
            student.setS_phone_number(s_phone_number);
        }
//        System.out.println(s_phone_number);

        studentService.updateStudentInfo(student);

        return "redirect:personal_settings";
    }



    @GetMapping("/changePassword")
    public String changePassword(HttpServletRequest request, Model model) {
        Student loginUser = CommonUtil.getLoginUser(request);
        Student student = studentService.getStudentById(loginUser.getS_id());
        String old_password = request.getParameter("old_password");
        System.out.println("old_password: " + old_password);
        String new_password = request.getParameter("new_password");
        System.out.println("new_password: " + new_password);
        String cm_password = request.getParameter("cm_password");
//        System.out.println(cm_password);

        if (!"".equals(old_password) && old_password != null) {
            if (old_password.equals(loginUser.getPassword())) {
                if (new_password != null && cm_password != null) {
                    if (new_password.equals(cm_password)) {
                        System.out.println("开始修改");
                        studentService.updatePassword(loginUser.getS_id(),new_password);
                        System.out.println("修改成功");
                        model.addAttribute("msg","修改成功!");
                    }else {
                        model.addAttribute("msg","两次输入密码不一致!");
                    }
                }else {
                    model.addAttribute("msg","新密码不能为空!");
                }
            }else {
                model.addAttribute("msg","密码不正确!");
            }
        }else {
            model.addAttribute("msg","密码不能为空!");
        }
        model.addAttribute("login_user",student);
        return "settings/personal_settings";
    }
}
