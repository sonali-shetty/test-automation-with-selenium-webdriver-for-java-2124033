package browser_interactions;

import org.openqa.selenium.Cookie;

import setup.Main;

public class Cookies extends Main {

  public static void main(String[] args) {
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    Cookie cookie = new Cookie("theme","light");
    driver.manage().addCookie(cookie);
    //to access the cookies.
   Cookie cookieTheme = driver.manage().getCookieNamed("theme");
   String domain = cookieTheme.getDomain();
   System.out.println(domain);

   driver.manage().deleteCookie(cookieTheme);
    System.out.println(driver.manage().getCookies().size());



    driver.quit();
  }
}