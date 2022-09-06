package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReservation {
    private String s_id;
    private String time_id;
    private String room_id;
    private String building_id;
    private String reservation_date;
    private String room_name;
    private String state;
    private RoomAvailableTimeInfo roomAvailableTimeInfo;
    private Student student;

    public StudentReservation(String s_id, String time_id, String room_id, String building_id, String reservation_date, String room_name, String state) {
        this.s_id = s_id;
        this.time_id = time_id;
        this.room_id = room_id;
        this.building_id = building_id;
        this.reservation_date = reservation_date;
        this.room_name = room_name;
        this.state = state;
    }

    public StudentReservation(String s_id, String time_id, String reservation_date, String room_id) {
        this.s_id = s_id;
        this.time_id = time_id;
        this.reservation_date = reservation_date;
        this.room_id = room_id;
    }
}
