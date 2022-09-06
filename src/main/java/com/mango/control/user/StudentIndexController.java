package com.mango.control.user;


import com.mango.dao.BaseDao;
import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import com.mango.service.Impl.ClassroomServiceImpl;
import com.mango.service.Impl.ReservationServiceImpl;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentIndexController {
    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    BaseDao baseDao;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    ClassroomServiceImpl classroomService;

    @GetMapping("/student_index")
    public String student(HttpServletRequest request, Model model) {
        Student student = CommonUtil.getLoginUser(request);
        List<Student> students = reservationService.getAllStudentReservationInfo(student);

        Map<String, Object> map = new HashMap<>();
        map.put("s_id",student.getS_id());
        int countTotalReservation = studentService.countReservation(map);
        map.put("state","预约成功");
        int countSucReservation = studentService.countReservation(map);
        map.put("state","预约取消");
        int countCanceledReservation = studentService.countReservation(map);
        int countClassroom = baseDao.countClassroom();

        model.addAttribute("countClassroom",countClassroom);
        model.addAttribute("countTotalReservation",countTotalReservation);
        model.addAttribute("countSucReservation",countSucReservation);
        model.addAttribute("countCanceledReservation",countCanceledReservation);
        model.addAttribute("students",students);


        return "student_index";
    }

    @GetMapping("/user_reservation")
    public String user_reservation(HttpServletRequest request, Model model) {
        Student loginUser = CommonUtil.getLoginUser(request);
        List<Student> students = reservationService.getAllStudentReservationInfo(loginUser);
        model.addAttribute("students",students);
        return "user_reservation";
    }

    @GetMapping("/cancel_reservation")
    public String cancel_reservation(String s_id, String room_id, String time_id, String reservation_date, String building_id) {
//        System.out.println(s_id);
//        System.out.println(room_id);
//        System.out.println(reservation_date);
//        System.out.println(building_id);
        reservationService.updateDeleteReservationInfo(s_id,room_id,time_id,reservation_date,building_id);
        return "redirect:user_reservation";
    }

}
