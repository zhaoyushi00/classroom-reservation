package com.mango.dao;

import com.mango.pojo.Classroom;
import com.mango.pojo.Student;
import com.mango.pojo.T_building;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface ReservationDao {

    List<Student> getAllStudentReservationInfo(Student student);


    List<Classroom> getAllClassroomReservationInfo(Map<String, Object> map);


    List<Classroom> getAllAvailableClassroom(Map<String, Object> map);


    List<String> getAllCanceledReservationDateById(String s_id);
}
