package com.foxgod.vecweb.mapper;

import com.foxgod.vecweb.bean.UserInfo;
import com.foxgod.vecweb.bean.UserVisit;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface DashboardMapper {

    //获取今日访问人数
    @SelectProvider(type = DashboardSql.class, method = "todayVisitNumber")
    public List<UserVisit> getTodayVisitNumber(String today);

    //获取新增用户
    @SelectProvider(type = DashboardSql.class, method = "newUser")
    public List<UserInfo> getNewUser(String today);

    //获取用户人数
    @SelectProvider(type = DashboardSql.class, method = "usernumber")
    public List<UserInfo> getUserNumber();

    //获取本周访问人数
    @SelectProvider(type = DashboardSql.class, method = "weekVisitNumber")
    public List<UserVisit> getWeekVisitNumber();


    class DashboardSql {
        public String todayVisitNumber(String today) {
            String sql = "SELECT * FROM `user_visit` where visit_time " +
                    "between '" + today + " 00:00:00' and '" + today + " 23:59:59'";
//            System.out.println(sql);
            return sql;
        }

        public String newUser(String today) {
            String sql = "SELECT * FROM `user_info` where create_time " +
                    "between '" + today + " 00:00:00' and '" + today + " 23:59:59'";
//            System.out.println(sql);
            return sql;
        }

        public String usernumber() {
            String sql = "SELECT * FROM `user_info`";
//            System.out.println(sql);
            return sql;
        }

        public String weekVisitNumber() {
            String sql = "SELECT * FROM user_visit WHERE " +
                    "YEARWEEK(DATE_FORMAT(visit_time,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1);";
//            System.out.println(sql);
            return sql;
        }

    }
}
