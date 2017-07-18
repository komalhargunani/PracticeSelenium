import java.awt.AWTException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.testcases.CommonUtility;

public class MouseHoverTest {
	
	public WebDriver driver;
	Properties prop;
	
	@BeforeMethod()
	public void setup(){
		
     driver=CommonUtility.setupFirefoxBrowser();
		
	}
	

	@Test
	public void performMouseHover() throws Exception{
		
		prop=CommonUtility.readPropertyFile();	
		driver.get(prop.getProperty("MouseHoverURL"));
		
		Actions action = new Actions(driver);
		WebElement element = null;
        
 
	     driver.findElement(By.xpath(prop.getProperty("XpathDepartment"))).click();
		List<WebElement> deptlist = driver.findElements(By.xpath("//span[@class='nav-text']"));
		
		Thread.sleep(1000);
		
		   for (int i=0; i<deptlist.size(); i++){
	            if (deptlist.get(i).getText().trim().equals("Home, Garden & Tools")){
	            	
	            	
	            	
	            System.out.println("++++++++++"+ deptlist.get(i).getText());
	            break;
	            }
	            else{
	            	System.out.println("+++++out+++");
	            }
	               
	        }
		   
		   System.out.println("departmentlist" +deptlist.size());
		   
		  /* System.out.println("deptmenu" +element.getText());
		   action.moveToElement(element).build().perform();
           
           
           WebElement subElement = driver.findElement(By.xpath(".//span[contains(text(),'All-New Fire 7 ')]"));
           
           action.moveToElement(subElement);
    
           action.click();
    
           action.perform();
           
		
		System.out.println("departmentlist" +deptlist.size());*/
		
	}
	
@AfterMethod
	
	public void closeBrowser(){
	
	
		CommonUtility.tearDown();
	}


}
