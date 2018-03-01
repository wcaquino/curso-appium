package br.ce.wcaquino.appium.core;

import org.junit.After;

public class BaseTest {

    @After
    public void tearDown() {
        DriverFactory.killDriver();
    }
}
