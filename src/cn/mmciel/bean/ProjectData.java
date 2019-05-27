package cn.mmciel.bean;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;
public class ProjectData {
	private String userid;
	private String projectid;
	private String projectname;
	private String projectps;

	private int isgroup;
	private String filepath;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp starttime;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp endtime;
	private String status;
	private String groupkey;
	private String fnhead;
	private String fnend;
	private String fnmid;
	private String groupname;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getIsgroup() {
		return isgroup;
	}
	public void setIsgroup(int isgroup) {
		this.isgroup = isgroup;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getFnhead() {
		return fnhead;
	}
	public void setFnhead(String fnhead) {
		this.fnhead = fnhead;
	}
	public String getFnend() {
		return fnend;
	}
	public void setFnend(String fnend) {
		this.fnend = fnend;
	}
	public String getFnmid() {
		return fnmid;
	}
	public void setFnmid(String fnmid) {
		this.fnmid = fnmid;
	}
	public String getProjectps() {
		return projectps;
	}
	public void setProjectps(String projectps) {
		this.projectps = projectps;
	}
	

	@Override
	public String toString() {
		return "ProjectData [userid=" + userid + ", projectid=" + projectid + ", projectname=" + projectname
				+ ", projectps=" + projectps + ", isgroup=" + isgroup + ", filepath=" + filepath + ", starttime="
				+ starttime + ", endtime=" + endtime + ", status=" + status + ", groupkey=" + groupkey + ", fnhead="
				+ fnhead + ", fnend=" + fnend + ", fnmid=" + fnmid + ", groupname=" + groupname + "]";
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGroupkey() {
		return groupkey;
	}
	public void setGroupkey(String groupkey) {
		this.groupkey = groupkey;
	}
	
}
