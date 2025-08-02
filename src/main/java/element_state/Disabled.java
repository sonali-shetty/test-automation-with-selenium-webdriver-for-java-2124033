package element_state;

import setup.Main;
import org.openqa.selenium.By;

public class Disabled extends Main {

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");

   boolean isEnabled = driver.findElement(By.name("my-disabled")).isEnabled();
    if (isEnabled){
      System.out.println("enabled");
    }else{
      System.out.println("disabled");
    }
    driver.quit();
  }
}
