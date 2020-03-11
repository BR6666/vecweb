package com.foxgod.vecweb.mapper;


import com.foxgod.vecweb.bean.AdminInfo;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    @Select("select * from admin_info where name=#{name}")
    public AdminInfo userlogin(String name);

}
