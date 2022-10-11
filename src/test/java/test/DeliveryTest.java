package test;

import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);


        $("[data-test-id='city'] input").setValue(validUser.getCity());
        $("[data-test-id='date'] .input__control").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("[data-test-id='date'] .input__control").setValue(firstMeetingDate);
        $("[data-test-id='name'] input").setValue(validUser.getName());
        $("[data-test-id='phone'] input").setValue(validUser.getPhone());
        $("[data-test-id='agreement']").click();
        $("button.button").click();

        $("[data-test-id='success-notification']")
                .shouldHave(text("Успешно! " + "Встреча успешно запланирована на " + firstMeetingDate), Duration.ofSeconds(15)).shouldBe(visible);

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("[data-test-id='date'] input").setValue(secondMeetingDate);
        $("button.button").click();
        System.out.println(daysToAddForFirstMeeting);
        $("[data-test-id='replan-notification']")
                .shouldHave(text("Необходимо подтверждение " + "У вас уже запланирована встреча на другую дату. Перепланировать? " + "Перепланировать "), Duration.ofSeconds(15))
                .shouldBe(visible);
        $("[data-test-id='replan-notification'] [type='button']").click();
        $("[data-test-id='success-notification']")
                .shouldHave(text("Успешно! " + "Встреча успешно запланирована на " + secondMeetingDate), Duration.ofSeconds(15)).shouldBe(visible);
    }
}