package CheckIn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckInPage;

public class CheckinTests {
        private WebDriver driver;

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
            //requires work on assert succes or failed, the page required permission
        }

        @AfterTest
        public void tearDown() throws  Exception{
            // quit
        driver.quit();
        }
}
