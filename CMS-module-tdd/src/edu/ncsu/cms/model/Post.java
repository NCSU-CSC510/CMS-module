package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

	private List<Version> versionList = new ArrayList<Version>();
	private Version currentVersion;
	private int postID;
	private int index=0;	
	private List<Comment> commentList = new ArrayList<Comment>();
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public List<Version> getVersionList() {
		return versionList;
	}
	public void setVersionList(List<Version> versionList) {
		this.versionList = versionList;
	}
	public Version getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(Version currentVersion) {
		this.currentVersion = currentVersion;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public Version getPostVersion(Post p , int versionId){
		List<Version> list = p.getVersionList();
		for (Version version : list) {
			if(version.getVersionId()==versionId){
				return version;
			}
		}
		return null;
	}
	public Post(){
		index++;
		currentVersion=new Version();
		currentVersion.setState(State.DRAFT);
		currentVersion.setVersionId(1);
		versionList.add(currentVersion);
		postID=index;
	}
	
}
