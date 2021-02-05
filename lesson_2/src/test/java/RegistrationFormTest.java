import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {
    private final String REGISTRATION_URL = "https://demoqa.com/automation-practice-form";
    String firstName = "Tom",
            lastName = "Sawyer",
            email = "tsawyer@email.ru",
            gender = "Other",
            mobile = "8987654322",
            birthYear = "1981",
            birthMonth = "May",
            birthDay = "11",
            fullDate = birthDay.concat(" " + birthMonth).concat("," + birthYear),
            subject = "Hindi",
            subjectTwo = "English",
            subjectTwoShort = "Eng",
            hobbies = "Reading",
            hobbiesTwo = "Music",
            uploadPath = "uploadFiles/bear.jpg",
            fileName = "bear.jpg",
            address = "Russia, 190000, St Petersburg, Dvortsovaya Naberezhnaya (Embankment), 34",
            state = "Haryana",
            city = "Panipat";


    @Test
    public void fieldsTest() {
        open(REGISTRATION_URL);

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText("Other")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month").find(byText(birthDay)).click();
        $("#subjectsContainer #subjectsInput").setValue(subject).pressEnter();
        $("#subjectsContainer #subjectsInput").setValue(subjectTwoShort).pressEnter();
        $("#hobbiesWrapper").find(byText(hobbies)).click();
        $("#hobbiesWrapper").find(byText(hobbiesTwo)).click();
        $("#uploadPicture").uploadFromClasspath(uploadPath);
        $("#currentAddress").setValue(address).pressTab();
        $("#state").click();
        $("#state").find(byText(state)).click();
        $("#city").click();
        $("#city").find(byText(city)).click();
        $("#submit").click();
        $(".modal-content").shouldHave(text(firstName),
                text(email),
                text(gender),
                text(mobile),
                text(fullDate),
                text(subject),
                text(subjectTwo),
                text(hobbies),
                text(hobbiesTwo),
                text(fileName),
                text(address),
                text(state),
                text(city));
    }
}