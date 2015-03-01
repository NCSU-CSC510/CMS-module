package edu.ncsu.cms.specs;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import edu.ncsu.cms.model.Post;

public class EditPostSteps {
	Post postObj;
	@Given("API call to the $value method is made")
	public void givenEditPostCalled(String value) {
		//postObj=editPost();
	}
 
	@When("$PostManager is invoked by $editPost method ")
	public void whenPostManagerInvoked(String PostManager, String editPost) {
		//postObj=PostManager.editPost;
	}
 
	
	@Then("I see post is edited by $role")
	public void thenPostObjShouldBe(String role) {
		if (role=="Manager")
			throw new RuntimeException("new post Object not created!");
	}

}
