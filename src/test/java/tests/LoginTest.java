package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterValidLoginAndPassword();
        loginPage.clickEnterButton();
    }

    @Test
    public void validLoginEmptyPasswordTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterValidLoginAndEmptyPassword();
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Чтобы войти, укажите пароль",
                "Текст сообщения об отсутствующем пароле не отображается");
    }

    @Test
    public void emptyLoginEmptyPasswordTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterEmptyLoginAndEmptyPassword();
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Чтобы войти, укажите имя пользователя",
                "Текст сообщения об отсутствующем имени пользователя не отображается");
    }

    @Test
    public void validLoginInvalidUsernameTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterValidLoginAndInvalidPassword();
        loginPage.clickEnterButton();

        assertEquals(loginPage.invalidLoginDataMessage(),
                "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать.",
                "Текст сообщения о неправильном пароле не отображается");
    }

    @Test
    public void forgotPasswordButtonTest() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.forgotPasswordButtonClick();

        assertEquals(loginPage.restorePasswordWindowText(),
                "Восстановление пароля",
                "страница восстановления пароля не открылась");
    }

    @Test
    public void enterWith1s() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.enterWith1sButtonClick();
        loginPage.logo1sIsDisplayed();

        assertTrue(loginPage.logo1sIsDisplayed(),
                "переадресация на страницу входа с 1С не осуществлена");
    }

    @Test
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
