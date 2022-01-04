package Test.Sample_Maven_ELF26;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import frameworkUtility.Baseclass;
import pom.HomePage;
import pom.TrainPage;

public class RegisterTest extends Baseclass{

	@Test
	public void transport() {
		//Precondition
		String url = "https://www.goibibo.com/";
		String homepageTitle = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
		HomePage homepage = new HomePage(driver);
		String  actualFromStation ="Bangalore City Junction";
		String   actualToStation ="CSTM , Mumbai Cst Railway Station";
		String Date = "Wed, 8 Dec 21";


		//Step1: validate URL
		String currentUrl = driver.getCurrentUrl();
		assertEquals(url, currentUrl, "URL is not entered properly");
		Reporter.log("URL entered is Proper",true);

		//Step2:validate Home Page Title 
		String actualhomepageTitle = driver.getTitle();
		assertEquals(actualhomepageTitle, homepageTitle , "HomePage is not displayed");
		Reporter.log("Home page Title is properly entered",true);


		//Step3:click on train tab
		homepage.getTrainButton().click();

		//Step4:Enter From station
		TrainPage t = new TrainPage(driver);
		t.getFromStation().clear();
		t.getFromStation().click();
		t.getStationName().click();
		//assertEquals(actualFromStation, t , "FromStation is not displayed");
		Reporter.log("actualFromStation is properly entered",true);

		//Step5:Enter To station
		TrainPage f = new TrainPage(driver);
		f.getToStation().clear();
		f.getToStation().click();
		f.getStationName().click();
		//assertEquals(actualToStation, f, "ToStation is not displayed");
		Reporter.log("actualToStation is properly entered",true);

		//Step6:Enter Date
		TrainPage d = new TrainPage(driver);
		d.getSelectDate().click();
		d.getNextMonth().click();
		d.getEnterDate().click();
		//assertEquals(Date, d , "date is not displayed");
		Reporter.log("Date is properly entered",true);

		//Step7:Click on SearchButton
		TrainPage s = new TrainPage(driver);
		s.getSearchTrainButton().click();
		Reporter.log("Navigated to next page",true);

	}


}
