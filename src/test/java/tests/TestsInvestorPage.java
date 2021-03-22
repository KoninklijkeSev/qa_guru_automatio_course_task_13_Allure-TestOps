package tests;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Tests investor page")
public class TestsInvestorPage extends BaseClass {

    @Test
    @Tag("functional")
    @DisplayName("Check to open investor page")
    void checkToOpenInvestorPage() {

        step("Open main page" + url, () -> {
            open(url);
        });

        step("Click investors button in a head", () -> {
            $(byText("Investors")).click();
        });

        step("Check open investors page", () -> {
            $("#__next").shouldHave(text("Arrival’s New Method presents an unprecedented commercial opportunity"));
        });
    }

    @Test
    @Tag("functional")
    @DisplayName("Check to download investor presentation")
    void checkToDownloadInvestorPresentation() throws IOException {

        step("Open main page" + url, () -> {
            open(url);
        });

        step("Click scroll down for more", () -> {
            $(byText("scroll down for more")).click();
        });

        step("Find and click investor relations", () -> {
            $(byText("Investor relations")).click();
        });

        step("Accept cookies", () -> {
            $(byText("accept cookies")).click();
        });

        step("Click investor presentation", () -> {
            File pdf = $(byLinkText("INVESTOR PRESENTATION")).download();
            sleep(5000);
            PDF actualPdf = new PDF(pdf);
            assertThat(actualPdf, PDF.containsText("Analyst Presentation"));
            pdf.delete();
        });
    }

}
