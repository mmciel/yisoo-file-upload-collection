package cn.mmciel.dao;

import cn.mmciel.bean.ProjectShareData;

public interface ProjectShareDataDao {
	
//	写入到数据库
	public boolean setProjectShareData(ProjectShareData data);
//	根据Id取到对象
	public ProjectShareData getProjectShareDataById(String data);
//	根据key取到对象
	public ProjectShareData getProjectShareDataByKey(String data);
//	根据key取到id
	public String getProjectIdByKey(String data);
//	根据id取到key
	public String getProjectKeyById(String data);
//	根据projectid删除
	public boolean DelProjectShareDataByProjectId(String data);
	
}
