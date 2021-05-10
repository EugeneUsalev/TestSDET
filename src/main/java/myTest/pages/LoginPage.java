package myTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page  {

     private By loginFieldLocator = By.id("passp-field-login");
     private By passFieldLocator = By.id("passp-field-passwd");
     private By submitButtonLocator = By.cssSelector("button[type='submit']");

     public LoginPage(WebDriver driver){
        super.driver = driver;
     }

     private void sendLogin(String login){
         waitElementIsVisible(loginFieldLocator);
         driver.findElement(loginFieldLocator).sendKeys(login);
     }

     private void sendPass(String pass){
         waitElementIsVisible(passFieldLocator);
         driver.findElement(passFieldLocator).sendKeys(pass);
     }

     private void submitClick(){
         waitElementIsVisible(submitButtonLocator);
         driver.findElement(submitButtonLocator).click();
     }

     public void login(String login, String pass){
         sendLogin(login);
         submitClick();
         sendPass(pass);
         submitClick();
     }


}
