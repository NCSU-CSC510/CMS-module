package edu.ncsu.cms.specs;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import edu.ncsu.cms.example.ExampleSteps;

@RunWith(JUnitReportingRunner.class)
public class JBehave  extends JUnitStories {

	public JBehave(){
		super();
	}
 
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new RetrievePostSteps(), new EditPostUserAccess(), new SavePostSteps(), new EditPostSteps());
	}
 
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("edu\\ncsu\\cms\\specs\\stories\\EditPostUserAccess.story", 
							 "edu\\ncsu\\cms\\specs\\stories\\RetrievePosts.story", 
							 "edu\\ncsu\\cms\\specs\\stories\\SavePosts.story",
							 "edu\\ncsu\\cms\\specs\\stories\\EditPosts.story");
	}
}
