package browser_interactions;

import setup.Main;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.remote.RemoteWebElement;

public class Screenshots extends Main {

  public static void main(String[] args) {
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    var browsingcontext = new BrowsingContext(driver, driver.getWindowHandle());

    

    // FULL PAGE
    
    String fullScreenshot = browsingcontext.captureScreenshot();
    saveScreenshot(fullScreenshot, "fullScreenshot.png");
    // ELEMENT
    WebElement mycolors = driver.findElement(By.name("my-colors"));
    String internalElementId = ((RemoteWebElement) mycolors).getId();
    String elementScreenshot = browsingcontext.captureElementScreenshot(internalElementId);
    saveScreenshot(elementScreenshot, "elementScreenshot.png");
    // VIEWPORT
    driver.findElement(By.name("my-date")).click();
    var datePicker = driver.findElement(By.className("datepicker")).getRect();
    String viewPortScreenshot = browsingcontext.captureBoxScreenshot(datePicker.getX(),
     datePicker.getY(), datePicker.getWidth(), datePicker.getHeight());
     saveScreenshot(viewPortScreenshot, 
     "viewPortScreenshot.png");
    
    driver.quit();
  }

  private static void saveScreenshot(String screenshot, String filename) {
    var decodedScreenshot = Base64.getDecoder().decode(screenshot);
    try {
      String path = "/workspaces/test-automation-with-selenium-webdriver-for-java-2124033/screenshots/";
      Files.write(Paths.get(path + filename), decodedScreenshot);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}