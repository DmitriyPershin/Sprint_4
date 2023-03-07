package testsForOrderingScooters.PageObjectForTestsOrdering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс для страницы заказа "Для кого самокат"
public class OrderPage {
    //поле "Имя"
    private By fieldName = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    //поле "Фамилия"
    private By fieldSurname = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    //Поле "Адрес"
    private By fieldAddress = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    //Поле "Метро"
    private By fieldMetro = By.xpath(".//input[@class='select-search__input']");
    //Форма выпадающего списка "Метро"
    private By fieldMetroSelectForm = By.xpath(".//div[@class='select-search__select']");
    //Выбор первого элемента из выпадающего списка "Метро"
    private By fieldMetroSelect = By.xpath(".//div[@class='select-search__select']/ul/li[1]/button");
    //Поле "Телефон"
    private By fieldTelephone = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");
    //кнопка "Далее"
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение формы заказа
    public void checkForTopOrderButtonPage(String name, String Surname, String Address, String Telephone) {
        //ожидаем первого поля Имя и заполняем его
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldName));
        driver.findElement(fieldName).sendKeys(name);
        //заполняем поле Фамилия
        driver.findElement(fieldSurname).sendKeys(Surname);
        //заполняем поле адрес
        driver.findElement(fieldAddress).sendKeys(Address);
        //нажимаем на выпадающий список "Местро"
        driver.findElement(fieldMetro).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldMetroSelectForm));
        //выбираем первый элемент из списка
        driver.findElement(fieldMetroSelect).click();
        //заполняем поле телефон
        driver.findElement(fieldTelephone).sendKeys(Telephone);
        //нажимаем на кнопку "Далее"
        driver.findElement(buttonNext).click();
        //Можно конечно еще добавить кучу проверок с очисткой, доступностью и т.д., посчитал, что здесь это не нужно.
        //Если будет нужно, то добавлю, тоже самое касается orderPage2
    }
}
