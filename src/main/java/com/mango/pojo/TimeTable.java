package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {

    private String time_id;
    private String room_id;
    private String building_id;
    private String time_name;
    private String time_begin;
    private String time_end;
    private Classroom classroom;
//    private List<RoomAvailableTimeInfo> roomAvailableTimeInfos;


}
