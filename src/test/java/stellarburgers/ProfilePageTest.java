package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobject.AccountProfilePage;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobject.MainPage.HOME_PAGE_BURGERS;

public class ProfilePageTest {
   // генерируем случайные данные для входа
    static String name = RandomStringUtils.randomAlphabetic(10);
    static String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    static String password = RandomStringUtils.randomAlphabetic(10);

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
    @Description("Проверь переход по клику на «Личный кабинет».")
    public void checkAccountProfileTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePage accountProfile = page(AccountProfilePage.class);
        //проверить отображение на дисплее "Выход"
        assertTrue(accountProfile.isLogoutDisplayed());
    }

    @Test
    @Description("Проверь переход по клику на «Конструктор»")
    public void checkConstructorFromAccountProfileTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePage accountProfile = page(AccountProfilePage.class);
        //кликнуть на "Конструктор"
        accountProfile.clickConstructorButton();

        //проверить отображение на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void checkLogoutFromAccountProfileTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPage loginPage = page(LoginPage.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        AccountProfilePage accountProfile = page(AccountProfilePage.class);
        //кликнуть на "Выход"
        accountProfile.clickLogout();

        //проверить отображение на дисплее кнопку "Войти"
        assertTrue(loginPage.isLoginButtonDisplayed());
    }
}