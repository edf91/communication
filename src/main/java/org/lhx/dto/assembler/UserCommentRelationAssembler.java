package org.lhx.dto.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lhx.domain.Comment;
import org.lhx.domain.User;
import org.lhx.domain.UserCommentRelation;
import org.lhx.dto.UserCommentRelationDTO;
import org.lhx.dto.comm.CommentUserDTO;
import org.lhx.dto.comm.CreateUserCommentRelationDTO;
import org.lhx.utils.DateUtil;
/**
 * 回复装配类
 */
public class UserCommentRelationAssembler {
	
	public static UserCommentRelationDTO entitiesToDTO(Comment comment,
			List<UserCommentRelation> entities) {
		if(comment == null) return null;
		UserCommentRelationDTO result = new UserCommentRelationDTO(
				comment.getUser().getAccount(),
				comment.getUser().getName(),
				DateUtil.dateToStr(new Date(comment.getPubDate())),
				comment.getContent(),comment.getTitle());
		
		List<CommentUserDTO> dtos = new ArrayList<CommentUserDTO>();
		for (UserCommentRelation entity : entities) {
			CommentUserDTO commentUserDTO = new CommentUserDTO(entity.getUser().getName()
					,entity.getUser().getAccount(),DateUtil.dateToStr(new Date(entity.getCommentTime())),entity.getReplyContent());
			dtos.add(commentUserDTO);
		}
		result.setCommentUserDTOs(dtos);
		return result;
	}

	public static UserCommentRelation toEntity(CreateUserCommentRelationDTO comm) {
		UserCommentRelation result = new UserCommentRelation();
		Comment comment = new Comment();
		comment.setId(comm.getCommentId());
		result.setComment(comment);
		User user = new User();
		user.setId(comm.getCommentUserId());
		result.setUser(user);
		result.setCommentTime(comm.getCommentTime());
		result.setReplyContent(comm.getReplyContent());
		return result;
	}
	
}
