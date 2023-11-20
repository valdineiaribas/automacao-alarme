package helpers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class AppiumDriverHelper {

	private static AppiumDriverLocalService server;
	private static AppiumDriver driver;

	@BeforeAll
	private static void setUpServer() {
		server = new AppiumServiceBuilder().usingPort(4723).withArgument(() -> "--base-path", "/").build();
		server.start();
	}

	@AfterAll
	private static void tearDownServer() {
		if (server != null) {
			server.stop();
		}
		server = null;
	}

	@Before
	private static void setUpDriver() {
		driver = getDriver();

	}

	@After
	private static void tearDownDriver() {
		if (driver != null) {
			driver.quit();
		}

		driver = null;
	}

	public static AppiumDriver getDriver() {
		if (driver == null) {
			driver = generateDriver();
		}
		return driver;
	}

	public static AppiumDriver generateDriver() {
		AppiumDriver driver = null;
		try {
			driver = new AppiumDriver(getURL(), getCapabilities());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver;

	}

	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("deviceName", "Emulador");
		capabilities.setCapability("appPackage", "com.google.android.deskclok");
		capabilities.setCapability("appActivity", "com.android.deskclok.DeskClok");
		return capabilities;
	}

	public static URL getURL() throws MalformedURLException {
		return new URL("http://127.0.0.1:4723/");
	}
}
