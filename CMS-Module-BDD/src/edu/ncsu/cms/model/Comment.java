package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private int commentId;
	private String userId;
	private int likeCount;
	private List<Comment> commentList = new ArrayList<Comment>();
	private Like likes;
	
	public Like getLikes() {
		return likes;
	}
	public void setLikes(Like likes) {
		this.likes = likes;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
