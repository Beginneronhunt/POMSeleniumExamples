package appium.winnix.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.windows.WindowsDriver;

public class NixSettingPage {

	private WindowsDriver nixSession = DriverSigletonBasePage.getWindowsDriver();
	private Wait<WindowsDriver> wait = DriverSigletonBasePage.getFluentWait();

	public void disableNix() {
		WebElement disableNix = nixSession.findElement(
				By.xpath("//*[@AutomationId='EnableNix']")
				);
		disableNix.click();
	}

	public void enableNix() {
		WebElement enableNix = nixSession.findElement(
				By.xpath("//*[@AutomationId='EnableNix']")
				);
		enableNix.click();
	}

	public Boolean isNixSettingsPageDisplayed() {
		Boolean backBtnIcon = false;
		WebElement homePage = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(
								By.xpath("//*[@AutomationId='SettingsView']/Button/Image")
								)
						)
				);

		backBtnIcon = homePage.isDisplayed();
		return backBtnIcon;
	}

	public NixSettingPage clickOnAccountID() {
		WebElement accountID = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(
								By.xpath(
										"//*[@AutomationId='AccountIdSumary' and @ClassName='TextBlock']"
										)
								)
						)
				);
		accountID.click();
		return this;
	}

	public NixSettingPage addAccountId() {
		WebElement newAccountID = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(
								By.xpath(
										"//*[@AutomationId='AccountIdView']//*[@AutomationId='NewAccountID']"
										)
								)
						)
				);
		newAccountID.click();
		newAccountID.clear();
		newAccountID.sendKeys("082200043");
		WebElement okAccountBtn = nixSession.findElement(
				By.xpath("//*[@AutomationId='AccountIdView']//Button[@Name='OK']")
				);
		okAccountBtn.click();
		return this;
	}

	public NixSettingPage clickOnServerPath() {
		WebElement serverPath = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(
								By.xpath("//*[@Name='Server Path' and @ClassName='TextBlock']")
								)
						)
				);
		serverPath.click();
		return this;
	}

	public NixSettingPage addServerPath() {
		WebElement newServerPath = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(
								By.xpath(
										"//*[@AutomationId='ServerPathView']//*[@AutomationId='NewServerPath']"
										)
								)
						)
				);
		newServerPath.click();
		newServerPath.clear();
		newServerPath.sendKeys("swastikinternational.suremdm.io");
		WebElement okServerPathBtn = nixSession.findElement(
				By.xpath("//*[@AutomationId='ServerPathView']//Button[@Name='OK']")
				);
		okServerPathBtn.click();
		return this;
	}

	public void setPassword() {
		WebElement setPasswordInput = nixSession.findElement(
				By.xpath("//*[@Name='Set Password' and @ClassName='TextBlock']")
				);
		setPasswordInput.click();
		By enterPasswordInput = By.xpath(
				"//*[@AutomationId='PasswordChangeView']//*[@AutomationId='newPassword' and @ClassName='PasswordBox']"
				);
		By confirmPasswordInput = By.xpath(
				"//*[@AutomationId='PasswordChangeView']//*[@AutomationId='confirmation' and @ClassName='PasswordBox']"
				);
		WebElement enterPasswordBox = nixSession.findElement(enterPasswordInput);
		enterPasswordBox.click();
		enterPasswordBox.clear();
		enterPasswordBox.sendKeys("India@123#");

		WebElement confirmPasswordBox = nixSession.findElement(
				confirmPasswordInput
				);
		confirmPasswordBox.click();
		confirmPasswordBox.clear();
		confirmPasswordBox.sendKeys("India@123#");
		WebElement okSetNixPasswordBtn = nixSession.findElement(
				By.xpath("//*[@AutomationId='PasswordChangeView']//Button[@Name='OK']")
				);
		okSetNixPasswordBtn.click();
		By setPasswordOkBtn = By.xpath(
				"//*[@ClassName='#32770']/*[@AutomationId='2']"
				);
		WebElement setPasswordDialougeBtn = wait.until(
				ExpectedConditions.elementToBeClickable(
						nixSession.findElement(setPasswordOkBtn)
						)
				);
		setPasswordDialougeBtn.click();
	}
	
}
