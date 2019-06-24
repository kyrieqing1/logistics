package com.kyrie.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.kyrie.dto.UserDto;
import com.kyrie.pojo.Role;
import com.kyrie.pojo.User;

public interface IUserService {
    public List<User> query();
    public Integer addUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
    public User queryById(Integer id);
    public List<Role> queryRole();
	public Integer saveUserAndRole(UserDto dto);
	public List<Role> queryRoleByUserId(Integer userId);
	public UserDto getUpdateInfo(Integer userId);
	public void updateUserAndRole(UserDto dto);
	public void deleteUserAndRole(Integer userId);
	public PageInfo<User> queryUserByPage(UserDto dto);
	public List<User> queryByUserName(User user);
}
