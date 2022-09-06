package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    private String room_id;
    private String room_name;
    private String building_id;
    private String room_floor;
    private String available_seat;
    private String is_multimedia_room;
    private T_building t_building;
    private List<TimeTable> timeTables;
    private List<StudentReservation> studentReservations;
    private List<RoomAvailableTimeInfo> roomAvailableTimeInfos;

    public Classroom(String room_id, String room_name, String building_id, String room_floor, String available_seat, String is_multimedia_room) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.building_id = building_id;
        this.room_floor = room_floor;
        this.available_seat = available_seat;
        this.is_multimedia_room = is_multimedia_room;
    }
}
