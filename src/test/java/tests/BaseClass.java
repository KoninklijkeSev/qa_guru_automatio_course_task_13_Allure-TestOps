package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import config.LocalRemoteConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class BaseClass {

    static final LocalRemoteConfig config = ConfigFactory.create(LocalRemoteConfig.class, System.getProperties());
    static final String url = "https://arrival.com/";
    Faker faker = new Faker();
    String SubscribeEmail = faker.internet().emailAddress("email");

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.version();
        Configuration.startMaximized = true;

        if(config.remoteUrl() != null) {
            // config for Java + Selenide
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = config.remoteUrl();
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(config.videoStore() != null)
            attachVideo();
        System.out.println();
        closeWebDriver();
    }
}
