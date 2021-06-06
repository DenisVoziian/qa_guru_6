package gitHubPages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPage {
    private SelenideElement searchInput = $("input[name='q']"),
            issuesTabLink = $("[data-content='Issues']");

    private SelenideElement repositorySearchLink(String repository) {
        return $(byLinkText(repository));
    }

    private SelenideElement issuesWithNumberLink(String numberIssue) {
        return $(withText("#" + numberIssue));
    }

    @Step("Open GitHub")
    public GitHubPage openGitHub(String uRL) {
        open(uRL);
        return this;
    }

    @Step("Find {searchData} by search")
    public GitHubPage searchOnMainPage(String searchData) {
        searchInput.val(searchData).pressEnter();
        return this;
    }

    @Step("Open {searchData}")
    public GitHubPage openSearchedResult(String searchData) {
        repositorySearchLink(searchData).click();
        return this;
    }

    @Step("Open 'Issues' tab")
    public GitHubPage openIssuesTab() {
        issuesTabLink.click();
        return this;
    }

    @Step("Check that issue with {number} number is displayed")
    public GitHubPage checkIssuedByNumber(String number) {
        issuesWithNumberLink(number).shouldBe(visible);
        return this;
    }
}
