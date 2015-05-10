package org.lhx.service;

import java.util.List;

import org.lhx.domain.FileInfo;
import org.lhx.dto.FileInfoDTO;
import org.lhx.dto.comm.ShowFileInfoDTO;

public interface FileInfoService extends BaseService<FileInfo>{
	/**
	 * 保存上传文件信息
	 */
	String save(FileInfoDTO dto);
	/**
	 * 删除文件
	 */
	String deleteById(String fileInfoId);
	/**
	 * 根据用户id查找文件列表，用户指老师，根据时间排序
	 * @param id
	 */
	List<ShowFileInfoDTO> findMyFilesByUserId(String id);
	/**
	 * 获取所有的文件列表，根据时间排序
	 */
	List<ShowFileInfoDTO> findAllFiles();
	/**
	 * 根据id下载文件
	 */
	FileInfoDTO getById(String fileId);

}
