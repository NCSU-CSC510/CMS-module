package edu.ncsu.cms.specs;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import edu.ncsu.cms.api.PostApi;
import edu.ncsu.cms.model.*;

public class SavePostSteps extends Steps{
	PostApi postApi = new PostApi();
	Post retrievedPost;
	Version retrievedVersion;
	
	@Given("number of posts $num")
	public void givenNumberOfPosts(@Named("num") int num) {
		for(int i = 0; i < num; i++)
			postApi.createPost();
	}
	
	@When("I try to save a post using postid=$postid, versionid=$versionid")
	public void savePost(@Named("postid") int postId, @Named("version") int versionid) {
		retrievedPost = postApi.savePost(postId, versionid, "abcd");
	}
	
	@Then("the post is updated")
	public void checkPost() {
		throw new RuntimeException("The post wasn't saved");
	}
}
	 

