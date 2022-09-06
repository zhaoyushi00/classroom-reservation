package com.mango.dao;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseDao {
    int countStudent();

    int countClassroom();

    int countReservation();
}
