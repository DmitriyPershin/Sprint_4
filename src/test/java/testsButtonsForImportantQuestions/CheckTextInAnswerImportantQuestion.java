package testsButtonsForImportantQuestions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckTextInAnswerImportantQuestion {
     private WebDriver driver;

     public CheckTextInAnswerImportantQuestion(WebDriver driver) {
        this.driver = driver;
     }

    //метод для нажатие на вопросы
    public void clickButton(String heading) {
        WebElement element = driver.findElement(By.id(heading));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id(heading)).click();
    }
    //метод для проверки ответов на вопросы    111
    public void checkTextInAnswer(String title, String panel){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(panel)));
        assertEquals(title,driver.findElement(By.id(panel)).getText());
    }
}
