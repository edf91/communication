package org.lhx.service.impl;

import javax.annotation.Resource;

import org.lhx.dao.BaseDao;
import org.lhx.domain.User;
import org.lhx.dto.assembler.UserAssembler;
import org.lhx.dto.comm.LoginUserComm;
import org.lhx.dto.comm.UserSessionDTO;
import org.lhx.service.UserService;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Resource(name = "userDao")
	public void setBaseDao(BaseDao<User> baseDao) {
		super.setBaseDao(baseDao);
	}

	public UserSessionDTO login(LoginUserComm loginComm) {
		String hql = "FROM User u WHERE u.account=? AND u.password=?";
		return UserAssembler.toSession((User)this.uniqueResultByHQL(hql, loginComm.getAccount(),loginComm.getPassword()));
	}
	
	
}
