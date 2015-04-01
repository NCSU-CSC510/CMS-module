package edu.ncsu.cms.manager;
import java.util.HashMap;
import java.util.List;

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
		if(ver.getState()!=State.DRAFT){
			Version newVer = new Version();
			newVer.setState(State.DRAFT);
			newVer.setVersionId(ver.getVersionId()+1);
			p.getVersionList().add(newVer);
			return newVer;
		}else{
			return ver;
		}
	}

	public void deletePost(int postID){
		Post p = getPostById(postID);
		if(p!=null){
			postsMap.remove(p.getPostID());
		} 
	}
	
	/*
	 * This method is used when we want to publish a particular version of the Post
	 */
	public void publishPostVersion(Post post, int versionID){
		Version ver = post.getPostVersion(post, versionID);
		ver.setState(State.PUBLISHED);
		List<Version> verList = post.getVersionList();
		for (Version version : verList) {
			if(version.getVersionId()!=versionID){
				version.setState(State.ARCHIVE);
			}
		}
	}

	
	/*
	 * This method is used to publish the current version of the post.
	 */
	public void publishPost(Post post){
		Version ver = post.getCurrentVersion();
		ver.setState(State.PUBLISHED);
		List<Version> verList = post.getVersionList();
		for (Version version : verList) {
			if(version.getVersionId()!=ver.getVersionId()){
				version.setState(State.ARCHIVE);
			}
		}
	}



}
