package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HBFSavePage {
	WebDriver driver;

	public HBFSavePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "firstname") 
	private WebElement txtbx_FirstName;

	@FindBy(how = How.ID, using = "lastname") 
	private WebElement txtbx_LastName;


	@FindBy(how = How.ID, using = "totalprice") 
	private WebElement txtbx_TotalPrice;

	@FindBy(how = How.ID, using = "depositpaid") 
	private WebElement select_DepositPaid;

	@FindBy(how = How.ID, using = "checkin") 
	private WebElement txtbx_CheckIn;

	@FindBy(how = How.ID, using = "checkout") 
	private WebElement txtbx_CheckOut;


	@FindBy(how = How.XPATH, using = "//input[contains(@value,'Save')]") 
	private WebElement btn_Save;




	public void enter_FirstName(String firstname) {
		txtbx_FirstName.sendKeys(firstname);
	}

	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void clickOn_Save() throws InterruptedException {
		//btn_Save.click();
		btn_Save.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}

	public void enter_TextInPrice(String totalprice) {

		txtbx_TotalPrice.sendKeys(totalprice);

	}

	public void select_InDepositPaid(String deppaid) {

		Select depPaid = new Select(select_DepositPaid);
		depPaid.selectByVisibleText(deppaid);

	}

	public void enter_DateInCheckIn(String checkindate) {

		txtbx_CheckIn.sendKeys(checkindate);

	}

	public void enter_DateInCheckOut(String checkoutdate) {

		txtbx_CheckOut.sendKeys(checkoutdate);

	}


	public void fill_PersonalDetails(String FirstName, String LastName, String Price, String DepositPaid, String CheckIn, String CheckOut) {
		enter_FirstName(FirstName);
		enter_LastName(LastName);
		enter_TextInPrice(Price);
		select_InDepositPaid(DepositPaid);
		enter_DateInCheckIn(CheckIn);
		enter_DateInCheckOut(CheckOut);
	}




}
