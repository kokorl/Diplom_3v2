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
import stellarburgers.pageobject.ResetPasswordPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobject.MainPage.HOME_PAGE_BURGERS;

public class LoginPageTest {
    // генерируем случайные данные для логина
    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup() {

        //открыть браузер
        Configuration.startMaximized = true;

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        //заполнить форму с именем, электронной почтой и паролем
        registrationPage.fillFormRegistration(name, email, password);
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Вход по кнопке Войти в аккаунт на главной")
    public void checkLoginButtonMainPageForLoginTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить отображение на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через кнопку Личный кабинет")
    public void checkPersonalAccountButtonMainPageForLoginTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить отображение на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через кнопку в форме регистрации")
    public void checkLoginButtonRegistrationPageForLoginTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        //кликнуть на "Войти"
        registrationPage.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить отображение на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля")
    public void checkLoginButtonForgotPasswordPageForLoginTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        //кликнуть на "Восстановить пароль"
        loginPage.clickRecoverPassword();

        ResetPasswordPage forgotPassword = page(ResetPasswordPage.class);
        //кликнуть на "Войти"
        forgotPassword.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить отображение на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }
}