package com.mango.dao;


import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClassroomDao {
    List<Classroom> getAll();


    void updateClassroom(Map<String, Object> map);

    void updateRoomAvailableTimeInfo(RoomAvailableTimeInfo roomAvailableTimeInfo);

    void updateDeleteRoomAvailableSeatInfo(RoomAvailableTimeInfo roomAvailableTimeInfo);

    int  getClassroomReserved(String room_id);

    void deleteClassroom(String room_id);

    void deleteClassroomTimeTable(String room_id);

    void deleteClassroomAvailableTime(String room_id);

    void addClassroom(Classroom classroom);

    void addClassroomAvailable(RoomAvailableTimeInfo roomAvailableTimeInfo);
}
