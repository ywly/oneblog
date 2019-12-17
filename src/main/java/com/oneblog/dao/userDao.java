package com.oneblog.dao;

import com.oneblog.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface userDao {
    /**
     * 查询Student表全部数据
     * @return
     */
    public List<User> selectStudent();
    /**
     * 用户登录
     */
    public List<User> loginuser(@Param("username")String username,@Param("password")String password);

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
