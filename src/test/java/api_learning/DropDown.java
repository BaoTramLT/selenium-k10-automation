package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;
import url.Urls;

public class DropDown {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            //navigate to the dropdown page
            driver.get(Urls.BASE_URL.concat(Urls.DROPDOWN_SLUG));

            //locate the select tag
            WebElement dropdownElem = driver.findElement(By.cssSelector("#dropdown"));
            SelectEx select = new SelectEx(dropdownElem);

            //select by visible text
            select.selectOption01();
            Thread.sleep(1000);

            //select.selectOption1();

            //select by index
            select.selectByIndex(2);
            Thread.sleep(2000);

            //select by value
            select.selectByValue("1");

            //debug purpose only
            Thread.sleep(2000);


        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
