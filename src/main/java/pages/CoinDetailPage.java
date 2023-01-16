package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoinDetailPage extends BasePage {

    @FindBy(name = "chart")
    private WebElement charScreen;

    @FindBy(xpath = "(//a[text()='Giriş yap'])[4]")
    private WebElement loginbutton;

    public boolean isOpenCoinDetailPage() {
        if (charScreen.isDisplayed()){
            return true;
        }
        return false;
    }

    public void closePopupMessage() {
        WebElement element =driver.findElement(By.xpath("//div[@class='css-4rbxuz']"));
        if (element.isEnabled()){
            element.click();
        }
    }

    public void clickLoginButton() {
        loginbutton.click();
    }
}
