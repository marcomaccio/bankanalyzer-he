package name.marmac.bankanalyzer.services.rest.tests.ua;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

/**
 * Created by marcomaccio on 11/11/2015.
 */
public class UTRetrieveBankAccountsStepDef {

    private Map<String,String> usernameAndPassword;

    /**
     *
     * @param arg1
     * @throws Throwable
     */
    @Given("^the username and password$")
    public void the_username_and_password(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    /**
     *
     * @throws Throwable
     */
    @When("^the client request a list of bankaccount$")
    public void the_client_request_a_list_of_bankaccount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /**
     *
     * @param arg1
     * @throws Throwable
     */
    @Then("^the response is a list containing (\\d+) bankaccounts$")
    public void the_response_is_a_list_containing_bankaccounts(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
