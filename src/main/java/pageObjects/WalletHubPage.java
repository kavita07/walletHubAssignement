package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class WalletHubPage extends BasePage{
	
	public WalletHubPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=\"Login\"]")
	WebElement loginLink;
	
	@FindBy(xpath = "//h1[text()=\"Login\"]")
	WebElement loginPageHeader;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//button/span[text()=\"Login\"]")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[@class=\"nav-txt\"][text()=\"Reviews\"]")
	WebElement reviewSection;
	
	@FindBy(css = "write-review [aria-label=\"4 star rating\"]")
	WebElement fourStar;
	
	@FindBy(css = "write-review [aria-checked=\"true\"]")
	WebElement starLighted;
	
	@FindBy(xpath = "//div[@class=\"dropdown second\"]/span[@class=\"dropdown-placeholder\"]")
	WebElement policyDropDown;
	
	@FindBy(xpath = "//*[@class=\"textarea wrev-user-input validate\"]")
	WebElement writeReviewTextArea;
	
	@FindBy(xpath = "//div[contains(text(),\"Submit\")]")
	WebElement submitButton;
	
	@FindBy(xpath = "//h4[text()=\"Your review has been posted.\"]")
	WebElement successMessage;
	
	@FindBy(xpath = "//div[@class=\"brgm-button brgm-user brgm-list-box\"]")
	WebElement profileMenu;
	
	@FindBy(xpath = "//div/review-star")
	WebElement updatedReview;
	
	public void clickOnLoginLink() {
		click(driver, loginLink);
	}
	
	public boolean isLoginPageDisplayed() {
		return isDisplayed(driver, successMessage);
	}
	
	public void enterCredentials(String id, String pwd) {
		clickOnLoginLink();
		type(emailTextBox, id );
		type(passwordTextBox, pwd );
		clickOnLoginButton();
	}
	
	public void clickOnLoginButton() {
		click(driver, loginButton);
	}
	
	public boolean isProfileMenuDisplayed() {
		return isDisplayed(driver, profileMenu);
	}
	
	public void mouseOver() {
		hoverOverElement(fourStar);
	}
	
	public boolean isStarLighted() {
		return isDisplayed(driver, starLighted);
	}
	
	public void clickOnFourStar() {
		click(driver, fourStar);
	}
	
	public void selectPolicyDropDownValue(String text) {
		click(driver, policyDropDown);
		WebElement element = (WebElement) By.xpath("//li[text()="+text+"]");
		click(driver, element);
	}
	
	public void writeReview() {
		String text = generateRandomString(200);
		type(writeReviewTextArea, text );
	}
	
	public void clickOnSubmitButton() {
		click(driver, submitButton);
	}
	
	public boolean isSuccessMessageDisplayed() {
		return isDisplayed(driver, 	successMessage);
	}
	
	public void selectProfileDropDownMenu(String text) {
		click(driver, profileMenu);
		WebElement element = (WebElement) By.xpath("//div[contains(@class,\\\"brgm-user-list\\\")]/a[text()=\\\"+text+\"\\\"");
		click(driver, element);
	}
	
	public boolean isReviewDisplayed() {
		return isDisplayed(driver, updatedReview);
	}

}
