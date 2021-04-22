package com.check.qa.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import com.check.qa.base.Base;

public class CheckTFMainPage extends Base {

	SoftAssert sofassrt=new SoftAssert();;

	// Find elements at run time

	@FindBy(xpath="//div[@class='c24-cookie-consent-notice-buttons clearfix']//a[contains(text(),'Akzeptieren')]")
	WebElement cookPopupBtn;

	@FindBy(xpath="//div[@class='product-panel    ' and  @id='200007']//a[contains(text(),'weiter')]")
	WebElement clickProductEnterBtn;

	@FindBy(xpath="//input[@class='c24-uli-input style-scope unified-login' and @id='cl_login']")
	WebElement emailTxtBox;

	@FindBy(xpath="//button[@class='c24-uli-button style-scope unified-login' and  @value='weiter']")
	WebElement enterBtn;

	@FindBy(xpath="//div[contains(text(),'Willkommen')]")
	WebElement verifyPageAfterEmailaddressEnter;

	@FindBy(xpath="//div[@class='c24-uli-bottom-title c24-uli-bottom-l-anonymous style-scope unified-login']//a[@class='c24-uli-cl-l-anonymous-trigger style-scope unified-login']")
	WebElement clickConasgstLink;

	@FindBy(xpath="//a[@class='sc-bdfBwQ sc-hKgILt jTtSWU gTLZXx styles__ButtonDialog-sc-1solng-2 focaaU']")
	WebElement clickFormbtn;

	@FindBy(xpath="//label[contains(text(),'Frau')]")
	WebElement fradbtn;

	@FindBy(xpath="//label[contains(text(),'Herr')]")
	WebElement mradbtn;

	@FindBy(xpath="//label[contains(text(),'Bitte wählen Sie Ihre Anrede aus.')]")
	WebElement valradtxt;

	@FindBy(xpath="//input[@name='GIVEN_NAME']")
	WebElement givenNametxtbx;

	@FindBy(xpath="//input[@name='LAST_NAME']")
	WebElement lastNametxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihren Vornamen an.')]")
	WebElement valgivenNametxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihren Nachnamen an.')]")
	WebElement vallastNametxtbx;

	@FindBy(xpath="//input[@name='DATE_OF_BIRTH']")
	WebElement datetxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihr Geburtsdatum an.')]")
	WebElement valdatetxtbx;

	@FindBy(xpath="//input[@name='PLACE_OF_BIRTH']")
	WebElement placetxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihren Geburtsort an.')]")
	WebElement valPlacetxtbx;

	@FindBy(xpath="//select[@name='MARITAL_STATUS']")
	WebElement Selectdrpdn;

	@FindBy(xpath="//label[contains(text(),'Bitte wählen Sie Ihren Familienstand aus.')]")
	WebElement valSelectdrpdn;

	@FindBy(xpath="//select[@name='NATIONALITY']")
	WebElement natSelectdrpdn;

	@FindBy(xpath="//label[contains(text(),'Bitte wählen Sie Ihre Staatsangehörigkeit aus.')]")
	WebElement valnatSelectdrpdn;

	@FindBy(xpath="//input[@name='POSTAL_CODE']")
	WebElement postCodeTxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihre Postleitzahl an.')]")
	WebElement valpostCodeTxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte überprüfen Sie Ihren Wohnort.')]")
	WebElement valpostCode2Txtbx;

	@FindBy(xpath="//input[@name='STREET']")
	WebElement strTxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie Ihre Meldeadresse an.')]")
	WebElement valstrTxtbx;

	@FindBy(xpath="//input[@name='HOUSE_NUMBER']")
	WebElement housenoTxtbx;

	@FindBy(xpath="//label[contains(text(),'Bitte geben Sie die Hausnummer Ihrer Meldeadresse an.')]")
	WebElement valhousenoTxtbx;

	@FindBy(xpath="//select[@name='HOUSING_SITUATION']")
	WebElement houseSitDrpdn;

	@FindBy(xpath="//label[contains(text(),'Bitte wählen Sie Ihre aktuelle Wohnsituation aus.')]")
	WebElement valhouseSitTxtbx;


