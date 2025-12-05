package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest{

    @Test
    void settingsTest() throws InterruptedException {
        loginPage.open();
        loginPage.enterLogin("admin@axudygu");
        loginPage.enterPassword("Qwerty12345");
        loginPage.clickEnterButton();
        accountPage.open();

        Account account = AccountFactory.get();
        accountPage.createSettings(account);

        assertTrue(accountPage.isSettingsSaved());
    }
}
