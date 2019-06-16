package intro;

import org.openqa.selenium.By;

public class BasePage {

    public void setValue(By element, String value){
        DriverFactory.getDriver().findElement(element).sendKeys(value);
    }

    public void clickOn(By element){
        DriverFactory.getDriver().findElement(element).click();
    }

    public String getTextFromElement(By element){
        return DriverFactory.getDriver().findElement(element).getText();
    }

    public boolean isSelected(By element){
        return DriverFactory.getDriver().findElement(element).isSelected();
    }
    public void clear(By element){
        DriverFactory.getDriver().findElement(element).clear();
    }

    public boolean isDisplayed(By element){
        return DriverFactory.getDriver().findElement(element).isDisplayed();
    }
    public boolean isEnable(By element){
        return DriverFactory.getDriver().findElement(element).isDisplayed();
    }
}
