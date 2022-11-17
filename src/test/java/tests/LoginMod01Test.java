package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

import java.util.function.UnaryOperator;

public class LoginMod01Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.LOGIN_FORM_SLUG));

            // input login creds
            LoginPageMod01 loginPage = new LoginPageMod01(driver);
            loginPage.usernameElem().sendKeys("Teo");
            loginPage.passwordElem().sendKeys("12345678");
            loginPage.loginBtnElem().click();

            //Debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
