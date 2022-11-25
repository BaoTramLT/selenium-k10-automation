package test_flows.global.footer;

import models.components.global.footer.*;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(driver);
        InformationColumn informationColumn = basePage.footerComponent().informationColumn();
        CustomerServiceColumn customerServiceColumn = basePage.footerComponent().customerServiceColumn();
        MyAccountColumn myAccountColumn = basePage.footerComponent().myAccountColumn();
        FollowUsColumn followUsColumn = basePage.footerComponent().followUsColumn();

        verifyInformationColumn(informationColumn);
        verifyCustomerServiceColumn(customerServiceColumn);
        verifyAccountColumn(myAccountColumn);
        verifyFollowUsColumn(followUsColumn);
    }


    private void verifyInformationColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap",
                "Shipping & Returns",
                "Privacy Notice",
                "Conditions of Use",
                "About us",
                "Contact us"
        );
        List<String> expectedHrefs = Arrays.asList(
                "https://demowebshop.tricentis.com/sitemap",
                "https://demowebshop.tricentis.com/shipping-returns",
                "https://demowebshop.tricentis.com/privacy-policy",
                "https://demowebshop.tricentis.com/conditions-of-use",
                "https://demowebshop.tricentis.com/about-us",
                "https://demowebshop.tricentis.com/contactus"
        );
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyAccountColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyFollowUsColumn(FooterColumnComponent footerColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("");
        List<String> expectedHrefs = Arrays.asList("");
        verifyFooterColumn(footerColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyFooterColumn(FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();

        if(footerColumnComponent.linkElem().isEmpty())
            Assert.fail("The column has no item to test");

        for (WebElement link : footerColumnComponent.linkElem()) {
            actualinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));
        }

        if(actualHrefs.isEmpty() || actualinkTexts.isEmpty())
            Assert.fail("[ERR] Texts or hyperlink is empty in the footer column");

        // verify link text
        Assert.assertEquals(actualinkTexts, expectedLinkTexts, "[ERR] Link text list is mismatched");
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Hyperlink list is mismatched");
        // verify hyperlinks

    }
}
