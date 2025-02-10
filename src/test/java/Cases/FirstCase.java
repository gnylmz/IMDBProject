package Cases;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstCase {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    JavascriptExecutor js;



    public FirstCase(WebDriver driver) {
         this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.js = (JavascriptExecutor) driver;



    }


     By cookies = By.xpath("//button[normalize-space()='Accept']");
    By menubutton = By.className("ipc-responsive-button__text");
    By oscarbutton = By.cssSelector("body > div:nth-child(2) > nav:nth-child(2) > div:nth-child(2) > aside:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(2) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > a:nth-child(1) > span:nth-child(1)");
    By choosedate1 = By.xpath("//li[normalize-space()='2020s']");
    By choosedate2 = By.xpath("//a[@id='event-history-edition-5']");
  static By director = By.xpath("//div[@class='sc-9a2a0028-10 iUfJXd']//li[1]//div[1]//ul[1]//li[1]//a[1]");
   static By writers1 = By.xpath("//div[@class='sc-9a2a0028-10 iUfJXd']//li[2]//div[1]//ul[1]//li[1]//a[1]");
   static By writers2 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Han Jin-won']");
  static By stars1 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Song Kang-ho']");
   static By stars2 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Lee Sun-kyun']");
  static By stars3= By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Cho Yeo-jeong']");

     public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept']")));
        driver.findElement(cookies).click();
    }

    public void clickMenu() {
        driver.findElement(menubutton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(oscarbutton));
    }

    public void chooseOscar() {
        driver.findElement(oscarbutton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickEventHistoryMenu() {
        
     WebElement eventhistory = driver.findElement(By.xpath("//li[@class='ipc-tab-arrow ipc-tab-arrow--visible ipc-tab-arrow--right']//*[name()='svg']"));
        js.executeScript("arguments[0].scrollIntoView(true);",eventhistory);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='event-history-edition-5']")));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickDate() {
        WebElement firstElement = driver.findElement(choosedate1);
         js.executeScript("arguments[0].click();", firstElement);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='ipc-tabs ipc-tabs--base ipc-tabs--align-left']//li[@role='presentation']")));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     WebElement secondElement = driver.findElement(choosedate2);
     js.executeScript("arguments[0].click();", secondElement);

    }

    public void clickParazitmovie() {
        WebElement parazitmovie = driver.findElement(By.xpath("//section[@data-testid='BestOriginalScreenplay']//h3[@class='ipc-title__text'][normalize-space()='Parazit']"));
        js.executeScript("arguments[0].scrollIntoView(true);",parazitmovie);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-testid='BestOriginalScreenplay']//h3[@class='ipc-title__text'][normalize-space()='Parazit']")));
        parazitmovie.click();
    }

    public void getDirectorWriterStarsName() {
        WebElement stars = driver.findElement(By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@aria-label='See full cast and crew'][normalize-space()='Stars']"));
        js.executeScript("arguments[0].scrollIntoView(true);",stars);
        String text1 =driver.findElement(director).getText();
        System.out.println("Director: " + text1);
        String text2 = driver.findElement(writers1).getText();
        System.out.println("First writer: " + text2);
        String text3 = driver.findElement(writers2).getText();
        System.out.println("Second writer: " + text3);
        String text4 = driver.findElement(stars1).getText();
        System.out.println("Firs star: " + text4);
        String text5 = driver.findElement(stars2).getText();
        System.out.println("Second star: " + text5);
        String text6 = driver.findElement(stars3).getText();
        System.out.println("Third star: " + text6);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backMainPage() {
       WebElement mainpage = driver.findElement(By.xpath("//a[@id='home_img_holder']"));
        js.executeScript("arguments[0].scrollIntoView(true);",mainpage);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='home_img_holder']")));
        js.executeScript("arguments[0].click();", mainpage);
    }
}
