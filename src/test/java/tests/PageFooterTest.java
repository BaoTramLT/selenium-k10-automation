package tests;

import driver.DriverFactory;
import models.pages.HerokuLoginPage;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class PageFooterTest implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.LOGIN_FORM_SLUG));

            // input login creds
            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
            System.out.println(loginPage.footerComponent().getLinkText());

            //Debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
