package gitHubTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubLambdaTests extends BaseTest {

    @Test
    void issueFindLambdaTest() {
        step("Open GitHub", (s) -> {
            s.parameter("uRL", BASE_URL);
            open(BASE_URL);
        });

        step("Find repository with name", (s) -> {
            s.parameter("repository", repository);
            $("input[name='q']").val(repository).pressEnter();
        });

        step("Open repository", (s) -> {
            s.parameter("repository", repository);
            $(byLinkText(repository)).click();
        });

        step("Open Issues lable", () -> {
            $("[data-content='Issues']").click();
        });

        step("Check that issue is displayed", (s) -> {
            s.parameter("number", numberIssue);
            $(withText("#" + numberIssue)).shouldBe(visible);
        });
    }
}