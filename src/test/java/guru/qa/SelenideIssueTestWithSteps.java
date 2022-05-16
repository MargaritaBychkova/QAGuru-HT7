package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideIssueTestWithSteps {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 76;

    @Test
    public void testGithubIssue(){

       SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Выполняем поиск репозитория" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step ("Переход по ссылке репозитория" + REPOSITORY, () -> {
                    $(linkText("eroshenkoam/allure-example")).click();
        });

        step ("Клик на таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверка, что существует Issue с номером" + ISSUE_NUMBER, () -> {
            $(withText("#76")).click();
        });







    }
}
