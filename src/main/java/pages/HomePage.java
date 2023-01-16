package pages;

import model.Coin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HomePage extends BasePage {

    @FindBy(id = "__APP")
    private WebElement pageDiv;

    public boolean isOpenHomePage() {
        if (pageDiv.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickToElement(String menu) {
        WebElement element = driver.findElement(By.xpath("(//div[text()='" + menu + "'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void writeDataToExcel(int count) throws InterruptedException, IOException {
        List<WebElement> c = findChildElemnts("//div[@class='css-b0tuh4']//button[@id!='previous-page' and position()<5]");
        List<Coin> coinList = new ArrayList<Coin>();
        for (WebElement element : c) {
            element.click();
            List<WebElement> name = findChildElemnts("//div[@class='css-leyy1t']//a//div//div[@class='css-1x8dg53']");
            int index = 1;
            for (WebElement coin : name) {
                String price = driver.findElement(By.xpath("(//div[@class='css-leyy1t']//div[@class='css-18yakpx']//div[@class='css-1vgqjs4' or @class='css-1ca67uc'])[" + index + "]")).getText();
                String volume = driver.findElement(By.xpath("(//div[@class='css-leyy1t']//div[@class='css-102bt5g'])[" + index + "]")).getText();
                coinList.add(new Coin(coin.getText(), price, volume));
                index++;
            }
        }
        writeToFile(coinList);

    }

    public void onHoverTabMenu(String tab) {
        WebElement element = driver.findElement(By.xpath("//div[@class='css-vurnku' and text()='" + tab + "']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void clickSubTab(String subTab) {
        driver.findElement(By.xpath("//div[@class='css-6hm6tl' and text()='" + subTab + "']")).click();
    }

    public boolean isDisplayedContext(String text) {
        if (driver.findElement(By.xpath("//div[text()='" + text + "']")).isDisplayed()) {
            return true;
        }
        return false;
    }

    public void checkLinkIsOpen(int random) throws InterruptedException {
        Random r = new Random();
        Actions actions = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            int randomNumber = r.nextInt(12) + 1;
            ;
            driver.findElement(By.xpath("((//div[@class='css-1yk9mh2'])[1]//a)[" + randomNumber + "]")).click();
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        }
    }

    public boolean isActiveTab(String text) {

        if (driver.findElement(By.xpath("//div[@id='tab-" + text + "']/div[contains(@class,'active')]")).isDisplayed()) {
            return true;
        }
        return false;
    }
}
