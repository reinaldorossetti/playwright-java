package search;

import br.reinaldo.base.BaseTests;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import br.reinaldo.pages.SearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTests extends BaseTests {

    SearchPage searchPage = new SearchPage(page);

    @Test
    @Step("Search for exact title")
    public void searchForExactTitle(){
        String title = "Agile Testing";
        searchPage.search(title);
        assertEquals(searchPage.getNumberOfVisibleBooks(), 1, "Number of visible books");
        assertTrue(searchPage.getVisibleBooks().contains(title), "Title of visible book");
        screenshot();
    }

     @Test
     @Step("Search for partial title")
    public void searchForPartialTitle(){
        searchPage.search("Test");

        List<String> expectedBooks = List.of(
                "Test Automation in the Real World",
                "Experiences of Test Automation",
                "Agile Testing",
                "How Google Tests Software",
                "Java For Testers"
        );

         assertEquals(searchPage.getNumberOfVisibleBooks(), expectedBooks.size(), "Number of visible books");
         assertEquals(searchPage.getVisibleBooks(), expectedBooks,"Titles of visible books");
         screenshot();
    }
}
