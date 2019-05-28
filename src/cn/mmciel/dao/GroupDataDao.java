package cn.mmciel.dao;

import java.util.ArrayList;
import java.util.List;

import cn.mmciel.bean.GroupData;

public interface GroupDataDao {
//	通过GroupKey获取全部
	public List<GroupData> getGroupData(String GroupKey);
//	通过number获取
	public GroupData getGroupDataByNumber(String GroupKey,String Number);
//	���
	public boolean setGroupData(GroupData data);
//	��������б�
	public boolean setGroupListData(ArrayList<GroupData> listdata);
//	�޸�����
	public boolean UpdateGroupData(GroupData data);
//	ɾ������
	public boolean DeleteGroupData(GroupData data);
}
