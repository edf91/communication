package org.lhx.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 老师发布信息
 */
@Entity
@Table(name = "info")
public class Infomation extends BaseDomain{
	private static final long serialVersionUID = 6097127445526843748L;
	
	/**
	 * 一对多如果一方加了joinColumn另一方不加，则会产生中间表，即要么两方都加要么不加
	 * mappedBy表示由该方维护，另一方不需要维护
	 */
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name = "user_id")
	private User user; // 发布用户
	
	@Column(name = "pubDate")
	private Long pubDate = new Date().getTime(); // 发布时间
	
	@Column(name = "content")
	private String content; // 发布内容
	@Column(name = "title")
	private String title; // 发布标题
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Long getPubDate() {
		return pubDate;
	}

	public void setPubDate(Long pubDate) {
		this.pubDate = pubDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
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
		Infomation other = (Infomation) obj;
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Infomation [user=" + user + ", pubTime=" + pubDate
				+ ", content=" + content + "]";
	}
	
}
