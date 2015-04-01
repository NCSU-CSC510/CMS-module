package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
	
	private List<Version> versionList = new ArrayList<Version>();
	private Version currentVersion;
	private int postId;
	private static int idCounter;
	
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
	
	
}
