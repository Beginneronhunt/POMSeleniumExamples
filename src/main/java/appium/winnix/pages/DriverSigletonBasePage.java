package appium.winnix.pages;

import io.appium.java_client.windows.WindowsDriver;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DriverSigletonBasePage {
	private static WindowsDriver nixSession;
	private static Wait<WindowsDriver> wait;


	private DriverSigletonBasePage(){
		// prevent instantiation
	}

	public static WindowsDriver getWindowsDriver(){
		if(nixSession == null){
			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(
						"app",
						"C:\\Program Files (x86)\\42Gears\\Nix Agent\\SureMDM Agent.exe"
						);
				capabilities.setCapability("platformName", "Windows");
				capabilities.setCapability("automationName", "Windows");
				capabilities.setCapability("deviceName", "WindowsPC");
				nixSession =
						new WindowsDriver(
								new URL("http://172.16.201.225:4723"),
								capabilities
								);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return nixSession;
	}
	public static Wait<WindowsDriver> getFluentWait(){
		if(wait == null){
			wait = new FluentWait<>(nixSession)
					.withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(1))
					.ignoring(NoSuchElementException.class)
					.withMessage("TimeOut: 60 Seconds Over");
		}
		return wait;
	}
}


