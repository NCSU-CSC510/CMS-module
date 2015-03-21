package edu.ncsu.cms.manager;
import java.util.HashMap;

import edu.ncsu.cms.model.*;

public class PostManager {

	private HashMap<Integer,Post> postsMap = new HashMap<Integer,Post>();
	
	public Post createPost(){
		
		Post newPost = new Post();
		postsMap.put(newPost.getPostID(), newPost);
		return newPost;		
	}
	public void addPostToList(Post p){
		postsMap.put(p.getPostID(),p);
	}
	
	public Post getPostById(int postID){
		return postsMap.get(postID);
	}
	public Version getPostVersionById(int postID, int versionid){
		Post post = postsMap.get(postID);
		return post.getPostVersion(post, versionid);
	}
	
	public Version editPostVersion(Post p, int VersionID) {
		Version ver = getPostVersionById(p.getPostID(), VersionID);
		ver.setState(State.DRAFT);
		return ver;
	}
	
	public void deletePost(int postID){
		Post p = getPostById(postID);
		if(p!=null){
			postsMap.remove(p);
		}
		
	}
}
