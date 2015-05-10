package org.lhx.service;

import java.util.List;

import org.lhx.dto.CommentDTO;
import org.lhx.dto.UserCommentRelationDTO;
import org.lhx.dto.comm.CreateCommentDTO;
import org.lhx.dto.comm.CreateUserCommentRelationDTO;

public interface CommentService{
	/**
	 * 根据状态查询所有，按照时间排序
	 */
	List<CommentDTO> findAllByStatus(int status);
	/**
	 * 根据当前用户以及状态获取所有的话题，按照时间排序
	 */
	List<CommentDTO> findByCurrentUserAndStatus(String account, int status);
	/**
	 * 根据id删除话题
	 */
	boolean delete(String id);
	/**
	 * 创建新的话题
	 */
	boolean save(CreateCommentDTO comm);
	/**
	 * 获取特定话题的回复具体详情
	 * @param commentId
	 */
	UserCommentRelationDTO findAllDiscussByCommentId(String commentId);
	/**
	 * 保存用户回复
	 */
	boolean saveUserComment(CreateUserCommentRelationDTO comm);
}
