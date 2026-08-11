package pruebasMaven;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
import java.io.File;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
public class TestGitHup2 {
 
    private WebDriver driver;
 
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
 
        driver = new ChromeDriver(options);
    }
 
    @Test
    public void testFormularioLocal() {
        
        File htmlFile = new File("src/main/resources/index.html");
        driver.get(htmlFile.toURI().toString());
 
        // 3. Interactuar con los elementos del HTML
        WebElement inputUser = driver.findElement(By.id("username"));
        inputUser.sendKeys("Eduardo");
 
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@id='submit-btn']"));
        btnSubmit.click();
 
        WebElement resultMsg = driver.findElement(By.id("result-message"));
        
        // 4. Validar el resultado
        String text = resultMsg.getText();
        assertTrue(text.startsWith("Hola, ") && text.endsWith("! Registro exitoso."));
    }
 
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

