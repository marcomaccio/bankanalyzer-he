package name.marmac.bankanalyzer.services.rest.client.webclient;

import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountTOType;
import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountsTOType;
import name.marmac.bankanalyzer.model.to.transactions.TransactionTOType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by marcomaccio on 10/11/2014.
 */
public class BankAnalyzerWebClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(BankAnalyzerWebClient.class);

    private WebClient                                                       mWebClient;
    private name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory    mBankAccountsObjectFactory;
    private name.marmac.bankanalyzer.model.to.transactions.ObjectFactory    mTransactionsObjectFactory;

    /**
     * This method allows to set the JAX-RS WebClient that connects to the REST Server Endpoint
     * @param webClient the JAX-RS webClient
     */
    public void setWebClient(WebClient webClient) {
        this.mWebClient = webClient;
    }

    /**
     *
     * @return the JAX-RS webClient
     */
    public WebClient getWebClient() {
        return this.mWebClient;
    }

    /**
     *
     * @param bankAccountsObjectFactory JAXB2 ObjectFactory that creates the JAXB serializable objects for: BankAccountTO, BankAccountsTO
     */
    public void setBankAccountsObjectFactory(name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory bankAccountsObjectFactory) {
        this.mBankAccountsObjectFactory = bankAccountsObjectFactory;
    }

    /**
     *
     * @param transactionsObjectFactory JAXB2 ObjectFactory that creates the JAXB serializable objects for: TransactionTO, TransactionsTO
     */
    public void setTransactionsObjectFactory(name.marmac.bankanalyzer.model.to.transactions.ObjectFactory transactionsObjectFactory) {
        this.mTransactionsObjectFactory = transactionsObjectFactory;
    }

    /**
     *
     * @param holderName    the BankAccount's holder name
     * @param iban          the BankAccount's IBAN
     * @param openingDate   the BankAccount's Opening Date
     * @param requestType   the requestType MediaType
     * @param responseType  the responseType MediaType
     * @return              the Response object
     */
    public Response createBankAccount(String holderName,
                                      String iban,
                                      String openingDate,
                                      MediaType requestType,
                                      MediaType responseType) {

        //Create the CustomerTOType (Transfer Object) to be serialized and passed to the server
        BankAccountTOType bankAccountTOType = mBankAccountsObjectFactory.createBankAccountTOType();
        bankAccountTOType.setHoldername(holderName);
        bankAccountTOType.setIBAN(iban);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(simpleDateFormat.parse(openingDate));
        } catch (ParseException pe) {
            LOGGER.error(pe.getMessage());
        }
        bankAccountTOType.setOpeningDate(cal);

        //call the cxf web client
        WebClient.getConfig(mWebClient).getHttpConduit().getClient().setReceiveTimeout(10000000);
        mWebClient.reset();
        Response response = mWebClient.type(requestType).accept(responseType).path("/bankaccounts").post(bankAccountTOType);

        LOGGER.info("RESPONSE HTTP STATUS: " + response.getStatus() );
        LOGGER.info("RESPONSE HTTP HEADERS size: " + response.getHeaders().size());
        for (Map.Entry<String, List<Object>> header : response.getHeaders().entrySet()) {
            LOGGER.info("\t Header (Key:value) = " + header.getKey() + ": ");

            for (Object value : header.getValue()) {
                LOGGER.info("\n" + value.toString() + ", ");
            }
            LOGGER.info("\n");
        }
        LOGGER.info("media-type: " + response.getMediaType().getType());
        LOGGER.info("Entity " + response.readEntity(BankAccountTOType.class));
        return response;
    }

    public Response getBankAccounts(MediaType requestType,
                                    MediaType responseType) {

        WebClient.getConfig(mWebClient).getHttpConduit().getClient().setReceiveTimeout(10000000);
        mWebClient.reset();
        Response response = mWebClient.type(requestType).accept(responseType).path("/bankaccounts").get();
        LOGGER.info("RESPONSE HTTP STATUS: " + response.getStatus() );
        LOGGER.info("RESPONSE HTTP HEADERS size: " + response.getHeaders().size());
        for (Map.Entry<String, List<Object>> header : response.getHeaders().entrySet()) {
            LOGGER.info("\t Header (Key:value) = " + header.getKey() + ": ");

            for (Object value : header.getValue()) {
                LOGGER.info("\t" + value.toString() + ", ");
            }
            LOGGER.info("\n");
        }
        LOGGER.info("media-type: " + response.getMediaType().getType());
        LOGGER.info("Entity " + response.readEntity(BankAccountsTOType.class));
        return response;
    }

    public Response getBankAccountByNativeId(String iban,
                                             MediaType requestType,
                                             MediaType responseType){
        WebClient.getConfig(mWebClient).getHttpConduit().getClient().setReceiveTimeout(10000000);
        mWebClient.reset();
        Response response = mWebClient.type(requestType).accept(responseType).path("/bankaccounts").path(iban).get();
        LOGGER.info("media-type: " + response.getMediaType().getType());
        LOGGER.info("Entity " + response.readEntity(BankAccountTOType.class));
        return response;
    }

    public Response createTransaction(String iban,
                                      MediaType requestType,
                                      MediaType responseType){
        //Setting up the TransactionTOType (the transferedObject)
        TransactionTOType transactionTOType = mTransactionsObjectFactory.createTransactionTOType();
        //Setting up the REST Client
        WebClient.getConfig(mWebClient).getHttpConduit().getClient().setReceiveTimeout(10000000);
        mWebClient.reset();
        Response response = mWebClient.type(requestType).accept(responseType).path("/bankaccounts").path(iban).path("/transactions").post(transactionTOType);
        return response;
    }

}
