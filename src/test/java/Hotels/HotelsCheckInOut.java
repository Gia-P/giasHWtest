package Hotels;

import intro.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelsCheckInOut extends DriverFactory {

    @Test
    public void hotelsCheckInOut() throws InterruptedException {
        LandingPageHotel landingPageHotel = new LandingPageHotel();
        SelectDayRoom selectDayRoom = new SelectDayRoom();
        int checkInDay = 40;
        int checkOutDay = 20;
        int selectChildren = 6;
        int selectRooms = 2;
        int selectAdult = 2;
        String setNights = String.valueOf(checkOutDay);
        landingPageHotel.setCityTextFilde("New York, New York, United States of America");
        Thread.sleep(500);
        landingPageHotel.clickDastLable();
        Thread.sleep(500);
        selectDayRoom.selectCheckIntDay(checkInDay);
        selectDayRoom.selectCheckOutDay(checkOutDay);
        String nights = landingPageHotel.getTextNumeNights();
        Assert.assertEquals(nights,setNights,"Nights Not =");
        landingPageHotel.clickRooms();
        //Options "1 room, 1 adult" or "1 room, 2 adults" or "More options…"
        selectDayRoom.selectRoomsOption("More options…");
        selectDayRoom.selectRooms(String.valueOf(selectRooms));
        selectDayRoom.selectAdult(String.valueOf(selectAdult));
        Assert.assertEquals(selectDayRoom.optionSizChildren(),7,"Siz Not =");
        selectDayRoom.selectChildren(String.valueOf(selectChildren));
        Assert.assertEquals(selectDayRoom.childrenAgeOption(),selectChildren, "Age Size Not =");
        String[] age = {"15", "4", "7", "10", "8", "2"};
        selectDayRoom.selectChildrenAge(age);
        Thread.sleep(3000);
    }

}
