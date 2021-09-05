package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    private final Page page;

    private final String locator_searchBar = "#searchBar";
    private final String locator_hiddenBooks = "li.ui-screen-hidden";
    private final String locator_visibleBooks = "li:not(.ui-screen-hidden)";
    private final String locator_visibleBookTitles = "li:not(.ui-screen-hidden) h2";


    public SearchPage(Page page){
        this.page = page;
    }

    public void search(String query) {
        clearSearchBar();
        page.fill(locator_searchBar, query);

        Page.WaitForSelectorOptions expectedState = new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.ATTACHED);
        page.waitForSelector(locator_hiddenBooks,expectedState);
    }

    public void clearSearchBar(){
        page.fill(locator_searchBar, "");

        Page.WaitForSelectorOptions expectedState = new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.DETACHED);
        page.waitForSelector(locator_hiddenBooks,expectedState);
    }

    public int getNumberOfVisibleBooks(){
       return page.querySelectorAll(locator_visibleBooks).size();
    }

    public List<String> getVisibleBooks(){
        return page.querySelectorAll(locator_visibleBookTitles)
                .stream()
                .map(ElementHandle::innerText)
                .collect(Collectors.toList());
    }
}