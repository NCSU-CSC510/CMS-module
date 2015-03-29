package edu.ncsu.cms.specs;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import edu.ncsu.cms.api.PostApi;
import edu.ncsu.cms.model.*;

public class PublishPostSteps extends Steps{
	PostApi postApi = new PostApi();
	Post retrievedPost;
	Version retrievedVersion;
	
	@Given("number of posts $num")
	public void givenNumberOfPosts(@Named("num") int num) {
		for(int i = 0; i <= num; i++)
			postApi.createPost();
	}
	
	@Given("a post with a draft version")
	public void givenDraftVersion() {
		retrievedPost = postApi.retrievePost(1);
		Version v1 = retrievedPost.getCurrentVersion();
		v1.setState(State.PUBLISHED);
		Version v2=new Version();
		v2.setVersionId(2);
		v2.setState(State.DRAFT);
		retrievedPost.addnewVersion(v2);
		//content = retrievedVersion.getContent();
	}
	
	@Given("a post with a published version")
	public void givenPublishedVersion() {
		retrievedVersion = postApi.retrievePost(2, 1);
		retrievedVersion.setState(State.PUBLISHED);
		
	}
	
	@When("I try to publish a post using postid=$postid, versionid=$versionid")
	public void publishPost(@Named("postid") int postId, @Named("version") int versionid) {
		postApi.publishPost(postId, versionid);
	}
	
	@Then("the current version is updated")
	public void checkPost() {
		if(retrievedPost.getCurrentVersion().getVersionId() !=2)
			throw new RuntimeException("The current version wasn't updated");
		
	}
	
	/*@Then("the post is not updated")
	public void checkNotPost() {
		if(content == null && retrievedVersion.getContent() != null)
			throw new RuntimeException("The post was updated");
		if(content == null && retrievedVersion.getContent() == null)
			return;
		if(!retrievedVersion.getContent().equals(content)) {
			throw new RuntimeException("The post was updated");
		} 
		
	}*/
}
	 

