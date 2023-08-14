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

	@Test(priority = 1, description = "Configure Nix Setting", enabled = true)
	public void testConfigureNix() throws InterruptedException {


		Boolean status = false;
		try {
			status = settingPageObj.isNixSettingsPageDisplayed();
		} catch (Exception ex) {
			System.out.println("Element not found: " + ex.getMessage());
		}

		if (status == true) {
			settingPageObj.clickOnAccountID();
			settingPageObj.addAccountId();
			settingPageObj.clickOnServerPath();
			settingPageObj.addServerPath();
			settingPageObj.enableNix();
			Thread.sleep(30000);
			homePageObj.goToNixHomePage();
			String nixServiceStatus = homePageObj.getNixServiceStatus();
			assertThat(nixServiceStatus).containsIgnoringCase("Online");
			nixSession.closeApp();
		} else {
			homePageObj.clickOnSettings();
			settingPageObj.clickOnAccountID();
			settingPageObj.addAccountId();
			settingPageObj.clickOnServerPath();
			settingPageObj.addServerPath();
			settingPageObj.enableNix();
			Thread.sleep(30000);
			homePageObj.goToNixHomePage();
			String nixServiceStatus = homePageObj.getNixServiceStatus();
			assertThat(nixServiceStatus).containsIgnoringCase("Online");
			nixSession.closeApp();
		}
	}

	@Test(priority = 2)
	public void testAppTitle() throws InterruptedException {
		Thread.sleep(5000);
		nixSession.launchApp();
		String agentName = homePageObj.getAppTitle();
		assertThat(agentName).isEqualTo("SureMDM Agent");
		nixSession.closeApp();
	}

	@Test(priority = 3)
	public void testDisableNix() throws InterruptedException {
		Thread.sleep(5000);
		nixSession.launchApp();
		homePageObj.clickOnSettings();
		settingPageObj.disableNix();
		Thread.sleep(10000);
		homePageObj.goToNixHomePage();
		String nixServiceStatus = homePageObj.getNixServiceStatus();
		assertThat(nixServiceStatus).containsIgnoringCase("Stopped");
		nixSession.closeApp();
	}

	@Test(priority = 4)
	public void testAddingPasswordToNix() throws InterruptedException {
		Thread.sleep(5000);
		nixSession.launchApp();
		Boolean status = false;
		try {
			status = settingPageObj.isNixSettingsPageDisplayed();
		} catch (Exception ex) {
			System.out.println("Element not found: " + ex.getMessage());
		}

		if (status == true) {
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
