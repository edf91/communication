package org.lhx.dto.assembler;

import org.lhx.domain.User;
import org.lhx.dto.comm.UserSessionDTO;

public class UserAssembler {
	
	public static UserSessionDTO toSession(User entity){
		if(entity == null) return null;
		UserSessionDTO result = new UserSessionDTO();
		result.setId(entity.getId());
		result.setAccount(entity.getAccount());
		result.setName(entity.getName());
		result.setUserType(entity.getUserType());
		return result;
	}
}
