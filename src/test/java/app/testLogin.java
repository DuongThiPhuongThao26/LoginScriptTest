package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Utils.ExcelUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@DisplayName("JUNIT5")
class testLogin {

    By errorMessage = By.xpath("//div[@class='message-error error message']");
    @Test
    void testSignInSuccess() throws Exception {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();

        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("D:\\Project\\LoginScriptTest\\src\\test\\resources\\DataTest.xlsx", "DataTestLoginFunction");

        HomePage HomePage = stepDef.login(excelUtils.getCellData("Email", 1), excelUtils.getCellData("Password", 1));
        assertEquals("https://magento.softwaretestingboard.com/", HomePage.getUrl());

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }

    @Test
    void testSignInFail() throws Exception {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();

        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("D:\\Project\\LoginScriptTest\\src\\test\\resources\\DataTest.xlsx", "DataTestLoginFunction");

        stepDef.login(excelUtils.getCellData("Email", 1), excelUtils.getCellData("Password", 1));
        LoginPage loginPage = new LoginPage(stepDef.driver);
        assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",loginPage.getErrorMessage(errorMessage));

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
