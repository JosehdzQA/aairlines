package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckInPage extends Base {
    //object repository

    private WebDriver driver;
    private By LinkCheckinTab = By.id("jq-myTripsCheckIn");

    private By radioBtn_Checkin = By.xpath("//*[@id='findYourTripFor']/div[1]/label/span[1]");
    private By radioBtn_TravelCredits = By.xpath("//*[@id='viewCanceledTripRadioButton']/label/span[1]");
    private By input_lastName = By.xpath("//*[@id='findReservationForm.lastName']");
    private By input_codeBook = By.xpath("//*[@id='findReservationForm.recordLocator']");
    private By input_ticket = By.xpath("//*[@id='findReservationForm.ticketNumber']");
    private By btn_Search = By.xpath("//*[@id='findReservationForm.submit']");

    /// input data
    String entry_type ="checkin";
    String entry_LastName ="Hernandez";
    String entry_CodeBook ="JCQNHD";
    String entry_TicketBook ="1234567890123";
    String entry_TravelCredits = "yes";
    //// data provider ///
    public CheckInPage(WebDriver driver){
        super(driver);
    }

    public Boolean checkinPageSearch(){
        //// click on checkin tab
        click(LinkCheckinTab);
        //// fill last name field input
        type(input_lastName,entry_LastName);
        //// fill code book field input
        type(input_codeBook,entry_CodeBook);
        //// fill ticket field input
        if("checkin" != entry_type) {
            if(entry_TravelCredits == "yes"){
                if(getWebRadioBtnValue(radioBtn_TravelCredits)){
                    System.out.println("Warning: View travel credits is active for default, the test continue with the search");
                } else {
                clickWebRadioBtnValue(radioBtn_TravelCredits);
                }
                type(input_ticket, entry_TicketBook);
            }

        }

//        click(btn_Search);
        return true;
    }

}