import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Primero{
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try{
            dr.get("https://demoqa.com/text-box");
            dr.manage().window().maximize();
            JavascriptExecutor js = (JavascriptExecutor) dr;

            js.executeScript("document.body.style.zoom = '75%'");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("Laura Martínez");
            dr.findElement(By.id("userEmail")).sendKeys("laura@gmail.com");
            dr.findElement(By.id("currentAddress")).sendKeys("Calle 25 # 10-20");
            dr.findElement(By.id("permanentAddress")).sendKeys("Carrera 15 # 30-40");

            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            js.executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    submit
            );

            submit.click();

            String nombre = dr.findElement(By.id("name")).getText();
            System.out.println(nombre);
            String correo = dr.findElement(By.id("email")).getText();
            System.out.println(correo);
            String direccion = dr.findElement(By.cssSelector("p[id = 'currentAddress']")).getText();
            System.out.println(direccion);
            String direccionActual = dr.findElement(By.cssSelector("p[id = 'permanentAddress'")).getText();
            System.out.println(direccionActual);

            if (nombre.contains("Laura Martínez")
                    && correo.contains("laura@gmail.com")
                    && direccion.contains("Calle 25 # 10-20")
                    && direccionActual.contains("Carrera 15 # 30-40")){
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