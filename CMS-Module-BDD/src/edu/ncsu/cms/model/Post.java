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
		versionList.add(currentVersion);
		postId=idCounter;
	}
	
	public int getPostId(){
	
		return postId;
	
	}
	public Version getCurrentVersion(){
	
		return currentVersion;
	
	}
	public void updateVersion(String content){
	
		
		//toDo
	}
	
	
}
