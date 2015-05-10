package org.lhx.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.lhx.dao.BaseDao;
import org.lhx.domain.FileInfo;
import org.lhx.dto.FileInfoDTO;
import org.lhx.dto.assembler.FileInfoAssembler;
import org.lhx.dto.comm.ShowFileInfoDTO;
import org.lhx.service.FileInfoService;
import org.springframework.stereotype.Service;
@Service("fileInfoService")
public class FileInfoServiceImpl extends BaseServiceImpl<FileInfo> implements FileInfoService {
	@Resource(name = "fileDao")
	public void setBaseDao(BaseDao<FileInfo> baseDao) {
		super.setBaseDao(baseDao);
	}

	public String save(FileInfoDTO dto) {
		FileInfo fileInfo = FileInfoAssembler.toEntity(dto);
		this.save(fileInfo);
		return fileInfo.getId();
	}

	public String deleteById(String fileInfoId) {
		// 先删除数据库,再删除磁盘上的文件
		FileInfo fileInfo = this.get(fileInfoId);
		File file = new File(fileInfo.getFilePath());
		this.delete(fileInfo);
		if(!file.exists()) return "THE FILE IS NO EXISTS!";
		return file.delete() ? "DELETE SUCCESS" : "DELETE UNSUCCESS!";
	}

	public List<ShowFileInfoDTO> findMyFilesByUserId(String uploadUserId) {
		String hql = "FROM FileInfo f WHERE f.user.id = ? ORDER BY f.uploadTime DESC";
		return FileInfoAssembler.toShowDTOs(this.findByHQL(hql, uploadUserId));
	}

	public List<ShowFileInfoDTO> findAllFiles() {
		return FileInfoAssembler.toShowDTOs(this.findAll());
	}

	public FileInfoDTO getById(String fileId) {
		return FileInfoAssembler.toShowDTO(this.get(fileId));
	}
	
}
