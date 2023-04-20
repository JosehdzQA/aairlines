package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginAAdvantagePage;

public class LoginAAdvantageTest {
   private WebDriver driver;
   String expectedResult = "Login Succesful"; ////"put data right"
   LoginAAdvantagePage loginAAdvantagePage;

    @BeforeMethod
    public void SetUp() throws Exception{
        String urlPage = "https://www.aa.com/homePage.do?locale=es_MX";
        loginAAdvantagePage  = new LoginAAdvantagePage(driver);
        driver = loginAAdvantagePage.LaunchBrowser("chrome");
        loginAAdvantagePage.pageToOpen(urlPage);
    }

    @Test
    public void testLoginAABy(){
        loginAAdvantagePage.LoginPageBtnBy();
        String actualResult = driver.findElement(By.xpath("/html/body/div/p[3]")).getText();
        //requires work on assert succes or failed, the page required permission
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void LoginPageByLoginForm(){
        String user = "jose";
        String lastName = "hdz";
        String password = "password";
        loginAAdvantagePage.LoginPageByLoginForm(user, lastName, password);
        String actualResult = driver.findElement(By.xpath("/html/body/div/p[3]")).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }

      @AfterMethod
      public void tearDown() throws Exception {
      driver.quit();
      }

}
