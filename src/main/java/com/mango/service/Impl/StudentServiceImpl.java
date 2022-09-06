package com.mango.service.Impl;

import com.mango.dao.ReservationDao;
import com.mango.dao.StudentDao;
import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import com.mango.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public Student getStudentById(String s_id) {
        return studentDao.getStudentById(s_id);
    }

    @Override
    public int updatePassword(String s_id, String new_password) {
        return studentDao.updatePassword(s_id,new_password);
    }


    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public int updateStudentInfo(Student student) {
        return studentDao.updateStudentInfo(student);
    }

    @Override
    public List<Student> countStudentReservation() {
        return studentDao.countStudentReservation();
    }

    @Override
    public int countReservation(Map<String, Object> map) {
        return studentDao.countReservation(map);
    }

    @Override
    public void deleteCancelReservation(StudentReservation studentReservation) {
        studentDao.deleteCancelReservation(studentReservation);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public boolean isThreeTimesCanceledOfWeekById(String s_id) {
        return checkThreeTimesCanceledOfWeek(reservationDao.getAllCanceledReservationDateById(s_id));
    }

    @Override
    public void deleteStudentInfo(String s_id) {
        studentDao.deleteStudentById(s_id);
        studentDao.deleteStudentBlackListById(s_id);
        studentDao.deleteStudentReservationById(s_id);
    }

    public boolean checkThreeTimesCanceledOfWeek(List<String> info) {
        for (int i = 0; i < info.size(); i++) {
            int date1 = Integer.parseInt(info.get(i));
            for (int j = i + 1; j < info.size(); j++) {
                int date2 = Integer.parseInt(info.get(j));
                if (Math.abs(date1 - date2) <= 7) {
                    for (int k = j + 1; k < info.size(); k++) {
                        int date3 = Integer.parseInt(info.get(k));
                        if (Math.abs(date2 - date3) <= 7) {
//                            System.out.println("yep");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
