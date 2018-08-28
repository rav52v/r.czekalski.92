package main.utils;

import org.openqa.selenium.support.PageFactory;

public abstract class PageFactorySuper {

	public PageFactorySuper() {
		PageFactory.initElements(Driver.driver, this);
	}
}
