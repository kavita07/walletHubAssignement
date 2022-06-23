package stepDefinitions;

import java.io.IOException;
import org.junit.Assert;
import base.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WalletHubPage;

public class WalletHubStepDefinitions extends BasePage {
	
	WalletHubPage whPage;

	@Before
	public void setUp1() throws IOException {
		//launchApp(whConfigFilePath);
		whPage = new WalletHubPage();
	}
	
	@When("User launches WalletHub URL")
	public void User_opens_WalletHub_URL() throws Throwable {
		Assert.assertEquals(readPropertiesFile(whConfigFilePath, "title"), navigateToURL(whConfigFilePath));
	}
	
	@And("User navigate to login page and enters credentials for WalletHub login")
	public void User_enter_userName_password() throws IOException {
		whPage.enterCredentials(readPropertiesFile(whConfigFilePath, "EmailId"), readPropertiesFile(whConfigFilePath, "password"));
	}
	
	@Then("Verify user login to wallethub successfully")
	public void Verify_user_login_successfull() {
		Assert.assertTrue(whPage.isProfileMenuDisplayed());
	}
	
	@When("User hovers over four star")
	public void User_ohovers_over_four_star() throws Throwable {
		whPage.mouseOver();
	}
	
	@Then("Verify star ligheten up")
	public void Verify_star_ligheten_up() {
		Assert.assertTrue(whPage.isStarLighted());
	}
	
	@When("User clicks on four star")
	public void clicks_on_four_star() throws Throwable {
		whPage.clickOnFourStar();
	}
	
	@When("User selects policy drodown value {string}")
	public void User_selects_policy_drodown_value(String text) throws Throwable {
		whPage.selectPolicyDropDownValue(text);
	}
	
	@When("User writes review with minimum 200")
	public void User_writes_review() throws Throwable {
		whPage.writeReview();
	}
	
	@When("User clicks on submit review button")
	public void clicks_on_submit_review_button(String text) throws Throwable {
		whPage.clickOnSubmitButton();
	}
	
	@Then("Verify review posted successfully")
	public void Verify_review_posted_successfully() {
		Assert.assertTrue(whPage.isSuccessMessageDisplayed());
	}
	
	@When("User selects profile menu value {string}")
	public void User_selects_profile_menu_value(String text) throws Throwable {
		whPage.selectPolicyDropDownValue(text);
	}
	
	@Then("Verify review displaying")
	public void Verify_review_displaying() {
		Assert.assertTrue(whPage.isReviewDisplayed());
	}
	
	
	
	
	
	
	
	

}
