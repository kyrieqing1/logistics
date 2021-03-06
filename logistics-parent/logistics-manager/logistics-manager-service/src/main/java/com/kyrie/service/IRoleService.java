package com.kyrie.service;

import java.util.List;

import com.kyrie.pojo.Role;

public interface IRoleService {
    public List<Role> query();
    public Integer addRole(Role role);
    public Integer updateRole(Role role);
    public Integer deleteRole(Integer id);
    public Role queryById(Integer id);
	public List<Role> queryRoleByUserId(Integer userId);
}
