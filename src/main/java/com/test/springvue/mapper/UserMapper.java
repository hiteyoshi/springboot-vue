package com.test.springvue.mapper;

import com.test.springvue.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> query();
    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public int insert(User user);
}
