package com.foxgod.vecweb.mapper;

import com.foxgod.vecweb.bean.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user_info")
    public List<UserInfo> getAllUsers();
}
