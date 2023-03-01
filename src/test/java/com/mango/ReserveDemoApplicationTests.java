package com.mango;

import com.antfinancial.mychain.baas.tool.restclient.RestClient;
import com.mango.dao.*;
import com.mango.pojo.Classroom;
import com.mango.pojo.RoomAvailableTimeInfo;
import com.mango.pojo.Student;
import com.mango.pojo.StudentReservation;
import com.mango.utils.CommonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ReserveDemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    StudentDao studentDao;

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    ClassroomDao classroomDao;

    @Autowired
    BaseDao baseDao;

    @Autowired
    BlackListDao blackListDao;

    @Test
    void contextLoads() throws SQLException {
        Student student = new Student();
        student.setS_id("32001041");
        List<Student> info = reservationDao.getAllStudentReservationInfo(student);
        System.out.println(info.size());
        for (Student s : info) {
            System.out.println(s);
        }
    }

    @Test
    public void testStudent() {
        List<Student> all = studentDao.getAll();

        for (Student student : all) {
            System.out.println(student);
        }
    }

    @Test
    public void testTime() throws ParseException {

        System.out.println(CommonUtil.toUseRate("1","89"));

    }

    @Test
    public void testClassroom() {
        Map<String, Object> map = new HashMap<>();
        List<Classroom> allReservationInfo = reservationDao.getAllClassroomReservationInfo(map);
        System.out.println(allReservationInfo.size());
        for (Classroom classroom : allReservationInfo) {
            System.out.println(classroom);
        }
    }

    @Test
    public void testAllClassroom() {
        List<Classroom> all = classroomDao.getAll();
        for (Classroom classroom : all) {
            System.out.println(classroom);
        }
    }

    @Test
    public void testUpdateClassroomInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("room_id", "101");
        map.put("available_seat", "100");

        classroomDao.updateClassroom(map);

    }


    @Test
    public void testConstantData() {
        System.out.println(baseDao.countStudent());
        System.out.println(baseDao.countClassroom());
        System.out.println(baseDao.countReservation());
    }

    @Test
    public void testUpdateStudentInfo() {
        Student student = new Student();
        student.setS_id("32001033");
        student.setS_year("1");
        studentDao.updateStudentInfo(student);
    }

    @Test
    public void testCountStudentReservation() {
        List<Student> students = studentDao.countStudentReservation();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testCountReservation() {
        Map<String, Object> map = new HashMap<>();
        map.put("s_id", "32009081");
//        map.put("state","预约取消");
        int i = studentDao.countReservation(map);
        System.out.println(i);
    }

    @Test
    public void testAllAvailableClassroom() {
        Map<String, Object> map = new HashMap<>();
//        Map<String, Map<String, String>> room_id_and_time_id = new HashMap<>();
//        room_id_and_time_id.put("2014", new HashMap<>() {{
//            put("201", "4");
//        }});
//        room_id_and_time_id.put("2015", new HashMap<>() {{
//            put("201", "5");
//        }});
//
//
//        map.put("room_id_and_time_id", room_id_and_time_id);
//        map.put("room_id","11");
        map.put("time_begin", "07:00:00");
        map.put("time_end", "08:00:00");
        List<Classroom> allAvailableClassrooms = reservationDao.getAllAvailableClassroom(map);
        System.out.println(allAvailableClassrooms.size());
        for (Classroom allAvailableClassroom : allAvailableClassrooms) {
            System.out.println(allAvailableClassroom);
        }
    }

    @Test
    public void testAdd() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = (Date) sdf.parse("2001-01-07");
        StudentReservation studentReservation = new StudentReservation("33", "33", "33", "33", "2001-01-06", "33", "33");
        studentDao.addStudentReservation(studentReservation);
    }

    @Test
    void testUpdate() {
        RoomAvailableTimeInfo roomAvailableTimeInfo = new RoomAvailableTimeInfo();
        roomAvailableTimeInfo.setTime_id("1");
        roomAvailableTimeInfo.setRoom_id("101");
        roomAvailableTimeInfo.setBuilding_id("1");
        roomAvailableTimeInfo.setAvailable_date("2001-01-07");
        classroomDao.updateDeleteRoomAvailableSeatInfo(roomAvailableTimeInfo);


    }

    @Test
    public void testBlack() {
        for (Student student : blackListDao.getAllBlackedStudent()) {
            System.out.println(student);
        }

    }

    @Test
    public void testRe() {
        List<String> info = reservationDao.getAllCanceledReservationDateById("32001033");
        for (int i = 0; i < info.size(); i++) {
            int date1 = Integer.parseInt(info.get(i));
            for (int j = i + 1; j < info.size(); j++) {
                int date2 = Integer.parseInt(info.get(j));
                if (Math.abs(date1 - date2) <= 7) {
                    for (int k = j + 1; k < info.size(); k++) {
                        int date3 = Integer.parseInt(info.get(k));
                        if (Math.abs(date2 - date3) <= 7) {
                            System.out.println("yep");
                            return ;
                        }
                    }
                }
            }
        }
        System.out.println("nope");
    }

}
