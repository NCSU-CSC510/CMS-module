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
}
