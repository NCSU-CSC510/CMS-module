package edu.ncsu.cms.specs;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import edu.ncsu.cms.model.*; 
public class PublishPostSteps extends Steps{
	Post postObj;
	PostManager postMangr = PostManager.instance();
	@Given("API call to the publishPost method is made")
	public void givenCreatePostCalled() {
		//postObj=postMangr.createNew(); 
	}
 
	@When("PostManager is invoked by publishPost method")
	public void whenPostManagerInvoked() {
		//postObj=postMangr.createNew();
	}
 
	
	@Then("I see current version of post is PUBLISHED")
	public void thenVersionShouldBe(@Named("version") String version) {
		/*if (postObj.getCurrentVersion().getState() != State.DRAFT)
			throw new RuntimeException("version is " + postObj.getCurrentVersion().getState() + ", but should be " + version);
	*/
	}
	 
}
