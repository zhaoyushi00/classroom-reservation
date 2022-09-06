package com.mango.control.admin;


import com.mango.constant.WebConstant;
import com.mango.pojo.BlackList;
import com.mango.pojo.Student;
import com.mango.service.Impl.BlackListServiceImpl;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BlackListController {

    @Autowired
    BlackListServiceImpl blackListService;


    @GetMapping("/blacklist")
    public String blacklist(HttpServletRequest request, Model model) {
        List<Student> allBlackedStudent = blackListService.getAllBlackedStudent();
        for (Student student : allBlackedStudent) {
            System.out.println(student);
        }
        model.addAttribute("allBlackedStudent",allBlackedStudent);
        return "blacklist";
    }

    @GetMapping("/set_student_black_list")
    public String set_student_black_list(HttpServletRequest request) {

        String selectStudentId = request.getParameter("selectStudentId");
        String date_begin = null;
        String date_end = null;

        String selectDate = request.getParameter("selectDate");

//        System.out.println(selectDate);
        if (!"".equals(selectDate) && selectDate != null) {
            date_begin = CommonUtil.getDateFormat(selectDate.substring(0, selectDate.indexOf(" ")));
//            System.out.println(date_begin);
            date_end = CommonUtil.getDateFormat(selectDate.substring(selectDate.lastIndexOf(" ") + 1));
//            System.out.println(date_end);
        }
        System.out.println("开始添加黑名单学生");
        blackListService.addStudentBlackList(new BlackList(selectStudentId,date_begin,date_end, WebConstant.BLACKED_SUCCESS_STATE,CommonUtil.getLoginUser(request).getS_id()));
        System.out.println("添加黑名单学生成功");
        return "redirect:all_student";
    }

    @GetMapping("/blacklist_delete")
    public String blacklist_delete(String s_id) {
        blackListService.deleteStudentBlackList(s_id);
        return "redirect:blacklist";
    }
}
