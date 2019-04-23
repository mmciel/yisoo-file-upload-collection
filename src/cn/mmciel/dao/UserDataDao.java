package cn.mmciel.dao;

import cn.mmciel.bean.UserData;

/**
 * 用户数据
 * @author mmciel
 *
 */
public interface UserDataDao {
//	查询登录结果
	public boolean getFind(UserData data);
//	添加用户
	public boolean setUserData(UserData data);
//	修改用户数据
	public boolean UpdateUserData(UserData data);
//	删除用户数据
	public boolean DeleteUserData(UserData data);
	
}
