package com.mango.service;

import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface ClassroomService {
    List<Classroom> getAll();

    void updateClassroom(Map<String, Object> map);


    void deleteClassroomInfo(String room_id);

    int  getClassroomReserved(String room_id);

    void addClassroom(Classroom classroom);

    void addClassAvailable(RoomAvailableTimeInfo roomAvailableTimeInfo);

}
