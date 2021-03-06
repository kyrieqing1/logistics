package com.kyrie.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.kyrie.pojo.Role;
import com.kyrie.pojo.User;
import com.kyrie.service.IUserService;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		String userName = uptoken.getUsername();
		User user = new User();
		user.setUserName(userName);
		//从数据库查询用户信息
		List<User> list = userService.queryByUserName(user);
		if (list==null||list.size()!=1) {
			return null;
		}
		User userBean = list.get(0);
		SimpleAuthenticationInfo info = 
				new SimpleAuthenticationInfo(userBean, userBean.getPassword(), new SimpleByteSource(userBean.getU1()), "qing");
		return info;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取认证用户的信息
		User user = (User) principals.getPrimaryPrincipal();
		//根据登录用户对应的角色信息
		List<Role> roles = userService.queryRoleByUserId(user.getUserId());
		//获取授权对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (roles!=null&&roles.size()>0) {
			for (Role role : roles) {
				//将用户具有的角色信息保存在该对象中
				info.addRole(role.getRoleName());
			}
		}
		return info;
	}

}
