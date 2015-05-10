package org.lhx.dto.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lhx.domain.Comment;
import org.lhx.domain.User;
import org.lhx.dto.CommentDTO;
import org.lhx.dto.comm.CreateCommentDTO;
import org.lhx.utils.DateUtil;

/**
 * 评论装配类
 */
public class CommentAssembler {
	
	public static CommentDTO toDTO(Comment entity){
		CommentDTO result = new CommentDTO();
		result.setId(entity.getId());
		result.setPubDate(DateUtil.dateToStr(new Date(entity.getPubDate())));
		result.setPubUser(entity.getUser().getName());
		result.setTitle(entity.getTitle());
		return result;
	}
	
	public static List<CommentDTO> toDOTs(List<Comment> entities){
		List<CommentDTO> result = new ArrayList<CommentDTO>();
		for (Comment entity : entities) {
			result.add(toDTO(entity));
		}
		return result;
	}

	public static Comment commToEntity(CreateCommentDTO comm) {
		Comment result = new Comment();
		result.setTitle(comm.getTitle());
		result.setContent(comm.getContent());
		result.setUser(new User(comm.getUserId()));
		return result;
	}
	
	
}
