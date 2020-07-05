package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/feature/ajio.feature",glue="steps",monochrome = true)
public class RunAjio extends AbstractTestNGCucumberTests {

}
