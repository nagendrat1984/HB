package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;


public class WebDriverEEManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverEEManager() {
		driverType = FileReaderEEManager.getInstance().getEEConfigReader().getBrowser();
		environmentType = FileReaderEEManager.getInstance().getEEConfigReader().getEnvironment();
	}

	public WebDriver getEEDriver() {
		if(driver == null) driver = createEEDriver();
		return driver;
	}

	private WebDriver createEEDriver() {
		switch (environmentType) {	    
		case LOCAL : driver = createEELocalDriver();
		break;
		case REMOTE : driver = createEERemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createEERemoteDriver() {
		throw new RuntimeException("To implement in future. Since this is a test project that I am working on for Equal Experts, not investing time now to create remote driver");
	}

	private WebDriver createEELocalDriver() {
		switch (driverType) {	    
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderEEManager.getInstance().getEEConfigReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER : driver = new InternetExplorerDriver();
		break;
		}

		if(FileReaderEEManager.getInstance().getEEConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderEEManager.getInstance().getEEConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	




	public void closeEEDriver() {
		driver.close();
		driver.quit();
	}

}