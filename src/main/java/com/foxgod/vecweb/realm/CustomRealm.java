package com.foxgod.vecweb.realm;

import com.foxgod.vecweb.bean.AdminInfo;
import com.foxgod.vecweb.mapper.LoginMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author FoxGod
 * @Date 2020/03/16 14:51
 */
public class CustomRealm extends AuthorizingRealm {

@Autowired
    LoginMapper loginMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token.getPrincipal() == null) {
            return null;
        }
        String username = token.getPrincipal().toString();
        AdminInfo adminInfo = loginMapper.userlogin(username);
        if (adminInfo == null) {
            throw  new UnknownAccountException("用户名不存在");
        }
        String realmName = getName();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, adminInfo.getPassword(), realmName);
        return simpleAuthenticationInfo;
    }
}
