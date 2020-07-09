package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature/democrm.feature", glue = "steps", monochrome = true)
public class RunCRM extends AbstractTestNGCucumberTests{
	
	

}
