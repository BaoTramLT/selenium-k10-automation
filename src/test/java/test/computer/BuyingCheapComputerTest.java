package test.computer;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.Test;
import test_flows.computer.OrderComputerFlow;
import test.testng01.BaseTest;
import url.Urls;

public class BuyingCheapComputerTest extends BaseTest implements Urls {

    @Test
    public void testCheapComputerBuying() {
        driver.get(BASE_URL.concat("/build-your-cheap-own-computer"));

        OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, CheapComputerComponent.class);

        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
