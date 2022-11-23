package tests.testng;

import org.testng.annotations.Test;

public class TestNgOrder {

    @Test(dependsOnMethods = "testB")
    public void testA() {
        System.out.println("Test A");
    }

    @Test()
    public void testB() {
        System.out.println("Test B");
        throw new RuntimeException("Err..");
    }
}
