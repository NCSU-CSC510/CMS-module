package edu.ncsu.cms.manager;

import edu.ncsu.cms.model.Comment;
import edu.ncsu.cms.model.Like;

public class CommentManager {
	public static void likeComment(Comment comment, String user){
		Like like = comment.getLikes();
		if(like.getUserList().contains(user))
		{
			like.getUserList().remove(user);
			comment.setLikeCount(like.getUserList().size());
			
		}
		else{
			like.getUserList().add(user);
			comment.setLikeCount(like.getUserList().size());
		}
	}
}
