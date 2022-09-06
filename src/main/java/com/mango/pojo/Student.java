package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String s_id;
    private String s_name;
    private String password;
    private String s_class;
    private String s_year;
    private String s_major;
    private String s_phone_number;
    private String suc_num;
    private String canceled_num;
    private List<StudentReservation> studentReservations;
    private BlackList blackList;

    public Student(String s_id, String s_name, String s_class, String s_year, String s_major, String s_phone_number) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_class = s_class;
        this.s_year = s_year;
        this.s_major = s_major;
        this.s_phone_number = s_phone_number;
    }
}
