package org.lhx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lhx.dao.BaseDao;
import org.lhx.domain.Infomation;
import org.lhx.dto.InfomationDTO;
import org.lhx.dto.assembler.InfomationAssembler;
import org.lhx.service.InfoService;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Infomation> implements InfoService{
	
	@Resource(name = "infoDao")
	public void setBaseDao(BaseDao<Infomation> baseDao) {
		super.setBaseDao(baseDao);
	}
	public List<InfomationDTO> findAllInfos() {
		String hql = "FROM Infomation ORDER BY pubDate DESC";
		return InfomationAssembler.toDOTs(this.findByHQL(hql));
	}
	
	public List<InfomationDTO> findInfosByUserId(String userId) {
		String hql = "FROM Infomation i WHERE i.user.id = ? ORDER BY i.pubDate DESC";
		return InfomationAssembler.toDOTs(this.findByHQL(hql, userId));
	}
	public String deleteById(String infoId) {
		Infomation info = new Infomation();
		info.setId(infoId);
		this.delete(info);
		return "DELETE SUCCESS";
	}
	public boolean save(InfomationDTO comm) {
		this.save(InfomationAssembler.toEntity(comm));
		return true;
	}
	public InfomationDTO getInfoById(String infoId) {
		return InfomationAssembler.toDTO(this.get(infoId));
	}
	
}
