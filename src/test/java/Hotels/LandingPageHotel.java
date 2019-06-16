package Hotels;

import intro.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LandingPageHotel extends BasePage {
    private By cityTextFild = By.id("qf-0q-destination");
    private By dastinationLabel = By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
    private By checkIn = By.id("qf-0q-localised-check-in");
    private By checkOut = By.id("qf-0q-localised-check-out");
    private By numeNights = By.xpath("//span[@class='widget-query-num-nights']");
    private By rooms = By.id("qf-0q-compact-occupancy");

    public void setCityTextFilde(String city){
        setValue(cityTextFild, city);
    }

    public void clickDastLable(){
        clickOn(dastinationLabel);
    }

    public void clickCheckIn(){
        clickOn(checkIn);
    }

    public void clickCheckOut(){
        clickOn(checkOut);
    }

    public String getTextNumeNights(){
        return getTextFromElement(numeNights);
    }

    public void clickRooms(){
        clickOn(rooms);
    }
}
