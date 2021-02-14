import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AnnotatedIssueTest {
    private final String URL = "https://github.com/";
    private String repoName = "erofeev-artem/qa_guru";
    private String issueName = "add allure to tests";
    private Steps steps = new Steps();

    @Test
    @Tag("Step_annotation")
    public void checkIssue1Test() {
        steps.openPage(URL);
        steps.searchRepo(repoName);
        steps.selectRepo(repoName);
        steps.selectIssueTab();
        steps.issueShouldBeVisible(issueName);
    }
}