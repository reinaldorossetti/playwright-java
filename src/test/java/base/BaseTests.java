package base;

import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;

import java.nio.file.Paths;

public class BaseTests {

    private Browser browser;
    protected SearchPage searchPage;
    Page page;

    @BeforeClass
    public void setUp(){

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        //A single browser tab
        page = browser.newPage();
        page.navigate("https://automationbookstore.dev/");
        searchPage = new SearchPage(page);
    }

    @AfterTest
    @Attachment(value = "PageScreenAfterTest", type = "image/png")
    public byte[] screenshot() {
        return page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png"))
                .setFullPage(true));
    }

    @AfterSuite
    public void tearDown(){
        page.close();
        browser.close();
    }
}