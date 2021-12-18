package Pages;

import Base.BasePage;
import Base.BaseTest;
import Elements.SearchElementValues;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage implements SearchElementValues {

    String searchStr = "bilgisayar";
    static String firstPrice;

    public Logger LOGGER = LogManager.getLogger(SearchPage.class);
    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 10, 1000);

    public void search() {
        driver.get("https://www.n11.com/");
        waitForElementAndSendKeys(searchBox, searchStr);
        waitSeconds(3);
        LOGGER.info("Arama alanına bılgısayar yazıldı.");
        waitForElementAndClick(searchBtn);

        driver.findElement(secondPage.getBy()).sendKeys(Keys.DOWN);
        waitForElementAndClick(secondPage);
        Assert.assertTrue("2.sayfada olduğunuz doğrulanamadı.", isElementVisible(secondPage, 10));
        LOGGER.info("2.sayfaya geçıldı");
        randomProduct();
        driver.findElement(addToBasket.getBy()).click();
        goToBasketAndControlPrice();
        waitSeconds(2);
        driver.findElement(By.xpath("//*[@class=\"btn btnBlack\"]")).click();
        waitForElementAndClick(quantity);
        LOGGER.info("Ürün arttırma gerçekleştırıldı.");
        waitForElementAndClick(clearBasket);
        LOGGER.info("Sepettekı ürün temızlendı.");
        waitSeconds(3);

        Assert.assertTrue("Ürün sepeti boş değil.", isElementVisible(cleanBasketCheck, 5));
        LOGGER.info("Sepetın boş olduğu doğrulandı.");

    }

    public void goToBasketAndControlPrice() {

        waitForElementAndClick(goToBasket);
        waitSeconds(2);
        String secondPriceTxt = driver.findElement(basketPrice.getBy()).getText();
        LOGGER.info("Sepettekı ürün fıyatı alındı.");
        System.out.println("İkinci Fiyat :" + secondPriceTxt);
        Assert.assertEquals("", firstPrice, secondPriceTxt);
        LOGGER.info("Ürün ve sepettekı fıyat eşıt olduğu doğrulandı");
    }

    public void randomProduct() {


        Random random = new Random();

        List<WebElement> productLst = driver.findElements(productList.getBy());
        int randomProduct = random.nextInt(productLst.size());
        productLst.get(randomProduct).click();

        LOGGER.info("Rastgele bır ürün seçıldı.");
        waitSeconds(3);
        firstPrice = driver.findElement(price.getBy()).getText();
        LOGGER.info("Ürün sayfasından fıyat alındı");
        System.out.println("İlk fiyat :" + firstPrice);

    }
}
