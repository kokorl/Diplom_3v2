package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobject.MainPage.HOME_PAGE_BURGERS;

public class RegistrationTest {
    //генерируем случайные данные для входа
    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    String passwordCorrectWithSixCharacters = RandomStringUtils.randomAlphabetic(6);
    String passwordUnCorrectWithFiveCharacters = RandomStringUtils.randomAlphabetic(5);

    @Before
    public void setup() {
        //открыть браузер
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Успешная регистрация")
    public void successfulRegistrationTest() {

        //перейти на страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        //заполнить форму с именем, электронной почтой и паролем из 6 символов
        registrationPage.fillFormRegistration(name, email, passwordCorrectWithSixCharacters);

        //проверить на дисплее кнопку "Войти"
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @Description("Регистрация с некорректным паролем")
    public void unsuccessfulRegistrationWithPasswordFiveCharactersTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        //заполнить форму с именем, электронной почтой и паролем из 5 символов
        registrationPage.fillFormRegistration(name, email, passwordUnCorrectWithFiveCharacters);

        //проверить на диспле "Некорректный пароль"
        assertTrue(registrationPage.isUnCorrectPasswordDisplayed());
    }
}