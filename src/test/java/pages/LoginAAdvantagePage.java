package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;


public class LoginAAdvantagePage extends Base {

    ////  objects repository
    private WebDriver driver;
    private By linkBtnLogin = By.xpath("//*[@id='log-in-button']");
    private By usernameBy_Loc = By.name("loginId");
    private By lastnameBy_Loc = By.name("lastName");
    private By passBy_Loc = By.name("password");
    private By btnLogin_Loc = By.name("_button_login");
    private By btnLoginFrm_Loc = By.name("_button_go");
    private By txtMsgError_Loc = By.xpath("/html/body/div/p[1]");

    //credentials
    String expectedURL = "https://www.aa.com/homePage.do?locale=es_MX/users/signin"; ///put correct url
    String currentURL = ""; ///get from execution the value
    String entry_userNameLogin = "jose";

    String entry_userLastNameLogin = "hdz";
    String entry_passwordLogin = "password";
           
    public LoginAAdvantagePage(WebDriver driver) {
        super(driver);
    }

        public void LoginPageBtnBy(){
            System.out.println("fill click by...");
            click(linkBtnLogin);
            type(usernameBy_Loc,entry_userNameLogin);
            type(lastnameBy_Loc,entry_userLastNameLogin);
            type(passBy_Loc,entry_passwordLogin);
            click(btnLogin_Loc);
        }

        ///requires work
        public void LoginPageByLoginForm(String user, String lastName, String Pass){
            // login by form page default on Mexico country
            System.out.println("form login...");
            type(usernameBy_Loc,entry_userNameLogin);
            type(lastnameBy_Loc,entry_userLastNameLogin);
            type(passBy_Loc,entry_passwordLogin);
            click(btnLoginFrm_Loc);
        }

    public Boolean LoginAAdvantagePage(){
        currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,currentURL);
        return true;
    }
}
