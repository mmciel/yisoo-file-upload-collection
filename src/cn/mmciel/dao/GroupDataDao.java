package cn.mmciel.dao;

import java.util.ArrayList;
import java.util.List;

import cn.mmciel.bean.GroupData;

public interface GroupDataDao {
//	��ѯ���
	public List<GroupData> getGroupData(String GroupKey);
//	���
	public boolean setGroupData(GroupData data);
//	��������б�
	public boolean setGroupListData(ArrayList<GroupData> listdata);
//	�޸�����
	public boolean UpdateGroupData(GroupData data);
//	ɾ������
	public boolean DeleteGroupData(GroupData data);
}
