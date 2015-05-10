package org.lhx.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 用户回复评论的关联表
 */
@Entity
@Table(name = "user_comment")
public class UserCommentRelation extends BaseDomain{
	
	private static final long serialVersionUID = -6922022521961301171L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; // 回复的用户
	
	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment comment; // 被回复的评论
	
	@Column(name = "commentTime")
	private Long commentTime = new Date().getTime(); // 回复时间
	
	@Column(name = "replyContent")
	private String replyContent; // 回复内容
	
	public UserCommentRelation(){
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Long getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Long commentTime) {
		this.commentTime = commentTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((commentTime == null) ? 0 : commentTime.hashCode());
		result = prime * result
				+ ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCommentRelation other = (UserCommentRelation) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentTime == null) {
			if (other.commentTime != null)
				return false;
		} else if (!commentTime.equals(other.commentTime))
			return false;
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCommentRelation [user=" + user + ", comment=" + comment
				+ ", commentTime=" + commentTime + ", replyContent="
				+ replyContent + "]";
	}
	
}
