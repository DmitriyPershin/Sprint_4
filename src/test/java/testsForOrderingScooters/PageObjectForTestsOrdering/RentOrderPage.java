package testsForOrderingScooters.PageObjectForTestsOrdering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


//класс для страницы заказа "Про аренду"
public class RentOrderPage {
    //поле "Когда привезти самокат"
    private By fieldCalendar = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //локатор для выбора значения из календаря
    private By fieldCalendarSelect = By.xpath(".//div[@class='react-datepicker__month']/div[1]/div[1]");
    //поле "Срок аренды"
    private By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    //локатор для выбора значеня из дроплиста "Срок аренды"
    private By fieldRentalPeriodSelect = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //локатор для чекбокса "чёрный жемчуг"
    private By checkBoxColorBlack = By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='black']");
    //локатор для чекбокса "серая безысходность"
    private By checkBoxColorGrey = By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='grey']");
    //поле Комментарий для курьера
    private By fieldComment = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/input[@placeholder='Комментарий для курьера']");
    //локатор для кнопки "Заказать" на форме
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //локатор для кнопки "Да" в модалке. Супер сложно его отслеживает вебдрайвер.
    private By modalButtonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор для блока "Заказ оформлен"
    private By modalButtonCompleteOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    private WebDriver driver;

    public RentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkForTopOrderButtonPage(String Comment) {
        //ожидаем появления первого поля и заполняем его
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldCalendar));
        driver.findElement(fieldCalendar).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldCalendarSelect));
        driver.findElement(fieldCalendarSelect).click();
        //Открываем календарь и выбираем 1 элемент из списка
        driver.findElement(fieldRentalPeriod).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldRentalPeriodSelect));
        driver.findElement(fieldRentalPeriodSelect).click();
        //нажимаем на чекбоксы
        driver.findElement(checkBoxColorBlack).click();
        driver.findElement(checkBoxColorGrey).click();
        //вводим комментарий
        driver.findElement(fieldComment).sendKeys(Comment);
        //нажимаем на кнопку "Заказать"
        driver.findElement(orderButton).click();
        //Ждем модалку и нажимаем на кнопку "Да"
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(modalButtonYes));
        driver.findElement(modalButtonYes).click();
        //Здесь тест падает, так как кнопка "Да" в хроме не нажимается и тест не может найти следующий элемент
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(modalButtonCompleteOrder));
        assertEquals("Заказ оформлен",driver.findElement(modalButtonCompleteOrder).getText());
    }
}

