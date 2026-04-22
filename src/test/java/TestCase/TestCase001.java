package TestCase;



import org.testng.annotations.Test;

import Pageobject.LoginReportingPage;
import TestBase.Testbase;

public class TestCase001 extends Testbase{
	
	@Test(priority = 1)
	public void LoginReportingPage() throws InterruptedException {
		LoginReportingPage lp=new LoginReportingPage(driver);
		lp.loginPageMethods(prop.getProperty("user_ID"), prop.getProperty("password"));
		Thread.sleep(5000);
		
	
	    lp.ClickOnPlusorTBT();
		lp.UploadImage(prop.getProperty("imagePath"));
		lp.Select_Topics(prop.getProperty("description"));
		lp. AllDropdown();
		lp.ClickOn_ConductedFor();
		lp.Enter_Attence(prop.getProperty("employeeAttendence"), prop.getProperty("contractorAttendence"), prop.getProperty("faculty_Name"),prop.getProperty("male_Attendence"),prop.getProperty("femel_Attendence"));
		lp.EnterActivSearchEmployee();
		lp.ClickOnReportButton_GOTOdashboard();
		lp.Refresh();
		Thread.sleep(3000);
		lp.dashboardTittle();
		lp.ClickOn_Edit(prop.getProperty("edit_facuty"));
		
		}
	
	
	
	
	
}