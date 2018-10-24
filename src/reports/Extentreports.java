package reports;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreports
{
    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;
     
    @BeforeTest
    public void init()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/STMExtentReport.html", true);
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml")); 
    }
     
    @Test
    public void captureScreenshot()
    {
        test = extent.startTest("captureScreenshot");
        System.setProperty("webdriver.gecko.driver","/home/sarumathi/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.automationtesting.in");
        String title = driver.getTitle();
        Assert.assertEquals("Home-Selenium Webdriver Appium", title);
        test.log(LogStatus.PASS, "Test Passed");
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws Exception
    {
    	System.out.println(result.getStatus());
    	//System.out.println(ITestResult.FAILURE);
        if(result.getStatus() == ITestResult.FAILURE)
        {
        	//File file = new File("/home/sarumathi/eclipse-workspace/TestsngProjects/img.png");
          //String screenShotPath = file.getAbsolutePath();
          String screenShotPath=  Screenshots.getScreenshot(driver, result.getName()); 
         
          test.log(LogStatus.FAIL, result.getThrowable());
          test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        }
        extent.endTest(test);
    }
     
         
    @AfterTest
    public void endreport()
    {
        driver.close();
       
        extent.flush();
        extent.close();
        driver.quit();
    }
}