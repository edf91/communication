package org.lhx.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * user类，代表学生和老师
 */
@Table(name = "user")
@Entity
public class User extends BaseDomain {

	private static final long serialVersionUID = -2345180469199893022L;

	@Column(name = "account")
	private String account; // 账号：学号或者工号
	
	@Column(name = "name")
	private String name; // 用户名字
	@Column(name = "password")
	private String password; // 密码
	
	@Column(name = "userType")
	private String userType; // 用户类型：0：学生；1：老师
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Infomation> infos = new HashSet<Infomation>(); // 老师开发布多次通知
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comment> comments = new HashSet<Comment>(); // 一个用户可以发表多次话题
	
	public User() {

	}

	public User(String userId) {
		super(userId);
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Infomation> getInfos() {
		return infos;
	}

	public void setInfos(Set<Infomation> infos) {
		this.infos = infos;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((infos == null) ? 0 : infos.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
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
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (infos == null) {
			if (other.infos != null)
				return false;
		} else if (!infos.equals(other.infos))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password
				+ ", userType=" + userType + ", infos=" + infos + ", comments="
				+ comments + "]";
	}

}
