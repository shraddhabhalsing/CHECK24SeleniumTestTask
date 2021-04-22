package com.check.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.check.qa.base.Base;
import com.check.qa.page.CheckTFMainPage;
import com.check.qa.util.CommonUtil;

public class CheckTFMainTest extends Base {

	//Create Object of MainPage where OR and methods are maintained
	CheckTFMainPage mainPageObj=new CheckTFMainPage();

   // 
	public static ExtentHtmlReporter pathHtml;
	public static ExtentReports exReport;
	public static ExtentTest exLog,exLog1,exLog2,exLog3,exLog4,exLog5,exLog6;
	
	
    // constructor to call Base class constructor
	CheckTFMainTest(){
		super();
	}
	
	//Prerequisite steps to be executed prior executing actual TestCases

	@BeforeTest
	public void basicSetUp()
	{
		DriversetUp();
		pathHtml=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\main\\java\\com\\check\\qa\\reporting\\ExtentReport.html");
		exReport=new ExtentReports();
		exReport.attachReporter(pathHtml);

	}

	// Launch URL TestCase

	@Test(priority=1)
	public void launchURL(){
		String pageTitle=LaunchBrowser();
		mainPageObj.initializeWebElement();
		exLog=exReport.createTest("open the check24 credit card result page under", "Automation");
		if (pageTitle.equals("Kreditkarte - jetzt die passende Kreditkarte finden | CHECK24"))
		{
			exLog.log(Status.PASS,"URL is launched successfully") ;
		}

		else

		{
			exLog.log(Status.FAIL,"Failed to launch URL") ;
		}
	}




	//Verify Cookie name in response header TestCase

	@Test(priority=2)
	@Parameters({"cookieValue"})
	public void verifyCookieDetails(String cookieValue ){
		String vCookieSetInResponse=mainPageObj.acceptCookie();
		exLog1=exReport.createTest("check whether the cookie `ppset=kreditkarte` is set in response headers.", "Automation");
		if (vCookieSetInResponse.equals(cookieValue))
		{
			exLog1.log(Status.PASS," Cookie `ppset=kreditkarte` found in response headers") ;
		}
		else

		{
			exLog1.log(Status.FAIL,"Failed to find Cookie `ppset=kreditkarte`  ") ;

		}
	}

	//Verify first product is selected then user is able to enter the email address and hit enter TestCase

	@Test(priority=3)
	@Parameters({"emailaddress"})
	public void clickFirstProductAndEnterEmail(String emailaddress){
		String verifyclickedOnEnter=mainPageObj.clickFirstProductEnterButton();
		exLog2=exReport.createTest("Click on the `weiter` button on the first of the listed products which has the number \"1\" on its panel (i.e. 1. Barclaycard Visa) ","Automation");
		if (verifyclickedOnEnter.equals("Jetzt die passende Kreditkarte finden | CHECK24"))
		{
			exLog2.log(Status.PASS,"Successfully clicked on enter button of the first listed products") ;
		}
		else

		{
			exLog2.log(Status.FAIL,"Failed to licked on enter button of the first listed products") ;
		}

		String verifyPageafterEmailAddres=mainPageObj.enterEmailAddressAndClickEnter(emailaddress);
		exLog3=exReport.createTest("Fill in any email value and click weiter ","Automation");
		if (verifyPageafterEmailAddres.equals("Willkommen"))
		{
			exLog3.log(Status.PASS,"Successfully entered email address and clicked on enter button") ;
		}
		else

		{
			exLog3.log(Status.FAIL,"Failed to entered email address and clicked on enter button") ;
		}

	}

	//Verify user can continue as a guest TestCase

	@Test(priority=4)
	public void clickGuestAsLink(){
		Boolean verFormbtn=mainPageObj.selectLink();
		exLog4=exReport.createTest("Choose Ich mochte als Gast fortfahren ", "Automation");
		if (verFormbtn)
		{
			exLog4.log(Status.PASS,"Clicked on Ich mochte als Gast fortfahren successfully ") ;
		}
		else

		{
			exLog4.log(Status.FAIL," Failed to clicked on Ich mochte als Gast fortfahren ") ;
		}
	}

