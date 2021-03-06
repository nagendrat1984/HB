package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderEEManager;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderEEManager.getInstance().getEEConfigReader().getApplicationUrl());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	public void zoomInZoomOut(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + FileReaderEEManager.getInstance().getEEConfigReader().getZoomSize() +"'");
	}



}