package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature/naukri.feature", glue = "steps", monochrome = true)
public class RunNaukri extends AbstractTestNGCucumberTests{

}
