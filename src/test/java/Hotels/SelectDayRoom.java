package Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static intro.DriverFactory.getDriver;

public class SelectDayRoom extends LandingPageHotel {
    SimpleDateFormat sdfDay = new SimpleDateFormat("d");
    SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM");
    Calendar calendar = new GregorianCalendar();

    public void selectCheckIntDay(int amount) throws InterruptedException {
        LandingPageHotel landingPageHotel = new LandingPageHotel();
        calendar.add(calendar.DAY_OF_MONTH, amount);
        String selectedDay = sdfDay.format(calendar.getTime());
        Thread.sleep(500);
        landingPageHotel.clickCheckIn();
        String selectedMonth = sdfMonth.format(calendar.getTime());
        List<WebElement> months = getDriver().findElements(By.xpath("//div[@class='widget-datepicker-label' and contains(text(),'2019')]"));
        for (WebElement month : months){
            String getMonth = month.getText();
            Thread.sleep(500);
            if (getMonth.contains(selectedMonth)) {
                if (months.indexOf(month) > 0){
                String xpath = "//div[contains(text(),'" + selectedMonth +"')]//following-sibling::button";
                getDriver().findElement(By.xpath(xpath)).click();
                }
                List<WebElement> days = getDriver().findElements(By.xpath("//*[@class='widget-datepicker-bd']//a"));
                for (WebElement day : days) {
                    if (day.getText().equals(selectedDay)) {
                        day.click();
                        Thread.sleep(500);
                        break;
                    }
                }
            }
        }
    }

    public void selectCheckOutDay(int amount) throws InterruptedException {
        LandingPageHotel landingPageHotel = new LandingPageHotel();
        calendar.add(calendar.DAY_OF_MONTH, amount);
        String selectedDay = sdfDay.format(calendar.getTime());
        landingPageHotel.clickCheckOut();
        String selectedMonth = sdfMonth.format(calendar.getTime());
        List<WebElement> months = getDriver().findElements(By.xpath("//div[@class='widget-datepicker-label' and contains(text(),'2019')]"));
        for (WebElement month : months){
            String getMonth = month.getText();
            Thread.sleep(500);
            if (getMonth.contains(selectedMonth)) {
                if (months.indexOf(month) > 0){
                    String xpath = "//div[contains(text(),'" + selectedMonth +"')]//following-sibling::button";
                    getDriver().findElement(By.xpath(xpath)).click();
                }
                List<WebElement> days = getDriver().findElements(By.xpath("//*[@class='widget-datepicker-bd']//a"));
                for (WebElement day : days) {
                    if (day.getText().equals(selectedDay)) {
                        day.click();
                        Thread.sleep(500);
                        break;
                    }
                }
            }
        }
    }

    public void selectRoomsOption(String options){
        WebElement roomsOption = getDriver().findElement(By.id("qf-0q-compact-occupancy"));
        Select dropdown = new Select(roomsOption);
        dropdown.selectByVisibleText(options);
    }

    public void selectRooms(String room){
        WebElement rooms = getDriver().findElement(By.id("qf-0q-rooms"));
        Select dropdown = new Select(rooms);
        dropdown.selectByVisibleText(room);
    }

    public void selectAdult(String adult){
        WebElement adults = getDriver().findElement(By.id("qf-0q-room-0-adults"));
        Select dropdown = new Select(adults);
        dropdown.selectByVisibleText(adult);
    }

    public void selectChildren(String children){
        WebElement childrens = getDriver().findElement(By.id("qf-0q-room-0-children"));
        Select dropdown = new Select(childrens);
        dropdown.selectByVisibleText(children);
    }

    public int optionSizChildren(){
        WebElement childrens = getDriver().findElement(By.id("qf-0q-room-0-children"));
        Select dropdown = new Select(childrens);
        List<WebElement> childrenOption = dropdown.getOptions();
        return childrenOption.size();
    }

    public int childrenAgeOption(){
        List<WebElement> ageOption = getDriver().findElements(By.xpath("//div[@class='widget-query-group widget-query-room-children widget-query-room-children-clone']//label"));
        return ageOption.size();
    }

    public void selectChildrenAge(String[] age){
        List<WebElement> childrenAge = getDriver().findElements(By.xpath("//div[@class='widget-query-group widget-query-room-children widget-query-room-children-clone']//select"));
        for (int i = 0; i < childrenAge.size(); i++){
            Select dropdown = new Select(childrenAge.get(i));
            dropdown.selectByVisibleText(age[i]);
        }
    }
}
