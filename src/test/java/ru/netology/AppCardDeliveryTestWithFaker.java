package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AppCardDeliveryTestWithFaker {
    private static Faker faker;

    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

//    @Test
//    void shouldGenerateTestData() {
//        String name = faker.name().fullName();
//        String phone = faker.phoneNumber().phoneNumber();
//        String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
//        printTestData(name, phone, cardNumber);
//    }

    @Test
    void shouldGenerateTestDataUsingUtils() {
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        printTestData(info);
    }

//    private void printTestData(String name, String phone, String cardNumber) {
//        System.out.println(StringUtils.repeat("=", 30));
//        System.out.println(name + "\n" + phone + "\n" + cardNumber);
//        System.out.println(StringUtils.repeat("=", 30));
//    }

    private void printTestData(entities.RegistrationInfo registrationInfo) {
        printTestData(registrationInfo.getName(), registrationInfo.getPhone(), registrationInfo.getCardNumber());
    }

//    String validCity = "Казань";
//    String invalidCity = "Зеленодольск";
//
//    String generateDate(int days, String dateFormat) {
//        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(dateFormat));
//    }
//
//    String validDate = generateDate(3, "dd.MM.yyyy");
//    String newValidDate = generateDate(4, "dd.MM.yyyy");
//    String invalidDate = generateDate(0, "dd");
//    String validName = "Составная-Фамилия Имя";
//    String invalidName = "Something";
//    String validPhone = "+79998887766";
//    String invalidPhone = "123456";
//    int validDuration = 15;
//    String msgFieldNotFilled = "Поле обязательно для заполнения";
//    String msgInvalidCity = "Доставка в выбранный город недоступна";
//    String msgInvalidDate = "Неверно введена дата";
//    String msgInvalidName = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
//    String msgInvalidPhone = "На указанный номер моб. тел. будет отправлен смс-код для подтверждения заявки на карту. Проверьте, что номер ваш и введен корректно.";
//    String msgSuccess = "Успешно! Встреча успешно запланирована на " + validDate;
//    String msgReplanNotification = "Необходимо подтверждение У вас уже запланирована встреча на другую дату. Перепланировать?";
//    String msgSuccessNotification = "Успешно! Встреча успешно запланирована на " + newValidDate;
//
//    @BeforeEach
//    void host() {
//        open("http://localhost:9999/");
//    }
//
//    @Test
//    void positiveTestFirstEntryValidDate() { //Issue сделан, тест исправлен
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='success-notification']").shouldHave(Condition.text(msgSuccess));
//    }
//
//    @Test
//    void positiveTestEntryNewValidDate() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(newValidDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='replan-notification']").shouldHave(Condition.text(msgReplanNotification));
//        $("[data-test-id='replan-notification'] .button").click();
//        $("[data-test-id='success-notification']").shouldHave(Condition.text(msgSuccessNotification));
//    }
//
//    @Test
//    void noCity() {
//        host();
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='city'] .input__sub").shouldHave(Condition.exactText(msgFieldNotFilled));
//    }
//
//    @Test
//    void inValidCity() {
//        $("[data-test-id='city'] input").setValue(invalidCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='city'] .input__sub").shouldHave(Condition.exactText(msgInvalidCity));
//    }
//
//    @Test
//    void noDate() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='date'] .input__sub").shouldHave(Condition.exactText(msgInvalidDate));
//    }
//
//    @Test
//    void inValidDate() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(invalidDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='date'] .input__sub").shouldHave(Condition.exactText(msgInvalidDate));
//    }
//
//    @Test
//    void noName() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='name'] .input__sub").shouldHave(Condition.exactText(msgFieldNotFilled));
//    }
//
//    @Test
//    void invalidName() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(invalidName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='name'] .input__sub").shouldHave(Condition.exactText(msgInvalidName));
//    }
//
//    @Test
//    void noPhone() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='phone'] .input__sub").shouldHave(Condition.exactText(msgFieldNotFilled));
//    }
//
//    @Test
//    void invalidPhone() { //Issue сделан, тест исправлен
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(invalidPhone);
//        $("[data-test-id='agreement']").click();
//        $(".button_view_extra").click();
//        $("[data-test-id='phone'] .input__sub").shouldHave(Condition.exactText(msgInvalidPhone));
//    }
//
//    @Test
//    void noAgreement() {
//        $("[data-test-id='city'] input").setValue(validCity);
//        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
//        $("[data-test-id='date'] input").setValue(validDate);
//        $("[data-test-id='name'] input").setValue(validName);
//        $("[data-test-id='phone'] input").setValue(validPhone);
//        $(".button_view_extra").click();
//        $("[data-test-id='agreement'].input_invalid").shouldBe(visible);
//    }
}
