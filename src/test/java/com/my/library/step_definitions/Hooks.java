package com.my.library.step_definitions;

import com.my.library.utilities.BrowserUtils;
import com.my.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    /*
    this class will pass pre- and post- conditions for each scenario and step
     */

//    @Before
    public void setupScenario() {
        System.out.println("====Setting up browser using cucumber @Before");
    }

//    @Before(value = "@login ", order = 1)
    public void setupScenarioForLogins() {
        System.out.println("===>will work for @login tag");
    }

    @After
    public void tearDownScenario(Scenario scenario) {


        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        BrowserUtils.sleep(2);
        Driver.closeDriver();

        //        System.out.println(" ============>closing browser using cucumber");
        //        System.out.println("=============>scenario ended/ take screenShot if failed! ");
    }

//    @BeforeStep
    public void setupStep() {
        System.out.println("----->APPLYING SETUP USING @BeforeStep");
    }


//    @AfterStep
    public void afterStep() {
        System.out.println("------------>APPLYING TEAR DOWN using @AfterStep");
    }

}
