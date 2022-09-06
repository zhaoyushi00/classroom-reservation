package com.mango.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    private String s_id;
    private String date_begin;
    private String date_end;
    private String state;
    private String blacker_id;


}
