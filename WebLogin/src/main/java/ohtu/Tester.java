package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Tester {
    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
        WebDriver driver = new ChromeDriver();
        
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(1);
        
        correctUsernameWrongPassword(driver, element);
        unlegitimateAccount(driver, element);
        createNewUserAccount(driver, element);
        logoutUser(driver, element);
        
        sleep(1);
        driver.quit();
    }

    public static void correctUsernameWrongPassword(WebDriver driver, WebElement element) {
        // failed login: correct username, wrong password
        sleep(1);
        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(2);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep1");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.click();
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        sleep(2);
    }
    
    public static void unlegitimateAccount(WebDriver driver, WebElement element) {
        // failed login: correct username, wrong password
        sleep(1);
        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkatus");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep123");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.submit();
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        sleep(1);
    }
    
    public static void createNewUserAccount(WebDriver driver, WebElement element) {
        // failed login: correct username, wrong password
        sleep(1);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        element = driver.findElement(By.name("username"));
        element.sendKeys("eerotttt");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salainen1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salainen1");
        element = driver.findElement(By.name("signup"));
        
        sleep(1);
        element.submit();
        sleep(1);
    }
    
    public static void logoutUser(WebDriver driver, WebElement element) {
        // failed login: correct username, wrong password
        sleep(1);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(1);
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
