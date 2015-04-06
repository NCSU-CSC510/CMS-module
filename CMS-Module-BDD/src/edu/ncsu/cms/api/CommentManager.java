package edu.ncsu.cms.api;

import java.util.Iterator;

import edu.ncsu.cms.model.Comment;
import edu.ncsu.cms.model.Like;
import edu.ncsu.cms.model.Post;

public class CommentManager {
	public static void addCommentOnPost(Post post, Comment comment){
		if(comment!= null){
			post.getCommentList().add(comment);
		}
	}

	public static void addCommentOnComment(Comment parentComment, Comment childComment){
		if(childComment!= null && parentComment != null){
			parentComment.getCommentList().add(childComment);
		}
	}

	public static void deleteCommentOnPost(Post post, Comment comment){
		if(post.getCommentList().contains(comment)){
			post.getCommentList().remove(comment);
		}
	}

	public static void deleteCommentOnComment(Comment parentComment, Comment childComment){
		if(parentComment.getCommentList().contains(childComment)){
			parentComment.getCommentList().remove(childComment);
		}
	}
	
	public static void editCommentOnPost(Post post, Comment comment){
		if(post!=null && comment!=null){
			Iterator<Comment> commentIterator = post.getCommentList().iterator();
			while(commentIterator.hasNext()){
				Comment oldComment = commentIterator.next();
				if(oldComment.getCommentId()== comment.getCommentId()){
					oldComment.setContent(comment.getContent());
				}
			}
		}
	}
	
	public static void editCommentOnComment(Comment parentComment, Comment childComment){
		if(parentComment!=null && childComment!=null){
			Iterator<Comment> commentIterator = parentComment.getCommentList().iterator();
			while(commentIterator.hasNext()){
				Comment oldComment = commentIterator.next();
				if(oldComment.getCommentId()== childComment.getCommentId()){
					oldComment.setContent(childComment.getContent());
				}
			}
		}
	}

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
