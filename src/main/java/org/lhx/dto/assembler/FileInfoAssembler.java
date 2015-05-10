package org.lhx.dto.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lhx.domain.FileInfo;
import org.lhx.domain.User;
import org.lhx.dto.FileInfoDTO;
import org.lhx.dto.comm.ShowFileInfoDTO;
import org.lhx.utils.DateUtil;

public class FileInfoAssembler {

	public static FileInfo toEntity(FileInfoDTO dto) {
		FileInfo result = new FileInfo();
		result.setFileName(dto.getFileName());
		result.setFilePath(dto.getFilePath());
		result.setFileSize(dto.getFileSize());
		result.setFileType(dto.getFileType());
		User user = new User();
		user.setId(dto.getUserId());
		result.setUser(user);
		return result;
	}
	
	public static ShowFileInfoDTO toShowDTO(FileInfo entity){
		ShowFileInfoDTO result = new ShowFileInfoDTO();
		result.setFileId(entity.getId());
		result.setFileName(entity.getFileName());
		result.setFilePath(entity.getFilePath());
		result.setFileType(entity.getFileType());
		result.setFileSize(entity.getFileSize());
		result.setUploadTime(DateUtil.dateToStr(new Date(entity.getUploadTime())));
		result.setUserId(entity.getUser().getId());
		result.setUserAccount(entity.getUser().getAccount());
		result.setUserName(entity.getUser().getName());
		return result;
	}

	public static List<ShowFileInfoDTO> toShowDTOs(List<FileInfo> findAll) {
		List<ShowFileInfoDTO> results = new ArrayList<ShowFileInfoDTO>();
		for (FileInfo entity : findAll) {
			results.add(toShowDTO(entity));
		}
		return results;
	}

}
