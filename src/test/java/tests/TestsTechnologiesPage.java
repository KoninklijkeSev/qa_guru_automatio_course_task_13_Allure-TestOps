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

@Feature("Tests technologies page")
public class TestsTechnologiesPage extends BaseClass {

    @Test
    @Tag("functional")
    @DisplayName("Check to open technologies page")
    void checkToOpenTechnologiesPage() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click technologies button in a head", () -> {
            $(byText("Technologies")).click();
        });

        step("Check open technologies page", () -> {
            $("#__next").shouldHave(text("Our technologies define us."));
        });
    }

    @Test
    @Disabled
    @Tag("functional")
    @DisplayName("Check to open technologies page with materials")
    void checkToOpenTechnologiesPageWithMaterials() {

        step("Open main page " + url, () -> {
            open(url);
        });

        step("Click technologies button in a head", () -> {
            $(byText("Technologies")).click();
        });

        step("Click in the materials link", () -> {
            $(byText("Materials")).click();
        });

        step("Check open page about materials", () -> {
            $(".cgFtLf.sc-1xylrd1-3").shouldHave(text("Arrival’s proprietary composite materials are low cost, strong and lightweight."));
        });
    }
}
