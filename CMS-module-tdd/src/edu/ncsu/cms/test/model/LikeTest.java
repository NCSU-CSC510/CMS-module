package edu.ncsu.cms.test.model;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ncsu.cms.model.Comment;
import edu.ncsu.cms.model.Like;
import edu.ncsu.cms.model.Post;

public class LikeTest {
	@Test
	public void testLikePost(){
		Like likeTest = mock(Like.class);
		List<String> userList = new ArrayList<String>();	
		when(likeTest.getUserList()).thenReturn(userList);
		Post postTest = new Post();
		postTest.setLikes(likeTest);
		assertEquals("Intially Post should have zero Likes", 0, postTest.getLikes().getUserList().size());
		postTest.likePost("user1");
		assertEquals("Now Post should have one Like", 1, postTest.getLikes().getUserList().size());
		assertEquals("User who liked the post should match with user in the added in the likeList for that post", "user1",postTest.getLikes().getUserList().get(0));
		postTest.likePost("user1");
		assertEquals("User should be deleted from the likeList after he/she dislikes the post",0,postTest.getLikes().getUserList().size());
	}
	
	@Test
	public void testLikeComment(){
		Like likeTest = mock(Like.class);
		List<String> userList = new ArrayList<String>();	
		when(likeTest.getUserList()).thenReturn(userList);
		Comment commentTest = new Comment("user2","Hi");
		commentTest.setLikes(likeTest);
		assertEquals(0,commentTest.getLikes().getUserList().size());
		commentTest.likeComment("user1");
		assertEquals(1,commentTest.getLikes().getUserList().size());
		assertEquals("user1",commentTest.getLikes().getUserList().get(0));
		commentTest.likeComment("user1");
		assertEquals(0,commentTest.getLikes().getUserList().size());
	}
}
