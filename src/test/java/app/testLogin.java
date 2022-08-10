package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Utils.ExcelUtils;
import Utils.Locator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DisplayName("JUNIT5")
class testLogin {

    @Test
    void testSignIn() throws Exception {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("D:\\Project\\LoginScriptTest\\src\\test\\resources\\DataTest.xlsx", "DataTestLoginFunction");
        StepDefinition stepDef = new StepDefinition();
        for (int i = 1; i <= 3; i++) {
            stepDef.initDriver();
            HomePage homePage = stepDef.login(excelUtils.getCellData("Email", i), excelUtils.getCellData("Password", i), Locator.linkSignIn, Locator.emailInput, Locator.passwordInput);
            String urlExpected = "https://magento.softwaretestingboard.com/";
            if (urlExpected.equals(homePage.getUrl())){
                System.out.println("PASSED!");
            } else {
                System.out.println("FAILED!");
            }

            Thread.sleep(3000);
            stepDef.quitBrowser();

        }
    }

}
