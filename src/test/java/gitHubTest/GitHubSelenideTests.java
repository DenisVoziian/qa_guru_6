package gitHubTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSelenideTests extends BaseTest {

    @Test
    void issueFindSelenideTest() {
        open(BASE_URL);
        $("input[name='q']").val(repository).pressEnter();
        $(byLinkText(repository)).click();
        $("[data-content='Issues']").click();
        $(withText("#" + numberIssue)).shouldBe(visible);
    }
}