package test.nestle.createaccount;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.thoughtworks.selenium.DefaultSelenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest
{
	private static WebDriver driver;
	  public static final String USERNAME = "earlwillis1";
	  public String browser_type;
	  public  String name="Screenshot/" + timeStamp + "_" + "Successful-Contact-Submit.png";
	  public String baseUrl = "http://stage.coffee-mate.com";
		public static final String AUTOMATE_KEY = "XsPyFTirN4mH8aCLMB9A";
		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "infoqa.xls";	
		String myTitle;
	    String safe = "http://10.10.10.34:8080/job/TESTNG3/ws/PageLoads";	

    @Test
    public InputStream retrieve(String zip) throws Exception
    {
    	
        String url = "http://weather.yahooapis.com/forecastrss?p=" + zip;
        URLConnection conn = new URL(url).openConnection();
        System.out.println("I Picked " +zip);
       
        if (zip.equals("firefox")) {
    		  driver=browserFirefox();
    		}
    	  

    	  else if (zip.equals("chrome")) {
    		  driver=browserChrome();
    		}
    	  
    	  else if (zip.equals("ie9")) {
    		  driver=browserIE9();
    		}
    	  

    	  else if (zip.equals("iPad")) {
    		  driver=browserIpad();
    		}
    	  
    	  else if (zip.equals("Android")) {
    		  driver=browserAndroid();
    		}
        driver.get(baseUrl + "/Contact-Us.aspx");
	    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlReason"))).selectByVisibleText("General Inquiry or Question");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("PubmoTestFirst");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("PubmoTestLast");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).sendKeys("xxxxx@yahoo.com");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress1")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress1")).sendKeys("75 W. 10th Street");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress2")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress2")).sendKeys("Apt. 3B");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCity")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCity")).sendKeys("New York");
	    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlStates"))).selectByVisibleText("New York");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZip")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZip")).sendKeys("10003");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone1")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone1")).sendKeys("212");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone2")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone2")).sendKeys("222");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone3")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHomePhone3")).sendKeys("2222");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone1")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone1")).sendKeys("212");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone2")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone2")).sendKeys("456");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone3")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone3")).sendKeys("7890");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtComments")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtComments")).sendKeys("Please do not contact this test account.");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnSubmit")).click();
	    for (int second = 0;; second++) {
	    	
	    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Thanks for taking the time to get in touch with us[\\s\\S]*$")) break; } catch (Exception e) {}
	    	Thread.sleep(800);
	    }
	    
	    assertEquals(driver.getTitle(), "Contact Us | COFFEE-MATE�");

	    
	    takeScreen();
        return conn.getInputStream();
    }


    @Test
    public void testApp() throws InterruptedException, IOException
    {
    	
        
    }

    @AfterClass
    public void tearDown()
    {
        
    }
    public WebDriver browserFirefox() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run Firefox");
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		  caps.setCapability("browser", "FireFox");
		  caps.setCapability("browser_version", "22.0");
		  caps.setCapability("os", "Windows");
		  caps.setCapability("os_version", "7");
		  caps.setCapability("browserstack.debug", "true");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Firefox");
	      browser_type="firefox";
	      System.out.println("Let me see which one get tested" +browser_type);
	      System.out.println("Let me see which one get tested" +driver);
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      return driver;
	   
	    
	 }  

	 public WebDriver browserChrome() throws MalformedURLException  
	 {  
	  
		 browser_type="chrome";
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = DesiredCapabilities.firefox();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "32.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Chrome");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
	      return driver;
	   
	    
	 }  
	 
	 public WebDriver browserIE9() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "9.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run IE9");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
	      return driver;
	   
	    
	 }
	 
	 public WebDriver browserIpad() throws MalformedURLException  
	 {  
	  

		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "iPad");
		 caps.setCapability("platform", "MAC");
		 caps.setCapability("device", "iPad 3rd (7.0)");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Ipad");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
	      return driver;
	   
	    
	 }
	 
	 public WebDriver browserAndroid() throws MalformedURLException  
	 {  
	  
		
		 String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "android");
		 caps.setCapability("platform", "ANDROID");
		 caps.setCapability("device", "Samsung Galaxy Note 10.1");

		    driver = new RemoteWebDriver(new URL(URL), caps);
	      System.out.println("Let me run Android");
	      driver.get("http://stage.coffee-mate.com/Registration/Create-Account.aspx?email=" + timeStamp +"%40yahoo.com&stt=True");
	      
	      return driver;
	   
	    
	 }
	 public void takeScreen() throws IOException 
	 {
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		    System.out.println("Take a screenshot for  " +driver);
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		    myTitle = driver.getTitle();
		     System.out.println("Looking at the page " +myTitle);
		    FileUtils.copyFile(screenshot, new File(name));
		    
	 }
		    
}