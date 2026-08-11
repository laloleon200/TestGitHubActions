package pruebasMaven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.time.Duration;

import pruebasMaven.registroDerechos;//se importa el proyecto.clase

class TestRegistroDerechos {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeEach
    public void setUp() {
    	ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOpts);
        
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //String filePath = "src/main/resources/DerechosAdquiridosForm.html";
        //String filePath = "C:\\Users\\ranfl\\Downloads\\Curso de automatizacion SeleniumJava\\Documentacion curso/DerechosAdquiridosForm.html";
        
        File htmlFile = new File("src/main/resources/DerechosAdquiridosForm.html");
        driver.get(htmlFile.toURI().toString());
        		
        //driver.get(filePath);
       // driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    	@Test
		void testEditarConfiguracióndeDerechosAdquiridos() {
			
			registroDerechos derechos = new registroDerechos(driver);
			
			derechos.seleccionarBotonEditar();
			derechos.seleccionarServicio("Seguro de Vida");
			derechos.seleccionarMotivo("Jubilación");
			derechos.seleccionarTipoAhorro("Todos");
			derechos.seleccionarPorcentaje("75");
			derechos.seleccionarAntiguedadMinima("5 años");
			derechos.seleccionarAntiguedadMaxima("70");
			derechos.seleccionarBotonGuardar();
			assertEquals("La Configuración de Derechos Adquiridos se ha actualizado exitosamente", derechos.elMensajeMostrado());
			
			/*
			WebElement botonEditarDerecho = wait.until(ExpectedConditions.visibilityOfElementLocated(
					//By.cssSelector("button[class*='btn-primary']")));
					By.xpath("//table[@id='tablaConfiguraciones']//tbody/tr[1]//button[contains(text(),'Editar')]")));//pregunter como saber armar elxpat
			botonEditarDerecho.click();

			new Select(driver.findElement(By.id("selectServicio"))).selectByValue(servicio);
			new Select(driver.findElement(By.id("selectMotivo"))).selectByValue(motivo);
			new Select(driver.findElement(By.id("selectTipoAhorro"))).selectByValue(tipo);
		
			driver.findElement(By.id("txtPorcentaje")).clear();
			driver.findElement(By.id("txtPorcentaje")).sendKeys(porcentaje);
		
			driver.findElement(By.id("txtAntiguedadMin")).clear();
			driver.findElement(By.id("txtAntiguedadMin")).sendKeys(antigMinima);
		
			driver.findElement(By.id("txtAntiguedadMax")).clear();
			driver.findElement(By.id("txtAntiguedadMax")).sendKeys(antigMaxima);
		
		
			WebElement botonGuardar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnGuardarConfig")));
			botonGuardar.click();
			
			WebElement alertaEditarConfiguracion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mensajeAlerta")));
			assertEquals("La Configuración de Derechos Adquiridos se ha actualizado exitosamente", alertaEditarConfiguracion.getText());
        	*/			        

		}
}
