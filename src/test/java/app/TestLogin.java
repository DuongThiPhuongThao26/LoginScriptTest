package app;

import Utils.Utils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("JUNIT5")
public class TestLogin extends BaseTest {
    @Test
    public void testLogin() throws Exception {
        ReadExcelFile excel = new ReadExcelFile();
        HomePage homePage = new HomePage(driver);
        for (int i = 1; i <= 3; i++) {

            excel.setExcelFile("src/test/resources/dataTestForLogin.xlsx", "Sheet1");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(excel.getCellData("email", i), excel.getCellData("password", i));
        }
        for (int i = 1; i <= 3; i++) {
            Thread.sleep(3000);
            if (Utils.urlExpected.equals(homePage.getUrl())) {
                excel.setCellData("PASSED", i, 2);
            } else {
                excel.setCellData("FAILED", i, 2);
            }
        }

    }
}
