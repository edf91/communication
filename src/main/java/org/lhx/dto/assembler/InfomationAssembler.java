package org.lhx.dto.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lhx.domain.Infomation;
import org.lhx.domain.User;
import org.lhx.dto.InfomationDTO;
import org.lhx.utils.DateUtil;

/**
 * 评论装配类
 */
public class InfomationAssembler {
	
	public static InfomationDTO toDTO(Infomation entity){
		InfomationDTO result = new InfomationDTO();
		result.setId(entity.getId());
		result.setPubDate(DateUtil.dateToStr(new Date(entity.getPubDate())));
		result.setPubUser(entity.getUser().getName());
		result.setTitle(entity.getTitle());
		result.setContent(entity.getContent());
		return result;
	}
	
	public static List<InfomationDTO> toDOTs(List<Infomation> entities){
		List<InfomationDTO> result = new ArrayList<InfomationDTO>();
		for (Infomation entity : entities) {
			result.add(toDTO(entity));
		}
		return result;
	}

	public static Infomation toEntity(InfomationDTO dto) {
		Infomation result = new Infomation();
		result.setContent(dto.getContent());
		result.setTitle(dto.getTitle());
		User user = new User();
		user.setId(dto.getUserId());
		result.setUser(user);
		return result;
	}
}
