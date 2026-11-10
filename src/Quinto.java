import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Quinto {

    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {

            dr.get("https://demoqa.com/webtables");
            dr.manage().window().maximize();

            WebElement botonAgregar = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("addNewRecordButton")
                    )
            );
            botonAgregar.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")))
                    .sendKeys("Carlos");

            dr.findElement(By.id("lastName")).sendKeys("Ramírez");

            dr.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");

            dr.findElement(By.id("age")).sendKeys("25");

            dr.findElement(By.id("salary")).sendKeys("2500000");

            dr.findElement(By.id("department")).sendKeys("Sistemas");

            WebElement botonGuardar = dr.findElement(By.id("submit"));

            ((org.openqa.selenium.JavascriptExecutor) dr)
                    .executeScript("arguments[0].click();", botonGuardar);

            WebElement buscador = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("searchBox")
                    )
            );
            buscador.sendKeys("Carlos");

            wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(
                            By.tagName("body"),
                            "Carlos"
                    )
            );

            String datos = dr.findElement(By.tagName("body")).getText();

            System.out.println(datos);

            if (datos.contains("Carlos")
                    && datos.contains("Ramírez")
                    && datos.contains("carlos@gmail.com")
                    && datos.contains("25")
                    && datos.contains("2500000")
                    && datos.contains("Sistemas")) {

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