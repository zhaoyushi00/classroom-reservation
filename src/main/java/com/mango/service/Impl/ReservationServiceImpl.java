package com.mango.service.Impl;

import com.mango.constant.WebConstant;
import com.mango.dao.ClassroomDao;
import com.mango.dao.ReservationDao;
import com.mango.dao.StudentDao;
import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import com.mango.service.ReservationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Data
public class ReservationServiceImpl implements ReservationService {

    private static Map<String, Map<String, String>> room_id_and_time_id = new HashMap<>();
    private static List<Classroom> allSelectClassrooms;



    @Autowired
    StudentDao studentDao;

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    ClassroomDao classroomDao;

    public static Map<String, Map<String, String>> getRoom_id_and_time_id() {
        return room_id_and_time_id;
    }

    public static void setRoom_id_and_time_id(Map<String, Map<String, String>> room_id_and_time_id) {
        ReservationServiceImpl.room_id_and_time_id = room_id_and_time_id;
    }

    public static List<Classroom> getAllSelectClassrooms() {
        return allSelectClassrooms;
    }

    public static void setAllSelectClassrooms(List<Classroom> allSelectClassrooms) {
        ReservationServiceImpl.allSelectClassrooms = allSelectClassrooms;
    }


    @Override
    public List<Student> getAllStudentReservationInfo(Student student) {
        return reservationDao.getAllStudentReservationInfo(student);
    }

    @Override
    public List<Classroom> getAllClassroomReservationInfo(Map<String, Object> map) {
        return reservationDao.getAllClassroomReservationInfo(map);
    }

    @Override
    public List<Classroom> getAllAvailableClassroom(Map<String, Object> map) {
        return reservationDao.getAllAvailableClassroom(map);
    }

    @Override
    public void updateAddReservationInfo(String s_id) {

        List<Classroom> allSelectClassrooms = getAllSelectClassrooms();
        RoomAvailableTimeInfo roomAvailableTime = new RoomAvailableTimeInfo();

        for (Classroom selectClassroom : allSelectClassrooms) {
            for (RoomAvailableTimeInfo roomAvailableTimeInfo : selectClassroom.getRoomAvailableTimeInfos()) {
                StudentReservation studentReservation = new StudentReservation();

                studentReservation.setS_id(s_id);
                studentReservation.setTime_id(roomAvailableTimeInfo.getTime_id());
                roomAvailableTime.setTime_id(roomAvailableTimeInfo.getTime_id());
                studentReservation.setRoom_id(roomAvailableTimeInfo.getRoom_id());
                roomAvailableTime.setRoom_id(roomAvailableTimeInfo.getRoom_id());
                studentReservation.setBuilding_id(roomAvailableTimeInfo.getBuilding_id());
                roomAvailableTime.setBuilding_id(roomAvailableTimeInfo.getBuilding_id());
                studentReservation.setReservation_date(roomAvailableTimeInfo.getAvailable_date());
                roomAvailableTime.setAvailable_date(roomAvailableTimeInfo.getAvailable_date());
                studentReservation.setState(WebConstant.RESERVATION_SUCCESS_STATE);
                studentReservation.setRoom_name(selectClassroom.getRoom_name());

                System.out.println(roomAvailableTimeInfo.getReservation_num());

                Integer reservationNums = Integer.parseInt(roomAvailableTimeInfo.getReservation_num()) + 1;
                roomAvailableTime.setReservation_num(reservationNums.toString());

                Integer availableNums = Integer.parseInt(roomAvailableTimeInfo.getAvailable_num()) - 1;
                roomAvailableTime.setAvailable_num(availableNums.toString());




                // 添加学生预约信息记录
                studentDao.addStudentReservation(studentReservation);

                // 更新可用教室时段表座位信息
                classroomDao.updateRoomAvailableTimeInfo(roomAvailableTime);
            }
        }

    }

    @Override
    public void updateDeleteReservationInfo(String s_id, String room_id, String time_id, String reservation_date, String building_id) {
        System.out.println("开始取消预约");
        System.out.println(time_id);
        studentDao.updateStudentReservationState(new StudentReservation(s_id,time_id,reservation_date,room_id));
//        studentDao.deleteCancelReservation(new StudentReservation(s_id,time_id,reservation_date,room_id));
        System.out.println("修改学生预约表成功");
        System.out.println("开始修改座位数");
        classroomDao.updateDeleteRoomAvailableSeatInfo(new RoomAvailableTimeInfo(time_id, room_id, building_id, reservation_date));
        System.out.println("修改座位数成功");
        System.out.println("取消预约成功");

    }



}
