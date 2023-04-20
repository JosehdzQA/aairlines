package CheckIn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckInPage;

public class CheckinTests {
        private WebDriver driver;
        String expectedResult = "checkin.. "; ////"put data right"
        CheckInPage checkInPage;

        @BeforeTest
        public void SetUp() throws Exception{
            String urlPage = "https://www.aa.com/homePage.do?locale=es_MX";
            checkInPage  = new CheckInPage(driver);
            driver = checkInPage.LaunchBrowser("chrome");
            checkInPage.pageToOpen(urlPage);
        }

        @Test
        public void testSearchBook(){
            checkInPage.checkinPageSearch();
            String actualResult = driver.findElement(By.xpath("/html/body/div/p[3]")).getText();
            //requires work on assert succes or failed.
            Assert.assertEquals(actualResult,expectedResult);
                
        }

        @AfterTest
        public void tearDown() throws  Exception{
            // quit
        driver.quit();
        }
}
