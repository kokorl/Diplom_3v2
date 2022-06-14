package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class LoginPage { //PageObject для страницы логина

    //поле "Email"
    @FindBy(how = How.XPATH,using = ".//input[@type='text']")
    private SelenideElement emailField;
    //поле "Пароль"
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordField;
    //кнопка "Войти"
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement loginButtonField;
    //текст "Зарегистрироваться"
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement register;
    //текст "Восстановить пароль"
    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement recoverPassword;

    //заполнение поля "Email"
    public void setEmailField(String email) {
        emailField.shouldBe(exist);
        emailField.setValue(email);
    }
    //заполнение "Пароль"
    public void setPasswordField(String password) {
        passwordField.shouldBe(exist);
        passwordField.setValue(password);
    }
    //клик по кнопке "Войти"
    public void clickLoginButton() {
        loginButtonField.shouldBe(exist);
        loginButtonField.click();
    }
    //найти кнопку "Войти"
    public boolean isLoginButtonDisplayed() {
        loginButtonField.shouldBe(exist);
        return loginButtonField.isDisplayed();
    }
    // заполнение поля "Имейл", "Пароль", метод клика по кнопке "Войти"
    public void fillFormLogin(String email,String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
    }
    //клик по тексту "Зарегистрироваться"
    public void clickRegister() {
        loginButtonField.shouldBe(exist);
        register.shouldBe(exist);
        register.click();
    }
    //клик по тексту "Восстановить пароль"
    public void clickRecoverPassword() {
        recoverPassword.shouldBe(exist);
        recoverPassword.click();
    }
}