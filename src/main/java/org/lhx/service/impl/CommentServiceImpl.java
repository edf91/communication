package org.lhx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lhx.dao.BaseDao;
import org.lhx.domain.Comment;
import org.lhx.domain.UserCommentRelation;
import org.lhx.dto.CommentDTO;
import org.lhx.dto.UserCommentRelationDTO;
import org.lhx.dto.assembler.CommentAssembler;
import org.lhx.dto.assembler.UserCommentRelationAssembler;
import org.lhx.dto.comm.CreateCommentDTO;
import org.lhx.dto.comm.CreateUserCommentRelationDTO;
import org.lhx.service.CommentService;
import org.springframework.stereotype.Service;
@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	
	@Resource(name = "commentDao")
	private BaseDao<Comment> commentDao;
	@Resource(name = "userCommentRelationDao")
	private BaseDao<UserCommentRelation> userCommentRelationDao;
	
	public List<CommentDTO> findAllByStatus(int status) {
		String hql = "FROM Comment c WHERE c.status = ? ORDER BY c.pubDate DESC";
		List<Comment> comments = commentDao.findByHQL(hql, status);
		return CommentAssembler.toDOTs(comments);
	}

	public List<CommentDTO> findByCurrentUserAndStatus(String account,
			int status) {
		String hql = "FROM Comment c WHERE c.user.account = ? AND c.status = ? ORDER BY c.pubDate DESC";
		List<Comment> comments = commentDao.findByHQL(hql,account, status);
		return CommentAssembler.toDOTs(comments);
	}

	public boolean delete(String id) {
		Comment comment = commentDao.get(id);
		if(comment != null){
			commentDao.delete(comment);
			return true;
		}
		return false;
	}

	public boolean save(CreateCommentDTO comm) {
		commentDao.save(CommentAssembler.commToEntity(comm));
		return true;
	}

	public UserCommentRelationDTO findAllDiscussByCommentId(
			String commentId) {
		String hql = "FROM UserCommentRelation uc WHERE uc.comment.id = ? ORDER BY uc.commentTime ASC";
		List<UserCommentRelation> userCommentRelations = userCommentRelationDao.findByHQL(hql, commentId);
		return UserCommentRelationAssembler.entitiesToDTO(commentDao.get(commentId),userCommentRelations);
	}

	public boolean saveUserComment(CreateUserCommentRelationDTO comm) {
		this.userCommentRelationDao.save(UserCommentRelationAssembler.toEntity(comm));
		return true;
	}
	
}
