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


class registroDerechos {

	private final WebDriver driver;
	
	private final By botonEditar = By.xpath("//table[@id='tablaConfiguraciones']//tbody/tr[1]//button[contains(text(),'Editar')]");
	private final By selectServicio = By.id("selectServicio");
	private final By selectMotivo = By.id("selectMotivo");
	private final By selectTipoAhorro = By.id("selectTipoAhorro");
	private final By txtPorcentaje = By.id("txtPorcentaje");
	private final By txtAntiguedadMin = By.id("txtAntiguedadMin");
	private final By txtAntiguedadMax = By.id("txtAntiguedadMax");
	private final By botonGuardar = By.id("btnGuardarConfig");
	private final By mensajeMostrado = By.id("mensajeAlerta");
	
	//Constructor
	registroDerechos(WebDriver driver){
		this.driver = driver;
	}
	
	//Acciones
	void seleccionarBotonEditar (){
		driver.findElement(botonEditar).click();	
	}
	
	void seleccionarServicio (String servicio){
		driver.findElement(selectServicio).sendKeys(servicio);	
	}
	
	void seleccionarMotivo (String motivo){
		driver.findElement(selectMotivo).sendKeys(motivo);	
	}
	
	void seleccionarTipoAhorro (String tipoAhorro){
		driver.findElement(selectTipoAhorro).sendKeys(tipoAhorro);	
	}
	
	void seleccionarPorcentaje (String porcentaje){
		driver.findElement(txtPorcentaje).clear();	
		driver.findElement(txtPorcentaje).sendKeys(porcentaje);	
	}
	
	void seleccionarAntiguedadMinima (String antMinima){
		driver.findElement(txtAntiguedadMin).clear();
		driver.findElement(txtAntiguedadMin).sendKeys(antMinima);	
	}
	
	void seleccionarAntiguedadMaxima (String antMaxima){
		driver.findElement(txtAntiguedadMax).clear();
		driver.findElement(txtAntiguedadMax).sendKeys(antMaxima);	
	}
	
	void seleccionarBotonGuardar (){
		driver.findElement(botonGuardar).click();	
	}
	
	String elMensajeMostrado (){
		return driver.findElement(mensajeMostrado).getText();
	}

}
