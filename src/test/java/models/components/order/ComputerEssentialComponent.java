package models.components.order;

import models.components.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputerEssentialComponent extends Component {

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType () {

    }

}
