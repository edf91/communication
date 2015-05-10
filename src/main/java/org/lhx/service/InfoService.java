package org.lhx.service;

import java.util.List;

import org.lhx.domain.Infomation;
import org.lhx.dto.InfomationDTO;

public interface InfoService extends BaseService<Infomation>{
	/**
	 * 根据状态查找通知并根据时间排序
	 */
	List<InfomationDTO> findAllInfos();
	/**
	 * 根据用户id查找通知
	 */
	List<InfomationDTO> findInfosByUserId(String userId);
	/**
	 * 根据id删除通知
	 */
	String deleteById(String infoId);
	/**
	 * 添加通知
	 */
	boolean save(InfomationDTO comm);
	/**
	 * 根据id查询通知
	 */
	InfomationDTO getInfoById(String infoId);
}
