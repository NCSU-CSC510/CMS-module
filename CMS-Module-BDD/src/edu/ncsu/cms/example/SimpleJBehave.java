package edu.ncsu.cms.example;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;


@RunWith(JUnitReportingRunner.class)
public class SimpleJBehave extends JUnitStories{
	
	public SimpleJBehave() {
		super();
	}
 
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new ExampleSteps());
	}
 
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("edu\\ncsu\\cms\\example\\story.story");
	}
	
 
}
