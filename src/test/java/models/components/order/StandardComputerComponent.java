package models.components.order;

import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {

    private static final By productAttributeSel = By.cssSelector("select[id^=\"product_attribute\"]");
    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        final int PROCESSOR_DROPDOWN_INDEX = 0;
        WebElement processorDropdownElem = component.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);
        Select select = new Select(processorDropdownElem);
        List<WebElement> allOptions = select.getOptions();
        String fullStrOption = null;

        for (WebElement option : allOptions) {
            String currentOptionText = option.getText();
            String optionTextWithoutSpaces = currentOptionText.trim().replace(" ", "");
            if (optionTextWithoutSpaces.startsWith(type)) {
                fullStrOption = currentOptionText;
                break;
            }
        }
    }

    @Override
    public String selectRAMType(String type) {
        return null;
    }
}
