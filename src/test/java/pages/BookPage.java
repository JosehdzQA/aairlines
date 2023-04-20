package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage extends Base {
    ////  objects repository
    private WebDriver driver;
    private By link_FlightLocator = By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[1]/div/ul/li/label/span[2]");
    private By link_HotelLocator = By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[1]/div/div/a[1]");
    private By link_CarLocator = By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[1]/div/div/a[2]");
//falla xpath radio
//    private By radioBtn_RoundTripLocator = By.xpath("//*[@id=\'flightSearchForm.tripType.roundTrip\']");
//    private By radioBtn_OneWayLocator = By.xpath("//*[@id=\'flightSearchForm.tripType.oneWay\']");

    private By radioBtn_RoundTripLocator = By.xpath("//*[@id=\"bookingCheckboxContainer\"]/div[1]/div[1]/label/span[1]");
    private By radioBtn_OneWayLocator = By.xpath("//*[@id=\"bookingCheckboxContainer\"]/div[1]/div[2]/label/span[1]");
    private By checkbox_RedeemMilesLocator = By.name("redeemMiles");//////
    private By input_TypeFromLocator = By.xpath("//*[@id=\'reservationFlightSearchForm.originAirport\']");
    private By inputTypeToLocator = By.xpath("//*[@id=\'reservationFlightSearchForm.destinationAirport\']");
    private By dropDownList_PassengerLocator = By.name("adultOrSeniorPassengerCount");
    private By input_DepartDateLocator = By.xpath("//*[@id='aa-leavingOn']");
    private By input_ReturnDateLocator = By.xpath("//*[@id=\'aa-returningFrom\']");

    private By btn_SearchLocator = By.xpath("//*[@id=\'flightSearchForm.button.reSubmit\']");

//    private By btn_SearchLocator = By.id("flightSearchForm.button.reSubmit");

    ///inputData///////////////// section DefaultData*******
    String entry_TripType ="roundtrip"; //1 oneway /2 roundtrip
    Integer entry_RedeemMiles = 0; ///0 off / 1 On
    Integer entry_OpfillData = 2; /// 1 oneway /2 roundtrip
    String entry_CityFromCode = "MEX";
    String entry_CityToCode = "CUN";
    Integer entry_NumberPassengers = 1;
    String entry_DepartDate ="04/29/2023";
    String entry_ReturnDate ="04/29/2023";
    Integer value_redeemMiles = 999;

    ///////add code for entry data with DataProvider ////////////


    ////// instance driver
    public BookPage(WebDriver driver){
        super(driver);
    }

    //// process to fill and search
    public Boolean SearchBooking(){

        ///verify if Booking page is displayed check option RedeemMiles checkbox
        if (isDisplayed(checkbox_RedeemMilesLocator)){

            if(entry_TripType=="roundtrip"){
                entry_OpfillData = 2;
            } else{
                entry_OpfillData = 1;
            }
        }else{
            System.out.println("Error Book page was not found, testing end");
            return isDisplayed(checkbox_RedeemMilesLocator);

        }
        ////update redeem miles checkbox
        //validate checkbox is active or not
        if(getCheckValue(checkbox_RedeemMilesLocator)){
            // true = 1 is selected /// false = 0 Not selected
            value_redeemMiles = 1;
        }
        else {
            value_redeemMiles = 0;
        }

        if (entry_RedeemMiles == 1 && value_redeemMiles == 1){
            System.out.println("line 68 Error Redeem selected for default, proceed to unselect and select for check function");
            clickCheckBoxes(checkbox_RedeemMilesLocator); //deselect
            clickCheckBoxes(checkbox_RedeemMilesLocator); // select
        } else if (entry_RedeemMiles == 1 && value_redeemMiles == 0) {
            System.out.println("Redeem selected");
            clickCheckBoxes(checkbox_RedeemMilesLocator); //select
        } else if (entry_RedeemMiles == 0 && value_redeemMiles == 0) {
            System.out.println("Redeem unselected for default ok");

        }else if (entry_RedeemMiles == 0 && value_redeemMiles == 1){
            System.out.println("error Redeem selected ");
            clickCheckBoxes(checkbox_RedeemMilesLocator); //deselect
        }

        ////select radio button

        /////section to fill data values ////////
        switch (entry_OpfillData){
            case 1: //fill data for one way
                type(input_TypeFromLocator,entry_CityFromCode);
                type(inputTypeToLocator,entry_CityToCode);
                //selected(passenger)
                type(input_DepartDateLocator,entry_DepartDate); /// dd/mm/aaaa
                break;

            case 2: //fill data for round trip
                type(input_TypeFromLocator,entry_CityFromCode);
                type(inputTypeToLocator,entry_CityToCode);
                //selected(passenger)
                type(input_DepartDateLocator,entry_DepartDate); /// dd/mm/aaaa
                type(input_ReturnDateLocator,entry_ReturnDate); /// dd/mm/aaaa
                break;

            case 999:
                System.out.println("Error: verify code and information");
                break;
            default:
                System.out.println("Error: Option does not exist, verify input Data");

        }

//        click(btn_SearchLocator);
        return true;
    }


}
