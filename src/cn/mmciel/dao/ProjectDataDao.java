package cn.mmciel.dao;

import java.util.List;

import cn.mmciel.bean.ProjectData;

public interface ProjectDataDao {
//	get
	public ProjectData getProjectDataByProjectName(String ProjectName);
	public List<ProjectData> getProjectDataByUser(String UserId);
//	通过id找项目资料
	public ProjectData getProjectDataByProjectId(String data);
//	���
	public boolean setProjectData(ProjectData data);
//	�޸�����
	public boolean UpdateProjectData(ProjectData data);
//  删除
	public boolean DeleteProjectData(ProjectData data);
//	修改当前项目
	public boolean UpdateProjectStatus(String ProjectID,String status);
//	根据userid和项目名找项目id
	public String getProjectId(String UserID,String ProjectName);
//  根据projectid删除
	public boolean DelProjectDataByProjectId(String data);
}
