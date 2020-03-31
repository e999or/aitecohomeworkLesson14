package com.github.Lesson15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;


public class SimpleTest {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTest.class);
    WebDriver webDriver ;

    @BeforeClass
    public void beforeTestClass() {
        LOG.info("Before class ComplexTest");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public void afterxTestClass() {
        LOG.info("After class ComplexTest");
        webDriver.quit();
    }


    @Test
    public void simpleTest() {
        LOG.info("Simple test");
        webDriver.get("https://yandex.ru/");
        WebElement input = webDriver.findElement(By.id("text"));
        input.sendKeys("Руддщ цщкдв");
        WebElement button = webDriver.findElement(By.xpath("//div[@class=\"search2__button\"]/button"));
        button.click();
        WebElement inspectedFild = webDriver.findElement(By.xpath("//span[@class=\"input__box\"]/input"));
        Assert.assertEquals(inspectedFild.getAttribute("value"),"Hello world");
        String inspectedFildTitle = webDriver.getTitle();
        Assert.assertTrue(inspectedFildTitle.contains("Hello world"));
    }
}



