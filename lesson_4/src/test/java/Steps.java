import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Steps {

    @Step("Open page")
    public void openPage(String url) {
        open(url);
    }

    @Step("Search repository")
    public void searchRepo(String repoName) {
        $("[name=q]").setValue(repoName).pressEnter();
    }

    @Step("Select repository")
    public void selectRepo(String repoName) {
        $$(".repo-list li a").find(Condition.text(repoName)).click();
    }

    @Step("Select issue tab")
    public void selectIssueTab() {
        $("[data-content='Issues']").click();
    }

    @Step("Check that issue is visible")
    public void issueShouldBeVisible(String name) {
        $(byText(name)).shouldBe(Condition.visible);
    }
}