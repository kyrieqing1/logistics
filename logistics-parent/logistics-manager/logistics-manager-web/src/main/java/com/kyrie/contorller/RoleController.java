package com.kyrie.contorller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.kyrie.pojo.Role;
import com.kyrie.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
   private IRoleService roleService;
	@RequestMapping("/query")
	public String query(Model m){
		List<Role> list = roleService.query();
		m.addAttribute("list", list);
		return "role/role";
	}   
}
