/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : reservation_demo

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 01/03/2023 10:00:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(32) NOT NULL COMMENT '管理员编号',
  `admin_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('admin', 'mango', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `a_id` varchar(32) NOT NULL COMMENT '公告编号',
  `a_content` varchar(900) DEFAULT NULL COMMENT '公告内容',
  `a_state` int DEFAULT NULL COMMENT '公告状态',
  `a_begin_time` datetime DEFAULT NULL COMMENT '公告开始时间',
  `a_end_time` datetime DEFAULT NULL COMMENT '公告结束时间',
  `s_id` varchar(255) DEFAULT NULL COMMENT '发布者编号',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='公告';

-- ----------------------------
-- Records of announcement
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist` (
  `s_id` varchar(32) NOT NULL COMMENT '学号',
  `date_begin` date DEFAULT NULL COMMENT '开始时间',
  `date_end` date DEFAULT NULL COMMENT '结束时间',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  `blacker_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设置者编号',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='黑名单';

-- ----------------------------
-- Records of blacklist
-- ----------------------------
BEGIN;
INSERT INTO `blacklist` VALUES ('32001261', '2022-09-01', '2022-09-16', '拉黑', 'admin');
COMMIT;

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `room_id` varchar(32) NOT NULL COMMENT '教室编号',
  `room_name` varchar(255) DEFAULT NULL COMMENT '教室名称',
  `building_id` varchar(255) NOT NULL COMMENT '所属教学楼编号',
  `room_floor` varchar(32) DEFAULT NULL COMMENT '楼层',
  `available_seat` varchar(32) DEFAULT NULL COMMENT '可用座位数',
  `is_multimedia_room` varchar(32) DEFAULT NULL COMMENT '多媒体教室',
  PRIMARY KEY (`room_id`,`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教室';

-- ----------------------------
-- Records of classroom
-- ----------------------------
BEGIN;
INSERT INTO `classroom` VALUES ('101', '教室一', '1', '1', '90', '否');
INSERT INTO `classroom` VALUES ('201', '教室二', '2', '2', '20', '是');
INSERT INTO `classroom` VALUES ('301', '教室三', '3', '3', '30', '是');
INSERT INTO `classroom` VALUES ('401', '教室四', '2', '4', '40', '否');
COMMIT;

-- ----------------------------
-- Table structure for room_available_time_info
-- ----------------------------
DROP TABLE IF EXISTS `room_available_time_info`;
CREATE TABLE `room_available_time_info` (
  `time_id` varchar(32) NOT NULL COMMENT '时段编号',
  `room_id` varchar(32) NOT NULL COMMENT '教室编号',
  `building_id` varchar(32) NOT NULL COMMENT '楼编号',
  `available_date` date NOT NULL COMMENT '日期',
  `reservation_num` varchar(32) DEFAULT NULL COMMENT '已预约人数',
  `available_num` varchar(32) DEFAULT NULL COMMENT '可预约人数',
  PRIMARY KEY (`time_id`,`room_id`,`building_id`,`available_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教室可用时段';

-- ----------------------------
-- Records of room_available_time_info
-- ----------------------------
BEGIN;
INSERT INTO `room_available_time_info` VALUES ('1', '101', '1', '2001-01-07', '4', '86');
INSERT INTO `room_available_time_info` VALUES ('1', '101', '1', '2001-09-12', '0', '90');
INSERT INTO `room_available_time_info` VALUES ('1', '201', '2', '2001-01-07', '3', '17');
INSERT INTO `room_available_time_info` VALUES ('10', '201', '2', '2001-01-07', '2', '18');
INSERT INTO `room_available_time_info` VALUES ('11', '201', '2', '2001-01-07', '0', '20');
INSERT INTO `room_available_time_info` VALUES ('12', '201', '2', '2001-01-07', '1', '19');
INSERT INTO `room_available_time_info` VALUES ('2', '101', '1', '2001-01-07', '0', '90');
INSERT INTO `room_available_time_info` VALUES ('3', '101', '1', '2001-01-07', '1', '89');
INSERT INTO `room_available_time_info` VALUES ('4', '201', '2', '2001-01-07', '1', '19');
INSERT INTO `room_available_time_info` VALUES ('5', '201', '2', '2001-01-07', '1', '19');
INSERT INTO `room_available_time_info` VALUES ('6', '201', '2', '2001-01-07', '0', '20');
INSERT INTO `room_available_time_info` VALUES ('7', '101', '1', '2001-01-07', '1', '89');
INSERT INTO `room_available_time_info` VALUES ('8', '101', '1', '2001-01-07', '0', '90');
INSERT INTO `room_available_time_info` VALUES ('9', '101', '1', '2001-01-07', '0', '90');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` varchar(32) NOT NULL COMMENT '学号',
  `s_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `s_class` varchar(255) DEFAULT NULL COMMENT '班级',
  `s_year` varchar(32) DEFAULT NULL COMMENT '年级',
  `s_major` varchar(255) DEFAULT NULL COMMENT '专业',
  `s_phone_number` varchar(255) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='学生';

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('32001033', '李尚鑫', '111', '2002', '2', '软件工程', '110');
INSERT INTO `student` VALUES ('32001041', '文权', '123', '2003', '3', '软件工程', '110');
INSERT INTO `student` VALUES ('32001042', '王紫龙', '123', '2003', '3', '软件工程', '110');
INSERT INTO `student` VALUES ('32001120', '余家好', '123', '2003', '3', '生物', '110');
INSERT INTO `student` VALUES ('32001137', '宋明明', '123', '2004', '4', '环境', '110');
INSERT INTO `student` VALUES ('32001173', '张景宣', '123', '2004', '1', '环境', '110');
INSERT INTO `student` VALUES ('32001199', '余钧豪', '123', '2003', '1', '生物', '110');
INSERT INTO `student` VALUES ('32001257', '诸思成', '123', '2003', '2', '生物', '110');
INSERT INTO `student` VALUES ('32001261', '舒恒鑫', '123', '2003', '4', '生物', '110');
INSERT INTO `student` VALUES ('32001272', '徐彬涵', NULL, '2002', '3', '软件工程', '110');
INSERT INTO `student` VALUES ('32001280', '李鼎辉', '123', '2003', '4', '化学', '110');
INSERT INTO `student` VALUES ('32001286', '何彬玮', '123', '2003', '1', '化学', '110');
INSERT INTO `student` VALUES ('32009081', '傅玉', '123', '2003', '1', '软件工程', '110');
INSERT INTO `student` VALUES ('admin', 'mango', '111', '', '', '', '');
COMMIT;

-- ----------------------------
-- Table structure for student_reservation
-- ----------------------------
DROP TABLE IF EXISTS `student_reservation`;
CREATE TABLE `student_reservation` (
  `s_id` varchar(32) NOT NULL COMMENT '学号',
  `time_id` varchar(32) NOT NULL COMMENT '时段编号',
  `room_id` varchar(32) NOT NULL COMMENT '教室编号',
  `building_id` varchar(32) NOT NULL COMMENT '楼编号',
  `reservation_date` date NOT NULL COMMENT '预约日期',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  `room_name` varchar(32) DEFAULT NULL COMMENT '教室名称',
  PRIMARY KEY (`s_id`,`time_id`,`room_id`,`building_id`,`reservation_date`),
  CONSTRAINT `f01` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='自习预约信息';

-- ----------------------------
-- Records of student_reservation
-- ----------------------------
BEGIN;
INSERT INTO `student_reservation` VALUES ('32001033', '1', '101', '1', '2001-01-07', '预约取消', '教室一');
INSERT INTO `student_reservation` VALUES ('32001033', '1', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32001033', '10', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32001033', '3', '101', '1', '2001-01-07', '预约成功', '教室一');
INSERT INTO `student_reservation` VALUES ('32001033', '8', '101', '1', '2001-01-07', '预约取消', '教室一');
INSERT INTO `student_reservation` VALUES ('32001041', '11', '201', '2', '2001-01-07', '预约取消', '教室二');
INSERT INTO `student_reservation` VALUES ('32001041', '2', '101', '1', '2001-01-07', '预约取消', '教室一');
INSERT INTO `student_reservation` VALUES ('32001041', '4', '201', '2', '2001-01-07', '预约取消', '教室二');
INSERT INTO `student_reservation` VALUES ('32001042', '7', '101', '1', '2001-01-07', '预约成功', '教室一');
INSERT INTO `student_reservation` VALUES ('32001137', '1', '101', '1', '2001-01-07', '预约成功', '教室一');
INSERT INTO `student_reservation` VALUES ('32001137', '1', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32001137', '10', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32001272', '1', '101', '1', '2001-01-07', '预约成功', '教室一');
INSERT INTO `student_reservation` VALUES ('32001272', '1', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32009081', '1', '101', '1', '2001-01-07', '预约成功', '教室一');
INSERT INTO `student_reservation` VALUES ('32009081', '12', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32009081', '2', '101', '1', '2001-01-07', '预约取消', '教室一');
INSERT INTO `student_reservation` VALUES ('32009081', '4', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32009081', '5', '201', '2', '2001-01-07', '预约成功', '教室二');
INSERT INTO `student_reservation` VALUES ('32009081', '6', '201', '2', '2001-01-07', '预约取消', '教室二');
COMMIT;

-- ----------------------------
-- Table structure for t_building
-- ----------------------------
DROP TABLE IF EXISTS `t_building`;
CREATE TABLE `t_building` (
  `building_id` varchar(32) NOT NULL COMMENT '楼编号',
  `building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼名称',
  `building_phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `building_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在校区',
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='教学楼';

-- ----------------------------
-- Records of t_building
-- ----------------------------
BEGIN;
INSERT INTO `t_building` VALUES ('1', '弘毅', '110', '南校区');
INSERT INTO `t_building` VALUES ('2', '慕贤', '110', '南校区');
INSERT INTO `t_building` VALUES ('3', '致远', '110', '南校区');
INSERT INTO `t_building` VALUES ('4', '精诚', '110', '南校区');
COMMIT;

-- ----------------------------
-- Table structure for time_table
-- ----------------------------
DROP TABLE IF EXISTS `time_table`;
CREATE TABLE `time_table` (
  `time_id` varchar(32) NOT NULL COMMENT '时段编号',
  `time_name` varchar(255) DEFAULT NULL COMMENT '时段名称',
  `time_begin` time DEFAULT NULL COMMENT '开始时间',
  `time_end` time DEFAULT NULL COMMENT '结束时间',
  `room_id` varchar(32) NOT NULL COMMENT '教室编号',
  `building_id` varchar(32) NOT NULL COMMENT '教学楼',
  PRIMARY KEY (`time_id`,`room_id`,`building_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='时段表';

-- ----------------------------
-- Records of time_table
-- ----------------------------
BEGIN;
INSERT INTO `time_table` VALUES ('1', '时段一', '07:00:00', '08:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('1', '时段一', '07:00:00', '08:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('1', '时段一', '07:00:00', '08:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('10', '时段十', '16:00:00', '17:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('10', '时段十', '16:00:00', '17:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('10', '时段十', '16:00:00', '17:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('11', '时段十一', '17:00:00', '18:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('11', '时段十一', '17:00:00', '18:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('11', '时段十一', '17:00:00', '18:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('12', '时段十二', '18:00:00', '19:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('12', '时段十二', '18:00:00', '19:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('12', '时段十二', '18:00:00', '19:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('2', '时段二', '08:00:00', '09:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('2', '时段二', '08:00:00', '09:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('2', '时段二', '08:00:00', '09:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('3', '时段三', '09:00:00', '10:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('3', '时段三', '09:00:00', '10:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('3', '时段三', '09:00:00', '10:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('4', '时段四', '10:00:00', '11:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('4', '时段四', '10:00:00', '11:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('4', '时段四', '10:00:00', '11:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('5', '时段五', '11:00:00', '12:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('5', '时段五', '11:00:00', '12:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('5', '时段五', '11:00:00', '12:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('6', '时段六', '12:00:00', '13:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('6', '时段六', '12:00:00', '13:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('6', '时段六', '12:00:00', '13:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('7', '时段七', '13:00:00', '14:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('7', '时段七', '13:00:00', '14:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('7', '时段七', '13:00:00', '14:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('8', '时段八', '14:00:00', '15:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('8', '时段八', '14:00:00', '15:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('8', '时段八', '14:00:00', '15:00:00', '301', '3');
INSERT INTO `time_table` VALUES ('9', '时段九', '15:00:00', '16:00:00', '101', '1');
INSERT INTO `time_table` VALUES ('9', '时段九', '15:00:00', '16:00:00', '201', '2');
INSERT INTO `time_table` VALUES ('9', '时段九', '15:00:00', '16:00:00', '301', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
