package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioSteps {
    HomeSteps homeSteps = new HomeSteps();
    MailSteps mailSteps = new MailSteps();


    @When("^выбран пункт меню \"(.+)\"$")
    public void stepSelectTopMenu(String menuItem) {
        homeSteps.stepSelectTopMenu(menuItem);


    }

    @When("^вводит логин\"(.+)\"$")
    public void stepTypeLogin(String value) throws InterruptedException {
        homeSteps.stepTypeLogin(value);

    }
    @When("^вводит пароль\"(.+)\"$")
    public void stepTypePassword(String value) throws InterruptedException {
        homeSteps.stepTypePassword(value);

    }
    @Then("^получает количество непрочитанных сообщений$")
    public void stepGetCountUnreadMessages() {
        mailSteps.stepGetCountUnreadMessages();

    }

    @When("^помечает сообщения прочитанными$")
    public void stepMarkUnreadMessage() throws InterruptedException {
        mailSteps.stepMarkUnreadMessage();

    }
}
