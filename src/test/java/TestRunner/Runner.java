package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Feature\\Modular.feature",
glue = "StepDefinition"
//,tags="@valid"

,plugin = {"pretty","html:target/HTMLReports/AsianPaints.html",

		"json:target/JSONReports/AsianPaints.json",// testNG reports

         "junit:target/JUNITReport/AsianPaints.xml",

         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class Runner extends AbstractTestNGCucumberTests{
}
