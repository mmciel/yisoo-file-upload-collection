package cn.mmciel.bean;

import java.sql.Timestamp;
public class ProjectData {
	private String userid;
	private String projectid;
	private String projectname;
	private String projectps;

	private int isgroup;
	private String filepath;
	private Timestamp starttime;
	private Timestamp endtime;
	private String status;
	private String group;
	private String fnhead;
	private String fnend;
	private String fnmid;
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
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
	
	public String toString() {
		return "ProjectData [userid=" + userid + ", projectid=" + projectid + ", projectname=" + projectname
				+ ", projectps=" + projectps + ", isgroup=" + isgroup + ", filepath=" + filepath + ", starttime="
				+ starttime + ", endtime=" + endtime + ", status=" + status + ", group=" + group + ", fnhead=" + fnhead
				+ ", fnend=" + fnend + ", fnmid=" + fnmid + "]";
	}
	
}
