package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class T_building {
    private String building_id;
    private String building_name;
    private String building_phone_number;
    private String building_location;
    private List<Classroom> classrooms;
}
