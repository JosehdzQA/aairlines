package FlightStatus;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FlightStatusPage;

public class FlightStatusTests {
    private WebDriver driver;
    String expectedResult = "flight status Succesful"; ////"put data right"
    FlightStatusPage flightStatusPage;

    @BeforeTest
    public void SetUp() throws Exception{
        String urlPage = "https://www.aa.com/homePage.do?locale=es_MX";
        flightStatusPage  = new FlightStatusPage(driver);
        driver = flightStatusPage.LaunchBrowser("chrome");
        flightStatusPage.pageToOpen(urlPage);
    }

    @Test
    public void testFlightStatus() throws InterruptedException {
        flightStatusPage.flightPageSearch();
        String actualResult = driver.findElement(By.xpath("/html/body/div/p[3]")).getText();
        //verification required work for assert and the correct web element
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterTest
    public void tearDown() throws  Exception{
        driver.quit();
    }

}
