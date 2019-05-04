package cn.mmciel.bean;

public class AirFileData {
	private String ShareCode;
	private String FilePath;
	private int  DownCount;
	private String FileCode;
	private int  MaxCount;
	
	
	public String getShareCode() {
		return ShareCode;
	}
	public void setShareCode(String shareCode) {
		ShareCode = shareCode;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public int getDownCount() {
		return DownCount;
	}
	public void setDownCount(int downCount) {
		DownCount = downCount;
	}
	public String getFileCode() {
		return FileCode;
	}
	public void setFileCode(String fileCode) {
		FileCode = fileCode;
	}
	public int getMaxCount() {
		return MaxCount;
	}
	public void setMaxCount(int maxCount) {
		MaxCount = maxCount;
	}
	
}
