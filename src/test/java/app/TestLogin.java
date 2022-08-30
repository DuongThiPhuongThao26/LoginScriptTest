package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUNIT5")
public class TestLogin extends BaseTest {

    @Test
    public void testSignIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Utils.email, Utils.pwd);
        HomePage homePage = new HomePage(driver);
        assertEquals(Utils.urlExpected, homePage.getUrl());
    }
}
