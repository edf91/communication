package org.lhx.dto.comm;

import java.util.Date;

/**
 * 回复DTO
 */
public class CreateUserCommentRelationDTO {
	private String commentUserId; // 回复用户的id
	private String commentId; // 被回复话题的id
	private String replyContent; // 回复内容
	private long commentTime = new Date().getTime(); //回复时间
	
	
	public CreateUserCommentRelationDTO(String commentUserId, String commentId,
			String replyContent) {
		super();
		this.commentUserId = commentUserId;
		this.commentId = commentId;
		this.replyContent = replyContent;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public long getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(long commentTime) {
		this.commentTime = commentTime;
	}
	
	
	
}
