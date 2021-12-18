package Pages;

import Base.BasePage;
import Elements.LoginElementValues;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class LoginPage extends BasePage implements LoginElementValues {

    private Logger LOGGER = LogManager.getLogger(LoginPage.class);
    String email="Alpselahaddin.ergun@gmail.com";
    String pass="160573Ha";

    public void goToLoginPage (){
        waitSeconds(1);
        String actualTitle;
        actualTitle = driver.getTitle();
        Assert.assertTrue("Login sayfasında değilsiniz", actualTitle.equals("Giriş Yap - n11.com"));
        LOGGER.info("Login sayfasi basariyla acildi.");
    }

    public void login(){
        waitForElementAndClick(login);
        goToLoginPage();
        waitForElementAndSendKeys(emailTxt,email);
        waitForElementAndSendKeys(passwordText,pass);
        waitForElementAndClick(loginBtn);
        Assert.assertTrue("Hesabın elementi görünmüyor. Login işlemi başarısız.",isElementVisible(loginCheck,10));
        LOGGER.info("Başarılı şekılde giriş yapıldı.");
    }

}
