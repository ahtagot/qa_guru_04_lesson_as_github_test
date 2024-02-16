import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1280x720";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void checkJunit5CodeExample() {

        //- Откройте страницу Selenide в Github
        open("/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $(byId("wiki-tab")).click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byId("wiki-pages-box")).$(byText("Show 3 more pages…")).click();
        $(byId("wiki-pages-box")).shouldHave(text("SoftAssertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byId("wiki-pages-box")).$(byText("SoftAssertions")).click();
        $(byId("wiki-content")).shouldHave(text("3. Using JUnit5 extend test class:"));

    }


}

