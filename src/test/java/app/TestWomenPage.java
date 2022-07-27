package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("JUNIT5")
public class TestWomenPage {
    @Test
    public void testAddToCart(){
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();
        HomePage homePage = stepDef.login("duongphuong261020@gmail.com", "Lungtung1234@");
        WomenPage womenPage = homePage.clickOnWomenTab();
        womenPage.addToCart();
        assertEquals("You added Breathe-Easy Tank to your shopping cart.", womenPage.getTextOfAlert());
    }

}
