package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {
    @BeforeEach
    void SetUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    void shouldTest() {
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue("Екатеринбург");
        //form.$("[data-test-id='date'] .input__control").doubleClick();
        //form.$("[data-test-id='date'] .input__control").sendKeys(Keys.DELETE);
        //form.$("[data-test-id='date'] input").setValue("04.11.2023");
        form.$("[data-test-id=name] input").setValue("Першиков Александр");
        form.$("[data-test-id=phone] input").setValue("+79222161614");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        //form.$("[data-test-id]=notification").shouldHave(Condition.exactText("Успешно!"));
    }

}
