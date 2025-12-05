package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @DataProvider(name = "for tests data")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"admin@axudygu", "", "Чтобы войти, укажите пароль"},
                {"", "", "Чтобы войти, укажите имя пользователя"},
                {"admin@axudygu", "Qwerty666666", "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать"},
        };
    }

    @Test(dataProvider = "for tests data")
    public  void errorMessages(String login, String password, String errorMessage){
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                errorMessage,
                "Текст сообщения об ошибке не соответствует ожидаемому");
    }

    @Test(retryAnalyzer = Retry.class, description = "Проверка авторизации валидными данными")
    public void successLoginTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterLogin("admin@axudygu");
        loginPage.enterPassword("Qwerty12345");
        loginPage.clickEnterButton();

        assertTrue(homepage.isPageOpen());
    }

    @Test(description = "Проверка авторизации без пароля")
    public void validLoginEmptyPasswordTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterLogin("admin@axudygu");
        loginPage.enterPassword("");
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Чтобы войти, укажите пароль",
                "Текст сообщения об отсутствующем пароле не отображается");
    }

    @Test(description = "Проверка авторизации без логина и пароля")
    public void emptyLoginEmptyPasswordTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterLogin("");
        loginPage.enterPassword("");
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Чтобы войти, укажите имя пользователя",
                "Текст сообщения об отсутствующем имени пользователя не отображается");
    }

    @Test(description = "Проверка авторизации с неверным паролем")
    public void validLoginInvalidPasswordTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterLogin("admin@axudygu");
        loginPage.enterPassword("Qwerty666666666");
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст сообщения о неправильном пароле не отображается");
    }

    @Test(description = "Проверка кнопки 'Забыл пароль'")
    public void forgotPasswordButtonTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.forgotPasswordButtonClick();

        assertEquals(loginPage.restorePasswordWindowText(),
                "Восстановление пароля",
                "страница восстановления пароля не открылась");
    }

    @Test(description = "Проверка кнопки 'Войти с 1С'")
    public void enterWith1s() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterWith1sButtonClick();
        loginPage.logo1sIsDisplayed();

        assertTrue(loginPage.logo1sIsDisplayed(),
                "переадресация на страницу входа с 1С не осуществлена");
    }

    @Test(description = "Проверка переключения на английскую версию")
    public void switchToEnglishVersion() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.clickToEnglishSwitcher();
        loginPage.textInEnglishVersion();

        assertEquals(loginPage.textInEnglishVersion(),
                "Log in to MoySklad",
                "английская версия сайта не отображается");
    }
}
