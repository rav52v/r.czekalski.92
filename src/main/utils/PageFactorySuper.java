package main.utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public abstract class PageFactorySuper {
	@Parameters({"explorer"})
	public PageFactorySuper(String explorer) {
		PageFactory.initElements(Driver.getDriver(explorer), this);
	}
}
