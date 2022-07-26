package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUNIT5")
class TestStepDefinition {

    @Test
    void testLoginSuccess() {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        String result = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");
        assertEquals("Home Page", result);
    }
}
