import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationFormTest {
    private final String REGISTRATION_URL = "https://demoqa.com/automation-practice-form";
    private final List<String> SUBJECTS = new ArrayList<>();

    @Test
    public void fieldsTest() {
        open(REGISTRATION_URL);
        fillFileds();
        $(RegistrationPage.SUBMIT_BUTTON).click();
        assertAll(
                () -> assertEquals(TestValues.FIRST_NAME.value, $(RegistrationPage.FIRST_NAME_FIELD).getValue()),
                () -> assertEquals(TestValues.LAST_NAME.value, $(RegistrationPage.LAST_NAME_FIELD).getValue()),
                () -> assertEquals(TestValues.EMAIL.value, $(RegistrationPage.EMAIL_FIELD).getValue()),
                () -> assertTrue($(By.xpath(format(RegistrationPage.GENDER_RADIO_INPUT, TestValues.GENDER.value))).isSelected()),
                () -> assertEquals(TestValues.MOBILE.value, $(RegistrationPage.MOBILE_NUMBER).getValue()),
                () -> assertEquals(TestValues.BIRTH_DAY.value.concat(" ").concat(TestValues.BIRTH_MONTH.value)
                        .concat(" ").concat(TestValues.BIRTH_YEAR.value), $(RegistrationPage.BIRTH_FIELD).getValue()),
                () -> assertEquals(TestValues.SUBJECT_1.value,
                        $(By.xpath(format(RegistrationPage.SUBJECT_FIELD_BY_NUMBER, "1"))).getText()),
                () -> assertEquals(TestValues.SUBJECT_2.value,
                        $(By.xpath(format(RegistrationPage.SUBJECT_FIELD_BY_NUMBER, "2"))).getText()),
                () -> assertTrue($(By.xpath(format(RegistrationPage.HOBBIES_CHECKBOX_INPUT, TestValues.HOBBIES_1.value))).isSelected()),
                () -> assertTrue($(By.xpath(format(RegistrationPage.HOBBIES_CHECKBOX_INPUT, TestValues.HOBBIES_2.value))).isSelected()),
                () -> assertEquals(TestValues.UPLOAD_FILE_PATH.value.split("/")[1],
                        $(RegistrationPage.UPLOAD_BUTTON).getValue().split("\\\\")[2]),
                () -> assertEquals(TestValues.ADDRESS.value, $(RegistrationPage.CURRENT_ADDRESS_AREA).getValue()),
                () -> assertEquals(TestValues.STATE.value, $(RegistrationPage.STATE).getText()),
                () -> assertEquals(TestValues.CITY.value, $(RegistrationPage.CITY).getText()));

    }

    private void fillFileds() {
        $(RegistrationPage.HEADER).shouldBe(Condition.visible);
        $(RegistrationPage.FIRST_NAME_FIELD).setValue(TestValues.FIRST_NAME.value);
        $(RegistrationPage.LAST_NAME_FIELD).setValue(TestValues.LAST_NAME.value);
        $(RegistrationPage.EMAIL_FIELD).setValue(TestValues.EMAIL.value);
        $(By.xpath(format(RegistrationPage.GENDER_RADIO_BUTTON, TestValues.GENDER.value))).click();
        $(RegistrationPage.MOBILE_NUMBER).setValue(TestValues.MOBILE.value);
        setDateOfBirth(TestValues.BIRTH_YEAR.value, TestValues.BIRTH_MONTH.value, TestValues.BIRTH_DAY.value);
        SUBJECTS.add(TestValues.SUBJECT_1.value);
        SUBJECTS.add(TestValues.SUBJECT_2.value);
        setSubjects(SUBJECTS);
        $(By.xpath(format(RegistrationPage.HOBBIES_CHECKBOX, TestValues.HOBBIES_1.value))).click();
        $(By.xpath(format(RegistrationPage.HOBBIES_CHECKBOX, TestValues.HOBBIES_2.value))).click();
        uploadFile(TestValues.UPLOAD_FILE_PATH.value);
        $(RegistrationPage.CURRENT_ADDRESS_AREA).setValue(TestValues.ADDRESS.value);
        $(RegistrationPage.STATE_DROPDOWN_LIST).setValue(TestValues.STATE.value).pressEnter();
        $(RegistrationPage.CITY_DROPDOWN_LIST).setValue(TestValues.CITY.value).pressEnter();
    }

    private void setDateOfBirth(String year, String month, String day) {
        $(RegistrationPage.BIRTH_FIELD).click();
        $(RegistrationPage.CALENDAR_MONTH_LIST).click();
        $(RegistrationPage.CALENDAR_MONTH_LIST).selectOption(month);
        $(RegistrationPage.CALENDAR_YEAR_LIST).selectOption(year);
        $(By.xpath(format(RegistrationPage.CALENDAR_DAYS_CONTAINER, day))).click();
    }

    private void setSubjects(List<String> SUBJECTS) {
        for (String subject : SUBJECTS) {
            $(RegistrationPage.SUBJECT_FIELD_INPUT).setValue(subject).pressEnter();
        }
    }

    private void uploadFile(String uploadFilePath) {
        $(RegistrationPage.UPLOAD_BUTTON).uploadFromClasspath(uploadFilePath);
    }

    private enum TestValues {

        FIRST_NAME("Tom"),
        LAST_NAME("Sawyer"),
        EMAIL("tsawyer@email"),
        GENDER("Other"),
        MOBILE("8987654322"),
        BIRTH_YEAR("1981"),
        BIRTH_MONTH("May"),
        BIRTH_DAY("11"),
        SUBJECT_1("Hindi"),
        SUBJECT_2("English"),
        HOBBIES_1("Reading"),
        HOBBIES_2("Music"),
        UPLOAD_FILE_PATH("uploadFiles/bear.jpg"),
        ADDRESS("Russia, 190000, St Petersburg, Dvortsovaya Naberezhnaya (Embankment), 34"),
        STATE("Haryana"),
        CITY("Panipat");

        public String value;

        TestValues(String value) {
            this.value = value;
        }
    }
}