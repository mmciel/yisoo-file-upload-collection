package cn.mmciel.dao;

import java.util.ArrayList;

import cn.mmciel.bean.GroupData;

public interface GroupDataDao {
//	��ѯ���
	public GroupData getGroupData(String Group);
//	���
	public boolean setGroupData(GroupData data);
//	��������б�
	public boolean setGroupListData(ArrayList<GroupData> listdata);
//	�޸�����
	public boolean UpdateGroupData(GroupData data);
//	ɾ������
	public boolean DeleteGroupData(GroupData data);
}
