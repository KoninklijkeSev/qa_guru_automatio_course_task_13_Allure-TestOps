package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Tests main page")
public class TestsMainPage extends BaseClass {

    @Test
    @Tag("functional")
    @DisplayName("Check open main page " + url)
    void checkToOpenMainPage() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Check that main page is open", () -> {
            $("#__next").shouldHave(text("Zero-emission mobility\n" + "solutions for your city."));
        });
    }

    @Test
    @Tag("functional")
    @DisplayName("Check subscribe form")
    void checkSubscribeForm() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click scroll down for more", () -> {
            $(byText("scroll down for more")).click();
        });

        step("Find and click subscribe form", () -> {
            $(byLinkText("CONNECT FOR UPDATES")).click();
        });

        step("Fill email", () -> {
            $("[placeholder='Type your email']").setValue(SubscribeEmail);
        });

        step("Push button 'Submit", () -> {
            $(byText("Submit")).click();
        });

        step("Check succesfully subscribe", () -> {
            $("#__next").shouldHave(text("You've been succesfully subscribed."));
        });
    }

    @Test
    @Tag("functional")
    @DisplayName("Check to open twitter page")
    void checkToOpenTwitterPage() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click button in a bottom Twitter", () -> {
            $(byText("Twitter")).click();
        });

        step("Switch page", () -> {
            Selenide.switchTo().window(1);
        });

        step("Check info thats open instagram", () -> {
            $("#react-root").shouldHave(text("Zero-emission solutions for cities. Human-centred, intelligent design - to revitalise public transportation."));
        });
    }

}
