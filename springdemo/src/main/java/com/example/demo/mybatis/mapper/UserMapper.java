package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAll();

    List<User> getUserByName(@Param("name") String name);

    int deleteByLoginName(String loginname);

    int insert(User User);

    void updateName(User User);
}
