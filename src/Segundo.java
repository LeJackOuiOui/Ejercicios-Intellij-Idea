import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Segundo {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://demoqa.com/radio-button");
            dr.manage().window().maximize();
            JavascriptExecutor js = (JavascriptExecutor) dr;

            js.executeScript("document.body.style.zoom = '75%'");

            WebElement impressiveRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("impressiveRadio")));
            impressiveRadio.click();
            boolean Selected;
            if (impressiveRadio.isSelected()){
                Selected = true;
            } else {
                Selected = false;
            }

            String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success"))).getText();

            System.out.println("El mensaje muestra: "+ message);
            if (message.equals("Impressive") && Selected){
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
