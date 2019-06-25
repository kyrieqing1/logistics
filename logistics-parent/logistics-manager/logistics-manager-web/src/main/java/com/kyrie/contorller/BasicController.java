package com.kyrie.contorller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import com.kyrie.dto.BasicDataDto;
import com.kyrie.pojo.BasicData;
import com.kyrie.service.IBasicDataService;

@Controller
@RequestMapping("/basic")
public class BasicController {
	@Autowired
	private IBasicDataService basicDataService;
	@RequestMapping("/queryPage")
   public String queryByPage(Model m, BasicDataDto dto){
		PageInfo<BasicData> pageInfo = basicDataService.queryBasicDataByPage(dto);
		m.addAttribute("pageModel", pageInfo);
	   return "basicData/basicData";
   }
	@RequestMapping("/addOrUpdateBasicData")
	public String addOrUpdateBasicData(Integer baseId,Model m){
		if (baseId == null) {
			//表示添加用户
			//查询所有的类别数据的信息
			List<BasicData> parents = basicDataService.queryByParentId();
			m.addAttribute("parents", parents);
		}else {
			//表示为修改基础数据信息
		       BasicDataDto dto = basicDataService.getUpdateInfo(baseId);
		       m.addAttribute("dto", dto);
		}
		return "basicData/addOrUpdateBasicData";
	}
	@RequestMapping("/saveAddOrUpdateBasicData")
	public String saveAddOrUpdateBasicData(BasicDataDto dto){
		if (dto!=null&&dto.getBasicData()!=null&&dto.getBasicData().getBaseId()!=null) {
			basicDataService.updateBasicData(dto);
		}else {
			basicDataService.saveBasicData(dto);
		}
		return "redirect:/basic/queryPage";
	}
	@RequestMapping("/deleteBasicData")
	public String deleteBasicData(Integer baseId){
		if (baseId != null) {
			basicDataService.deleteBasicData(baseId);
		}
		return "redirect:/basic/queryPage";
	}
}
