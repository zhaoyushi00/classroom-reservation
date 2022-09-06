package com.mango.service;


import com.mango.pojo.BlackList;
import com.mango.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BlackListService {
    void addStudentBlackList(BlackList blackList);

    List<Student> getAllBlackedStudent();

    void deleteStudentBlackList(String s_id);

    BlackList getBlackedStudentById(String s_id);
}
