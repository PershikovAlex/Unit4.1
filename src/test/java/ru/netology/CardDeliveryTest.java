package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {
    @BeforeEach
    void SetUp() {
        open("http://localhost:9999");
    }

    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void shouldTest() {
        String planningDate = generateDate(5, "dd.MM.yyyy");
        SelenideElement form = $(".form");
        $("[data-test-id=city] input").setValue("Екатеринбург");
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(planningDate);
        $("[data-test-id=name] input").setValue("Першиков Александр");
        $("[data-test-id=phone] input").setValue("+79222161614");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id='notification']").shouldBe(Condition.hidden);
        $("[data-test-id='notification'] .notification__content").shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(11));
    }
}
