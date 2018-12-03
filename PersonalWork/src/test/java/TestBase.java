import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {

        start();

    }

    public void start() {
        wd = new ChromeDriver();
       wd.manage().window().maximize();

    }

    public void openSite(String url) {
        wd.get(url);

    }



    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {

        if (text != null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        stop();
    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
        wd.quit();
    }



    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void confirmAlert() {

        wd.switchTo().alert().accept();
    }



    protected int getContactCount() {
        int count = wd.findElements(By.name("selected[]")).size();
        return count;
    }


}
