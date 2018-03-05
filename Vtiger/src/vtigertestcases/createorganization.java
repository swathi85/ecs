package vtigertestcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class createorganization {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\swathireddyv\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://classroom:8888/");
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		Actions AC=new Actions(Driver);
		//-----------------------------------------------------------
		//verify home page displayed 

		if(Driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM")) 
		{
			System.out.println("homepage is displayed");
		}

		else
		{
		    System.out.println("home page not displayed");
		    return;
		}

		//----------------------------------------------------------------------------------------------------
		//creating web elements

		WebElement objUN=Driver.findElement(By.name("user_name"));
		WebElement objPWD=Driver.findElement(By.name("user_password"));
		WebElement objLogin=Driver.findElement(By.id("submitButton"));
		//------------------------------------------------------------------------------------------------------
		//verify username displayed

		if(objUN.isDisplayed()) 
		{
			System.out.println("User Name displayed");
		}
		//verify password displayed

		if(objPWD.isDisplayed())
		{
		   System.out.println("Password displayed");
		}
		//verify Login and Clear displayed

		if(objLogin.isDisplayed())
		{
		   System.out.println("Login  displayed");
		}
		//------------------------------------------------------------------------------------------------------

		String SUN="qaplanet1";
		String SPWD="user1";
		//-----------------------------------------------------------------------------------------------------
		
		objUN.clear();
		objUN.sendKeys(SUN);
		objPWD.clear();
		objPWD.sendKeys(SPWD);
		//----------------------------------------------------------------------------------------------------
		objLogin.click();
		ArrayList<String> AL=new ArrayList<String>();
		AL.add("Calendar");
		AL.add("Leads");
		AL.add("Organizations");
		AL.add("Contacts");
		AL.add("Opportunities");
		AL.add("Products");
		AL.add("Documents");
		AL.add("Email");
		AL.add("Trouble Tickets");
		AL.add("Dashboard");
		Iterator<String> it=AL.iterator();
		while(it.hasNext())
		{
			String text=it.next();
			System.out.println(text);
					
		}
		
		Driver.findElement(By.linkText("Organizations")).click();
		
			Driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		if(Driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/span")).getText().equals("Creating New Organization"))
				{
			System.out.println("Cerate home page displayed");
				}
		Driver.findElement(By.xpath("//input[@value='  Save")).click();
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		if(A.getText().equals("Organization Name cannot be empty"))
		{
			System.out.println("Alert1 present");
			A.accept();
		}
		
		DateFormat df=new SimpleDateFormat("dd_MM_yyyy_mm_ss");
		
		Date d=new Date();
		
		String time=df.format(d);
		
		System.out.println(time);
Driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("swathi");


	}

}
