package eugene.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends Page {

    private By searchFieldLocator = By.cssSelector(".input__control.input__input");
    private By searchButtonLocator = By.cssSelector(".search2__button");

    public ResultPage search(String stringForSearch){
        $(searchFieldLocator).setValue(stringForSearch);
        $(searchButtonLocator).click();
        return page(ResultPage.class);
    }

}
