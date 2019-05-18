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

	@Override
	public boolean UpdateProjectStatus(String ProjectID, String status) {
		String sql = "update projectdata set status=? where projectid=?";
		try {
			int update = runner.update(sql,status,ProjectID);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public String getProjectId(String UserID, String ProjectName) {
		//把自动生成的id写到data中
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String tsql = "SELECT * FROM projectdata where projectname=? and userid=?";
		List<ProjectData> list;
		try {
			list = qr.query(tsql, 
					new BeanListHandler<ProjectData>(ProjectData.class),
					ProjectName,UserID);
			System.out.println("sousuoda"+list.get(0).getProjectid());
			return list.get(0).getProjectid();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


}
