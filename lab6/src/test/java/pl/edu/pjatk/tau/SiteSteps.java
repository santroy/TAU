package pl.edu.pjatk.tau;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import pl.edu.pjatk.tau.Pages;

public class SiteSteps {

    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Login page")
    public void userOnLoginPage() {
        pages.carGarage().openPage();
    }

    @When("user inserts login: $login in login field")
    public void userInsertsLoginData(String login) {
        pages.carGarage().setUser(login);
    }

    @Then("user inserts password: $password in password field")
    public void userInsertsPasswordData(String password) { 
    	pages.carGarage().setPassword(password); 
    }

    @When("user clicks button with login option")
    public void userClicksButton() {
        pages.carGarage().submitLoginClick();
    }

    @Then("site responds failed login text in new site")
    public void siteDisplaysFailedLoginText() {
        pages.carGarage().getLoginFailedMessage();
    }
}