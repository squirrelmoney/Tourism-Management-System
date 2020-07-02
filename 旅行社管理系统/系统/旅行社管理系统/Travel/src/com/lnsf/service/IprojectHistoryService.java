package com.lnsf.service;

import java.util.List;

import com.lnsf.model.ProjectHistory;

public interface IprojectHistoryService
{
	//查找所有的历史记录信息，返回一个list
	abstract List<ProjectHistory> AllProjectHistory();
		
	//插入新历史记录信息，要求项目事先存在  flag=0--插入失败    flag=1--插入成功   
	//flag=2--插入失败，项目表中没有该项目，则无法插入到历史记录表中
	abstract int InsertProjectHistory(ProjectHistory ph);
	
	//更新历史记录信息的次数，要求项目事先存在
	abstract int UpdateProjectHistory(ProjectHistory ph);	
}
