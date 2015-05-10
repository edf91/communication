package org.lhx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.lhx.domain.User;
import org.lhx.dto.InfomationDTO;
import org.lhx.service.InfoService;
import org.lhx.utils.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 通知控制类
 */
@Controller
@RequestMapping("/info")
public class InfoController {
	@Resource(name = "infoService")
	private InfoService infoService;
	
	@ResponseBody
	@RequestMapping(value = "/getInfoDetail")
	public InfomationDTO getInfoDetail(String infoId){
		return this.infoService.getInfoById(infoId);
	}
	
	@ResponseBody
	@RequestMapping("/addInfo")
	public boolean addInfo(InfomationDTO comm,HttpServletRequest request){
		UserUtil.setSession(request.getSession());
		User user = UserUtil.getUser();
		comm.setUserId(user.getId());
		return infoService.save(comm);
	}
	@ResponseBody
	@RequestMapping(value = "/listValidInfo")
	public List<InfomationDTO> listValidInfo(){
		return infoService.findAllInfos();
	}
	@ResponseBody
	@RequestMapping(value = "/listMyInfos")
	public List<InfomationDTO> listMyInfos(HttpServletRequest request){
		UserUtil.setSession(request.getSession());
		return infoService.findInfosByUserId(UserUtil.getUser().getId());
	}
	@ResponseBody
	@RequestMapping(value = "/removeInfo")
	public String removeInfo(String infoId){
		return infoService.deleteById(infoId);
	}
}
