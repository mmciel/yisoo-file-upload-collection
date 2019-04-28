package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.mmciel.bean.ProjectData;
import cn.mmciel.bean.UserData;
import cn.mmciel.dao.ProjectDataDao;
import cn.mmciel.utils.JdbcUtils;

public class ProjectDataDaoImpl implements ProjectDataDao{
	QueryRunner runner = null;
	public ProjectDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	public boolean setProjectData(ProjectData data) {
		String sql = "insert into projectdata values"
				+ "(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int update = runner.update(sql,
					data.getUserid(),data.getProjectname(),
					data.getProjectps(),
					data.getIsgroup(),data.getFilepath(),
					data.getStarttime(),data.getEndtime(),
					data.getStatus(),data.getGroup(),
					data.getGroupname(),
					data.getFnhead(),data.getFnend(),
					data.getFnmid());
			if(update == 1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public boolean UpdateProjectData(ProjectData data) {
		return false;
	}

	@Override
	public boolean DeleteProjectData(ProjectData data) {
		return false;
	}
	@Override
	public ProjectData getProjectDataByProjectName(String ProjectName) {
		return null;
	}
	
	public List<ProjectData> getProjectDataByUser(String UserId) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM projectdata where userid=?";
		try {
			List<ProjectData> list = qr.query(sql, new BeanListHandler<ProjectData>(ProjectData.class),UserId);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Test
	public void  fff() {
		ProjectDataDaoImpl k = new ProjectDataDaoImpl();
		List<ProjectData> temp = k.getProjectDataByUser("100000");
		System.out.println(temp.size());
	}


}
