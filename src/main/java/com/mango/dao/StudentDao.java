package com.mango.dao;


import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentDao {
    Student getStudentById(String s_id);

    List<Student> getAll();

    int updateStudentInfo(Student student);

    int updatePassword(String s_id, String new_password);

    List<Student> countStudentReservation();

    int countReservation(Map<String, Object> map);

    void addStudentReservation(StudentReservation studentReservation);

    void deleteCancelReservation(StudentReservation studentReservation);

    void addStudent(Student student);

    void updateStudentReservationState(StudentReservation studentReservation);

    void deleteStudentById(String s_id);
    void deleteStudentBlackListById(String s_id);
    void deleteStudentReservationById(String s_id);

}
