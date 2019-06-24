package com.kyrie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyrie.mapper.RoleMapper;
import com.kyrie.pojo.Role;
import com.kyrie.pojo.RoleExample;
import com.kyrie.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> query() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	@Override
	public Integer addRole(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public Integer updateRole(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public Integer deleteRole(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role queryById(Integer id) {		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> queryRoleByUserId(Integer userId) {
		return roleMapper.queryRoleByUserId(userId);
	}

}
