package Base;

import Elements.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
    private Logger LOGGER = Logger.getLogger(BasePage.class);

    protected WebElement waitForElement(Element info) {
        isElementVisible(info,10);
        isElementClickable(info,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(info.getBy()));
    }


    protected void waitForElementAndClick(Element elementInfo) {
        waitForElement(elementInfo).click();
    }

    protected void waitForElementAndSendKeys(Element elementInfo, String text) {
        waitForElement(elementInfo).sendKeys(text);
    }

    protected void waitSeconds(int seconds) {
        try {
            LOGGER.info(seconds + " saniye boyunca bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }
    protected void waitVisibilityOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(by));
        }catch (Exception e ){
        }
    }
    protected void waitClickableOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .elementToBeClickable(by));
        }catch (Exception e ){
        }
    }
    public boolean isElementClickable(Element elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitClickableOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean isElementVisible(Element elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitVisibilityOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
