package com.foxgod.vecweb.mapper;

import com.foxgod.vecweb.bean.AdminInfo;

import com.foxgod.vecweb.bean.AdminJurisdiction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {
    //获取所有角色
    @Select("SELECT admin_info.name as name, admin_info.password ,admin_info.remarks ,admin_jurisdiction.name as jurisdiction  \n" +
            "FROM admin_info,admin_jurisdiction where admin_info.jurisdiction=admin_jurisdiction.num")
    public List<AdminInfo> selectadmin();

    //获取角色权限
    @Select("select  * from admin_jurisdiction  limit 1,99")
    public List<AdminJurisdiction> selectadminjurisdiction();

    //添加角色
    @Insert("insert into admin_info(name,password,jurisdiction,remarks) values(#{name},#{password},#{jurisdiction},#{remarks})")
    public Integer addadmin(AdminInfo adminInfo);

    //查找是否有这个角色
    @Select("select * from admin_info where name=#{name}")
    public AdminInfo isadminname(String name);

    //删除角色信息
    @Delete("delete from admin_info where name=#{name}")
    public Integer deladmin(String name);

    //修改角色信息
    @Update("update admin_info set password=#{password},jurisdiction=#{jurisdiction},remarks=#{remarks} where name=#{name}")
    public Integer update(AdminInfo adminInfo);
}
