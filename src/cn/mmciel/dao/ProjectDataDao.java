package cn.mmciel.dao;

import cn.mmciel.bean.ProjectData;

public interface ProjectDataDao {
//	get
	public ProjectData getProjectDataByProjectName(String ProjectName);
	public ProjectData getProjectDataByUser(String UserId);
//	���
	public boolean setProjectData(ProjectData data);
//	�޸�����
	public boolean UpdateProjectData(ProjectData data);
//	ɾ������
	public boolean DeleteProjectData(ProjectData data);
}
