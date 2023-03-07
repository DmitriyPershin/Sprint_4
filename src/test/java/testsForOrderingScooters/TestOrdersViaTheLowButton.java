package testsForOrderingScooters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testsForOrderingScooters.PageObjectForTestsOrdering.MainPage;
import testsForOrderingScooters.PageObjectForTestsOrdering.OrderPage;
import testsForOrderingScooters.PageObjectForTestsOrdering.RentOrderPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOrdersViaTheLowButton {
    private final String name;
    private final String Surname;
    private final String Address;
    private final String Telephone;
    private final String Comment;


    public TestOrdersViaTheLowButton(String name, String Surname, String Address, String Telephone, String Comment) {
        this.name = name;
        this.Surname = Surname;
        this.Address = Address;
        this.Telephone = Telephone;
        this.Comment = Comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { "Ванька", "Петров", "ул.Пушкина","+79949375561","быстро,быстро" },
                { "Петька", "Иванов", "ул.Лермонтова","+7994915561","Как можно скорее" },
        });
    }

    private WebDriver driver;
    @Before
    public void getBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox","--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void checkLowButtonOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLowButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.checkForTopOrderButtonPage(name,Surname,Address,Telephone);

        RentOrderPage rentPage = new RentOrderPage(driver);
        rentPage.checkForTopOrderButtonPage(Comment);
    }
    @Test
    public void checkTopButtonOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.checkForTopOrderButtonPage(name,Surname,Address,Telephone);

        RentOrderPage rentPage = new RentOrderPage(driver);
        rentPage.checkForTopOrderButtonPage(Comment);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}