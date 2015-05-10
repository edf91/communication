package org.lhx.utils;

import javax.servlet.http.HttpSession;

import org.lhx.domain.User;
/**
 * 获取当前登陆用户工具
 */
public class UserUtil {
	public final static String USER_SESSION_NAME = "user";
	private static HttpSession session;
	public static void setSession(HttpSession session){
		UserUtil.session = session;
	}
	
	public static User getUser(){
		if(session == null) return null;
		return (User) session.getAttribute(USER_SESSION_NAME);
	}
}
