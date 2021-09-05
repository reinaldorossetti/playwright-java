package br.reinaldo.base;

import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Paths;

public class BaseTests {

    private static Browser browser;
    public static Page page;

    @BeforeAll
    static void setUp(){

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        //A single browser tab
        page = browser.newPage();
        page.navigate("https://automationbookstore.dev/");
    }

    @Attachment(value = "PageScreenAfterTest", type = "image/png")
    public byte[] screenshot() {
        return page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png"))
                .setFullPage(true));
    }

    @AfterAll
    static void tearDown(){
        page.close();
        browser.close();
    }
}