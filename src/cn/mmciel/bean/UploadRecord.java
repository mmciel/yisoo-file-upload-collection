package cn.mmciel.bean;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class UploadRecord {
	private String ProjectId;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp CreateTime;
	private String FileName;
	private String GroupKey;
	private String GroupNumber;
	public UploadRecord(String projectId, Timestamp createTime, String fileName, String groupKey, String groupNumber) {
		ProjectId = projectId;
		CreateTime = createTime;
		FileName = fileName;
		GroupKey = groupKey;
		GroupNumber = groupNumber;
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
	public String getGroupNumber() {
		return GroupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		GroupNumber = groupNumber;
	}

	
}
