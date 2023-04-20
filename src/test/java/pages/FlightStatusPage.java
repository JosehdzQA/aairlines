package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightStatusPage extends Base {
    private WebDriver driver;
    private By LinkflightStatusTab = By.id("jq-flightStatus");

    private By searchByCity = By.xpath("//*[@id='flightStatusView']/div[1]/div/ul/li[1]/label/span[1]");
    private By searchByflightNumber = By.xpath("//*[@id='flightStatusView']/div[1]/div/ul/li[2]/label/span[2]");
    private By departCityCode = By.xpath("//*[@id='originAirport']");
    private By toCityCode = By.xpath("//*[@id='destinationAirport']");

//    private By btnSearch = By.xpath("//*[@id='flightSchedulesSearchButton']");
    private By btnSearch = By.id("flightSchedulesSearchButton");
    private By flightNumber = By.xpath("//*[@id='flightNumber']");
    private By listBoxDate= By.xpath("//*[@id='travelDateDropdown']\n");

    String entry_searchBy ="city";
    String entry_departCityCode ="CUN";
    String entry_toCityCode ="MEX";
    String entry_dateFlight ="viernes, abril 7";
    String entry_flightNumber = "12345";

    public FlightStatusPage(WebDriver driver)  {super(driver);    }

    public Boolean flightPageSearch() throws InterruptedException {
        Thread.sleep(3000);
        click(LinkflightStatusTab);
        Thread.sleep(3000);

       if("city" == entry_searchBy) {
            type(departCityCode,entry_departCityCode);
            click(toCityCode);
            type(toCityCode,entry_toCityCode);
           click(departCityCode);
       } else{
           type(flightNumber,entry_flightNumber);
       }
     // requires work select listbox value function
        click(btnSearch);
        return true;
        }
}
