package name.marmac.bankanalyzer.services.rest.server.impl.jaxrs;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import name.marmac.bankanalyzer.dal.api.BankAccountsPersistenceServices;
import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountTOType;
import name.marmac.bankanalyzer.model.to.bankaccounts.BankAccountsTOType;
import name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory;
import name.marmac.bankanalyzer.model.to.transactions.TransactionsTOType;
import name.marmac.bankanalyzer.services.rest.server.properties.BankAccountsServicesProperties;
import name.marmac.tutorials.cxfatwork.services.web.rest.api.customerservice.BankAccountsServices;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.List;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Api(value = "/bankaccountsservices", description = "Bank Accounts Services - CRUD")
@Path("/bankaccountsservices")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class BankAccountsServicesImplJaxrs implements BankAccountsServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsServicesImplJaxrs.class);

    private static final String PATH_PARAM_IBAN                 = "iban";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN_ALL = "*";

    //JAX-RS and JAX-WS context
    @javax.ws.rs.core.Context
    private MessageContext response                                                                 = null;
    private name.marmac.bankanalyzer.model.to.bankaccounts.ObjectFactory bankAccountsObjectFactory  = null;
    private name.marmac.bankanalyzer.model.to.transactions.ObjectFactory transactionsObjectFactory  = null;
    private BankAccountsServicesProperties      bankAccountsServicesProperties                      = null;
    private BankAccountsPersistenceServices     bankAccountsPersistenceServices                     = null;

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

    /**
     *
     * @param bankAccountsObjectFactory
     */
    public void setBankAccountsObjectFactory(ObjectFactory bankAccountsObjectFactory) {
        this.bankAccountsObjectFactory = bankAccountsObjectFactory;
    }

    /**
     *
     * @return
     */
    public name.marmac.bankanalyzer.model.to.transactions.ObjectFactory getTransactionsObjectFactory() {
        return transactionsObjectFactory;
    }

    /**
     *
     * @param transactionsObjectFactory
     */
    public void setTransactionsObjectFactory(name.marmac.bankanalyzer.model.to.transactions.ObjectFactory transactionsObjectFactory) {
        this.transactionsObjectFactory = transactionsObjectFactory;
    }

    /**
     *
     * @return
     */
    public BankAccountsServicesProperties getBankAccountsServicesProperties() {
        return bankAccountsServicesProperties;
    }

    /**
     *
     * @param bankAccountsServicesProperties
     */
    public void setBankAccountsServicesProperties(BankAccountsServicesProperties bankAccountsServicesProperties) {
        this.bankAccountsServicesProperties = bankAccountsServicesProperties;
    }

    /**
     *
     * @return
     */
    public BankAccountsPersistenceServices getBankAccountsPersistenceServices() {
        return bankAccountsPersistenceServices;
    }

    /**
     *
     * @param bankAccountsPersistenceServices
     */
    public void setBankAccountsPersistenceServices(BankAccountsPersistenceServices bankAccountsPersistenceServices) {
        this.bankAccountsPersistenceServices = bankAccountsPersistenceServices;
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
        //Retrieve the bankaccount from the Persistence Layer
        List<BankAccountPO> bankAccountPOList = bankAccountsPersistenceServices.getAllBankAccounts();
        //Convert the Persistence Object to the TransferObject
        bankAccountsTOType = convertToBankAccountsTOType(bankAccountPOList);
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
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/bankaccounts/{iban}")
    @ApiOperation(value = "Get BankAccount by IBAN",
            notes = "Retrieve method of a specific Bank Account",
            response = BankAccountTOType.class)
    public BankAccountTOType getBankAccountByNativeId(@ApiParam(value = PATH_PARAM_IBAN, required = true) @PathParam("iban") String iban) {

        LOGGER.debug("getBankAccountByNativeId Method: search for BankAccount with IBAN=" + iban);

        BankAccountTOType bankAccountTOType = bankAccountsObjectFactory.createBankAccountTOType();
        BankAccountPO bankAccountPO = bankAccountsPersistenceServices.getBankAccountByNativeId(iban);
        if (bankAccountPO != null) {
            bankAccountTOType = this.convertToBankAccountTOType(bankAccountPO);
            response.getHttpServletResponse().setHeader("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN_ALL);
        }
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

    @Override
    public TransactionsTOType getTransactionsByBankAccount() {
        return null;
    }


    /**
     * Convert a list of BankAccountPO into a BankAccountsTOType
     * @param bankAccountPOList
     * @return
     */
    private BankAccountsTOType convertToBankAccountsTOType(List<BankAccountPO> bankAccountPOList){
        BankAccountsTOType bankAccountsTOType = getBankAccountsObjectFactory().createBankAccountsTOType();
        for (BankAccountPO bankAccountPO : bankAccountPOList){
            //get each BankAccountPO and convert into a BankAccountTOType
            BankAccountTOType bankAccountTOType = convertToBankAccountTOType(bankAccountPO);
            //add the bankAccountTOType to the list BankAccountsTOType
            bankAccountsTOType.getBankaccounts().add(bankAccountTOType);
        }
        return bankAccountsTOType;
    }

    /**
     * Convert a single BankAccountPO into a BankAccountTOType
     * @param bankAccountPO
     * @return
     */
    private BankAccountTOType convertToBankAccountTOType(BankAccountPO bankAccountPO){
        BankAccountTOType bankAccountTOType = getBankAccountsObjectFactory().createBankAccountTOType();
        bankAccountTOType.setIBAN(bankAccountPO.getIban());
        bankAccountTOType.setHoldername(bankAccountPO.getHolderName());

        Calendar cal = Calendar.getInstance();

        cal.setTime(bankAccountPO.getOpeningDate());
        bankAccountTOType.setOpeningDate(cal);

        cal.setTime(bankAccountPO.getCreatedDate());
        bankAccountTOType.setCreatedDate(cal);

        cal.setTime(bankAccountPO.getLastUpdate());
        bankAccountTOType.setLastUpdate(cal);

        return bankAccountTOType;
    }


}
