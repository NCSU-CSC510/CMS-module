package edu.ncsu.cms.specs;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import edu.ncsu.cms.model.*; 
public class CreatePostSteps extends Steps{
	Post postObj;
	@Given("API call to the createPost method is made")
	public void givenCreatePostCalled() {
		//postObj=createPost();
	}
 
	@When("PostManager is invoked")
	public void whenPostManagerInvoked() {
		//postObj=PostManager.getPostObj;
	}
 
	
	@Then("I see a new post created")
	public void thenPostObjShouldBe() {
		if (postObj==null)
			throw new RuntimeException("new post Object not created!");
	}
	
	@Then("version is assigned to $version")
	public void thenVersionShouldBe(@Named("version") String version) {
		//if (!version.equals("Draft"))
		//	throw new RuntimeException("version is " + postObj.getVersion() + ", but should be " + version);
	}
	 
}
