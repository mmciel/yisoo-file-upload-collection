package cn.mmciel.dao;

import cn.mmciel.bean.UploadRecord;

public interface UploadRecordDao {
	//数据存入数据库
	public boolean setUploadRecord(UploadRecord data);
}
