package Operation;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {
    
	WebDriver driver;
    
    public UIOperation(WebDriver driver){
        this.driver = driver;
    }
    
    public void perform(Properties p,String operation,String objectName,String objectType,String value) throws Exception{
        
    	System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICK":
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            Thread.sleep(2000);
            break;
        case "SETTEXT":
            driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
            Thread.sleep(2000);
            break;
        case "GOTOURL":
            driver.get(p.getProperty(value));
            Thread.sleep(2000);
            break;
        case "GETTEXT":
            driver.findElement(this.getObject(p,objectName,objectType)).getText();
            Thread.sleep(000);
            break;
        default:
            break;
        }
    }

    private By getObject(Properties p, String objectName, String objectType) throws Exception{
    	
        if(objectType.equalsIgnoreCase("XPATH"))
            return By.xpath(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("CLASSNAME"))
            return By.className(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("NAME"))
            return By.name(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("CSS"))
            return By.cssSelector(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("LINK"))
            return By.linkText(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("PARTIALLINK"))
            return By.partialLinkText(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("ID"))
            return By.id(p.getProperty(objectName));
        else
            throw new Exception("Invalid object type.");
    }
}