import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SimpleIssueTest {
    private final String URL = "https://github.com/";
    private String repoName = "erofeev-artem/qa_guru";
    private String issueName = "add allure to tests";

    @Test
    @Tag("Selenide")
    public void checkIssueTest() {
        open(URL);
        $("[name=q]").setValue(repoName).pressEnter();
        $$(".repo-list li a").find(Condition.text(repoName)).click();
        $("[data-content='Issues']").click();
        $(byText(issueName)).shouldBe(Condition.visible);
    }
}