
import eugene.pages.MainPage;
import eugene.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CalcTest {

    @BeforeTest
    public void setup(){
        MainPage mainPage = open("https://yandex.ru/",MainPage.class);
        ResultPage resultPage = mainPage.search("Калькулятор");
    }

    @Test
    public void testIntegerOperations(){
        checkCalculator("(1+2)*3-40/5", "(1 + 2) × 3 − 40 / 5 = 1");
    }

    @Test
    public void testDivisionByZero(){
        checkCalculator("6/0", "6 / 0 = ∞");
    }

    @Test
    public void testErrorIfMissingMeaning(){
        checkCalculator("sin(", "Ошибка");
    }

    @AfterTest
    public void close(){

    }

    public void checkCalculator(String expression, String expectedString){
        ResultPage resultPage = new ResultPage();
        resultPage.inputExpression(expression);
        Assert.assertTrue(resultPage.checkResult(expectedString));
    }
}
