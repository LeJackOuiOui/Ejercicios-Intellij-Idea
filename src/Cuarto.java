import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cuarto {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/buttons");
            dr.manage().window().maximize();
            JavascriptExecutor js = (JavascriptExecutor) dr;

            js.executeScript("document.body.style.zoom = '75%'");

            Actions actions = new Actions(dr);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));
            WebElement doubleClickBtn = dr.findElement(By.id("doubleClickBtn"));

            actions.doubleClick(doubleClickBtn).perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

            String message = dr.findElement(By.id("doubleClickMessage")).getText();

            System.out.println("El resultado fue: "+message);
            if (message.equals("You have done a double click")){
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            dr.quit();
        }
        }
}
