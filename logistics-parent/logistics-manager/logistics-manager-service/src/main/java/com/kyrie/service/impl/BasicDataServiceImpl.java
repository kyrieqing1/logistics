package com.kyrie.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyrie.dto.BasicDataDto;
import com.kyrie.mapper.BasicDataMapper;
import com.kyrie.pojo.BasicData;
import com.kyrie.pojo.BasicDataExample;
import com.kyrie.service.IBasicDataService;
@Service
public class BasicDataServiceImpl implements IBasicDataService {
	@Autowired
    private BasicDataMapper basicDataMapper;
	@Override
	public List<BasicData> query() {
		BasicDataExample example = new BasicDataExample();
		return basicDataMapper.selectByExample(example);
	}
	@Override
	public PageInfo<BasicData> queryBasicDataByPage(BasicDataDto dto) {
		if (dto.getPageNum()!=null&&dto.getPageSize()!=null) {
			PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		}
		//查询所有的BasicData信息
		List<BasicData> list = this.query();
		PageInfo<BasicData> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public List<BasicData> queryByParentId() {
		BasicDataExample example = new BasicDataExample();
		example.createCriteria().andParentIdIsNull();
		return basicDataMapper.selectByExample(example);
	}
	@Override
	public BasicDataDto getUpdateInfo(Integer baseId) {
		//表示是修改操作
		BasicData basicData = this.basicDataMapper.selectByPrimaryKey(baseId);
		BasicDataDto dto = new BasicDataDto();
		dto.setBasicData(basicData);
		return dto;
	}
	@Override
	public void saveBasicData(BasicDataDto dto) {
		BasicData basicData = dto.getBasicData();
		//保存基本数据
		this.basicDataMapper.insertSelective(basicData);
	}
	@Override
	public void updateBasicData(BasicDataDto dto) {
		//获取更新的基本数据
		BasicData basicData = dto.getBasicData();
		this.basicDataMapper.updateByPrimaryKeySelective(basicData);
	}
	@Override
	public void deleteBasicData(Integer baseId) {
		this.basicDataMapper.deleteByPrimaryKey(baseId);
	}

}
