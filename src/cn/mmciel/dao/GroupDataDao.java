package cn.mmciel.dao;

import java.util.ArrayList;

import cn.mmciel.bean.GroupData;

public interface GroupDataDao {
//	查询结果
	public GroupData getGroupData(String Group);
//	添加
	public boolean setGroupData(GroupData data);
//	添加数据列表
	public boolean setGroupListData(ArrayList<GroupData> listdata);
//	修改数据
	public boolean UpdateGroupData(GroupData data);
//	删除数据
	public boolean DeleteGroupData(GroupData data);
}
