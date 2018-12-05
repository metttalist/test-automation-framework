package com.igor.khorev.qa.utility;

import com.igor.khorev.qa.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by metttalist on 8/14/18.
 */
public class DefaultEventListener implements WebDriverEventListener {

    private static final Log LOGGER = new Log(DefaultEventListener.class);


    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOGGER.debug("Navigating to: {}", url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.debug("Navigation successful.", url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        LOGGER.debug("Navigating back...");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        LOGGER.debug("Navigation successful.");

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        LOGGER.debug("Navigating forward...");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        LOGGER.debug("Navigation successful.");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        LOGGER.debug("Refreshing the page...");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        LOGGER.debug("Done.");

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOGGER.debug("In attempt to find webElement:({}).", by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        LOGGER.debug("The element is found.");

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        LOGGER.debug("Executing '{}' script...", script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

}
