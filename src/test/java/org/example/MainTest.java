package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class MainTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
//    option.setPageLoadStrategy(PageLoadStrategy.EAGER);
        this.driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void check_categories_in_main_page_in() {
        driver.get("https://skillfactory.ru");

        final var mainCategoriesLinks = driver.findElements(By.className("directions__list-link"));

        assertThat(mainCategoriesLinks).hasSize(8);

        final var linkTexts = mainCategoriesLinks.stream().map(webElement -> webElement.getText().trim()).toList();
        assertThat(linkTexts).containsExactly("Программирование", "Data Science", "Аналитика данных", "Тестирование", "Высшее образование", "Дизайн", "Менеджмент", "Все курсы");
    }


    @Test
    public void check_all_courses_green_css_class() {
        driver.get("https://skillfactory.ru");

        final var mainCategoriesLinks = driver.findElements(By.className("directions__list-link"));

        assertThat(mainCategoriesLinks).hasSize(8);

        //check that categories don't have green style class
        IntStream.rangeClosed(0, mainCategoriesLinks.size() - 2)
                .forEach(index -> {
                    final var cssClass = mainCategoriesLinks.get(index).getAttribute("class");
                    assertThat(cssClass).isEqualTo("directions__list-link");
                });

        final var allCoursesClass = mainCategoriesLinks.get(mainCategoriesLinks.size() - 1).getAttribute("class");
        assertThat(allCoursesClass).isEqualTo("directions__list-link directions__list-link_green");
    }

    @Test
    public void check_programming_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(0);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/programmirovanie");
    }

    @Test
    public void check_data_science_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(1);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/data-science");
    }


    @Test
    public void check_data_analyze_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(2);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/analitika-dannyh");
    }


    @Test
    public void check_testing_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(3);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/testirovanie");
    }

    @Test
    public void check_education_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(4);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://new.skillfactory.ru/vyssheye-obrazovaniye");
    }


    @Test
    public void check_design_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(5);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/design");
    }


    @Test
    public void check_management_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(6);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses/management-i-upravlenie");
    }

    @Test
    public void check_all_courses_category_url() {
        driver.get("https://skillfactory.ru");

        final var programmingCategoryLink = driver.findElements(By.className("directions__list-link")).get(7);
        programmingCategoryLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/courses");
    }


    @Test
    public void check_programming_courses_count() {
        driver.get("https://skillfactory.ru/courses/programmirovanie");

        final var programmingCategoryLink = driver.findElements(By.className("card"));
        assertThat(programmingCategoryLink).hasSize(36);
    }

    @Test
    public void check_choose_your_PL_test_card() {
        driver.get("https://skillfactory.ru/courses/programmirovanie");

        final var type1 = driver.findElement(By.xpath("//*[@id=\"Type-1-green\"]/div[1]/div[1]/p[1]"));
        final var type2 = driver.findElement(By.xpath("//*[@id=\"Type-1-green\"]/div[1]/div[1]/p[2]"));
        final var content = driver.findElement(By.xpath("//*[@id=\"Type-1-green\"]/div[2]/h3/a"));
        final var price = driver.findElement(By.xpath("//*[@id=\"Скоро\"]/div/div[2]/div/p[2]/span"));

        assertThat(type1.getText()).isEqualTo("Тест");
        assertThat(type2.getText()).isEqualTo("Программирование");
        assertThat(content.getText()).isEqualTo("Какой язык программирования вам подходит?");
        assertThat(price.getText()).isEqualTo("БЕСПЛАТНО");
    }

    @Test
    public void check_it_from_0_card() {
        driver.get("https://skillfactory.ru/courses/programmirovanie");

        final var type = driver.findElement(By.xpath("//*[@id=\"Type-2-darkgreen\"]/div[1]/div[1]/p[2]"));
        final var oldPrice = driver.findElement(By.xpath("//*[@id=\"START\"]/div/div[2]/div/p[1]/span"));
        final var content = driver.findElement(By.xpath("//*[@id=\"START\"]/div/div[2]/p"));
        final var price = driver.findElement(By.xpath("//*[@id=\"START\"]/div/div[2]/div/p[2]/span"));

        assertThat(type.getText()).isEqualTo("Профориентация");
        assertThat(content.getText()).isEqualTo("Не знаете, с чего начать в IT? Начните с профориентации. На курсе «IT-специалист с нуля» вы попробуете 9 востребованных профессий — от тестировщика до аналитика данных. А после будете учиться тому, что подходит вам на 100%");
        assertThat(price.getText()).isEqualTo("4490");
        assertThat(oldPrice.getText()).isEqualTo("7483");
    }


    @Test
    public void check_python_testing_card() {
        driver.get("https://skillfactory.ru/courses/programmirovanie");

        final var type1 = driver.findElement(By.xpath("//*[@id=\"Type-4-green\"]/div[1]/div[1]/p[1]"));
        final var type2 = driver.findElement(By.xpath("//*[@id=\"Type-4-green\"]/div[1]/div[1]/p[2]"));

        final var oldPrice = driver.findElement(By.xpath("//*[@id=\"QAP\"]/div/div[2]/div/p[1]/span"));
        final var content = driver.findElement(By.xpath("//*[@id=\"QAP\"]/div/div[2]/p"));
        final var price = driver.findElement(By.xpath("//*[@id=\"QAP\"]/div/div[2]/div/p[2]/span"));

        assertThat(type1.getText()).isEqualTo("Профессия");
        assertThat(type2.getText()).isEqualTo("Программирование");

        assertThat(content.getText()).isEqualTo("Станьте тестировщиком-автоматизатором на Python — обеспечивайте качество ПО в крупной IT-компании, стартапе или на фрилансе");
        assertThat(price.getText()).isEqualTo("3790");
        assertThat(oldPrice.getText()).isEqualTo("6317");
    }

    @Test
    public void check_business_cards_present() {
        driver.get("https://skillfactory.ru/");

        final var businessCard = driver.findElements(By.className("business__card"));
        assertThat(businessCard).hasSize(4);
    }

    @Test
    public void check_business_cards_content_and_order() {
        driver.get("https://skillfactory.ru/");

        final var businessCard = driver.findElements(By.className("business__card"));
        assertThat(businessCard.get(0).getText()).isEqualTo("Проект\nПротестируйте новый интерфейс сайта на курсе «Тестировщик-автоматизатор»");
        assertThat(businessCard.get(1).getText()).isEqualTo("Хакатон\nИсследуйте безопасность веб-приложения на курсе «\"Белый\" хакер»");
        assertThat(businessCard.get(2).getText()).isEqualTo("Стажировка\nПротестируйте сайт перед релизом на курсе «Тестировщик-автоматизатор»");
        assertThat(businessCard.get(3).getText()).isEqualTo("Проект\nСоздайте сервис для определения надежности подрядчиков на курсе «Fullstack-разработчик»");
    }

    @Test
    public void check_business_card_volga_content() {
        driver.get("https://skillfactory.ru/");

        final var businessCardLabel = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
        final var businessCardContent = driver.findElement(By.xpath("//*[@id=\"green\"]/p"));
        final var businessCardInnerLink = driver.findElement(By.xpath("//*[@id=\"green\"]/p/a"));

        assertThat(businessCardLabel.getText()).isEqualTo("Хакатон");
        assertThat(businessCardContent.getText()).isEqualTo("Исследуйте безопасность веб-приложения на курсе «\"Белый\" хакер»");

        businessCardInnerLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/cyber-security-etichnij-haker");

    }

    @Test
    public void check_business_card_scan_content() {
        driver.get("https://skillfactory.ru/");

        final var businessCardLabel = driver.findElement(By.xpath("//*[@id=\"grey\"]/span"));
        final var businessCardContent = driver.findElement(By.xpath("/html/body/div[2]/div[9]/div/div/div/section/div/div/div/div[4]/p"));
        final var businessCardInnerLink = driver.findElement(By.xpath("/html/body/div[2]/div[9]/div/div/div/section/div/div/div/div[4]/p/a"));

        assertThat(businessCardLabel.getText()).isEqualTo("Проект");
        assertThat(businessCardContent.getText()).isEqualTo("Создайте сервис для определения надежности подрядчиков на курсе «Fullstack-разработчик»");

        businessCardInnerLink.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/python-fullstack-web-developer");
    }

    @Test
    public void check_additional_materials_link() {
        driver.get("https://skillfactory.ru/");

        final var link = driver.findElement(By.xpath("//*[@id=\"rec623700702\"]/div/div/div/section/div/a/span"));
        final var linkText = driver.findElement(By.xpath("//*[@id=\"rec623700702\"]/div/div/div/section/div/a/span"));

        assertThat(link.getText()).isEqualTo("смотреть все материалы");
        assertThat(linkText.getText()).isEqualTo("смотреть все материалы");

        link.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/free-events");
    }

    @Test
    public void check_online_intensive_qa_page() {
        driver.get("https://skillfactory.ru/");

        final var header = driver.findElement(By.xpath("//*[@id=\"red\"]/div[2]/h3"));
        final var button = driver.findElement(By.xpath("//*[@id=\"red\"]/div[2]/button"));

        assertThat(header.getText()).isEqualTo("IТестировщик ПО: инструкция по быстрому старту в IT");
        assertThat(button.getText()).isEqualTo("Участвовать");

        button.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).startsWith("https://live.skillfactory.ru/");

    }

    @Test
    public void check_offer() {
        driver.get("https://skillfactory.ru/");

        final var note = driver.findElement(By.xpath("//*[contains(text(), 'Подробности в')]"));
        final var link = driver.findElement(By.xpath("//a[@href='/refund-money']"));

        assertThat(note.getText()).isEqualTo("Подробности в оферте");
        assertThat(link.getText()).isEqualTo("оферте");

        link.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://skillfactory.ru/refund-money");

    }

    @Test
    public void check_media_link() {
        driver.get("https://skillfactory.ru/");

        final var link = driver.findElement(By.xpath("//*[@id=\"rec623700900\"]/div/div/div/section/div/a"));
        final var linkText = driver.findElement(By.xpath("//*[@id=\"rec623700900\"]/div/div/div/section/div/a/span"));

        assertThat(link.getText()).contains("перейти в Медиа");
        assertThat(linkText.getText()).contains("перейти в Медиа");

        link.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).startsWith("https://blog.skillfactory.ru/");
    }


    @ParameterizedTest
    @MethodSource("generator")
    void testCalculateMandateI(TestParameterDto value) {
        driver.get("https://skillfactory.ru/");
        final var tab = driver.findElement(By.xpath(value.getElementXpath()));

        assertThat(tab.getText()).isEqualTo(value.getExpectedTitle());

        tab.click();

        final var tabs = new ArrayList<>(driver.getWindowHandles());
        assertThat(tabs).hasSize(2);

        final var openedNewTab = driver.switchTo().window(tabs.get(tabs.size() - 1));

        final var currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).startsWith(value.getExpectedUrl());

        System.out.println(value);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new TestParameterDto("//a[@href='/free-events']", "БЕСПЛАТНО", "https://skillfactory.ru/free-events")),
                Arguments.of(new TestParameterDto("//a[@href='/career-center']", "ЦЕНТР КАРЬЕРЫ", "https://skillfactory.ru/career-center")),
                Arguments.of(new TestParameterDto("//a[@href='/contacts']","КОНТАКТЫ","https://skillfactory.ru/contacts")));
    }
}



