import Base.BaseTest;
import Pages.LoginPage;
import Pages.SearchPage;
import org.junit.Test;

public class N11_Test extends BaseTest {

    LoginPage login;
    SearchPage search;

    @Test
    public void n11Test(){

        login = new LoginPage();
        search = new SearchPage();

        login.login();
        search.search();


    }
}
