package edu.ncsu.cms.specs;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import edu.ncsu.cms.model.*; 
public class DeletePostSteps extends Steps{
	Post postObj;
	boolean deleted;
	PostManager postMangr = PostManager.instance();
	@Given("API call to the deletePost method is made")
	public void givenDeletePostCalled() {
		
		postObj= postMangr.createNew();
				   
	}
 
	@When("PostManager is invoked by deletePost method")
	public void whenPostManagerInvoked() {
		 deleted =postMangr.deletePost(postObj.getPostId());
	}
 
	@Then("I see post is deleted")
	public void thenPostObjShouldBe() {
		if (deleted==false)
			throw new RuntimeException("new post Object not deleted!");
	}
		}
	 

