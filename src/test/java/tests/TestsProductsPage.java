package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Tests products page")
public class TestsProductsPage extends BaseClass {

    @Test
    @Tag("functional")
    @DisplayName("Check to open products page with arrival bus")
    void checkToOpenProductsPageTheArrivalBus() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click investors button in a head", () -> {
            $(byText("Products")).click();
        });

        step("Click in the arrival bus", () -> {
            $(byText("The Arrival Bus")).click();
        });

        step("Check open page about the arrival bus", () -> {
            $(".grUrcU.sc-1btm3za-1").shouldHave(text("Every city is different, so the Arrival Bus can be tailored to local needs."));
        });
    }

    @Test
    @Tag("functional")
    @DisplayName("Check to open products page with arrival van")
    void checkToOpenProductsPageTheArrivalVan() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click investors button in a head", () -> {
            $(byText("Products")).click();
        });

        step("Click in the arrival van", () -> {
            $(byText("The Arrival Van")).click();
        });

        step("Check open page about the arrival van", () -> {
            $(".eqrrvD.sc-1ffldrv-1").shouldHave(text("We’ve re-thought commercial cargo vehicles."));
        });
    }

    @Test
    @Tag("functional")
    @DisplayName("Check to open digital products")
    void checkToOpenProductsPageDigitalProducts() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click investors button in a head", () -> {
            $(byText("Products")).click();
        });

        step("Click in digital products", () -> {
            $(byText("Digital Products")).click();
        });

        step("Check open page about the arrival van", () -> {
            $(".eqrrvD.sc-1ffldrv-1").shouldHave(text("We’ve developed a range of digital products"));
        });
    }

}
