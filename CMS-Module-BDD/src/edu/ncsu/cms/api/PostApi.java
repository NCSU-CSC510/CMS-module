package edu.ncsu.cms.api;

import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.PostManager;
import edu.ncsu.cms.model.Version;

public class PostApi {
	PostManager postManager = PostManager.instance();

	public Version retrievePost(int postId, int versionId) {

		return postManager.getPostById(postId, versionId);
	}

	public Post retrievePost(int postId) {

		return postManager.getPostById(postId);
	}

	public void savePost(int postId, int versionId, String content) {

		postManager.savePost(postId, versionId, content);
	}

	public Post createPost() {

		return postManager.createNew();
	}
}
