package gitHubTest;

import gitHubPages.GitHubPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class GitHubWithStepsTests extends BaseTest {
    private GitHubPage gitHubPage = new GitHubPage();

    @Feature("QA.GURU")
    @Story("HW#6. Allure Reports. Артём Ерошенко")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "GitHub", url = "https://github.com/")
    @Owner("denisvoziian")
    @Test
    void issueFindWithStepsTest() {
        gitHubPage.openGitHub(BASE_URL)
                .searchOnMainPage(repository)
                .openSearchedResult(repository)
                .openIssuesTab()
                .checkIssuedByNumber(numberIssue);
    }
}