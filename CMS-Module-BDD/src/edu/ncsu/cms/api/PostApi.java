package edu.ncsu.cms.api;

import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.PostManager;

public class PostApi {
	PostManager postManager = PostManager.instance();
	
	public Post retrievePost(int postId, int versionId) {
		
		return postManager.createNew();
	}
	
	public Post createPost() {
		
		return postManager.createNew();
	}
}
