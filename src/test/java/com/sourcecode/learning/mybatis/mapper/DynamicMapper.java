package com.sourcecode.learning.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DynamicMapper {
	
	//根据表名称查询该表数据
	public List<Map<String, Object>> queryByTableName(@Param("tableName")String tableName);

}
