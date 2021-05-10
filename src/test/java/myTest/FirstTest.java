package myTest;

import myTest.pages.LoginPage;
import myTest.pages.MailPage;
import myTest.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {

    private WebDriver driver;

    @BeforeTest
    public void start(){

        driver = new WDriver(Config.DRIVER_NAME).getDriver();
        driver.get(Config.BASE_URL);
    }

    @Test
    public void test1(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        new LoginPage(driver).login(Config.LOGIN,Config.PASSWD);
        mainPage.goToMailPage();
        MailPage mailPage = new MailPage(driver);
        List<String> subjectsList = mailPage.getMessageSubjectsList();
        int startCount = counter(subjectsList, Config.MESSAGE_SUBJECT);
        mailPage.sendMail(Config.LOGIN, Config.MESSAGE_SUBJECT, startCount);
        subjectsList = mailPage.getMessageSubjectsList();
        int finalCount = counter(subjectsList, Config.MESSAGE_SUBJECT);
        Assert.assertTrue(finalCount == startCount + 1);
    }

    @AfterTest
    public void stop(){
        driver.quit();
    }

    private int counter(List<String> list, String string){
        int count = 0;
        for (String value: list){
            if(value.equals(string))count ++;
        }
        return count;
    }

}
