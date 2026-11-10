import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tercero {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://www.selenium.dev/selenium/web/web-form.html");
            dr.manage().window().maximize();
            JavascriptExecutor js = (JavascriptExecutor) dr;

            js.executeScript("document.body.style.zoom = '75%'");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id"))).sendKeys("ADSO");

            dr.findElement(By.name("my-password")).sendKeys("Sena2026");
            dr.findElement(By.name("my-textarea")).sendKeys("Automatización con Selenium");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Received!"));

            String result = dr.findElement(By.id("message")).getText();
            System.out.println("El resultado fue: "+result);
            if (result.equals("Received!")){
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            dr.quit();
        }
    }
}
