package org.lhx.dto;


/**
 * 评论dto
 */
public class InfomationDTO {
	
	private String id;
	private String title;
	private String pubDate;
	private String pubUser;
	private String content;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getPubUser() {
		return pubUser;
	}
	public void setPubUser(String pubUser) {
		this.pubUser = pubUser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
