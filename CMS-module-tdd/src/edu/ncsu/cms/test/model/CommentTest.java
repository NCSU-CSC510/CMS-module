package edu.ncsu.cms.test.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import edu.ncsu.cms.manager.CommentManager;
import edu.ncsu.cms.model.Comment;
import edu.ncsu.cms.model.Post;

public class CommentTest {
	@Test
	public void testAddCommentOnPost(){
		Post postTest = mock(Post.class);
		List<Comment> commentList = new ArrayList<Comment>();
		postTest.setCommentList(commentList);
		when(postTest.getCommentList()).thenReturn(commentList);
		Comment commentTest = new Comment("user1", "Hi!!");
		assertEquals("Initially Post should have 0 comments on it",0,postTest.getCommentList().size());
		CommentManager.addCommentOnPost(postTest, commentTest);
		assertEquals("After adding a new comment the post now should have 1 comment on it", 1,postTest.getCommentList().size());
		assertEquals("Comment Id of the first comment should be 1", 1,postTest.getCommentList().get(0).getCommentId());
		assertEquals("Content of the comment should match with Hi!!","Hi!!",postTest.getCommentList().get(0).getContent());
		assertEquals("User who added the comment should be user1","user1",postTest.getCommentList().get(0).getUserId());
	}
	
	@Test
	public void testAddCommentOnComment(){
		Comment parentComment = mock(Comment.class);
		List<Comment> commentList = new ArrayList<Comment>();
		parentComment.setCommentList(commentList);
		when(parentComment.getCommentList()).thenReturn(commentList);
		Comment commentTest = new Comment("user1", "Hi!!");
		assertEquals("Initially Comment should have 0 comments on it", 0,parentComment.getCommentList().size());
		CommentManager.addCommentOnComment(parentComment, commentTest);
		assertEquals("After adding a new comment the Comment now should have 1 comment on it",1,parentComment.getCommentList().size());
		assertEquals("Comment Id of the first comment should be 1",1,parentComment.getCommentList().get(0).getCommentId());
		assertEquals("Content of the comment should match with Hi!!","Hi!!",parentComment.getCommentList().get(0).getContent());
		assertEquals("User who added the comment should be user1","user1",parentComment.getCommentList().get(0).getUserId());
	}
	
	@Test
	public void testDeleteCommentOnPost(){
		Post postTest = mock(Post.class);
		List<Comment> commentList = new ArrayList<Comment>();
		Comment commentTest = new Comment("user1", "Hi!!");
		commentList.add(commentTest);
		postTest.setCommentList(commentList);
		when(postTest.getCommentList()).thenReturn(commentList);
		assertEquals(1,postTest.getCommentList().size());
		assertEquals(1,postTest.getCommentList().get(0).getCommentId());
		assertEquals("Hi!!",postTest.getCommentList().get(0).getContent());
		assertEquals("user1",postTest.getCommentList().get(0).getUserId());
		CommentManager.deleteCommentOnPost(postTest, commentTest);
		assertEquals(0,postTest.getCommentList().size());
	}
	
	@Test
	public void testDeleteCommentOnComment(){
		Comment parentComment = mock(Comment.class);
		List<Comment> commentList = new ArrayList<Comment>();
		Comment commentTest = new Comment("user1", "Hi!!");
		commentList.add(commentTest);
		parentComment.setCommentList(commentList);
		when(parentComment.getCommentList()).thenReturn(commentList);
		assertEquals(1,parentComment.getCommentList().size());
		assertEquals(1,parentComment.getCommentList().get(0).getCommentId());
		assertEquals("Hi!!",parentComment.getCommentList().get(0).getContent());
		assertEquals("user1",parentComment.getCommentList().get(0).getUserId());
		CommentManager.deleteCommentOnComment(parentComment, commentTest);
		assertEquals(0,parentComment.getCommentList().size());
	}
	
	@Test
	public void testEditCommentOnPost(){
		Post postTest = mock(Post.class);
		List<Comment> commentList = new ArrayList<Comment>();
		Comment comment = new Comment("user1", "Hi!!");
		commentList.add(comment);
		postTest.setCommentList(commentList);
		Comment commentTest = new Comment(1,"user1", "Hello!!");
		when(postTest.getCommentList()).thenReturn(commentList);
		assertEquals(1,postTest.getCommentList().size());
		assertEquals(1,postTest.getCommentList().get(0).getCommentId());
		assertEquals("Hi!!",postTest.getCommentList().get(0).getContent());
		assertEquals("user1",postTest.getCommentList().get(0).getUserId());
		CommentManager.editCommentOnPost(postTest, commentTest);
		assertEquals(1,postTest.getCommentList().size());
		assertEquals(1,postTest.getCommentList().get(0).getCommentId());
		assertEquals("Hello!!",postTest.getCommentList().get(0).getContent());
		assertEquals("user1",postTest.getCommentList().get(0).getUserId());
	}
	
	@Test
	public void testEditCommentOnComment(){
		Comment parentComment = mock(Comment.class);
		List<Comment> commentList = new ArrayList<Comment>();
		Comment comment = new Comment("user1", "Hi!!");
		commentList.add(comment);
		parentComment.setCommentList(commentList);
		Comment commentTest = new Comment(1,"user1", "Hello!!");
		when(parentComment.getCommentList()).thenReturn(commentList);
		assertEquals(1,parentComment.getCommentList().size());
		assertEquals(1,parentComment.getCommentList().get(0).getCommentId());
		assertEquals("Hi!!",parentComment.getCommentList().get(0).getContent());
		assertEquals("user1",parentComment.getCommentList().get(0).getUserId());
		CommentManager.editCommentOnComment(parentComment, commentTest);
		assertEquals(1,parentComment.getCommentList().size());
		assertEquals(1,parentComment.getCommentList().get(0).getCommentId());
		assertEquals("Hello!!",parentComment.getCommentList().get(0).getContent());
		assertEquals("user1",parentComment.getCommentList().get(0).getUserId());
	}
	
	
}