	//verify that the error messages are shown for all the empty fields TestCase

	@Test(priority=5)
	public void verifyErrMsgsForForm(){


		Boolean verifyRadbtnsnotselectedErrmsg=mainPageObj.VerifyErrMsgForSalutation();

		exLog5=exReport.createTest("Click on enter button and verify that the error messages are shown for all empty fields", "Automation");
		if (verifyRadbtnsnotselectedErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for Salutation field") ;
		}
		else

		{
			exLog5.log(Status.FAIL," Failed to  display error message for Salutation field ") ;

		}
		
		Boolean checkFNandLNErrmsg=mainPageObj.VerifyErrMsgForFNandLN();

		if (checkFNandLNErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for FirstName and LastName field") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for FirstName and LastName field ") ;

		}

		Boolean checkBirthDateErrmsg=mainPageObj.VerifyErrMsgForBirthDate();
		if (checkBirthDateErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for BirthDate") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for BirthDate ") ;

		}

		Boolean checkBirthPlaceErrmsg=	mainPageObj.VerifyErrMsgForBirthPlace();
		if (checkBirthPlaceErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for BirthPlace") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for BirthPlace ") ;

		}
		
		Boolean checkMaStatusErrmsg=mainPageObj.VerifyErrMsgForMaStatus();
		if (checkMaStatusErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for Marital Status") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for Marital Status ") ;

		}
		
		Boolean checkNationalityErrmsg=	mainPageObj.VerifyErrMsgForNationality();
		if (checkNationalityErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for Nationality") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for Nationality ") ;

		}
		
		Boolean checkPostalCodeAndCityErrmsg=	mainPageObj.VerifyErrMsgForPostalCodeAndCity();
		if (checkPostalCodeAndCityErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for PostalCodeAndCity field") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for PostalCodeAndCity field ") ;

		}
		
		Boolean checkStreetNoAndHouseAddErrmsg=	mainPageObj.VerifyErrMsgForStreetNoAndHouseAdd();
		if (checkStreetNoAndHouseAddErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for StreetNoAndHouseAdd field") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for StreetNoAndHouseAdd field ") ;

		}
		
		Boolean checkHouseSiterrmsg=	mainPageObj.VerifyErrMsgForHouseSite();
		if (checkHouseSiterrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for HouseSite field") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for HouseSite field ") ;

		}
		
		Boolean checkPhnNoErrmsg=	mainPageObj.VerifyErrMsgForPhnNo();
		if (checkPhnNoErrmsg)
		{
			exLog5.log(Status.PASS,"Error message displayed as expected for PhnNo field") ;
		}
		else

		{
			exLog5.log(Status.FAIL,"  Failed to  display error message for PhnNo field ") ;

		}


	}

    //Fill in all fields with valid values, click on `weiter` button again and the next form page should appear without any error message TestCase
	
	@DataProvider
	public Object[][] passSheet()
	{
		Object[][] val=CommonUtil.readDataFromExcel("InputData");
		return val;
	}

	@Test(priority=6,dataProvider="passSheet")
	public void insertDatainForm(String salutn,String firstName, String lastName,String birthDate ,String birthPlace,
			String maritalStatus ,String nationality, String PostalCity,String strNo,String Houseno,String HousSit,String Mobilno  )
	{

		String vHeader= mainPageObj.addDataInForm(salutn, firstName, lastName, birthDate, birthPlace, maritalStatus, nationality, PostalCity, strNo, Houseno, HousSit, Mobilno);


		exLog6=exReport.createTest("fill in all fields with valid values, click on `weiter` button again and the next form page should appear without any error message.", "Automation");
		if (vHeader.equals("Rechtliche Hinweise"))
		{
			exLog6.log(Status.PASS,"Form submitted successfully") ;
		}
		else

		{
			exLog6.log(Status.FAIL," Failed to submit the form ") ;

		}

	}

	//Close browser

	@AfterTest
	public void closeBrowser() {
		exReport.flush();
		driver.close();



	}
}
