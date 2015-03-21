package edu.ncsu.cms.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.ncsu.cms.manager.PostManager;
import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.State;
import edu.ncsu.cms.model.Version;

public class PostTest {

	@Test
	public void testCreateNewPost(){
		PostManager mgr = new PostManager();
		Post newPost = mgr.createPost();
		assertNotNull(newPost);
		Version postVer = newPost.getCurrentVersion();
		assertNotNull(postVer);
		assertEquals("Post must be in draft State", State.DRAFT, postVer.getState());
		String content = "This is my first Post";
		postVer.setContent(content);
		assertEquals("Content of post doesn not match", content, postVer.getContent());
	}
	
	@Test
	public void testEditPost(){
		PostManager mgr = new PostManager();
		Post newPost = mgr.createPost();
		assertNotNull(newPost);
		Version postVer = newPost.getCurrentVersion();
		assertNotNull(postVer);
		assertEquals("Post must be in draft State", State.DRAFT, postVer.getState());
		String content = "This is my first Post";
		postVer.setContent(content);
		assertEquals("Content of post doesn not match", content, postVer.getContent());
		mgr.publishPostVersion(newPost, postVer.getVersionId());
		assertEquals("Post version Not published",State.PUBLISHED, postVer.getState());
		Version newVer = mgr.editPostVersion(newPost,postVer.getVersionId());
		assertEquals("The value of edit post version doesn't match",2, newVer.getVersionId());
		String newContent = "Post Edited";
		newVer.setContent(newContent);
		assertEquals("Edited post version text doesn't match",newContent, newVer.getContent());
	}
}
