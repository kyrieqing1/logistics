package com.kyrie.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.kyrie.dto.BasicDataDto;
import com.kyrie.pojo.BasicData;

public interface IBasicDataService {
   public List<BasicData> query();

   public PageInfo<BasicData> queryBasicDataByPage(BasicDataDto dto);

   public List<BasicData> queryByParentId();

   public BasicDataDto getUpdateInfo(Integer baseId);

   public void saveBasicData(BasicDataDto dto);

   public void updateBasicData(BasicDataDto dto);

   public void deleteBasicData(Integer baseId);
}
