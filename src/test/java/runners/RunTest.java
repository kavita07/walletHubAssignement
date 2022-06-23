package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//src/test/java/features",
glue = "stepDefinitions",
plugin = { "pretty",
		"json:target/cucumber-report/cucumber.json",
		"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
},
dryRun = false,
monochrome = true,
tags="@test"
)



public class RunTest {

}
