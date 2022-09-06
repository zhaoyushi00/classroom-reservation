package com.mango.service;


import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    Student getStudentById(String s_id);

    int updatePassword(String s_id, String new_password);

    List<Student> getAll();

    int updateStudentInfo(Student student);

    List<Student> countStudentReservation();

    int countReservation(Map<String, Object> map);

    void deleteCancelReservation(StudentReservation studentReservation);

    void addStudent(Student student);

    boolean isThreeTimesCanceledOfWeekById(String s_id);

    void deleteStudentInfo(String s_id);
}
