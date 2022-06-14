package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage { //PageObject для страницы восстановления пароля

    //текст "Войти"
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement login;

    //клик по "Войти"
    @Step("Кликнули по тексту \"Войти\"")
    public void clickLogin() {
        login.click();
    }
}