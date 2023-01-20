package com.andreev.tests;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Random;

public class TestData {
    // статичные данные
    public static String firstName = "Artem";
    public static String lastName = "Andreev";
    public static String userEmail = "artem@mail.com";
    public static String userPhoneNumber = "8919000000";
    public static String currentAddress = "Kazan, Republic of Tatarstan, Russia";
    public static File photo = new File("src/test/resources/img/cat.jpg");
    public static String state = "NCR";
    public static String city = "Delhi";

    // рандомные данные
    static Faker faker = new Faker();
    public static String
            randFirstName = faker.name().firstName(),
            randLastName = faker.name().lastName(),
            randGender = String.valueOf(enumGender.values()[new Random().nextInt(enumGender.values().length)]),
            randUserEmail = faker.internet().emailAddress(),
            randUserPhoneNumber = getPhone(),
            randDay = getDay(),
            randMonth = String.valueOf(enumMonth.values()[new Random().nextInt(enumMonth.values().length)]),
            randYear = String.valueOf(faker.random().nextInt(1900, 2100)),
            randHobbies = String.valueOf(enumHobbies.values()[new Random().nextInt(enumHobbies.values().length)]),
            randCurrentAddress = faker.address().fullAddress(),
            randState = String.valueOf(enumState.values()[new Random().nextInt(enumState.values().length)]),
            randCity = getCity();

    public static String getDay() {
        int day = faker.random().nextInt(1, 28);
        if (day < 10)
            return "0" + day;
        else
            return String.valueOf(day);
    }

    public static String getCity() {
        switch (randState) {
            case "NCR": return String.valueOf(enumCityNCR
                    .values()[new Random().nextInt(enumCityNCR.values().length)]);
            case "Uttar": return String.valueOf(enumCityUttar
                    .values()[new Random().nextInt(enumCityUttar.values().length)]);
            case "Haryana": return String.valueOf(enumCityHaryana
                    .values()[new Random().nextInt(enumCityHaryana.values().length)]);
            default: return String.valueOf(enumCityRajasthan
                    .values()[new Random().nextInt(enumCityRajasthan.values().length)]);
        }
    }

    public static String getPhone() {
        int randIntSize5 = faker.random().nextInt(10000, 99999);
        return randIntSize5 + String.valueOf(randIntSize5);
    }

    enum enumMonth {
        January, February, March, April, May, June, July, August, September, October, November, December
    }

    enum enumGender {
        Male, Female, Other
    }

    enum enumHobbies {
        Sports, Reading, Music
    }

    enum enumState {
        NCR, Uttar, Haryana, Rajasthan
    }

    enum enumCityNCR {
        Delhi, Gurgaon, Noida
    }

    enum enumCityUttar {
        Agra, Lucknow, Merrut
    }

    enum enumCityHaryana {
        Karnal, Panipat
    }

    enum enumCityRajasthan {
        Jaipur, Jaiselmer
    }
}
