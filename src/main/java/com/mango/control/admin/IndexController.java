package com.mango.control.admin;

import com.mango.dao.BaseDao;
import com.mango.pojo.Student;
import com.mango.service.Impl.ReservationServiceImpl;
import com.mango.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    BaseDao baseDao;

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {

        List<Student> students = studentService.countStudentReservation();

        int countStudent = baseDao.countStudent();
        int countClassroom = baseDao.countClassroom();
        int countReservation = baseDao.countReservation();

        model.addAttribute("students",students);
        model.addAttribute("countStudent",countStudent);
        model.addAttribute("countClassroom",countClassroom);
        model.addAttribute("countReservation",countReservation);

        return "index";
    }


}
