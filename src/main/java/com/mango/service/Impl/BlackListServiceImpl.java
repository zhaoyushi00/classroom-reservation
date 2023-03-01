package com.mango.service.Impl;

import com.antfinancial.mychain.baas.tool.restclient.RestClient;
import com.mango.constant.WebConstant;
import com.mango.dao.BlackListDao;
import com.mango.pojo.BlackList;
import com.mango.pojo.Student;
import com.mango.service.BlackListService;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    BlackListDao blackListDao;



    @Override
    public void addStudentBlackList(BlackList blackList) {
        blackListDao.addStudentBlackList(blackList);
    }

    @Override
    public List<Student> getAllBlackedStudent() {
        return blackListDao.getAllBlackedStudent();
    }

    @Override
    public void deleteStudentBlackList(String s_id) {
        blackListDao.deleteStudentBlackList(s_id);
    }

    @Override
    public BlackList getBlackedStudentById(String s_id) {
        return blackListDao.getBlackedStudentById(s_id);
    }
}
