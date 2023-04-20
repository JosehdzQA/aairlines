package Bookings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookPage;

public class BookingsTests {

    private WebDriver driver;
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

    }

    @AfterTest
    public void tearDown() throws  Exception{
        // quit
//        driver.quit();
    }


}
