package com.andreev.tests;

import com.andreev.helpers.Attachments;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    private static String browserName = System.getProperty("browser", "firefox");
    private static String browserSize = System.getProperty("browserSize", "1920x1080");

        @BeforeAll
        public static void beforeAllTests(){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            System.out.println(browserName);
            Configuration.browser = browserName;
            Configuration.browserSize = browserSize;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    public void afterEachTests() {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
//        Attachments.browserConsoleLogs();
//        Attachments.addVideo();
    }
}
