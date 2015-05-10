package org.lhx.dto;

import java.util.List;

import org.lhx.dto.comm.CommentUserDTO;

/**
 * 话题回复界面详细信息对象
 */
public class UserCommentRelationDTO {
	private String commCreateUserAccount; // 发起用户账号
	private String commCreateUserName; // 用户名
	
	private String commCreateTime; // 话题创建时间
	private String commContent; // 话题内容
	private String commTitle; // 话题标题
	
	private List<CommentUserDTO> commentUserDTOs; // 参与回复的所有用户，可以包含自己，按照时间升序排序
	public UserCommentRelationDTO(){
		
	}
	
	public UserCommentRelationDTO(String commCreateUserAccount,
			String commCreateUserName, String commCreateTime,
			String commContent, String commTitle) {
		super();
		this.commCreateUserAccount = commCreateUserAccount;
		this.commCreateUserName = commCreateUserName;
		this.commCreateTime = commCreateTime;
		this.commContent = commContent;
		this.commTitle = commTitle;
	}


	public String getCommCreateUserAccount() {
		return commCreateUserAccount;
	}
	public void setCommCreateUserAccount(String commCreateUserAccount) {
		this.commCreateUserAccount = commCreateUserAccount;
	}
	public String getCommCreateUserName() {
		return commCreateUserName;
	}
	public void setCommCreateUserName(String commCreateUserName) {
		this.commCreateUserName = commCreateUserName;
	}
	public String getCommCreateTime() {
		return commCreateTime;
	}
	public void setCommCreateTime(String commCreateTime) {
		this.commCreateTime = commCreateTime;
	}
	public String getCommContent() {
		return commContent;
	}
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}
	public String getCommTitle() {
		return commTitle;
	}
	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}

	public List<CommentUserDTO> getCommentUserDTOs() {
		return commentUserDTOs;
	}

	public void setCommentUserDTOs(List<CommentUserDTO> commentUserDTOs) {
		this.commentUserDTOs = commentUserDTOs;
	}
	
}
