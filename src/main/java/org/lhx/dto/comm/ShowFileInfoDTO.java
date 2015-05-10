package org.lhx.dto.comm;

import org.lhx.dto.FileInfoDTO;
/**
 * 文件列表
 */
public class ShowFileInfoDTO extends FileInfoDTO{
	private String userAccount;
	private String userName;
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
