package com.mango.control;


import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/list")
    public String updateReservationBoard(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students",students);
        return "list";
    }

    /**
     * 获取当前用户
     * @param request
     * @return
     */
    public Student student(HttpServletRequest request) {
        return CommonUtil.getLoginUser(request);
    }

}
