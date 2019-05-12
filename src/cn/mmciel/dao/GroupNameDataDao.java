package cn.mmciel.dao;

import java.util.ArrayList;
import java.util.List;

import cn.mmciel.bean.GroupNameData;

public interface GroupNameDataDao {
//	��ѯ��¼���
	public boolean getFind(GroupNameData data);
//	����û�
	public boolean setGroupNameData(GroupNameData data);
//	�޸��û�����
	public boolean UpdateGroupNameData(GroupNameData data);
//	ɾ���û�����
	public boolean DeleteGroupNameData(GroupNameData data);
	//通过userid寻找名下所有的名单
	public List<GroupNameData> getGroupNameDataByUserId(String Userid);
	//通过key查找采用的名单名称
	public String getGroupNameDataByGroupKey(String groupKey);
}
