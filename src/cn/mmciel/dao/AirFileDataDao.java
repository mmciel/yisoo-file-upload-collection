package cn.mmciel.dao;

import cn.mmciel.bean.AirFileData;

public interface AirFileDataDao {
	//添加数据到数据库
	public boolean setAirFileData(AirFileData data);
	
	//通过sharecode获取数据库信息
	public AirFileData getAirFileData(String ShareCode);
}
