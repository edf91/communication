package org.lhx.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lhx.utils.UserUtil;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登陆过滤器
 */
public class SessionFilter extends OncePerRequestFilter{
	/**
	 * 公告访问资源
	 */
	private static List<String> sources = new ArrayList<String>();
	public SessionFilter() {
		sources.add("/user/index");
		sources.add("/smartAdmin/login.jsp");
		sources.add("/user/login");
		sources.add("/user/getCheckImg");
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {
		UserUtil.setSession(request.getSession());
		String requestPath = request.getRequestURI();
		System.out.println(requestPath);
		if(sources.contains(requestPath) || 
				requestPath.endsWith(".js") || 
				requestPath.endsWith(".css") ||
				requestPath.endsWith(".png") ||
				requestPath.endsWith(".ico") ||
				requestPath.endsWith(".woff")){
			filter.doFilter(request, response);
			return ;
		}
		if(UserUtil.getUser() == null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return ;
		}
		filter.doFilter(request, response);
		
	}

}
