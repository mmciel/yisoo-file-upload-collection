package cn.mmciel.dao.impl;


import java.sql.Timestamp;

import org.junit.Test;

import cn.mmciel.bean.ProjectData;

public class TestProjectDataImpl {
	@Test
	public void test() {
		Timestamp etime = new Timestamp(System.currentTimeMillis());
		Timestamp stime = new Timestamp(System.currentTimeMillis());
		ProjectData data = new ProjectData();
		data.setUserid("10000");
		data.setProjectname("yisoo");
		data.setIsgroup(1);
		data.setFilepath("./dididi");
		
		data.setStarttime(etime);
		data.setEndtime(stime);
		data.setStatus("1");
		data.setGroupkey("123123");
		data.setFnhead("k");
		data.setFnmid("-");
		data.setFnend("=");;
		
		new ProjectDataDaoImpl().setProjectData(data);
	}
}
