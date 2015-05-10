package org.lhx.service;

import org.lhx.domain.User;
import org.lhx.dto.comm.LoginUserComm;
import org.lhx.dto.comm.UserSessionDTO;

public interface UserService extends BaseService<User>{
	UserSessionDTO login(LoginUserComm loginComm) ;
}
