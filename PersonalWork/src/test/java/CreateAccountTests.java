import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void testCreateAccountWithButtonCreateAccount() throws InterruptedException {

        openSite("https://mish.sheygam.com/#/wellcome");

        createNewAccount("dvd.1@gmail.com", "abcd1234", "abcd1234");
        Thread.sleep(4000);
    }

    public void createNewAccount(String email, String password, String repPassword) {

        buttonCreateAccount();
        fillCreateAccountForm(email, password, repPassword);
    }

    public void buttonCreateAccount() {
        click(By.xpath("//span[contains(text(),'Create Account')]"));
    }

    public void fillCreateAccountForm(String email, String password, String repPassword) {

        if(isInFillCreateAccountForm()){
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='password']"), password);
        type(By.xpath("//input[@formcontrolname='passwordRep']"), repPassword);
        submitNewAccount();}
    }

    public boolean isInFillCreateAccountForm() {
    return isElementPresent(By.xpath("//div[@id='cdk-overlay-0']"));
    }

    public void submitNewAccount() {
        click(By.xpath("//button[@type='submit']"));
    }
}
