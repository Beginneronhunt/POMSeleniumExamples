package appium.winnix.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import appium.winnix.pages.NixHomePage;
import appium.winnix.pages.NixSettingPage;

public class NixHomeTest extends BaseTest {

	NixSettingPage settingPageObj = new NixSettingPage();
	NixHomePage homePageObj = new NixHomePage();

	@Test(priority = 1, description = "Verify Enrolling Nix to SwastikConsole")
	public void testConfigureNix() throws InterruptedException {

		Boolean status = false;
		try {
			status = settingPageObj.isNixSettingsPageDisplayed();
		} catch (Exception ex) {
			System.out.println("Element not found: " + ex.getMessage());
		}

		if (status) {
			settingPageObj.clickOnAccountID()
			.addAccountId()
			.clickOnServerPath()
			.addServerPath()
			.enableNix();
			Thread.sleep(30000);
			homePageObj.goToNixHomePage();
			String nixServiceStatus = homePageObj.getNixServiceStatus();
			assertThat(nixServiceStatus).containsIgnoringCase("Online");
			nixSession.closeApp();

		} else {
			homePageObj.clickOnSettings();
			settingPageObj.clickOnAccountID()
			.addAccountId()
			.clickOnServerPath()
			.addServerPath()
			.enableNix();
			Thread.sleep(30000);
			homePageObj.goToNixHomePage();
			String nixServiceStatus = homePageObj.getNixServiceStatus();
			assertThat(nixServiceStatus).containsIgnoringCase("Online");
			nixSession.closeApp();
		}
	}

	@Test(priority = 2, description = "Verify Nix App Title")
	public void testAppTitle() throws InterruptedException {
		nixSession.launchApp();
		Thread.sleep(5000);
		String agentName = homePageObj.getAppTitle();
		assertThat(agentName).isEqualTo("SureMDM Agent");
		nixSession.closeApp();
	}

	@Test(priority = 3, description = "Verify disabling Nix Service")
	public void testDisableNix() throws InterruptedException {
		nixSession.launchApp();
		Thread.sleep(5000);
		homePageObj.clickOnSettings();
		settingPageObj.disableNix();
		Thread.sleep(10000);
		homePageObj.goToNixHomePage();
		String nixServiceStatus = homePageObj.getNixServiceStatus();
		assertThat(nixServiceStatus).containsIgnoringCase("Stopped");
		nixSession.closeApp();
	}

	@Test(priority = 4, description = "Verify adding Nix settings password", enabled = false)
	public void testAddingPasswordToNix() throws InterruptedException {
		Thread.sleep(5000);
		Boolean status = false;
		try {
			status = settingPageObj.isNixSettingsPageDisplayed();
		} catch (Exception ex) {
			System.out.println("Element not found: " + ex.getMessage());
		}

		if (status) {
			settingPageObj.setPassword();
		} else {
			homePageObj.clickOnSettings();
			settingPageObj.setPassword();
			settingPageObj.clickOnAccountID();
			settingPageObj.addAccountId();
			settingPageObj.clickOnServerPath();
			settingPageObj.addServerPath();
			settingPageObj.enableNix();
			Thread.sleep(1000);
			nixSession.closeApp();
		}
	}
}
