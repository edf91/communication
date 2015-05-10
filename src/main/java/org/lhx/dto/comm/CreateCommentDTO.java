package org.lhx.dto.comm;

import org.lhx.dto.CommentDTO;
/**
 * 创建话题dto
 */
public class CreateCommentDTO extends CommentDTO{
	private String userId;
	private String content;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
