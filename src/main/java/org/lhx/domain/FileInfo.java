package org.lhx.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 文件信息表
 */
@Entity
@Table(name = "file_info")
public class FileInfo extends BaseDomain{

	private static final long serialVersionUID = 7293881093770595633L;
	@Column(name = "fileName")
	private String fileName; // 文件名
	
	@Column(name = "fileSize") 
	private long fileSize; // 文件大小
	
	@Column(name = "fileType")
	private String fileType; // 文件类型
	
	@Column(name = "uploadTime")
	private long uploadTime; // 上传时间
	@Column(name = "filePath")
	private String filePath; // 存放路径，相对路径
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name = "user_id")
	private User user; //上传用户
	
	
	public FileInfo(){
		
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public long getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(long uploadTime) {
		this.uploadTime = uploadTime;
	}
	
}
