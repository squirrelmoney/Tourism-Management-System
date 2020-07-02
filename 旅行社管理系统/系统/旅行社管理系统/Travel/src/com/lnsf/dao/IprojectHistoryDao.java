package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.ProjectHistory;


public interface IprojectHistoryDao
{
	//查找所有的历史记录信息，返回一个list
	abstract List<ProjectHistory> findAllProjectHistory();
		
	//插入新历史记录信息，要求项目事先存在
	abstract boolean insertInfoToProjectHistory(ProjectHistory ph);
	
	//更新历史记录信息的次数，要求项目事先存在
	abstract boolean updateProjectHistory(ProjectHistory ph);
}
