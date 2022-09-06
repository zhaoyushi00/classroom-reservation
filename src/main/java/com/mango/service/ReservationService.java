package com.mango.service;


import com.mango.pojo.Classroom;
import com.mango.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface ReservationService {


    List<Student> getAllStudentReservationInfo(Student student);

    List<Classroom> getAllClassroomReservationInfo(Map<String, Object> map);

    List<Classroom> getAllAvailableClassroom(Map<String, Object> map);


    void updateAddReservationInfo(String s_id);

    void updateDeleteReservationInfo(String s_id, String room_id, String time_id, String reservation_date, String building_id);


}
