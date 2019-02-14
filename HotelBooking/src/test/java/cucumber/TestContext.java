package cucumber;

import managers.PageObjectEEManager;
import managers.WebDriverEEManager;

public class TestContext {
	private WebDriverEEManager webDriverEEManager;
	private PageObjectEEManager pageObjectEEManager;


	public TestContext(){
		webDriverEEManager = new WebDriverEEManager();
		pageObjectEEManager = new PageObjectEEManager(webDriverEEManager.getEEDriver());
	}

	public WebDriverEEManager getWebDriverEEManager() {
		return webDriverEEManager;
	}

	public PageObjectEEManager getPageObjectEEManager() {
		return pageObjectEEManager;
	}


}