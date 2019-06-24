package com.kyrie.contorller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.kyrie.dto.UserDto;
import com.kyrie.pojo.Role;
import com.kyrie.pojo.User;
import com.kyrie.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    private IUserService userService;
	@RequestMapping("/query")
	public String query(Model m){
		List<User> list = userService.query();
		m.addAttribute("list", list);
		return "user/user";
	}
	@RequestMapping("/addUserAndRole")
	public String queryRole(Integer userId, Model m){
		//查询所有角色信息
		List<Role> roles = userService.queryRole();
		m.addAttribute("roles", roles);
		if (userId != null) {
			//点击修改把用户的信息和用户具有的角色信息保存在dto对象中
			UserDto dto = userService.getUpdateInfo(userId);
			m.addAttribute("dto", dto);
		}
		return "user/addUserAndRole";
	}
      @RequestMapping("/saveAddUserAndRole")
	public String saveUserAndRole(UserDto dto){
    	 if (dto != null&&dto.getUser()!=null&&dto.getUser().getUserId()!=null) {
			userService.updateUserAndRole(dto);
		}else {
			userService.saveUserAndRole(dto);
		}
		return "redirect:/user/queryPage";
	}
      @RequestMapping("/deleteUser")
      public String deleteUser(Integer userId){
    	  if(userId != null){
    		 //先删除中间表数据 
    		  userService.deleteUserAndRole(userId);
    		  //再删除用户表中数据
    		  userService.deleteUser(userId);
    	  }
    	  return "redirect:/user/queryPage";
      }
      @RequiresRoles("管理员")
      @RequestMapping("/queryPage")
      public String queryPage(Model m, UserDto dto){
    	  PageInfo<User> pageInfo = userService.queryUserByPage(dto);
    	  m.addAttribute("pageModel", pageInfo);
    	  return "user/user";
      }
}
