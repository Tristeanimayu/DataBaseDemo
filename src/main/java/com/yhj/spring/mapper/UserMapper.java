package com.yhj.spring.mapper;

import com.yhj.spring.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //id查询
    List<User> select(String id);

    //查询全部
    List<User> userList();

    //新增保存
    void save(User user);

    //id删除
    int delete(Integer id);

    //id查找
    User findUserById(int id);

    //更改信息
    int update(User user);

}
