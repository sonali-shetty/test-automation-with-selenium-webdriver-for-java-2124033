package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

@SuppressWarnings("unused")
public class LoginPage {
  
   private By usernamefield = By.id("username-field");
   private By passwordfield = By.id("password-field");
   private By loginButton = By.id("login-form-submit");

   private WebDriver driver;

   public LoginPage(WebDriver driver){
    this.driver=driver;
   }

   public void setUsername(String username){
    driver.findElement(usernamefield).sendKeys(username);
   }

   public void setPassword(String password){
    driver.findElement(passwordfield).sendKeys(password);
   }

   public String clickLoginButton(){
    driver.findElement(loginButton).click();

  Alert alert = driver.switchTo().alert();
  String message = alert.getText();
  alert.accept();
  System.out.println("Alert message: " + message);
  return message;
   }

   public String login(String username, String password){
    setUsername(username);
    setPassword(password);
    return clickLoginButton();
   }
}