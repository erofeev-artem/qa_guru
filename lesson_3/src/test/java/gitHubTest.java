import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class gitHubTest {

    @Test
    public void softAssertionTest() {
        open("https://github.com/");
        $(".HeaderMenu").shouldBe(Condition.visible);
        $("[name=q]").setValue("Selenide").pressEnter();
        $$(".repo-list a").find(Condition.text("selenide/selenide")).click();
        $("span[data-content='Wiki']").click();
        $$("#wiki-pages-box li a").shouldHave(CollectionCondition.itemWithText("SoftAssertions"));
        $x("//li//*[text()='SoftAssertions']").click();
        $$("#wiki-content ol li").shouldHave(CollectionCondition.itemWithText("Using JUnit5 extend test class:"));
    }
}