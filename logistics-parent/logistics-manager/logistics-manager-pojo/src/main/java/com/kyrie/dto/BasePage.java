package com.kyrie.dto;

public class BasePage {
	//设置默认值
   private Integer pageNum = 1;
   private Integer pageSize = 5;
   //查询信息
   private String msg;
public Integer getPageNum() {
	return pageNum;
}
public void setPageNum(Integer pageNum) {
	this.pageNum = pageNum;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
   
}