	@FindBy(xpath="//input[@name='PHONENUMBER_MOBILE']")
	WebElement phonenoTxtbx;

	@FindBy(xpath="//label[contains(text(),'Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.')]")
	WebElement valphonenoTxtbx;

	@FindBy(xpath="//input[@name='CONTACT_EMAIL']")
	WebElement contemailTxtbx;

	@FindBy(xpath="//label[contains(text(),'Für den Versand der Antragsbestätigung benötigen wir Ihre E-Mail-Adresse.')]")
	WebElement valcontemailTxtbx;

	@FindBy(xpath="//h2[contains(text(),'Rechtliche Hinweise')]")
	WebElement verifyLastPageHeader;



	//Initialize WebElements mentioned in the current page
	public void initializeWebElement(){
		PageFactory.initElements(driver, this);
	}



	//Method to verify cookie name

	public String acceptCookie(){	

		Cookie cookie = null ;
		try
		{
			cookie = driver.manage().getCookieNamed("ppset");
			sofassrt.assertEquals(cookie.getValue(),"kreditkarte");
			sofassrt.assertAll();


		}catch(Exception e)
		{
			System.out.println(e);
		}

		return cookie.getValue();
	}

	//Method to accept cookie pop up and select first listed product
	public String clickFirstProductEnterButton(){
		try
		{
			cookPopupBtn.click();
			clickProductEnterBtn.click();

		}catch(Exception e)
		{
			System.out.println(e);
		}
		return driver.getTitle();
	}

	//Method to enter email address , click enter and verify after enter respective details are populated
	public String enterEmailAddressAndClickEnter(String userName){

		emailTxtBox.sendKeys(userName);
		JavascriptExecutor aa= (JavascriptExecutor) driver;
		aa.executeScript("arguments[0].click();", enterBtn);
		return verifyPageAfterEmailaddressEnter.getText();


	}

	//Method to select continue as a guest

	public Boolean selectLink()
	{
		Boolean verifyFormbtn=false;
		JavascriptExecutor ab= (JavascriptExecutor) driver;
		ab.executeScript("arguments[0].click();", clickConasgstLink);
		verifyFormbtn=clickFormbtn.isDisplayed();
		return verifyFormbtn;
	}


