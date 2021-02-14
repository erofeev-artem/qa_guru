import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaIssueTest {
    private final String URL = "https://github.com/";
    private String repoName = "erofeev-artem/qa_guru";
    private String issueName = "add allure to tests";

    @Test
    @Tag("Step_method")
    public void checkIssueTest() {
        step("Open page", () -> open(URL));
        step("Search repository", () -> $("[name=q]").setValue(repoName).pressEnter());
        step("Select repository", () -> $$(".repo-list li a")
                .find(Condition.text(repoName)).click());
        step("Select issue tab", () -> $("[data-content='Issues']").click());
        step("Check that issue is visible", () -> $(byText(issueName)).shouldBe(Condition.visible));
    }
}