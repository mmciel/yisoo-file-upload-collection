package cn.mmciel.dao.impl;

import java.sql.Timestamp;

import org.apache.commons.dbutils.QueryRunner;

import cn.mmciel.bean.GroupData;
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
					data.getGroupNumber(),
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



}
