package Elements;

import org.openqa.selenium.By;

public interface LoginElementValues {

    public Element login = new Element(By.xpath("//*[@class='btnSignIn']"));
    public Element emailTxt = new Element(By.xpath("//*[@id='email']"));
    public Element passwordText = new Element(By.xpath("//*[@id='password']"));
    public Element loginBtn = new Element(By.xpath("//*[@id='loginButton']"));
    public Element loginCheck = new Element(By.xpath("//*[@class='myAccount']"));

}
