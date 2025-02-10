package StepDefinitions;

import Cases.FirstCase;
import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstCaseStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(FirstCaseStepDefinitions.class);
    WebDriver driver = DriverFactory.getDriver();
    FirstCase firstCase = new FirstCase(driver);


    @Given("User at mainpage")
    public void userAtMainpage() {
    }

    @When("User accept cookies")
    public void userAcceptCookies() {
        firstCase.acceptCookies();
    }

    @When("User click menu button")
    public void userClickMenuButton() {
        firstCase.clickMenu();

    }

    @When("User click Oscar option from Award&Evetns menu")
    public void userClickOscarOptionFromAwardEvetnsMenu() {
        firstCase.chooseOscar();
    }

    @When("User click {int} from Event History menu")
    public void userClickFromEventHistoryMenu(int arg0) {
        firstCase.clickEventHistoryMenu();
    }

    @When("User click {int}")
    public void userClick(int arg0) {
        firstCase.clickDate();
    }

    @When("User click parazit movie")
    public void userClickParazitMovie() {
        firstCase.clickParazitmovie();
    }



    @When("User get Director Writer and Stars name")
    public void userGetDirectorWriterAndStarsName() {
        firstCase.getDirectorWriterStarsName();
    }

    @Then("User back mainpage")
    public void userBackMainpage() {
        firstCase.backMainPage();
    }


}
