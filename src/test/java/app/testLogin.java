package app;

import Utils.ExcelUtils;
import Utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUNIT5")
class testLogin {

    @Test
    void testSignIn() throws Exception {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("D:\\Project\\LoginScriptTest\\src\\test\\resources\\DataTest.xlsx", "DataTestLoginFunction");
        StepDefinition stepDef = new StepDefinition();
        for (int i = 1; i <= 3; i++) {
            stepDef.initDriver();
            HomePage homePage = stepDef.login(excelUtils.getCellData("Email", i), excelUtils.getCellData("Password", i), Utils.linkSignIn, Utils.emailInput, Utils.passwordInput);
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
