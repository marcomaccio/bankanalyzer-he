package name.marmac.bankanalyzer.services.rest.server.impl.jaxrs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountTOType;
import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountsTOType;
import name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory;
import name.marmac.bankanalyzer.services.rest.server.properties.BankAccountsServicesProperties;
import name.marmac.tutorials.cxfatwork.services.web.rest.api.customerservice.BankAccountsServices;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Api(value = "/bankaccountsservices", description = "Bank Accounts Services - CRUD")
@Path("/bankaccountsservices")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class BankAccountsServicesImplJaxrs implements BankAccountsServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsServicesImplJaxrs.class);
    //JAX-RS and JAX-WS context
    @javax.ws.rs.core.Context
    private MessageContext response                                                                 = null;
    private name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory bankAccountsObjectFactory  = null;
    private name.marmac.bankanalyzer.model.to.transactions.ObjectFactory transactionsObjectFactory  = null;
    private BankAccountsServicesProperties bankAccountsServicesProperties   = null;

    /**
     *
     */
    public BankAccountsServicesImplJaxrs(){
        LOGGER.debug("Initializing Bank Accounts Services Impl JaxRS ");
    }

    /** Getters & Setters - START **/
    public ObjectFactory getBankAccountsObjectFactory() {
        return bankAccountsObjectFactory;
    }

    public void setBankAccountsObjectFactory(ObjectFactory bankAccountsObjectFactory) {
        this.bankAccountsObjectFactory = bankAccountsObjectFactory;
    }

    public name.marmac.bankanalyzer.model.to.transactions.ObjectFactory getTransactionsObjectFactory() {
        return transactionsObjectFactory;
    }

    public void setTransactionsObjectFactory(name.marmac.bankanalyzer.model.to.transactions.ObjectFactory transactionsObjectFactory) {
        this.transactionsObjectFactory = transactionsObjectFactory;
    }

    public BankAccountsServicesProperties getBankAccountsServicesProperties() {
        return bankAccountsServicesProperties;
    }

    public void setBankAccountsServicesProperties(BankAccountsServicesProperties bankAccountsServicesProperties) {
        this.bankAccountsServicesProperties = bankAccountsServicesProperties;
    }

    /** Getters & Setters - END **/

    @Override
    public BankAccountTOType createBankAccount(BankAccountTOType bankaccounttotype) {
        return null;
    }

    /**
     *
     * @param limit
     * @param iban
     * @param holdername
     * @param openingDate
     * @param createDate
     * @param lastUpdate
     * @return
     */
    @Override
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/bankaccounts")
    @ApiOperation(value = "Get BankAccounts filtering them by some parameters in AND condition",
            notes = "Retrieve method",
            response = BankAccountsTOType.class)
    public BankAccountsTOType getBankAccountsByQuery(@QueryParam("limit") Integer limit,
                                                     @QueryParam("iban") String iban,
                                                     @QueryParam("holdername") String holdername,
                                                     @QueryParam("openingDate") String openingDate,
                                                     @QueryParam("createDate") String createDate,
                                                     @QueryParam("lastUpdate") String lastUpdate) {

        //TODO: Implements the filters query
        BankAccountsTOType bankAccountsTOType = bankAccountsObjectFactory.createBankAccountsTOType();

        return bankAccountsTOType;
    }

    @Override
    public BankAccountsTOType updateBankAccounts(BankAccountsTOType bankaccountstotype) {
        BankAccountsTOType bankAccountsTOType = bankAccountsObjectFactory.createBankAccountsTOType();

        return bankAccountsTOType;
    }

    @Override
    public BankAccountsTOType deleteBankAccounts(BankAccountsTOType bankaccountstotype) {
        BankAccountsTOType bankAccountsTOType = bankAccountsObjectFactory.createBankAccountsTOType();

        return bankAccountsTOType;
    }

    @Override
    public BankAccountTOType getBankAccountByNativeId(@PathParam("id") String id) {

        BankAccountTOType bankAccountTOType = bankAccountsObjectFactory.createBankAccountTOType();

        return bankAccountTOType;
    }

    @Override
    public BankAccountTOType updateBankAccountByNativeId(@PathParam("id") String id, BankAccountTOType bankaccounttotype) {
        BankAccountTOType bankAccountTOType = bankAccountsObjectFactory.createBankAccountTOType();

        return bankAccountTOType;
    }

    @Override
    public BankAccountTOType deleteBankAccountByNativeId(@PathParam("id") String id) {
        BankAccountTOType bankAccountTOType = bankAccountsObjectFactory.createBankAccountTOType();

        return bankAccountTOType;
    }
}
