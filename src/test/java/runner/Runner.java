package runner;

import core.report.controller.ActionController;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		 tags = {},
		 glue = {"hooks", "steps"},
		 plugin = {"pretty","json:target/json-cucumber-reports/cucumber.json",
				 	"junit:target/xml-junit/junit.xml",
				 	"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"},
		features = {"src/test/resources/features"})
public class Runner {
	@AfterClass
	public static void tearDownAll(){
		new ActionController().sendResults();
	}
}
