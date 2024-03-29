package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(
		features = "src/test/java/FeaturePackage/",
		glue = {"StepDefinitionPackage","Hooks"},
		/* dryRun = true, */ 
		tags = "@smoke and @sanity",
		monochrome =true
		)
public class Runnerclass extends AbstractTestNGCucumberTests {

}
