package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FacebookPage;

public class FacebookStepDefinition extends BasePage {

	FacebookPage facebookPage;

	@Before
	public void setUp() throws IOException {
		launchApp(fbConfigFilePath);
		facebookPage = new FacebookPage();
	}

	@When("User launches facebook URL")
	public void User_opens_URL() throws Throwable {
		Assert.assertEquals(readPropertiesFile(fbConfigFilePath, "title"), navigateToURL(fbConfigFilePath));
	}

	@And("User enters user name and password for facebook login")
	public void User_enters_userName_password() throws IOException {
		facebookPage.enterRegisteredEmailId(readPropertiesFile(fbConfigFilePath, "EmailId"));
		facebookPage.enterPasswordForLogin(readPropertiesFile(fbConfigFilePath, "password"));
	}

	@And("User clicks on SignIn button")
	public void User_clicks_on_SignIn_button() {
		facebookPage.loginToApp();
	}
	
	@Then("Verify user login successfull")
	public void Verify_user_login_successfull() {
		Assert.assertTrue(facebookPage.isProfileNameDisplaed());
	}
	
	@And("User posts message {string}")
	public void User_posts_message(String message) throws Throwable {
		facebookPage.postMessage(message);
	}
	
	@Then("Verify text {string} displayed")
	public void Verify_text_displayed(String message) {
		Assert.assertTrue(facebookPage.isTextDisplayed(message));
	}

	@After
	public void tearDown() throws IOException {
		logger.info("********** CLOSING BROWSER **********");
		driver.quit();
	}
}
