package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Выполняем поиск репозитория {repo}")
    public void searchForRepository(String repo) {

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();

    }

    @Step ("Клик на таб Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();

    }
@Step ("Проверка, что существует Issue с номером {number}")
    public void shouldCheckAnIssueWithNumber(int number) {
    $(withText("#" + number)).should(Condition.visible);

    }
}
