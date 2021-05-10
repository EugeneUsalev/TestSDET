package myTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;

    protected WebElement waitElementIsVisible(By locator){
        return new WebDriverWait(driver,10, 100).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean elementIsExist(By locator){
        try {
            waitElementIsVisible(locator);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
