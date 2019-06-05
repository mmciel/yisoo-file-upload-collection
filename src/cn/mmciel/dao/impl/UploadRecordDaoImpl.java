package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mmciel.bean.GroupData;
import cn.mmciel.bean.ProjectData;
import cn.mmciel.bean.UploadRecord;
import cn.mmciel.dao.UploadRecordDao;
import cn.mmciel.utils.JdbcUtils;



public class UploadRecordDaoImpl implements UploadRecordDao {
	QueryRunner runner = null;
	public UploadRecordDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}

	public boolean setUploadRecord(UploadRecord data) {
		String sql = "insert into uploadrecord values"
				+ "(?,?,?,?,?)";

		try {

			int update = runner.update(sql,
					data.getProjectId(),
					data.getGroupKey(),
					data.getNumber(),
					data.getFileName(),
					data.getCreateTime()
					);
			if(update != 1) {
				return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true ;
	}

	@Override
	public List<UploadRecord> getUploadRecordByProjectId(String projectid) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM uploadrecord where projectid=?";
		try {
			List<UploadRecord> list = qr.query(sql,
					new BeanListHandler<UploadRecord>(UploadRecord.class),
					projectid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
