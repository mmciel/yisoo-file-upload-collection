package cn.mmciel.dao;

import cn.mmciel.bean.UserData;

/**
 * �û�����
 * @author mmciel
 *
 */
public interface UserDataDao {
//	��ѯ��¼���
	public boolean getFind(UserData data);
//	����û�
	public boolean setUserData(UserData data);
//	�޸��û�����
	public boolean UpdateUserData(UserData data);
//	ɾ���û�����
	public boolean DeleteUserData(UserData data);
	
}
