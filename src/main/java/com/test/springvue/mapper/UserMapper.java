package com.test.springvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springvue.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user")
//    public List<User> query();
//    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);
    @Select("select * from t_user where id=#{id}")
    User selectById(int id);

    //对多用many=@Many
    //对一用one=@One
    @Select("select * from t_user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id", property = "orders",javaType = List.class,
                many = @Many(select = "com.test.springvue.mapper.OrderMapper.selectByUid"))
    })
    List<User> selectAllUserAndOrders();
}
