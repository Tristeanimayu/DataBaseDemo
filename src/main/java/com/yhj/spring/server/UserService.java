package com.yhj.spring.server;

import com.yhj.spring.bean.User;
import com.yhj.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //id查询
    public List<User> select(String id){
        return userMapper.select(id);
    }

    //查询全部用户
    public List<User> userList(){
        return userMapper.userList();
    }

    //新增保存用户
    public void save(User user){
        userMapper.save(user);
    }

    //id删除
    public int delete(Integer id){
        return userMapper.delete(id);
    }

    //id查找
    public User findUserById(int id){
        return userMapper.findUserById(id);
    }

    //修改信息
    public int update(User user){
        return userMapper.update(user);
    }












}
