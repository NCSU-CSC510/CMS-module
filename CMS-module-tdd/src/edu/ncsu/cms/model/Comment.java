package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.cms.manager.CommentManager;

public class Comment {
	private int commentId;
	private String userId;
	private int likeCount=0;
	private List<Comment> commentList = new ArrayList<Comment>();
	private Like likes = new Like();
	private String content;
	private int commentIdCounter = 0;
	
	public Comment(String userId, String content){
		this.commentId = ++commentIdCounter;
		this.userId = userId;
		this.content = content;
	}
	public Comment(int commentId, String userId, String content){
		this.commentId = commentId;
		this.userId = userId;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public int likeComment(String user){
		CommentManager.likeComment(this, user);
		return this.likeCount;
	}
}
