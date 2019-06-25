<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">基础数据管理管理</a></li>
    </ul>
    </div>
    <div class="formbody">   
    <div class="formtitle"><span>基本信息</span></div>
  <form action="/basic/saveAddOrUpdateBasicData" method="post">
    <ul class="forminfo">
    <input name="basicData.baseId" type="hidden" value="${dto.basicData.baseId}" />
    <li><label>基础数据</label>
    <input name="basicData.baseName" type="text" class="dfinput" value="${dto.basicData.baseName}"/>
    </li>
    <li><label>描述数据</label>
    <input name="basicData.baseDesc" type="text" class="dfinput" value="${dto.basicData.baseDesc}"/>
    </li>
    <c:if test="${empty dto}">
    <li><label>所属类型</label>
                    
                    <div class="vocation">
                        <select class="select1" name="basicData.parentId">
                        <option value="0">--类别数据--</option>
                        <c:forEach items="${parents}" var="parent">
                            <option value="${parent.baseId}">${parent.baseName}</option>
                        </c:forEach>
                        </select>
                    </div>
                    <i></i>
              </li>
    </c:if>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
 </form>
 </div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>