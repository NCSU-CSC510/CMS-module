package edu.ncsu.cms.specs;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import edu.ncsu.cms.model.Post;
import edu.ncsu.cms.model.PostManager;
import edu.ncsu.cms.model.State;
import edu.ncsu.cms.model.Version;

public class EditPostSteps {
	Post postObj;
	PostManager p = PostManager.instance();
	Version version;
	String state;
	
	@Given("API call to the editPost method is made")
	public void givenEditPostCalled() {
		postObj = p.createNew();
		version = postObj.getCurrentVersion();
		p.editPost(postObj, version.getVersionId(), "content");
	}
 
	@When("the post is in $s state ")
	public void whenPostStateIs(String s) {
		//check for the state of the object;
			state = s;
	}
 
	
	@Then("post version $content is replaced")
	public void thenContentIs(String content) {
		if(state.equals( (State.DRAFT).toString() )) {
			version.setContent(content);
		}
	}
	
	@Then("Then $n version is created")
	public void thenNewVersion(String n) {
		Version v2 = new Version();
		if(state.equals( (State.ARCHIVE).toString() )) {
			v2.setContent(n);
		}
	}
	
	@Then("Then $n version is created in $s State")
	public void thenNewDraft(String n) {
		Version v2 = new Version();
		if(state.equals( (State.PUBLISHED).toString() )) {
			version.setContent(n);
		}
	}

}
