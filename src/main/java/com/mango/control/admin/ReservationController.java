package com.mango.control.admin;


import com.mango.pojo.Classroom;
import com.mango.pojo.Student;
import com.mango.service.Impl.ReservationServiceImpl;

import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/all_student_reservation")
    public String all_student_reservation(HttpServletRequest request,Model model) {
        Student student = new Student();

        String searchByIdOrName = request.getParameter("searchByIdOrName");
//        System.out.println(searchByIdOrName);
        if (!"".equals(searchByIdOrName) && searchByIdOrName != null) {
            student.setS_id(searchByIdOrName);
        }

        String selectedYear = request.getParameter("selectedYear");
//        System.out.println(!"".equals(selectedYear));
        if(!"".equals(selectedYear) && selectedYear != null) {
            student.setS_year(selectedYear);
        }

        String selectedMajor = request.getParameter("selectedMajor");
//        System.out.println("selectedMajor" + selectedMajor);
        if (!"".equals(selectedMajor) && selectedMajor != null) {
            student.setS_major(selectedMajor);
        }

        List<Student> students = reservationService.getAllStudentReservationInfo(student);

        model.addAttribute("students",students);

        return "reservation/all_student_reservation";
    }


    @GetMapping("/all_classroom_reservation")
    public String all_classroom_reservation(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();

        String searchByIdOrName = request.getParameter("searchByIdOrName");
//        System.out.println(searchByIdOrName);
        if (!"".equals(searchByIdOrName) && searchByIdOrName != null) {
            map.put("room_id",searchByIdOrName);
        }

        String selectedTime = request.getParameter("selectedTime");
        if(!"".equals(selectedTime) && selectedTime != null) {
            String time_begin = selectedTime.substring(0,selectedTime.indexOf("-"));
            String time_end = selectedTime.substring(selectedTime.lastIndexOf("-")+1);
            map.put("time_begin",time_begin);
            map.put("time_end",time_end);
        }

        String selectDate = request.getParameter("selectDate");
//        System.out.println(selectDate);
        if (!"".equals(selectDate) && selectDate != null) {
            String date_begin = CommonUtil.getDateFormat(selectDate.substring(0, selectDate.indexOf(" ")));
//            System.out.println(date_begin);
            String date_end = CommonUtil.getDateFormat(selectDate.substring(selectDate.lastIndexOf(" ") + 1));
//            System.out.println(date_end);
            if (!date_begin.equals(date_end)) {
                map.put("date_begin", date_begin);
                map.put("date_end", date_end);
            }

        }
        List<Classroom> classrooms = reservationService.getAllClassroomReservationInfo(map);

        model.addAttribute("classrooms",classrooms);

        return "reservation/all_classroom_reservation";
    }


}
