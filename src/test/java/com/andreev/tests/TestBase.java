package com.andreev.tests;

import com.andreev.config.CredentialsConfig;
import com.andreev.helpers.Attachments;
import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    private static final String browserName = System.getProperty("browser", "chrome");
    private static final String browserSize = System.getProperty("browserSize", "1920x1080");
    private static final String browserVersion = System.getProperty("browserVersion", "100.0");
    private static final String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub");
    private static final String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

        @BeforeAll
        public static void beforeAllTests(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.browser = browserName;
            Configuration.browserVersion = browserVersion;
            Configuration.browserSize = browserSize;
            Configuration.baseUrl = baseUrl;
            Configuration.remote = "https://" + credentials.login() + ":" + credentials.password() + "@" + url;
    }

    @AfterEach
    public void afterEachTests() {
        Attachments.screenshotAs("Screenshot");
        Attachments.addVideo();
    }
}
