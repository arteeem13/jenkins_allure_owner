package com.andreev.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {

    static SelenideElement
            pageTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    private static final String PAGE_TITLE = "Student Registration Form";

    public static void openPage() {
        open( "/automation-practice-form");
        pageTitle.shouldHave(text(PAGE_TITLE));
    }

    public static void setFirstName(String value){
        firstNameInput.setValue(value);
    }

    public static void setLastName(String value){
        lastNameInput.setValue(value);
    }

    public static void setEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
    }

    public static void setGender(String gender){
        $(byText(gender)).click();
    }

    public static void setMobile(String userPhoneNumber){
        $("#userNumber").setValue(userPhoneNumber);
    }

    public static void setSubjects(String subjects){
        $("#subjectsInput").setValue(subjects).pressTab();
    }

    public static void setCurrentAddress(String currentAddress){
        $("#currentAddress").setValue(currentAddress);
    }

    public static void setHobbies(String hobbies){
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public static void setPhoto(File photo){
        $("#uploadPicture").uploadFile(photo);
    }

    public static void setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }

    public static void setStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
    }

    public static void submitStudentRegistrationForm(){
        $("#submit").scrollTo();
        $("#submit").click();
    }

    public static void checkValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
