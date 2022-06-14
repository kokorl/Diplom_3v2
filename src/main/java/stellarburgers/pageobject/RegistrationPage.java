package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationPage { //PageObject для страницы регистрации

    //поле "Имя"
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameField;
    //поле "Email"
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailField;
    //поле "Пароль"
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    //текст "Войти"
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement login;
    //текст "Некорректный пароль"
    @FindBy(how = How.XPATH,using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement unCorrectPassword;

    //заполнить поля "Имя"
    public void setNameField(String name) {
        nameField.setValue(name);
    }
    //заполнить поля "Email"
    public void setEmailField(String email) {
        emailField.setValue(email);
    }
    //заполнить поля "Пароль"
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }
    //клик по кнопке "Зарегистрироваться"
    @Step("Кликнули по кнопке \"Зарегистрироваться\"")
    public void clickRegisterButton() {
        registerButton.click();
    }
    //заполнение поля "Имя", заполнение поля "Email",
    // заполнение поля "Пароль", клик по кнопке "Зарегистрироваться"
    public void fillFormRegistration(String name, String email,String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegisterButton();
    }
    //клик по тексту "Войти"
    @Step("Кликнули по тексту \"Войти\"")
    public void clickLogin() {
        login.click();
    }
    //найти текста "Некорректный пароль"
    public boolean isUnCorrectPasswordDisplayed() {
        unCorrectPassword.shouldBe(visible);
        return unCorrectPassword.isDisplayed();
    }
}