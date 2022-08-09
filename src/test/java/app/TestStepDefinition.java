package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import app.Helpers.ExcelUtils;
import org.junit.AfterClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@DisplayName("JUNIT5")
class TestStepDefinition {
    @Test
    void testInputValidEmailPwd() throws Exception {
        StepDefinition stepDef = new StepDefinition();
        stepDef.initDriver();

        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("D:\\Project\\LoginScriptTest\\src\\test\\resources\\DataTest.xlsx", "DataTestLoginFunction");

        HomePage HomePage = stepDef.login(excelUtils.getCellData("Email", 1), excelUtils.getCellData("Password", 1));
        assertEquals("https://magento.softwaretestingboard.com/", HomePage.getUrl());

        Thread.sleep(3000);
        stepDef.quitBrowser();
    }
}
