package com.foxgod.vecweb.mapper;

import com.foxgod.vecweb.bean.AdminInfo;

import com.foxgod.vecweb.bean.AdminJurisdiction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {

    @Select("SELECT admin_info.name as name, admin_info.password ,admin_info.remarks ,admin_jurisdiction.name as jurisdiction  \n" +
            "FROM admin_info,admin_jurisdiction where admin_info.jurisdiction=admin_jurisdiction.num")
    public List<AdminInfo> selectadmin();

    @Select("select  * from admin_jurisdiction  limit 1,99")
    public List<AdminJurisdiction> selectadminjurisdiction();

    @Insert("insert into admin_info(name,password,jurisdiction,remarks) values(#{name},#{password},#{jurisdiction},#{remarks})")
    public Integer addadmin(AdminInfo adminInfo);

    @Select("select * from admin_info where name=#{name}")
    public AdminInfo isadminname(String name);

    @Delete("delete from admin_info where name=#{name}")
    public Integer deladmin(String name);

    @Update("update admin_info set password=#{password},jurisdiction=#{jurisdiction},remarks=#{remarks} where name=#{name}")
    public Integer update(AdminInfo adminInfo);
}
