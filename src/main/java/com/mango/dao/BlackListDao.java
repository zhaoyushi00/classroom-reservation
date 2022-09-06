package com.mango.dao;


import com.mango.pojo.BlackList;
import com.mango.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlackListDao {

    void addStudentBlackList(BlackList blackList);

    List<Student> getAllBlackedStudent();

    void deleteStudentBlackList(String s_id);

    BlackList getBlackedStudentById(String s_id);
}
