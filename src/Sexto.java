import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Sexto {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();

            WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            revealedInput.sendKeys("Prueba Selenium ADSO");

            String valorActual = revealedInput.getDomProperty("value");

            System.out.println("El texto es actual es: " + valorActual);
            System.out.println("El texto es correcto: Prueba Selenium ADSO");
            if (valorActual.equals("Prueba Selenium ADSO")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }

            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");
            FileHandler.copy(captura, destino);
            System.out.println("Captura guardada exitosamente como evidencia_selenium.png");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}