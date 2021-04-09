package eugene.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage extends Page{

    private By calcBlockLocator = By.cssSelector(".calculator__wrapper");

    SelenideElement calculator = $(calcBlockLocator);
    SelenideElement inputField = calculator.$(".input__control");
    SelenideElement resultField = calculator.$(".calculator-display");

    public void inputExpression(String mathExpression){
        inputField.setValue(mathExpression).pressEnter();
    }

    public boolean checkResult(String expectedString){
        return resultField.getText().equals(expectedString);
    }

}