	//Method to click on enter button and verify Salutation field is blank
	public Boolean VerifyErrMsgForSalutation()
	{

		clickFormbtn.click();

		if (!fradbtn.isSelected() ||!mradbtn.isSelected()  ){
			String radacterrormsg =valradtxt.getText();
			sofassrt.assertEquals(radacterrormsg, "Bitte wählen Sie Ihre Anrede aus.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}
	}

	//Method to verify FirstName and LastName field is blank
	public Boolean VerifyErrMsgForFNandLN()
	{


		if (givenNametxtbx.getAttribute("value").equals("") && lastNametxtbx.getAttribute("value").equals("")||givenNametxtbx.getAttribute("value").equals("") ||lastNametxtbx.getAttribute("value").equals(""))
		{
			String givenNameerrmsg=valgivenNametxtbx.getText();
			sofassrt.assertEquals(givenNameerrmsg, "Bitte geben Sie Ihren Vornamen an.");

			String lastNameerrmsg=vallastNametxtbx.getText();
			sofassrt.assertEquals(lastNameerrmsg, "Bitte geben Sie Ihren Nachnamen an.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}

	}

	//Method to verify BirthDate field is blank
	public Boolean VerifyErrMsgForBirthDate()
	{

		if (datetxtbx.getAttribute("value").equals(""))
		{
			String dateErrmsg=valdatetxtbx.getText();
			sofassrt.assertEquals(dateErrmsg, "Bitte geben Sie Ihr Geburtsdatum an.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}


	}

	//Method to verify BirthPlace field is blank
	public Boolean VerifyErrMsgForBirthPlace()
	{

		if (placetxtbx.getAttribute("value").equals(""))
		{
			String dateErrmsg=valPlacetxtbx.getText();
			sofassrt.assertEquals(dateErrmsg,"Bitte geben Sie Ihren Geburtsort an.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}

	}

	//Method to verify Marital status field is blank
	public Boolean VerifyErrMsgForMaStatus()
	{

		if (!Selectdrpdn.isSelected())
		{

			String madrpdnErrmsg=valSelectdrpdn.getText();
			sofassrt. assertEquals(madrpdnErrmsg,"Bitte wählen Sie Ihren Familienstand aus.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;

		}

	}

	//Method to verify Nationality field is blank
	public Boolean VerifyErrMsgForNationality()
	{



		if (!natSelectdrpdn.isSelected())
		{

			String natdrpdnErrmsg=valnatSelectdrpdn.getText();
			sofassrt.assertEquals(natdrpdnErrmsg,"Bitte wählen Sie Ihre Staatsangehörigkeit aus.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}
	}



	//Method to verify Postal code and city field are blank
	public Boolean VerifyErrMsgForPostalCodeAndCity()
	{

		if (postCodeTxtbx.getAttribute("value").equals(""))
		{
			String postCodeErrmsg=valpostCodeTxtbx.getText();
			sofassrt.assertEquals(postCodeErrmsg,"Bitte geben Sie Ihre Postleitzahl an.");
			String postCode1Errmsg=valpostCode2Txtbx.getText();
			sofassrt.assertEquals(postCode1Errmsg,"Bitte überprüfen Sie Ihren Wohnort.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;

		}

	}

	//Method to verify Street No and city House address are blank
	public Boolean VerifyErrMsgForStreetNoAndHouseAdd()
	{

		if (strTxtbx.getAttribute("value").equals("") && housenoTxtbx.getAttribute("value").equals("")||strTxtbx.getAttribute("value").equals("") ||housenoTxtbx.getAttribute("value").equals(""))
		{
			String strErrmsg=valstrTxtbx.getText();
			sofassrt.assertEquals(strErrmsg, "Bitte geben Sie Ihre Meldeadresse an.");
			String housenoErrmsg=valhousenoTxtbx.getText();
			sofassrt.assertEquals(housenoErrmsg, "Bitte geben Sie die Hausnummer Ihrer Meldeadresse an.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;

		}

	}

	//Method to verify HouseSite field is  blank
	public Boolean VerifyErrMsgForHouseSite()
	{

		if (!houseSitDrpdn.isSelected())
		{

			String houseSitdrpdnErrmsg=valhouseSitTxtbx.getText();
			sofassrt. assertEquals(houseSitdrpdnErrmsg,"Bitte wählen Sie Ihre aktuelle Wohnsituation aus.");
			sofassrt.assertAll();
			return true;

		}

		else

		{
			return false;
		}

	}	

	//Method to verify PhnNo field is blank
	public Boolean VerifyErrMsgForPhnNo()
	{

		if (phonenoTxtbx.getAttribute("value").equals(""))
		{
			String phonenoErrmsg=valphonenoTxtbx.getText();
			sofassrt.assertEquals(phonenoErrmsg,"Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.");
			sofassrt.assertAll();

			return true;

		}

		else

		{
			return false;
		}


	}


	//Method to fill form details and after clicking on enter verify next page is displayed

	public String addDataInForm(String salutn,String firstName, String lastName,String birthDate ,String birthPlace,
			String maritalStatus ,String nationality, String PostalCity,String strNo,String Houseno,String HousSit,String Mobilno  )
	{

		if (salutn.equals("Frau"))
		{

			fradbtn.click();
		}

		else
		{
			mradbtn.click();

		}

		givenNametxtbx.sendKeys(firstName);

		lastNametxtbx.sendKeys(lastName);

		datetxtbx.sendKeys(birthDate);

		placetxtbx.sendKeys(birthPlace);

		Select maritalStatusSelect=new Select(Selectdrpdn);
		maritalStatusSelect.selectByVisibleText(maritalStatus);

		Select nationalitySelect=new Select(natSelectdrpdn);
		nationalitySelect.selectByVisibleText(nationality);

		postCodeTxtbx.sendKeys(PostalCity);

		strTxtbx.sendKeys(strNo);

		housenoTxtbx.sendKeys(Houseno);

		Select houseSitSelect=new Select(houseSitDrpdn);
		houseSitSelect.selectByVisibleText(HousSit);

		phonenoTxtbx.sendKeys(Mobilno);

		clickFormbtn.click();

		return verifyLastPageHeader.getText();

	}





}
