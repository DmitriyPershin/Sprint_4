package testsForOrderingScooters.PageObjectForTestsOrdering;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private By topOrderButton = By.className("Button_Button__ra12g");
    private By lowOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopButton(){
        driver.findElement(topOrderButton).click();
    }
    public void clickLowButton(){
        WebElement element = driver.findElement(lowOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowOrderButton).click();
    }
}
