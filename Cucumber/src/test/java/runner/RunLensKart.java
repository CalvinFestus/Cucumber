package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature/lenskart.feature", glue = "steps", monochrome = true)
public class RunLensKart extends AbstractTestNGCucumberTests {

}
