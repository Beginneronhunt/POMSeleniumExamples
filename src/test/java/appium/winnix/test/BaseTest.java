package appium.winnix.test;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static appium.winnix.pages.DriverSigletonBasePage.getWindowsDriver;
import static appium.winnix.pages.DriverSigletonBasePage.getFluentWait;

public class BaseTest {

	WindowsDriver nixSession;
	Wait<WindowsDriver> wait;
	String nixStatus;

	@BeforeSuite
	public void setUp() {
		nixSession = getWindowsDriver();

		wait = getFluentWait();
	}


	@AfterSuite
	public void tearDown() {
		nixSession.quit();
	}
}
