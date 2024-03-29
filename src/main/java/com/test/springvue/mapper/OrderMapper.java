package com.test.springvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springvue.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper {
    @Select("select * from t_order where uid= #{uid}")
    List<Order> selectByUid(int uid);
}
