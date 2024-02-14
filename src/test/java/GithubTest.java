import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


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
        open("/");
        $("[placeholder = 'Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("[data-testid = 'results-list']").shouldHave(text("selenide/selenide"));
        $("[data-testid = 'results-list']").$("a[href='/selenide/selenide']").click();

        // - Перейдите в раздел Wiki проекта
        $(byId("wiki-tab")).click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byId("wiki-body")).shouldHave(text("Soft assertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byId("wiki-content")).$("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(byId("wiki-content")).shouldHave(text("3. Using JUnit5 extend test class:"));


    }


}