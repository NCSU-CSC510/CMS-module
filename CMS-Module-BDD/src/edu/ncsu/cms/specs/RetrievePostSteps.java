package edu.ncsu.cms.specs;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import edu.ncsu.cms.api.PostApi;
import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.Version;

public class RetrievePostSteps {
	PostApi postApi = new PostApi();
	Post retrievedPost;
	Version retrievedVersion;
	
	@Given("number of posts $num")
	public void givenNumberOfPosts(@Named("num") int num) {
		for(int i = 0; i < num; i++)
			postApi.createPost();
	}
	
	@When("I try to retrieve a post using postid=$postid")
	public void retrieveJustPostTestWhen(@Named("postid") int postId) {
		retrievedPost = postApi.retrievePost(postId);
	}
	
	@Then("I get the post with postid=$postid")
	public void retrieveJustPostTestThen(@Named("postid") int postId) {
		if(retrievedPost.getPostId() != postId)
			throw new RuntimeException("Postid should be " + postId);
	}
	
	@When("I try to retrieve a post using postid=$postid, versionid=$versionid")
	public void retrievePostTestWhen(@Named("postid") int postId, @Named("versionid") int versionid) {
		retrievedPost = postApi.retrievePost(postId);
		retrievedVersion = postApi.retrievePost(postId, versionid);
	}
	
	@Then("I get the post with postid=$postid, versionid=$versionid")
	public void retrievePostTestThen(@Named("postid") int postId, @Named("versionid") int versionid) {
		if(retrievedPost.getPostId() != postId)
			throw new RuntimeException("Postid should be " + postId);
		if(retrievedVersion.getVersionId() != versionid)
			throw new RuntimeException("Versionid should be " + versionid);
	}
	
	@Then("I get post null")
	public void retrievePostTestNull() {
		if(retrievedPost != null)
			throw new RuntimeException("Invalid post should be null");
	}
	
	@Then("I get version null")
	public void retrieveVersionTestNull() {
		if(retrievedPost == null)
			throw new RuntimeException("Valid post should not be null");
		if(retrievedVersion != null)
			throw new RuntimeException("Invalid version should be null");
	}
}
