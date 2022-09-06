package com.mango.service.Impl;

import com.mango.dao.ClassroomDao;
import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import com.mango.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;

    @Override
    public List<Classroom> getAll() {
        return classroomDao.getAll();
    }

    @Override
    public void updateClassroom(Map<String, Object> map) {
        classroomDao.updateClassroom(map);
    }


    @Override
    public int getClassroomReserved(String room_id) {
        return classroomDao.getClassroomReserved(room_id);
    }

    @Override
    public void addClassroom(Classroom classroom) {
        classroomDao.addClassroom(classroom);
    }

    @Override
    public void addClassAvailable(RoomAvailableTimeInfo roomAvailableTimeInfo) {
        classroomDao.addClassroomAvailable(roomAvailableTimeInfo);
    }

    @Override
    public void deleteClassroomInfo(String room_id) {
        classroomDao.deleteClassroom(room_id);
        classroomDao.deleteClassroomTimeTable(room_id);
        classroomDao.deleteClassroomAvailableTime(room_id);
    }
}
