package com.mango.constant;


import org.springframework.stereotype.Component;

@Component
public class WebConstant {


    //当前登陆用户
    public static final String LOGIN_USER = "login_user";

    //学生预约信息成功状态
    public static final String RESERVATION_SUCCESS_STATE = "预约成功";

    //学生预约信息取消状态
    public static final String RESERVATION_CANCELED_STATE = "预约取消";

    //学生黑名单正常状态
    public static final String BLACKED_SUCCESS_STATE = "拉黑";

    //学生黑名单已失效状态
    public static final String BLACKED_CANCELED_STATE = "已失效";

}
