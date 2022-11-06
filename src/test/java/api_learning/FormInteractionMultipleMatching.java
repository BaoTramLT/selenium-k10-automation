package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define selector values
            By inputFieldSel = By.tagName("input");
            WebElement usernameElem = driver.findElement(inputFieldSel);
            List<WebElement> inputFieldsElem = driver.findElements(inputFieldSel);
            if(inputFieldsElem.isEmpty()) {
                throw new RuntimeException("[ERROR] There is no input fields");
            }
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            inputFieldsElem.get(0).sendKeys("teo");
            inputFieldsElem.get(1).sendKeys("12345678");

            //Debug
            Thread.sleep(3000);

        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}
