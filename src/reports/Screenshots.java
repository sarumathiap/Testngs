package reports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	public static String getScreenshot(WebDriver driver, String shotname )throws Exception {
		//String data= new SimpleDateFormat("ddmmyyyy").format(new Date());
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
		
			String dest =System.getProperty(("user.dir")+"/",shotname+".png");

			File finaldest=new File(dest);
			 FileUtils.copyFile(src,finaldest);
				System.out.println(dest);
			return dest;
		}
}
