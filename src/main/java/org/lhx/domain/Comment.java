package org.lhx.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 评论
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseDomain{

	private static final long serialVersionUID = 5287362160004165674L;
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name = "createUser_id")
	private User user; // 一个用户可以发表多次评论话题；
	
	@Column(name = "content")
	private String content; // 内容
	
	@Column(name = "title")
	private String title; // 话题
	
	@Column(name = "pubDate")
	private Long pubDate = new Date().getTime(); // 发表时间
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_comment", 
		joinColumns = { @JoinColumn(name = "comment_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> commentUsers = new HashSet<User>(); // 一个用户可以回复多次

	@Column(name = "status")
	private int status = 1; // 状态：1发布：-1删除
	
	public Comment(){
		
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPubDate() {
		return pubDate;
	}

	public void setPubDate(Long pubDate) {
		this.pubDate = pubDate;
	}

	public Set<User> getCommentUsers() {
		return commentUsers;
	}
	public void setCommentUsers(Set<User> commentUsers) {
		this.commentUsers = commentUsers;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentUsers == null) ? 0 : commentUsers.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + status;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentUsers == null) {
			if (other.commentUsers != null)
				return false;
		} else if (!commentUsers.equals(other.commentUsers))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "Comment [user=" + user + ", content=" + content + ", title="
				+ title + ", pubDate=" + pubDate + ", commentUsers="
				+ commentUsers + ", status=" + status + "]";
	}
	
	
	
}
