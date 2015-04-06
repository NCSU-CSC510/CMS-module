package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.cms.api.LikeManager;

public class Post {
	
	private List<Version> versionList = new ArrayList<Version>();
	private Version currentVersion;
	private int postId;
	private static int idCounter;
	private List<Comment> commentList = new ArrayList<Comment>();
	private int likesCount=0;
	private Like likes = new Like();
	Post(){
		idCounter++;
		currentVersion=new Version();
		currentVersion.setState(State.DRAFT);
		currentVersion.setVersionId(1);
		versionList.add(currentVersion);
		postId=idCounter;
	}
	
	public int getPostId(){
	
		return postId;
	
	}
	public Version getCurrentVersion(){
	
		return currentVersion;
	
	}
	public void setCurrentVersion(Version v){
		
		currentVersion =v;
	
	}
	public void addnewVersion(Version v) {
		this.versionList.add(v);
		
	}
	public Version getVersion(int versionid) {
		for(Version v : versionList) {
			if(v.getVersionId() == versionid)
				return v;
		}
		return null;
	}
	public void updateVersion(String content){
	
		
		//toDo
	}
	
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	public Like getLikes() {
		return likes;
	}
	public void setLikes(Like likes) {
		this.likes = likes;
	}
	public int likePost(String user){
		LikeManager.like(this, user);
		return this.likesCount;
	}
	
	
}
