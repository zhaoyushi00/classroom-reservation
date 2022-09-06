package com.mango.control.admin;


import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import com.mango.service.ClassroomService;
import com.mango.service.Impl.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassroomController {


    @Autowired
    ClassroomServiceImpl classroomService;

    @GetMapping("/all_classroom")
    public String all_classroom(Model model) {
        List<Classroom> classrooms = classroomService.getAll();
        model.addAttribute("classrooms",classrooms);
        return "classroom/all_classroom";
    }


    @GetMapping("/updateClassroomInfo")
    public String updateClassroonInfo(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        String room_id = request.getParameter("room_id");
        if(!"".equals(room_id) && room_id != null) {
            map.put("room_id",room_id);
        }

        String room_name = request.getParameter("room_name");
        if(!"".equals(room_name) && room_name != null) {
            map.put("room_name",room_name);
        }

        String room_floor = request.getParameter("room_floor");
        if(!"".equals(room_floor) && room_floor != null) {
            map.put("room_floor",room_floor);
        }

        String available_seat = request.getParameter("available_seat");
        if (!"".equals(available_seat) && available_seat != null) {
            map.put("available_seat",available_seat);
        }

        String is_multimedia_room = request.getParameter("is_multimedia_room");
        if (!"".equals(is_multimedia_room) && is_multimedia_room != null) {
            map.put("is_multimedia_room",is_multimedia_room);
        }

        System.out.println("更改教室信息");
        classroomService.updateClassroom(map);


        return "redirect:all_classroom";
    }

    @GetMapping("/classroom_delete")
    public String classroom_delete(String room_id, Model model) {
        int reservedNums = classroomService.getClassroomReserved(room_id);
        if (reservedNums > 0) {
            model.addAttribute("msg","该教室已被预约,无法删除");
            List<Classroom> classrooms = classroomService.getAll();
            model.addAttribute("classrooms",classrooms);
            return "classroom/all_classroom";
        }else {
            //删除所有教室相关表 教室，教室时段表，教室可用表等信息
            classroomService.deleteClassroomInfo(room_id);
        }
        return "redirect:all_classroom";
    }

    @GetMapping("/add_new_classroom")
    public String add_new_classroom(HttpServletRequest request) {
        String room_id = request.getParameter("room_id");
        String room_name = request.getParameter("room_name");
        String building_id = request.getParameter("building_id");
        String room_floor = request.getParameter("room_floor");
        String available_seat = request.getParameter("available_seat");
        String is_multimedia_room = request.getParameter("is_multimedia_room");
        classroomService.addClassroom(new Classroom(room_id,room_name,building_id,room_floor,available_seat,is_multimedia_room));
        return "redirect:all_classroom";
    }

    @GetMapping("/add_new_classroom_available")
    public String add_new_classroom_available(HttpServletRequest request) {
        String time_id = request.getParameter("time_id");
        String room_id = request.getParameter("room_id");
        String building_id = request.getParameter("building_id");
        String available_date = request.getParameter("available_date");

        String available_num = request.getParameter("available_num");
        classroomService.addClassAvailable(new RoomAvailableTimeInfo(time_id,room_id,building_id,available_date,"0",available_num));
        return "redirect:all_classroom";
    }
}
