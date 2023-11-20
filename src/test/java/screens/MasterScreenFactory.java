package screens;

import org.openqa.selenium.support.PageFactory;

import helpers.AppiumDriverHelper;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MasterScreenFactory {

//	public static AlarmeScreen getAlarmeScreen() {
//		AlarmeScreen alarmeScreen = new AlarmeScreen();
//		PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverHelper.getDriver()), alarmeScreen);
//		return alarmeScreen;
//	}

	public static <T> T getPage(Class<T> cls) {
		T page;
		try {
			page = cls.newInstance();
			PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverHelper.getDriver()), page);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return page;
	}

}
