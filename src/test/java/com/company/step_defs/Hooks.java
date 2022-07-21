package com.company.step_defs;

import com.company.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Before- setup method is running before the scenario");

    }

    @After
    public void tearDownScenario(Scenario scenario){
        /**
         * cast webdriver to TakeScreenshot interface. (TakeScreenshot)Driver.getDriver()
         * call getScreenShotAs method and output type as OutputType.BYTES
         * save the result into byte[] array: byte[] image
         * attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         * if scenairo is failed, take a screenshot
         */
        if(scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
        System.out.println("After - teardown method is running after the scenario ");
        Driver.closeDriver();
    }
}
