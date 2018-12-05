package com.igor.khorev.qa.utility;

import com.igor.khorev.qa.annotation.TestComponent;
import com.igor.khorev.qa.logger.Log;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Set;

/**
 * Created by metttalist on 8/21/18.
 */

@TestComponent("testConfiguration")
public class TestConfiguration {

    private static final Log LOGGER = new Log(TestConfiguration.class);

    private String browser;
    private String browserVersion;
    private int browserTimeoutSeconds;
    private String projectName;
    private String applicationName;
    private String applicationURL;
    private String host;
    private String proxyUrl;
    private Platform platform;
    private String userName;
    private String userPassword;
    private String chromeDriverPath;
    private String firefoxDriverPath;
    private String userHomeDirPath;
    private Set<Cookie> fullCookies;
    private String sessionCookie;

    public String getBrowser() {
        return browser;
    }
    @Value("${browser}")
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public int getBrowserTimeoutSeconds() {
        return browserTimeoutSeconds;
    }

    @Value("${browserTimeoutSeconds}")
    public void setBrowserTimeoutSeconds(int browserTimeoutSeconds) {
        this.browserTimeoutSeconds = browserTimeoutSeconds;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationURL() {
        return applicationURL;
    }

    public void setApplicationURL(String applicationURL) {
        this.applicationURL = applicationURL;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProxyUrl() {
        return proxyUrl;
    }

    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }
    @Value("#{${chromeDriverPathMap}}")
    public void setChromeDriverPath(Map<String, String> chromeDriverPathMap) {
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
            this.chromeDriverPath = getUserHomeDirPath() + "/src/test/resources/" + chromeDriverPathMap.get("MAC");
        } else if (System.getProperty("os.name").toUpperCase().contains("LINUX")) {
            this.chromeDriverPath = getUserHomeDirPath() + "/src/test/resources/" + chromeDriverPathMap.get("LINUX");
        } else if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
            this.chromeDriverPath = getUserHomeDirPath() + "\\src\\main\\resources\\" + chromeDriverPathMap.get("WIN");
        }
    }

    public String getFirefoxDriverPath() {
        return firefoxDriverPath;
    }
    @Value("#{${firefoxDriverPathMap}}")
    public void setFirefoxDriverPath(Map<String, String> firefoxDriverPathMap) {
        if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
            this.firefoxDriverPath = getUserHomeDirPath() + "/src/test/resources/" + firefoxDriverPathMap.get("MAC");
        } else if (System.getProperty("os.name").toUpperCase().contains("LINUX")) {
            this.firefoxDriverPath = getUserHomeDirPath() + "/src/test/resources/" + firefoxDriverPathMap.get("LINUX");
        } else if (System.getProperty("os.name").toUpperCase().contains("WIN")) {
            this.firefoxDriverPath = getUserHomeDirPath() + "\\src\\main\\resources\\" + firefoxDriverPathMap.get("WIN");
        }
    }

    public String getUserHomeDirPath() {
        this.userHomeDirPath = SystemUtils.getUserDir().toString();
        return userHomeDirPath;
    }

    public void setUserHomeDirPath(String userHomeDirPath) {
        this.userHomeDirPath = userHomeDirPath;
    }

    public Set<Cookie> getFullCookies() {
        return fullCookies;
    }

    public void setFullCookies(Set<Cookie> fullCookies) {
        this.fullCookies = fullCookies;
    }

    public String getSessionCookie() {
        return sessionCookie;
    }

    public void setSessionCookie(String sessionCookie) {
        this.sessionCookie = sessionCookie;
    }
}
