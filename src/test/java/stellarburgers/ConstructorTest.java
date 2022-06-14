package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobject.MainPage.HOME_PAGE_BURGERS;

public class ConstructorTest {

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
    @Description("Проверь, что работает переход к разделу Начинки")
    public void checkClickFillingTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //Проверить отображение на дисплее после перехода в раздел "Начинки"
        assertTrue("Не в разделе 'Начинки'", mainPage.isHeaderFillingVisible());
    }

    @Test
    @Description("Должен работать переход к разделу Булки")
    public void checkClickBunsTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //проверить отображение на дисплее заголовок "Булки"
        assertTrue(mainPage.isHeaderBunsVisible());
    }

    @Test
    @Description("Должен работать переход к разделу Соусы")
    public void checkClickSaucesTest() {

        //перейти на главную страницу бургеров
        MainPage mainPage = open(HOME_PAGE_BURGERS, MainPage.class);

        //кликнуть на раздел "Соусы"
        mainPage.clickSauces();

        //проверить отображение на дисплее после перехода в раздел "Начинки"
        assertTrue("Не в разделе 'Соусы'", mainPage.isHeaderSaucesVisible());
    }
}