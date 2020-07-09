package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature/JustDial.feature", glue = "steps", monochrome = true)
public class RunJustDial extends AbstractTestNGCucumberTests{
	
	

}
