package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CoinDetailPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class HomeSteps {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private CoinDetailPage coinDetailPage=new CoinDetailPage();

    @Given("I navigate to binance homepage")
    public void iNavigateToHomePage() {
        Assert.assertTrue(homePage.isOpenHomePage(),"Homepage could not be opened");
    }

    @And("I click the {string} from page")
    public void iClickTheElementButton(String menu) {
        homePage.clickToElement(menu);
    }

    @And("The first {int} pages of the listed coins are exported to excel")
    public void iExpoertedToEXcel(int count) throws InterruptedException, IOException {
       homePage.writeDataToExcel(count);
    }

    @And("I click {string} from the {string} menu at the top of the homepage")
    public void iClickFromSpot(String tab,String subTab){
        homePage.onHoverTabMenu(subTab);
        homePage.clickSubTab(tab);
    }

    @And("I click the login button on the page that opens")
    public void iClickLoginButtonThatOpen(){
        Assert.assertTrue(coinDetailPage.isOpenCoinDetailPage(),"CoinDetail could not be opened");
        coinDetailPage.closePopupMessage();
        coinDetailPage.clickLoginButton();
    }

    @And("I write {string} in the email field On the login page")
    public void iWriteTextinEmailField(String text){
        Assert.assertTrue(loginPage.isOpenLoginPage(),"LoginPage could not be opened");
        loginPage.writeTextEmailField(text);
    }
    @And("I click the {string} button on the login screen")
    public void iClickNextButtonOnLoginPage(String text){
        loginPage.clickButton(text);
    }

    @Then("I check the {string} warning message on the screen")
    public void iCheckWarningMesssageOnLoginPage(String text){
      Assert.assertTrue(loginPage.isVisibleMessage(text),"Message could not be displayed");
    }


    @When("I check that {int} randomly clicked pages are opened under {string}")
    public void iCheckClickedLinkIssOpened(int random,String text) throws InterruptedException {
        Assert.assertTrue(homePage.isDisplayedContext(text),"Hakkımızda could not be displayed");
        homePage.checkLinkIsOpen(random);
    }

    @When("I checked that the {string} page is opened properly")
    public void iCheckedPageIsOpened(String text){
      Assert.assertTrue(homePage.isActiveTab(text));
    }





}
