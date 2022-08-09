package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@DisplayName("JUNIT5")
class TestStepDefinition {

    @Test
    void testInputValidEmailPwd() throws InterruptedException {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage HomePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");
        assertEquals("Home Page", HomePage.getTittleHomePage());

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
