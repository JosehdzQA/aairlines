package Bookings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookPage;

public class BookingsTests {

    private WebDriver driver;
    String expectedResult = "Search Booking Succesful"; ////"put data right"
    BookPage bookPage;

    @BeforeTest
    public void SetUp() throws Exception{
        String urlPage = "https://www.aa.com/homePage.do?locale=es_MX";
        bookPage = new BookPage(driver);
        driver = bookPage.LaunchBrowser("chrome");
        bookPage.pageToOpen(urlPage);
    }

    @Test
    public void testSearchBook(){
        bookPage.SearchBooking();
        String actualResult = driver.findElement(By.xpath("/html/body/div/p[3]")).getText();
        //requires work on assert succes or failed, the page required permission
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterTest
    public void tearDown() throws  Exception{
        // quit
//        driver.quit();
    }


}
