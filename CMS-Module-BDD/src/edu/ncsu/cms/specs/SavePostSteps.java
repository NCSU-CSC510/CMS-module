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
	String content;
	
	@Given("number of posts $num")
	public void givenNumberOfPosts(@Named("num") int num) {
		for(int i = 0; i < num; i++)
			postApi.createPost();
	}
	
	@Given("a post with a draft version")
	public void givenDraftVersion() {
		retrievedVersion = postApi.retrievePost(1, 1);
		content = retrievedVersion.getContent();
	}
	
	@Given("a post with a published version")
	public void givenPublishedVersion() {
		retrievedVersion = postApi.retrievePost(2, 1);
		retrievedVersion.setState(State.PUBLISHED);
		content = retrievedVersion.getContent();
	}
	
	@When("I try to save a post using postid=$postid, versionid=$versionid")
	public void savePost(@Named("postid") int postId, @Named("version") int versionid) {
		postApi.savePost(postId, versionid, "abcd");
	}
	
	@Then("the post is updated")
	public void checkPost() {
		if(content == null && retrievedVersion.getContent() == null)
			throw new RuntimeException("The post wasn't updated");
		if(retrievedVersion.getContent().equals(content)) {
			throw new RuntimeException("The post wasn't updated");
		}
	}
	
	@Then("the post is not updated")
	public void checkNotPost() {
		if(content == null && retrievedVersion.getContent() != null)
			throw new RuntimeException("The post was updated");
		if(!retrievedVersion.getContent().equals(content)) {
			throw new RuntimeException("The post was updated");
		}
	}
}
	 

