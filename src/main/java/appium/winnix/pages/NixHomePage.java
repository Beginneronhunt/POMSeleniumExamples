package appium.winnix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.windows.WindowsDriver;

public class NixHomePage {

  private WindowsDriver nixSession = DriverSigletonBasePage.getWindowsDriver();
  private Wait<WindowsDriver> wait = DriverSigletonBasePage.getFluentWait();
    
    public void goToNixHomePage() {
          WebElement backButton = nixSession.findElement(
            By.xpath("//*[@AutomationId='SettingsView']/Button/Image")
          );
          backButton.click();
        }
        public void clickOnSettings() {
            WebElement settings = wait.until(
              ExpectedConditions.elementToBeClickable(
                nixSession.findElement(
                  By.xpath(
                    "//*[@AutomationId ='SettingsButton' and @ClassName='Button']"
                  )
                )
              )
            );
            settings.click();
          }
          public String getNixServiceStatus() {
            WebElement fetchNixStatus = nixSession.findElement(
              By.xpath("//*[@AutomationId='Status']")
            );
           String nixStatus = fetchNixStatus.getAttribute("Name");
            return nixStatus;
          }
          
          public String getAppTitle() {
            WebElement appTitle = nixSession.findElement(By.name("SureMDM Agent"));
            String agentName = appTitle.getAttribute("Name");
            return agentName;
          }
          
}
