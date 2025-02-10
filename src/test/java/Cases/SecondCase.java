package Cases;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class SecondCase {
    static WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;
    JavascriptExecutor js;


    public SecondCase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
        this.js = (JavascriptExecutor) driver;
    }

    By searchBox = By.xpath("//input[@id='suggestion-search']");
    By searchbutton = By.xpath("(//div[@class='sc-ezyZrH gNJKGK searchResult__constTitle'][normalize-space()='Parasite'])[1]");
  static By Director = By.xpath("//div[@class='sc-9a2a0028-10 iUfJXd']//li[1]//div[1]//ul[1]//li[1]//a[1]");
   static By Writers1 = By.xpath("//div[@class='sc-9a2a0028-10 iUfJXd']//li[2]//div[1]//ul[1]//li[1]//a[1]");
 static  By Writers2 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Han Jin-won']");
  static By Stars1 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Song Kang-ho']");
   static By Stars2 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Lee Sun-kyun']");
static By Stars3 = By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'][normalize-space()='Cho Yeo-jeong']");
  By galleryButton = By.xpath("//*[name()='path' and contains(@d,'M4.8 14h2.')]");

    public void clickSearchBox() {
        driver.findElement(searchBox).click();

    }

    public void writingMovieName() {
       elementHelper.sendKey(searchBox,"Parazit");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       driver.findElement(searchbutton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hero__primary-text']")));
    }

    public void getInfoNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hero__primary-text']")));
        WebElement Stars = driver.findElement(By.xpath("//div[@class='sc-70a366cc-3 iwmAOx']//a[@aria-label='See full cast and crew'][normalize-space()='Stars']"));
        js.executeScript("arguments[0].scrollIntoView(true);",Stars);
        String Text1 = driver.findElement(Director).getText();
        System.out.println("Director: " + Text1);
        String Text2 = driver.findElement(Writers1).getText();
        System.out.println("First writer: " + Text2);
        String Text3 = driver.findElement(Writers2).getText();
        System.out.println("Second writer: " + Text3);
        String Text4 = driver.findElement(Stars1).getText();
        System.out.println("Firs star: " + Text4);
        String Text5 = driver.findElement(Stars2).getText();
        System.out.println("Second star: " + Text5);
        String Text6 = driver.findElement(Stars3).getText();
        System.out.println("Third star: " + Text6);

    }

    public void comparesName() {
      By firstdirectorname = FirstCase.director;
      String Firsttext = driver.findElement(firstdirectorname).getText();
      By seconddirectorname = SecondCase.Director;
      String Secondtext = driver.findElement(seconddirectorname).getText();
      Assert.assertEquals(Firsttext,Secondtext);
    }

    public void clickGallery() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement photosbutton = driver.findElement(By.cssSelector("div[data-testid='photos-title'] h3[class='ipc-title__text']"));
        js.executeScript("arguments[0].scrollIntoView(true);",photosbutton);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3[@class='ipc-title__text'])[2]")));
        photosbutton.click();
        System.out.println("Tıklandı");

        driver.findElement(galleryButton).click();
    }

    public void verifyPhotoLinks() {

        List<WebElement> images = driver.findElements(By.tagName("img"));


        for (WebElement img:images) {
            String imageUrl = img.getAttribute("src");

            if(imageUrl== null || imageUrl.isEmpty()) {
                System.out.println("Resim URLi boş" +img);
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("❌ Kırık resim bulundu: " + imageUrl + " | HTTP Durumu: " + responseCode);
                } else {
                    System.out.println("✅ Resim çalışıyor: " + imageUrl + " | HTTP Durumu: " + responseCode);
                }
                connection.disconnect();
            } catch (IOException e) {
                System.out.println("❌ Bağlantı hatası: " + imageUrl);
            }
        }
    }
}
