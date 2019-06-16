package intro;

import org.openqa.selenium.By;

public class LandingPage extends BasePage{
    //Locators
    private By emailTextField = By.id("email");
    private By passwordTextField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By messengerLink = By.linkText("Messenger");
    private By maleGender = By.id("u_0_a");
    private By signUpButton = By.id("u_0_u");
    private By firstNameTextField = By.id("u_0_c");
    private By lastNameTextField = By.id("u_0_e");
    private By regEmailTextField = By.id("u_0_h");
    private By regPasswordTextField = By.id("u_0_o");
    private By regEmailInfoText = By.xpath("//div[@class='uiContextualLayer uiContextualLayerLeft']//div[@class='_5v-0 _53im']//div[@class='_5633 _5634 _53ij' and text()='Please enter a valid mobile number or email address.']");
    ////div[@class='_5v-0 _53im']//div[text()='Please enter a valid mobile number or email address.']"
    //*[text()='Please enter a valid mobile number or email address.']
    //div[@class='uiContextualLayer uiContextualLayerLeft']//div[@class='_5v-0 _53im']//div[@class='_5633 _5634 _53ij' and text()='Please enter a valid mobile number or email address.']
    private By erorMessageButton  = By.id("u_0_g");
    private By reEmail = By.id("u_0_k");
    //Constructors

    //Methods
    public void setEmailTextField(String value){
        setValue(emailTextField, value);
    }

    public void setPasswordTextField(String value){
        setValue(passwordTextField, value);
    }

    public void clicOnLoginButton(){
        clickOn(loginButton);
    }

    public void clickOnMessenger(){
        clickOn(messengerLink);
    }

    public boolean checkMaleGender() {
        return isSelected(maleGender);
    }

    public void clickOnkMaleGender(){
        clickOn(maleGender);
    }

    public void clickOnSignUpButton(){
        clickOn(signUpButton);
    }

    public void setFirstNameTextField(String value){
        setValue(firstNameTextField, value);
    }

    public void setLastNameTextField(String value){
        setValue(lastNameTextField, value);
    }

    public void setRegEmailTextField(String value){
        setValue(regEmailTextField, value);
    }

    public void clickOnRegPasswordTextField(){
        clickOn(regPasswordTextField);
    }

    public void clickOnRegEmailTextField(){
        clickOn(regEmailTextField);
    }

    public String getRegEmailInfoText(){
        return getTextFromElement(regEmailInfoText);
    }

    public void clearEmailTextField(){
        clear(regEmailTextField);
    }

    public boolean isDisplayedReEmail(){
        return isDisplayed(reEmail);
    }
    public boolean isDisplayedErorMasage(){
        return isEnable(regEmailInfoText);
    }
}
