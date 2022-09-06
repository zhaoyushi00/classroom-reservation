package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomAvailableTimeInfo {
    private String time_id;
    private String room_id;
    private String building_id;
    private String available_date;
    private String reservation_num;
    private String available_num;
    private TimeTable timeTable;
    private List<StudentReservation> studentReservations;

    public RoomAvailableTimeInfo(String time_id, String room_id, String building_id, String available_date, String reservation_num, String available_num) {
        this.time_id = time_id;
        this.room_id = room_id;
        this.building_id = building_id;
        this.available_date = available_date;
        this.reservation_num = reservation_num;
        this.available_num = available_num;
    }

    public RoomAvailableTimeInfo(String time_id, String room_id, String building_id, String available_date) {
        this.time_id = time_id;
        this.room_id = room_id;
        this.building_id = building_id;
        this.available_date = available_date;
    }
}
