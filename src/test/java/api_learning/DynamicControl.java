package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitforElementEnabled;
import url.Urls;

import java.time.Duration;

public class DynamicControl {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));

            // define 2 forms locator
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");

            // interact with the checkbox elems
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            // if the checkbox is not selected then select it
            if (!checkboxElem.isSelected()) {
                checkboxElem.click();
            }
            // debug purpose only
            Thread.sleep(1000);

            // interact with the input form elems
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputFormBtnElem = inputFormElem.findElement(By.tagName("button"));

            // if the text field is not enabled then click on the button
            if (!inputFieldElem.isEnabled()) {
                inputFormBtnElem.click();

                //wait until the text field is enabled then sendkeys
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
                wait.until(new WaitforElementEnabled(By.cssSelector("#input-example input")));
            }

            inputFieldElem.sendKeys("This is the new text");

            // debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
