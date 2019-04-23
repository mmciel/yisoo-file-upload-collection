package cn.mmciel.dao.impl;

import org.junit.Test;


import cn.mmciel.bean.UserData;

public class TestUserDataImpl {
	
	@Test
	public void test() {
		UserDataImpl t = new UserDataImpl();
		UserData data = new UserData();
		data.setPassword("123345");
		data.setUsername("211");
		data.setUsermail("32");
		data.setPermission(1);
		
		
		t.setUserData(data);
		
		
	}
}
