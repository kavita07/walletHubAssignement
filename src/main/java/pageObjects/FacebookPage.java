package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class FacebookPage extends BasePage {

	String emailId;
	String profileName;

	public FacebookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/input[@id=\"email\"]")
	WebElement registeredEmailAddressTextBox;


	@FindBy(xpath = "//input[@id='pass']")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@id='loginbutton']")
	WebElement logInButton;
	
	@FindBy(xpath = "//span[contains(text(),\"What's on your mind\")]")
	WebElement postSection;
	
	
	@FindBy(xpath = "//div[div[contains(text(),\"What's on your mind\")]]//p")
	WebElement postTextBox;
	
	
	@FindBy(xpath = "//span[text()=\"Post\"]")
	WebElement postButton;
	// Actions to be performed

	public void enterRegisteredEmailId(String email) {
		type(registeredEmailAddressTextBox, email);
	}

	public void enterPasswordForLogin(String pwd) {
		type(passwordTextBox, pwd);
	}

	public void loginToApp() {
		click(driver, logInButton);
		try {
			 profileName = readPropertiesFile(fbConfigFilePath, "profileName");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isProfileNameDisplaed() {
		return isDisplayed(driver, driver.findElement(By.xpath("//span[text()="+profileName+"]")));
	}
	
	public void postMessage(String text) {
		click(driver, postSection);
		type(postTextBox, text);
		click(driver,postButton);
	}

	public boolean isTextDisplayed(String text) {
		return isDisplayed(driver, driver.findElement(By.xpath("//div[text()=\""+text+"\"]")));	}
}
