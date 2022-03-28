package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseLambdaTest {

        private static final String REPOSITORY = "schwester34/tests6";
        private static final int ISSUE_NUMBER = 1;
        @Test
        public void testLambdaSteps() {

            step("Open home page", () -> {
                open("https://github.com");
            });
            step("Search for a repository" + REPOSITORY,() -> {
                $(".header-search-input").click();
                $(".header-search-input").sendKeys("schwester34/tests6");
                $(".header-search-input").submit();
            } );

            step("Open the repository" + REPOSITORY, ()->{
                $(By.linkText("schwester34/tests6")).click();
            });
            step("Go to tab Issue", () -> {
                $(By.partialLinkText("Issues")).click();

            });
            step("Checking for tabs Issue" + ISSUE_NUMBER, () ->{
                $(withText("#1")).should(Condition.exist);
            });

        }

    @Test
    void webSteps() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
