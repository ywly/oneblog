package com.oneblog.service.impl;

import com.oneblog.dao.userDao;
import com.oneblog.entity.User;
import com.oneblog.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl implements userService {
    //需要调用dao层的方法
    @Resource
    private userDao dao;



    @Override
    public List<User> selectStudent() {
        return dao.selectStudent();
    }

    @Override
    public List<User> loginuser(String username,String password) {

        return dao.loginuser(username,password);
    }

    @Override
    public List<User> usernameishave(String username) {
        return dao.usernameishave(username);
    }

    @Override
    public List<User> emailishave(String email) {
        return dao.emailishave(email);
    }

    @Override
    public void adduser(User user) {
        dao.adduser(user);
    }
}
