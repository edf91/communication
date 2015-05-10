package org.lhx.dto.comm;
/**
 * 回复用户信息
 */
public class CommentUserDTO {
	
	private String discussUserName; // 参与讨论的用户名
	private String discussUserAccount; // 账号
	
	private String discussTime; // 回复时间
	
	private String discussContent; // 回复内容
	
	public CommentUserDTO(){}
	public CommentUserDTO(String discussUserName, String discussUserAccount,
			String discussTime, String discussContent) {
		super();
		this.discussUserName = discussUserName;
		this.discussUserAccount = discussUserAccount;
		this.discussTime = discussTime;
		this.discussContent = discussContent;
	}

	public String getDiscussUserName() {
		return discussUserName;
	}

	public void setDiscussUserName(String discussUserName) {
		this.discussUserName = discussUserName;
	}

	public String getDiscussUserAccount() {
		return discussUserAccount;
	}

	public void setDiscussUserAccount(String discussUserAccount) {
		this.discussUserAccount = discussUserAccount;
	}

	public String getDiscussTime() {
		return discussTime;
	}

	public void setDiscussTime(String discussTime) {
		this.discussTime = discussTime;
	}

	public String getDiscussContent() {
		return discussContent;
	}

	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}
	
	
}
