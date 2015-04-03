package edu.ncsu.cms.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.cms.manager.PostManager;
import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.State;
import edu.ncsu.cms.model.Version;

public class PostVersionTest {
	PostManager mgr;
	Post newPost;
	Version postVer;
	@Before
	public void createNewPost(){
		mgr = PostManager.getPostManager();
		newPost = mgr.createPost();
		assertNotNull(newPost);
		postVer = newPost.getCurrentVersion();
		assertNotNull(postVer);
		String content = "This is my first Post";
		postVer.setContent(content);			
	}
	@Test
	public void testNewPostVersion(){
		//We already have a new post created in the before block. So the new post version should 
		// be in DRAFT state
		assertEquals("The new post version should be DRAFT",State.DRAFT,postVer.getState());
	}
	
	@Test
	public void testPublishPostVersion(){
		PostManager mgr = PostManager.getPostManager();
		mgr.publishPost(newPost);
		assertEquals("The new post version should be PUBLISHED",State.PUBLISHED,postVer.getState());
	}
	
	@Test
	public void testEditPostVersion(){
		PostManager mgr = PostManager.getPostManager();
		mgr.publishPost(newPost);
		assertEquals("The new post version should be PUBLISHED",State.PUBLISHED,postVer.getState());
		Version ver = mgr.editPostVersion(newPost, newPost.getCurrentVersion().getVersionId());
		assertEquals("Version should be in DRAFT state",State.DRAFT,ver.getState());
		
	}
	
	@Test
	public void testArchivedPost(){
		Version tmpVer = new Version();
		tmpVer.setContent("This is a new version");
		tmpVer.setState(State.DRAFT);
		tmpVer.setVersionId(2);
		newPost.getVersionList().add(tmpVer);
		newPost.setCurrentVersion(tmpVer);
		mgr.publishPost(newPost);
		assertEquals("The current post version should be in published state",State.PUBLISHED,tmpVer.getState());
		assertEquals("The old post versions should be in ARCHIVE state",State.ARCHIVE,postVer.getState());
	}
	
}
