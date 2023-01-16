package steps;

import config.Configuration;
import driver.DriverManager;
import driver.TargetFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static WebDriver driver;
    public static void setUp(String browser,String ortam){
        Map env = new HashMap();
        env.put("env", ortam);
        Configuration cfg =ConfigFactory.create(Configuration.class, env);
        driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(cfg.url());
    }

    public static  void after(){
        //driver.quit();
    }
}
