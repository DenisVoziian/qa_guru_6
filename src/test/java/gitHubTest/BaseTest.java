package gitHubTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static final String BASE_URL = "https://github.com/";

    protected String repository = "allure-framework/allure2",
            numberIssue = "1291";

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }
}
