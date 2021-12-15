package Elements;

import org.openqa.selenium.By;

public interface SearchElementValues {

    public Element searchBox = new Element(By.xpath("//*[@id='searchData']"));
    public Element searchBtn = new Element(By.xpath("//*[@class='searchBtn']"));
    public Element currentPage = new Element(By.xpath("//*[@id='currentPage']"));
    public Element secondPage = new Element(By.xpath("//*[@class='pagination']/a[2]"));
    public Element productList = new Element(By.xpath("//*[@class='clearfix']/li[@class='column ']//div[@class='pro']/a"));
    public Element addToBasket = new Element(By.xpath("//*[@class='product-add-cart']"));
    public Element price = new Element(By.xpath("//*[@class='newPrice']/ins"));
    public Element goToBasket = new Element(By.xpath("//*[@class='btn btnBlack btnGoBasket']"));
    public Element quantity = new Element(By.xpath("//*[@class='spinnerUp spinnerArrow']"));
    public Element basketPrice = new Element(By.xpath("//*[@class='newPrice']/ins"));
    public Element clearBasket = new Element(By.xpath("//*[@class=\"removeProd svgIcon svgIcon_trash\"]"));
    public Element cleanBasketCheck = new Element(By.xpath("//*[@class='cartEmptyText']"));


}
