package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {

    private WebDriver driver;
//    String urlPage = "https://www.aa.com/homePage.do?locale=es_MX";
//    String browserType ="chrome";


    public Base(WebDriver driver){
        this.driver = driver;
    }

//    public Base(String page){
//        System.out.println("Web Page "+ page);
//    }
//
//    public WebDriver getDriver(){
//        return driver;
//    }

    public WebDriver LaunchBrowser(String browserType){

        switch (browserType) {
            case "firefox":///required update for the driver and path correct
                System.setProperty("webdriver.firefox.driver","resources/firefox.exe");
                driver = new ChromeDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":///required update for the driver and path correct
                System.setProperty("webdriver.edge.driver","resources/edgedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser defaul choice..");
                System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        String title = driver.getTitle();
        // print title browser
        System.out.println("Open Browser: "+title);

        return driver;
    }

    ////wrapping
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type (By locator,String inputTxt){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputTxt);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }   catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void clickCheckBoxes(By locator){
        driver.findElement(locator).click();
    }

    public Boolean getCheckValue(By locator){
            return driver.findElement(locator).isSelected();
    }

    public void clickWebRadioBtnValue(By locator){ driver.findElement(locator).click();}

    public Boolean getWebRadioBtnValue(By locator){ return driver.findElement(locator).isSelected();}

    public void clean(WebElement element){
        element.clear();
    }

    public void tearDown(){
        System.out.println("browser quit");
        driver.quit();
    }

    public void pageToOpen(String urlPage){
        driver.get(urlPage);
    }

}
