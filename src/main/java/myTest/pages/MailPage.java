package myTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MailPage extends Page{

    private By sendMailButton = By.cssSelector(".js-main-action-compose");
    private By messageSubjectLocator = By.cssSelector(".mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject");
    private By moreMessagesLocator = By.cssSelector(".ns-view-messages-pager-load-more.ns-view-id-195.mail-MessagesPager-LoadMore");
    private By adressFieldLocator = By.cssSelector(".MultipleAddressesDesktop-Field.ComposeYabblesField .composeYabbles");
    private By subjectFieldLocator = By.cssSelector(".compose-LabelRow-Content.ComposeSubject-Content input");
    private By sendMessageButtonLocator = By.cssSelector(".ComposeControlPanelButton.ComposeControlPanel-Button.ComposeControlPanel-SendButton.ComposeSendButton.ComposeSendButton_desktop");
    private By messageBodyLocator = By.cssSelector(".cke_wysiwyg_div.cke_reset.cke_enable_context_menu.cke_editable.cke_editable_themed.cke_contents_ltr.cke_htmlplaceholder");
    private By refreshButtonLocator = By.cssSelector(".mail-ComposeButton-Refresh.js-main-action-refresh.ns-action");

    public MailPage(WebDriver driver){
        super.driver = driver;
    }

    public List<String > getMessageSubjectsList(){

        while (elementIsExist(moreMessagesLocator)){
            driver.findElement(moreMessagesLocator).click();
        } //если список писем более одной страницы

        waitElementIsVisible(messageSubjectLocator);
        List<WebElement> messagesList = driver.findElements(messageSubjectLocator);
        List<String> subjectsList = new ArrayList<>();
        for (WebElement subject: messagesList){
            subjectsList.add(subject.getText());
        }
        return subjectsList;
    }

    public void sendMail(String respondent, String theme, int count){
        driver.findElement(sendMailButton).click();
        driver.findElement(adressFieldLocator).sendKeys(respondent + "@yandex.ru");
        driver.findElement(subjectFieldLocator).sendKeys(theme);
        driver.findElement(messageBodyLocator).sendKeys("Найдено " + count + " писем\\ьма");
        driver.findElement(sendMessageButtonLocator).click();

        //НЕ ЕСТЬ ХОРОШО, НО ПРИДЁТСЯ
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(refreshButtonLocator).click();
    }
}
