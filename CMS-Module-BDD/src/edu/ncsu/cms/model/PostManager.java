package edu.ncsu.cms.model;
import java.util.*;


public class PostManager {
	
	private HashMap<Integer,Post> postLists= new HashMap<Integer,Post>();
	private static PostManager postMngrInstance=new PostManager();
	private PostManager(){}
	
	public static PostManager instance(){
		return postMngrInstance;
	}
	
	public Post createNew(){
		
		Post p = new Post();
		addPost(p);
		return p;		
	}
	public void addPost(Post p){
		postLists.put(p.getPostId(),p);
	}
	
	public Post getPostById(int postID){
		return postLists.get(postID);
	}
	
	public Post editPost(Post p, int VersionID) {
		
		return p;
	}
	
}
