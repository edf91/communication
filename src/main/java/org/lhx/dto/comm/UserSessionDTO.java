package org.lhx.dto.comm;

import org.lhx.domain.User;
/**
 * 存放于session中的User去掉password
 */
public class UserSessionDTO extends User{
	private static final long serialVersionUID = -8303808806376817258L;
	
	public String getPassword() {
		return null;
	}
}
