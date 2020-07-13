package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature/shopclues.feature", glue = "steps", monochrome = true)
public class RunShopClues extends AbstractTestNGCucumberTests{

}
