package cn.mmciel.bean;

import java.sql.Timestamp;

public class ViewData {
	private String projectid;
	private String groupkey;
	private String number;
	private String filename;
	private Timestamp createtime;
	private String name;
	private String grade;
	private int iscommit;
	
	
	public ViewData(String projectid, String groupkey, String number, String filename, Timestamp createtime,
			String name, String grade, int iscommit) {
		super();
		this.projectid = projectid;
		this.groupkey = groupkey;
		this.number = number;
		this.filename = filename;
		this.createtime = createtime;
		this.name = name;
		this.grade = grade;
		this.iscommit = iscommit;
	}
	public int getIscommit() {
		return iscommit;
	}
	public void setIscommit(int iscommit) {
		this.iscommit = iscommit;
	}

	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getGroupkey() {
		return groupkey;
	}
	public void setGroupkey(String groupkey) {
		this.groupkey = groupkey;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "ViewData [projectid=" + projectid + ", groupkey=" + groupkey + ", number=" + number + ", filename="
				+ filename + ", createtime=" + createtime + ", name=" + name + ", grade=" + grade + ", iscommit="
				+ iscommit + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
