package name.marmac.bankanalyzer.services.rest.tests.it;

import name.marmac.bankanalyzer.services.rest.client.webclient.BankAnalyzerWebClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcomaccio on 11/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/rest-client-integrationtest-context.xml"})
public class ITRetrieveBankAccountsTest {

    public static final transient Logger LOGGER = LoggerFactory.getLogger(ITRetrieveBankAccountsTest.class);

    @Resource
    public BankAnalyzerWebClient bankAnalyzerWebClient;

    /**
     * This Method allows to set the BankAnalyzerWebClient that has wraps the REST methods on the server
     * @param bankAnalyzerWebClient the bankAnalyzerWebClient
     */
    public void setBankAnalyzerWebClient(BankAnalyzerWebClient bankAnalyzerWebClient) {
        this.bankAnalyzerWebClient = bankAnalyzerWebClient;
    }

    @Test
    public void testGetBankAccounts() {
        LOGGER.info("TEST: getBankAccounts");
        Response response = bankAnalyzerWebClient.getBankAccounts(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_JSON_TYPE);

        //Check that the response status code is 200
        Assert.assertEquals(HttpServletResponse.SC_OK, response.getStatus());
    }
}
