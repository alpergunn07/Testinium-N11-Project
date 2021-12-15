package Base;

import Elements.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
    protected Actions action = new Actions(driver);
    private Logger LOGGER = Logger.getLogger(BasePage.class);

    protected WebElement getElement(Element elementInfo) {
        return driver.findElement(elementInfo.getBy());
    }

    protected WebElement waitForElement(Element info) {
        isElementVisible(info,10);
        isElementClickable(info,10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(info.getBy()));
    }


    protected void waitForElementAndClick(Element elementInfo) {
        waitForElement(elementInfo).click();
    }
    protected void waitForElementAndClickWithAction(Element elementInfo) {
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(elementInfo)).click().build().perform();

    }

    protected void waitForElementAndSendKeys(Element elementInfo, String text) {
        waitForElement(elementInfo).sendKeys(text);
    }

    protected String waitForElementAndGetText(Element elementInfo) {
        return waitForElement(elementInfo).getText();
    }

    protected String waitForElementAndGetAttribute(Element elementInfo, String attribute) {
        return waitForElement(elementInfo).getAttribute(attribute);
    }

    protected List<WebElement> waitForElements(Element elementInfo) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementInfo.getBy()));
    }

    protected void waitForElementsAndClickWithIndex(Element elementInfo, int index) {
        waitForElements(elementInfo).get(index).click();

    }

    protected void waitSeconds(int seconds) {
        try {
            LOGGER.info(seconds + " saniye boyunca bekleniyor.");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //  LOGGER.info(e);
        }
    }
    protected void waitVisibilityOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(by));
        }catch (Exception e ){
            //this.LOGGER.error( by + "---> Element görünüm hatası. " + e.getStackTrace().toString());
        }
    }
    protected void waitClickableOfElementLocatedBy(By by) {
        try {
            wait.until(ExpectedConditions
                    .elementToBeClickable(by));
        }catch (Exception e ){
            //this.LOGGER.error( by + "---> Element tıklanamıyor hatası. " + e.getStackTrace().toString());
        }
    }
    public boolean isElementClickable(Element elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitClickableOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            // LOGGER.info(key +" görünmüyor.");
            return false;
        }
    }
    public boolean isElementVisible(Element elementInfo, int timeout){

        try{
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            waitVisibilityOfElementLocatedBy(elementInfo.getBy());
            return true;
        }catch (Exception e){
            // LOGGER.info(key +" görünmüyor.");
            return false;
        }
    }

    public void javaScriptClicker(Element elementInfo){
        isElementClickable(elementInfo,10);
        isElementVisible(elementInfo,10);
        WebElement element = driver.findElement(elementInfo.getBy());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
