package com.dhu.config;
import com.dhu.pojo.User;
import com.dhu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到用户对象
        Subject subject = SecurityUtils.getSubject();
        //获取用户登录信息
        User currentUser = (User) subject.getPrincipal();
        //拿到用户权限并授权
        info.addStringPermission(currentUser.getPerms());
        System.out.println("执行了授权");
        return info;
    }

    @Override//认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken= (UsernamePasswordToken) authenticationToken;
        User user = userService.selectPasswordByName(userToken.getUsername());
        if(user==null){
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("username",user.getUserName());
        System.out.println("执行了认证");
        //执行认证并传递共享资源
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
