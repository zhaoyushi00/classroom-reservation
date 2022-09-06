package com.mango.control.admin;


import com.mango.constant.WebConstant;
import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
//@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/all_student")
    public String all_student(Model model) {

        List<Student> students = studentService.getAll();
        model.addAttribute("students",students);

        return "student/all_student";
    }

    @GetMapping("/add_new_student")
    public String add_new_student(HttpServletRequest request) {
        String s_id = request.getParameter("s_id");

        String s_name = request.getParameter("s_name");

        String s_major = request.getParameter("s_major");

        String s_class = request.getParameter("s_class");

        String s_year = request.getParameter("s_year");

        String s_phone_number = request.getParameter("s_phone_number");

        studentService.addStudent(new Student(s_id,s_name,s_class,s_year,s_major,s_phone_number));


        return "redirect:all_student";
    }

    @GetMapping("/student_delete")
    public String student_delete(String s_id) {
        System.out.println(s_id);
        studentService.deleteStudentInfo(s_id);
        return "redirect:all_student";
    }


}
