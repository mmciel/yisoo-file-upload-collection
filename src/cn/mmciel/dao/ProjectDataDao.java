package cn.mmciel.dao;

import cn.mmciel.bean.ProjectData;

public interface ProjectDataDao {
//	get
	public ProjectData getProjectDataByProjectName(String ProjectName);
	public ProjectData getProjectDataByUser(String UserId);
//	添加
	public boolean setProjectData(ProjectData data);
//	修改数据
	public boolean UpdateProjectData(ProjectData data);
//	删除数据
	public boolean DeleteProjectData(ProjectData data);
}
