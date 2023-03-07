package testsButtonsForImportantQuestions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.After;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestToCheckTextInImportantQuestions {
    //текст для ожидаемого результата
    static String accordionPanelText0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    static String accordionPanelText1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    static String accordionPanelText2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    static String accordionPanelText3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    static String accordionPanelText4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    static String accordionPanelText5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    static String accordionPanelText6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    static String accordionPanelText7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final String title;
    private final String heading;
    private final String panel;

    public TestToCheckTextInImportantQuestions(String title, String heading, String panel) {
        this.title = title;
        this.heading = heading;
        this.panel = panel;
    }
    private WebDriver driver;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                { accordionPanelText0, "accordion__heading-0", "accordion__panel-0" },
                { accordionPanelText1, "accordion__heading-1", "accordion__panel-1" },
                { accordionPanelText2, "accordion__heading-2", "accordion__panel-2" },
                { accordionPanelText3, "accordion__heading-3", "accordion__panel-3" },
                { accordionPanelText4, "accordion__heading-4", "accordion__panel-4" },
                { accordionPanelText5, "accordion__heading-5", "accordion__panel-5" },
                { accordionPanelText6, "accordion__heading-6", "accordion__panel-6" },
                { accordionPanelText7, "accordion__heading-7", "accordion__panel-7" },
        });
    }
    @Before
     public void getBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void checkButtonInPage() {
        CheckTextInAnswerImportantQuestion checkTextInAnswerImportantQuestion = new CheckTextInAnswerImportantQuestion(driver);
        checkTextInAnswerImportantQuestion.clickButton(heading);
        checkTextInAnswerImportantQuestion.checkTextInAnswer(title,panel);
    }

    @After
    public void teardown() {
    driver.quit();
    }
}

