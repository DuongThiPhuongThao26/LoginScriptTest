package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestStepDefinition {

    @Test
    public void testLoginSuccess() {
        String email = "metis.auto.maker@gmail.com";
        String pwd = "Fpt@1234";

        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        String result = stepDef.login(email, pwd);

        assertEquals("https://dopl9dr063y3a.cloudfront.net/", result);
    }

    @Test
    public void testLoginFail() {
        String email = "thaodtp12@fsoft.com";
        String pwd = "1234@";
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        stepDef.login(email, pwd);
        String result = stepDef.login(email, pwd);
        assertEquals("https://dopl9dr063y3a.cloudfront.net/login", result);
    }

}
