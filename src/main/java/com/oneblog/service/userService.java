package com.oneblog.service;

import com.oneblog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {


        /**
         * 查询Student表全部数据
         * @return
         */
        public List<User> selectStudent();
        /**
         * 用户登录
         */
        public List<User> loginuser(String username,String password);
        /**
         * 查询用户名是否可用
         */
        public List<User> usernameishave(String username);
        /**
         * 查询邮箱是否可用
         */
        public List<User> emailishave(String email);
        /**
         * 用户注册
         */
        void adduser(User user);
}
