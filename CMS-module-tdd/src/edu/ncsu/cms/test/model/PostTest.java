package edu.ncsu.cms.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.ncsu.cms.manager.PostManager;
import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.State;
import edu.ncsu.cms.model.Version;

public class PostTest {
	PostManager mgr;
	Post newPost;
	Version postVer;
	private void createNewPost(){
		mgr = PostManager.getPostManager();
		newPost = mgr.createPost();
		assertNotNull(newPost);
		postVer = newPost.getCurrentVersion();
		assertNotNull(postVer);
		assertEquals("Post must be in draft State", State.DRAFT, postVer.getState());
		String content = "This is my first Post";
		postVer.setContent(content);
		assertEquals("Content of post doesn not match", content, postVer.getContent());		
	}
	@Test
	public void testCreateNewPost(){
		PostManager mgr = PostManager.getPostManager();
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
		PostManager mgr = PostManager.getPostManager();
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
	
	@Test
	public void testPublishPost(){
		createNewPost();
		Version newVer =  new Version();
		newVer.setContent("This is new Post Version");
		newVer.setState(State.DRAFT);
		newVer.setVersionId(newPost.getCurrentVersion().getVersionId()+1);
		newPost.getVersionList().add(newVer);
		newPost.setCurrentVersion(newVer);
		mgr.publishPost(newPost);
		assertEquals("Post must be in published State", State.PUBLISHED, newVer.getState());
		mgr.publishPostVersion(newPost,1);
		Version oldVer = newPost.getPostVersion(newPost, 1);
		assertEquals("Post must be in published State", State.PUBLISHED, oldVer.getState());		
	}
	
	@Test
	public void testDeletePost(){
		createNewPost();
		mgr.deletePost(newPost.getPostID());
		Post temp = mgr.getPostById(newPost.getPostID());
		assertEquals("Post should be deleted",null,temp);
		
	}
}
