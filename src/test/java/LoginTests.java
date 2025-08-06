import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import page_objects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTests{

  private LoginPage loginPage;

  @BeforeEach
  public void loadPage(){
    driver.get("https://www.selenium.dev/selenium/web/login.html");
    loginPage = new LoginPage(driver);

  }

  @Test
  public void testSuccessfulLogin(){
    String message = loginPage.login("username","password");
    assertEquals("You have successfully logged in.", message);
  }

  @Test 
  public void loginWithNoUsername(){
    String message = loginPage.login("", "password");
    assertEquals("Please enter valid credentials", message);
  }




}