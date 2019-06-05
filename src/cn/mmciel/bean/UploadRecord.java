package cn.mmciel.bean;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class UploadRecord {
	private String ProjectId;
	private String GroupKey;
	private String Number;
	private String FileName;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp CreateTime;
	
	public UploadRecord() {}

	public UploadRecord(String projectId, String groupKey, String number, String fileName, Timestamp createTime) {
		ProjectId = projectId;
		GroupKey = groupKey;
		Number = number;
		FileName = fileName;
		CreateTime = createTime;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getGroupKey() {
		return GroupKey;
	}
	public void setGroupKey(String groupKey) {
		GroupKey = groupKey;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String Number) {
		this.Number = Number;
	}

	
}
