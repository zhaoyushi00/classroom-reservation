package com.mango.control.user;


import com.mango.pojo.BlackList;
import com.mango.pojo.Classroom;
import com.mango.pojo.Student;
import com.mango.service.Impl.BlackListServiceImpl;
import com.mango.service.Impl.ReservationServiceImpl;
import com.mango.service.Impl.StudentServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MakeReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    BlackListServiceImpl blackListService;

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping("/make_reservation")
    public String make_reservation(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();

        String selectLocation = request.getParameter("selectLocation");
//        System.out.println(selectLocation);
        if (!"".equals(selectLocation) && selectLocation != null) {
            map.put("selectLocation", selectLocation);
        }

        String selectBuildingName = request.getParameter("selectBuildingName");
//        System.out.println(selectBuildingName);
        if (!"".equals(selectBuildingName) && selectBuildingName != null) {
            map.put("selectBuildingName", selectBuildingName);
        }

        String selectRoomName = request.getParameter("selectRoomName");
        if (!"".equals(selectRoomName) && selectRoomName != null) {
            map.put("selectRoomName", selectRoomName);
        }

        String selectRoomFloor = request.getParameter("selectRoomFloor");
        if (!"".equals(selectRoomFloor) && selectRoomFloor != null) {
            map.put("selectRoomFloor", selectRoomFloor);
        }

        String selectTime = request.getParameter("selectTime");
        if (!"".equals(selectTime) && selectTime != null) {
            String time_begin = selectTime.substring(0, selectTime.indexOf("-"));
//            System.out.println(time_begin);
            String time_end = selectTime.substring(selectTime.lastIndexOf("-") + 1);
//            System.out.println(time_end);
            map.put("time_begin", time_begin);
            map.put("time_end", time_end);
//            map.put("selectTime",selectTime);
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

        List<Classroom> allAvailableClassrooms = reservationService.getAllAvailableClassroom(map);
//        System.out.println(allAvailableClassrooms.size());

        String[] selectedCheckbox = request.getParameterValues("selectedCheckbox");
        if (selectedCheckbox != null) {
            Map<String, Map<String, String>> room_id_and_time_id = new HashMap<>();
            for (String checkbox : selectedCheckbox) {
//                System.out.println(checkbox);
                String time_id = checkbox.substring(0, checkbox.indexOf("-"));
//                System.out.println(time_id + "######");
                String room_id = checkbox.substring(checkbox.indexOf("-") + 1);
//                System.out.println(room_id + "######");
                room_id_and_time_id.put(room_id.concat(time_id), new HashMap<>() {{
                    put(room_id, time_id);
                }});
            }

            reservationService.setRoom_id_and_time_id(room_id_and_time_id);

            return "redirect:confirm_reservation";
        }

        model.addAttribute("allAvailableClassrooms", allAvailableClassrooms);

        return "make_reservation";
    }


    @RequestMapping("/confirm_reservation")
    public String confirm_reservation(HttpServletRequest request, Model model) {
        Map<String, Object> map = new HashMap<>();

        map.put("room_id_and_time_id", reservationService.getRoom_id_and_time_id());

        List<Classroom> allSelectClassrooms = reservationService.getAllAvailableClassroom(map);
        reservationService.setAllSelectClassrooms(allSelectClassrooms);

        model.addAttribute("allSelectClassrooms", allSelectClassrooms);
        return "confirm_reservation";
    }


    @RequestMapping("/reservation_check")
    public String reservation_check(HttpServletRequest request, Model model) {
        Student loginUser = CommonUtil.getLoginUser(request);

        System.out.println("开始预约...");
        // 先查询是否在黑名单中
        BlackList student = blackListService.getBlackedStudentById(loginUser.getS_id());
        System.out.println(student);

        if (student != null) {

            model.addAttribute("msg","已被列入黑名单中，无法预约!");
            return "confirm_reservation";
        }else {
            // 如果不在进行下一个判断
            // 查询是否一星期存在三次取消预约，先通过sql找出所有取消预约的记录
            if (studentService.isThreeTimesCanceledOfWeekById(loginUser.getS_id()) == true) {
                model.addAttribute("msg","存在一个星期超过三次取消预约行为，无法预约!");
                return "confirm_reservation";
            }
        }

        reservationService.updateAddReservationInfo(loginUser.getS_id());
        System.out.println("预约成功!");

        return "redirect:make_reservation";
    }
}
