package myTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class MainPage extends Page {

    private By loginLink = By.className("desk-notif-card__login-new-item-title");
    private By mailLink = By.className("desk-notif-card__mail-title");

    public MainPage(WebDriver driver){
        super.driver = driver;
    }


    public void goToLoginPage() {
        driver.findElement(loginLink).click();
    }

    public void goToMailPage() {
        driver.findElement(mailLink).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1){
            driver.switchTo().window(tabs.get(1));
        }
    }
}
