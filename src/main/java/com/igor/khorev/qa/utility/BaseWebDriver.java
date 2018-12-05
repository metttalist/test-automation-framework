package com.igor.khorev.qa.utility;

import com.igor.khorev.qa.annotation.TestComponent;
import com.igor.khorev.qa.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by metttalist on 8/13/18.
 */
@TestComponent("driver")
@DependsOn({"testConfiguration"})
public class BaseWebDriver {
//    Creating new ClassPathXmlApplicationContext object to use for bean retrieval from spring container.
//    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Autowired
    public TestConfiguration testConfiguration;

    private static final Log LOGGER = new Log(BaseWebDriver.class);

    private int pageLoadTimeout;
    private String driverType;
    private RemoteWebDriver remoteWebDriver;
    private EventFiringWebDriver wrappedWebDriver;

    @PostConstruct
    public void init(){

        driverType = getDriverType();

        switch (driverType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", testConfiguration.getChromeDriverPath());
                remoteWebDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", testConfiguration.getFirefoxDriverPath());
                remoteWebDriver = new FirefoxDriver();
                break;
            case "ie":
                remoteWebDriver = new InternetExplorerDriver();
                break;
            case "safari":
                remoteWebDriver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Driver type of: '" + driverType + "' is not supported.");
        }

        wrappedWebDriver = new EventFiringWebDriver(remoteWebDriver);
        DefaultEventListener eventListener = new DefaultEventListener();
        wrappedWebDriver.register(eventListener);

        if (testConfiguration.getBrowser().equals("chrome")) {
            // Set Chrome browser window size since maximize() is failing for Chrome
            wrappedWebDriver.manage().window().setSize(new Dimension(1500, 1150));
        } else wrappedWebDriver.manage().window().maximize();

        wrappedWebDriver.manage().timeouts().setScriptTimeout(testConfiguration.getBrowserTimeoutSeconds(), TimeUnit.SECONDS);

        testConfiguration.setBrowserVersion(remoteWebDriver.getCapabilities().getVersion());
        testConfiguration.setPlatform(remoteWebDriver.getCapabilities().getPlatform());

    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public String getDriverType() {
        this.driverType = testConfiguration.getBrowser().toLowerCase();
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public void goToURL(String url) {
        wrappedWebDriver.navigate().to(url);
    }

    public void navigateBack() {
        wrappedWebDriver.navigate().back();
    }

    public void  navigateForward() {
        wrappedWebDriver.navigate().forward();
    }

    public void refresh() {
        wrappedWebDriver.navigate().refresh();
    }

    public void close() {
        wrappedWebDriver.close();
    }

    public void quit() {
        wrappedWebDriver.quit();
    }

    public WebElement waitForElement(By by) {
        return waitForElement(by, null);
    }

    public WebElement waitForElement(By by, Integer maxWaitInSeconds) {
        final int waitInSeconds =
                (maxWaitInSeconds != null) ? maxWaitInSeconds : testConfiguration.getBrowserTimeoutSeconds();
        return (new WebDriverWait(wrappedWebDriver, waitInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForElements(By by, Integer maxWaitInSeconds) {
        final int waitInSeconds =
                (maxWaitInSeconds != null) ? maxWaitInSeconds : testConfiguration.getBrowserTimeoutSeconds();
        return (new WebDriverWait(wrappedWebDriver, waitInSeconds)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitForElementToBeClickable(WebElement element, Integer maxWaitInSeconds) {
        final int waitInSeconds =
                (maxWaitInSeconds != null) ? maxWaitInSeconds : testConfiguration.getBrowserTimeoutSeconds();
         (new WebDriverWait(wrappedWebDriver, waitInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
         element.click();
    }
}
