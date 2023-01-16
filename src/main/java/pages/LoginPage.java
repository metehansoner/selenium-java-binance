package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "wrap_app")
    private WebElement loginScreen;

    @FindBy(id = "username")
    private WebElement txtEmailField;
    

    public boolean isOpenLoginPage() {
        if (loginScreen.isDisplayed()){
            return true;
        }
        return false;
    }

    public void writeTextEmailField(String text) {
        txtEmailField.clear();
        txtEmailField.sendKeys(text);
    }

    public void clickButton(String text) {
        driver.findElement(By.xpath("//button[text()='"+text+"']")).click();
    }

    public boolean isVisibleMessage(String text) {
        if (driver.findElement(By.xpath("//div[text()='"+text+"']")).isDisplayed()){
            return true;
        }
        return false;
    }
}
