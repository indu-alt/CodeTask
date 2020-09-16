package CodeChallenge;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException, IOException {

		 // For Chrome
		System.setProperty("webdriver.chrome.driver","E:\\Indu\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
  	
      String baseUrl = "http://www.makemytrip.com/";
      // launch browser and direct it to the Base URL
      driver.get(baseUrl);
      driver.manage().window().maximize();
     // from CITY
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label")).click();
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("Delhi");
      driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
      // TO CITY
       Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Bengalore");
        driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]")).click();
      // Depature date
        Thread.sleep(1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
     	Calendar cal = Calendar.getInstance();
     	System.out.println("Current Date: "+sdf.format(cal.getTime()));
     	//Number of Days to add
         cal.add(Calendar.DAY_OF_MONTH, 30);  
     	//Date after adding the days to the current date
     	String newDate = sdf.format(cal.getTime());  
     	System.out.println("30 days later Date: "+ newDate);
        cal.set(Calendar.DAY_OF_MONTH, 30); 
	 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[4]/div/p[1]")).click();
    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/p/a")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id=\"section--wrapper\"]/div[1]/div[3]/div/div[1]/div/span[2]/label/div/div/p[1]")).click();
    String Price=driver.findElement(By.xpath("//*[@id=\"section--wrapper\"]/div[1]/div[3]/div/div/div/p/span[1]/span")).getText();
    System.out.println("Lowest Flight price"+ Price);
    //Adding screenshot
    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scr, new File("E:\\Indu\\Indu\\abcd.jpg"));
	System.out.println("Execution completed");
  //close browser
  driver.close();
      }

}
