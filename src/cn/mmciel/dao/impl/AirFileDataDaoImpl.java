package cn.mmciel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.mmciel.bean.AirFileData;
import cn.mmciel.bean.GroupData;
import cn.mmciel.dao.AirFileDataDao;
import cn.mmciel.utils.JdbcUtils;

public class AirFileDataDaoImpl implements AirFileDataDao {

	QueryRunner runner = null;
	public AirFileDataDaoImpl() {
		runner = new QueryRunner(JdbcUtils.getDataSource());

	}
	
	@Override
	public boolean setAirFileData(AirFileData data) {
		String sql = "insert into airfiledata values"
				+ "(?,?,?,?,?)";

		try {
			//判断分享码是否重复
//			if(this.getAirFileData(data.getShareCode())!=null) {
//				return false;
//			}
			int update = runner.update(sql,
					data.getShareCode(),
					data.getFilePath(),
					data.getDownCount(),
					data.getFileCode(),
					data.getMaxCount());
			//System.out.println(update);
			if(update != 1) {
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AirFileData getAirFileData(String ShareCode) {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT * FROM airfiledata where sharecode=?";
		try {
			List<AirFileData> list = qr.query(sql,
					new BeanListHandler<AirFileData>(AirFileData.class),
					ShareCode);
			if(list.size()==0) {
				return null;
			}else {
				return list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
