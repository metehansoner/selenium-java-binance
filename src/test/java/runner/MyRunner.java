package runner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.BaseSteps;

@Test
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@smoke",
        features = {"src/test/java/features"},
        glue = {"steps"})
public class MyRunner extends AbstractTestNGCucumberTests{
    @Parameters({ "browser" ,"env"})
    @BeforeTest
    public static void setUpScenario(String browser,String env) {
        System.out.println(env);
        BaseSteps.setUp(browser,env);
    }
    @AfterTest
    public static  void afterTest(){
        BaseSteps.after();
    }
}