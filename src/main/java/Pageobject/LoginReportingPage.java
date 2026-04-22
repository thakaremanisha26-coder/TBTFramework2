package Pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginReportingPage extends BaseClass{

	public LoginReportingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(name  = "email")
	WebElement emails;
	
	@FindBy(name = "password")
	WebElement passwords;
	
	@FindBy(css  = "button[type='submit")
     WebElement login;
	
	
	
	public void loginPageMethods(String name, String name1) {
		emails.sendKeys(name);
		passwords.sendKeys(name1);
		login.click();
	}
	
	@FindBy(xpath = "//button[@class=\"clide-v2-i-btn clide-v2-mob-hide d-flex justify-content-center align-items-center p-0 lh-1\"]")
	WebElement PlusButton;

	@FindBy(xpath = "(//div[@class=\"dropdown-item border-bottom \"])[6]")
	WebElement TBTclick;

	public void ClickOnPlusorTBT() {
		PlusButton.click();
		TBTclick.click();
	}

	public void UploadImage(String image) throws InterruptedException {
		// add image
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate hidden file input
		WebElement fileInput = wait1.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//input[@accept=\".jpg, .jpeg, .png, .mp4, .mkv, .wav, .omv\"])[1]")));
		// Upload file
		Thread.sleep(5000);
		fileInput.sendKeys(image);
	}

	@FindBy(xpath = "(//div[@class=\" css-yk16xz-control\"])[1]")
	WebElement Topic;

	@FindBy(xpath = "//div[@id=\"react-select-2-option-8\"]")
	WebElement InsideTpoics;

	@FindBy(xpath = "//textarea[@class=\"slds-textarea\"]")
	WebElement What_Cover_Description;

	public void Select_Topics(String description) {
		Topic.click();
		InsideTpoics.click();
		What_Cover_Description.sendKeys(description);
	}

	public void AllDropdown() throws InterruptedException {
		// select SERVICE
		WebElement services = driver.findElement(By.xpath("(//select[@class=\"slds-select\"])[1]"));
		Select service = new Select(services);
		service.selectByValue("19");
		System.out.println(service.getFirstSelectedOption().getText());

		// select PROJECT
		Thread.sleep(2000);
		WebElement projects = driver.findElement(By.xpath("(//select[contains(@class,'slds-select')])[2]"));
		Select project = new Select(projects);
		project.selectByValue("137");
		System.out.println(project.getFirstSelectedOption().getText());

		// select DEPARTMENT
		Thread.sleep(2000);
		WebElement departments = driver.findElement(By.xpath("(//select[contains(@class,'slds-select')])[3]"));
		Select department = new Select(departments);
		department.selectByValue("1");
		System.out.println(department.getFirstSelectedOption().getText());

		// select ZONE
		WebElement zones = driver.findElement(By.xpath("(//select[contains(@class,'slds-select')])[4]"));
		Select zone = new Select(zones);
		zone.selectByValue("10");
		// zone.selectByValue("115");
		System.out.println(zone.getFirstSelectedOption().getText());

		// select LOCATION
		Thread.sleep(2000);
		WebElement locations = driver.findElement(By.xpath("(//select[contains(@class,'slds-select')])[5]"));
		Select location = new Select(locations);
		location.selectByValue("27");
		System.out.println(location.getFirstSelectedOption().getText());

		// SELECT ACTIVITY
		WebElement activitys = driver.findElement(By.xpath("(//select[contains(@class,'slds-select')])[6]"));
		Select activity = new Select(activitys);
		activity.selectByValue("13");

	}
	
  //CONDUCTED FOR
	@FindBy (xpath = "(//label[@class=\"slds-checkbox__label\"])[1]")
	WebElement employee;
	
	@FindBy (xpath = "(//label[@class=\"slds-checkbox__label\"])[2]")
	WebElement contractor;
	
	public void ClickOn_ConductedFor() {
		employee.click();
		contractor.click();
	}
	
	//ADD ATTENDENCE
	@FindBy (xpath = "//input[@name=\"employee_attendees_count\"]")
	WebElement employeeAttendence;
	
	@FindBy (xpath = "//input[@name=\"contractor_attendees_count\"]")
	WebElement contractorAttencence;
	
	@FindBy (xpath = "//input[@placeholder=\"Enter Faculty Name\"]")
	WebElement faculty_Name;
	
	@FindBy (xpath = "//input[@name=\"male_attendees_count\"]")
	WebElement male_Attendence;
	
	@FindBy (xpath = "//input[@name=\"female_attendees_count\"]")
	WebElement femal_Attendence;
	
	public void Enter_Attence(String empAtte,String conAtte,String faculty, String maleAtt, String femelAtt) {
		employeeAttendence.sendKeys(empAtte);
		contractorAttencence.sendKeys(conAtte);
		faculty_Name.sendKeys(faculty);
		male_Attendence.sendKeys(maleAtt);
		femal_Attendence.sendKeys(femelAtt);
	}
	
	
	public void EnterActivSearchEmployee() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class=\" css-1wa3eu0-placeholder\"])[1]")).click();
		Actions act1 = new Actions(driver);
		act1.sendKeys("M").perform();
		Thread.sleep(2000);
		act1.sendKeys(Keys.TAB).perform();
		// curser change one place to other place
		act1.sendKeys(Keys.TAB).perform();
		act1.sendKeys("S").perform();
		Thread.sleep(2000);
		act1.sendKeys(Keys.TAB).perform();

	}
	@FindBy (xpath = "//button[text()=\"Report\"]")
	WebElement ReportButton;
	
	@FindBy (xpath = "(//button[@class=\"red-btn\"])[1]")
	WebElement gotodashboard;	
	public void ClickOnReportButton_GOTOdashboard() {
		ReportButton.click();
		gotodashboard.click();
	}
	
	public void Refresh() {
    	driver.navigate().refresh();
    }
	
	//CLICK ON DAHBOARD TITTLE
	
	@FindBy (xpath = "(//label[@class=\"fw-bold clide-v2-scroll-title clide-v2-secondary-color mb-0\"])[1]")
	WebElement dashboard_Tittle;
	
		
	public void dashboardTittle() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		// click dashboard title
		dashboard_Tittle.click();
	}
	
	//CLICK ON EDIT
	
	@FindBy (xpath = "//button[@class=\"border-0 bg-transparent p-0\"]")
	WebElement edit;
	
	@FindBy (xpath = "//input[@class=\"form-control common-black-1 font-weight-500\"]")
	WebElement edit_FacultyClear;
	
	@FindBy (xpath = "//input[@class=\"form-control common-black-1 font-weight-500\"]")
	WebElement edit_Faculty;
	
	@FindBy (xpath = "(//button[@class=\"clide-v2-icon-btn\"])[1]")
	WebElement save;
	
	
	public void ClickOn_Edit(String faculty) {
		edit.click();
		edit_FacultyClear.clear();
		edit_Faculty.sendKeys(faculty);
		save.click();
		
	}

	

	
	
	
	

}
