package cn.mmciel.dao;

import java.util.List;

import cn.mmciel.bean.UploadRecord;

public interface UploadRecordDao {
	//数据存入数据库
	public boolean setUploadRecord(UploadRecord data);
	
	//取出指定projectid的所有数据到list
	public List<UploadRecord> getUploadRecordByProjectId(String projectid);
	
}
