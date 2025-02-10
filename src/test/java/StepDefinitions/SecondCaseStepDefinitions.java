package StepDefinitions;

import Cases.FirstCase;
import Cases.SecondCase;
import Util.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondCaseStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(SecondCaseStepDefinitions.class);
    WebDriver driver = DriverFactory.getDriver();
    SecondCase secondCase = new SecondCase(driver);

    @When("User click searchbox")
    public void userClickSearchbox() {
        secondCase.clickSearchBox();
    }

    @When("User write movie name and click search")
    public void userWriteMovieNameAndClickSearch() {
        secondCase.writingMovieName();
    }

    @When("User get Director Writer and Stars name from movie page")
    public void userGetDirectorWriterAndStarsNameFromMoviePage() {
        secondCase.getInfoNames();
    }

    @When("User compares them in the first case")
    public void userComparesThemInTheFirstCase() {
        secondCase.comparesName();
    }

    @When("User click gallery")
    public void userClickGallery() {
        secondCase.clickGallery();
    }

    @Then("User verify that links to photos are correct")
    public void userVerifyThatLinksToPhotosAreCorrect() {
        secondCase.verifyPhotoLinks();
    }

}
