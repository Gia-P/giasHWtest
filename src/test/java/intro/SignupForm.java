package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SignupForm extends DriverFactory {

    @Test
    public void invalidEmailCheck() throws InterruptedException {
        LandingPage landingPage = new LandingPage();

        String[] email = {"plainaddress", "#@%^%#$@#$@#.com", "@example.com", "Joe Smith <email@example.com>",
        "email.example.com", "email@example@example.com", ".email@example.com", "email.@example.com",
        "email..email@example.com", "あいうえお@example.com", "email@example.com (Joe Smith)",
        "email@example", "email@-example.com", "email@example.web", "email@111.222.333.44444",
        "email@example..com","test@technosoft", "Abc..123@example.com"};
        Thread.sleep(500);
        landingPage.setFirstNameTextField("Gia");
        landingPage.setLastNameTextField("Pachkha");
        Thread.sleep(500);
        int count1 = 0;
        int count = 0;
        for (int i = 0; i < email.length; i++){
            landingPage.setRegEmailTextField(email[i]);
            landingPage.clickOnRegPasswordTextField();
            landingPage.clickOnRegEmailTextField();
            List<WebElement> elements = getDriver().findElements(By.xpath("//div[starts-with(@id, 'js_' )]"));
            for (WebElement element : elements){
                if (element.getText().equals("Please enter a valid mobile number or email address.")){
                    System.out.println(element.getText() + " === " + email[i]);
                    count1++;
                    break;
                }
            }
            if (landingPage.isDisplayedReEmail()) {
                count++;
            }
            Thread.sleep(500);
            landingPage.clearEmailTextField();
        }
        System.out.println(" Error massage count is: " + count1 + "\n Invalid email count is: " + email.length + "\n Accept invalid email count is: " + count);
    }
}
