package name.marmac.bankanalyzer.dal.impl.jpa;

import name.marmac.bankanalyzer.dal.api.BankAccountsPersistenceServices;
import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import name.marmac.bankanalyzer.model.impl.jpa.BankAccount;
import name.marmac.bankanalyzer.model.impl.jpa.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Transactional
@Repository("BankAccountsPersistenceService")
public class BankAccountsPersistenceServicesImplJPA implements BankAccountsPersistenceServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsPersistenceServicesImplJPA.class);
    private static final String OBJECT_FOUND_MESSAGELOG = "The PL has found N. :";

    @PersistenceContext(unitName = "bankanalyzer-punit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    /**
     *
     * @param entityManager
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @return
     */
    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    /**
     *
     * @return
     */
    @Override
    public BankAccountPO createNewBankAccount() {

        LOGGER.debug("Method createNewBankAccount has been called ");

        BankAccountPO newBankAccount = new BankAccount();
        newBankAccount.setCreatedDate(new Date());
        newBankAccount.setLastUpdate(new Date());

        LOGGER.debug("The new empty BankAccount has been created " + newBankAccount.toString());
        return newBankAccount;
    }

    /**
     *
     * @param bankAccountPO
     * @return
     */
    @Override
    public BankAccountPO save(BankAccountPO bankAccountPO) {
        return null;
    }

    /**
     *
     * @param nativeId
     * @return
     */
    @Override
    public BankAccountPO getBankAccountByNativeId(String nativeId) {
        LOGGER.debug("Method getBankAccountByNativeId has been called with iban=" + nativeId);

        BankAccount bankAccount = null;

        Query query = entityManager.createNamedQuery("BankAccounts.findByIBAN", BankAccount.class);
        query.setParameter("iban", nativeId);

        List<BankAccount> resultList = query.getResultList();
        LOGGER.debug(OBJECT_FOUND_MESSAGELOG + resultList.size() + " bankaccounts");
        if (!resultList.isEmpty())
        {
            bankAccount = resultList.get(0);
        }
        return bankAccount;
    }

    /**
     *
     * @return
     */
    @Override
    public List<BankAccountPO> getAllBankAccounts() {
        LOGGER.debug("Method getAllBankAccounts has been called ");
        List<BankAccountPO> bankAccountList = entityManager.createNamedQuery("BankAccounts.findAll").getResultList();

        LOGGER.debug(OBJECT_FOUND_MESSAGELOG + bankAccountList.size() + " bankaccounts");
        return bankAccountList;
    }

    /**
     *
     * @return
     */
    @Override
    public int getBankAccountsCount() {
        LOGGER.debug("Method getBankAccountsCount has been called ");

        Query query = entityManager.createNamedQuery("BankAccounts.Count", int.class);
        int totalCount = query.getResultList().size();

        LOGGER.debug("Total Count: " + totalCount);
        return totalCount;
    }

    /**
     *
     * @return
     */
    @Override
    public TransactionPO createNewTransaction() {

        LOGGER.debug("Method createNewBankAccount has been called ");

        TransactionPO newTransaction = new Transaction();
        newTransaction.setCreatedDate(new Date());
        newTransaction.setLastUpdate(new Date());

        LOGGER.debug("The new empty Transaction has been created " + newTransaction.toString());
        return newTransaction;
    }

    /**
     *
     * @param transactionPO
     * @return
     */
    @Override
    public TransactionPO save(TransactionPO transactionPO) {
        return null;
    }

    /**
     *
     * @param bankAccountNativeId
     * @return
     */
    @Override
    public List<TransactionPO> getAllTransactionsByBankAccount(String bankAccountNativeId) {

        LOGGER.debug("Method getAllTransactionsByBankAccount has been called ");

        Query query = entityManager.createNamedQuery("Transactions.findAllByBankAccount", Transaction.class);
        query.setParameter("iban", bankAccountNativeId);
        List<TransactionPO> transactionsList = query.getResultList();

        LOGGER.debug(OBJECT_FOUND_MESSAGELOG + transactionsList.size());
        return transactionsList;
    }

    /**
     *
     * @param iban
     * @param valueDate
     * @return
     */
    @Override
    public List<TransactionPO> getAllTransactionsByBankAccountAndValueDate(String iban, Date valueDate){
        LOGGER.debug("Method getTransactionByNativeId has been called ");

        Query query = entityManager.createNamedQuery("Transactions.findAllByBankAccountAndValueDate", Transaction.class);
        query.setParameter("valueDate",     valueDate);
        query.setParameter("iban",          iban);

        List<TransactionPO> transactionsList = query.getResultList();
        LOGGER.debug(OBJECT_FOUND_MESSAGELOG + transactionsList.size() + " transactions");
        return transactionsList;
    }

    /**
     *
     *
     * @param executionDate
     * @param valueDate
     * @param amount
     * @param currency
     * @param iban
     * @return
     */
    @Override
    public List<TransactionPO> getTransactionByKeyValues(Date executionDate, Date valueDate, BigDecimal amount, String currency, String iban) {
        LOGGER.debug("Method getTransactionByNativeId has been called ");
        Query query = entityManager.createNamedQuery("Transactions.findAllByKeyValues", Transaction.class);
        query.setParameter("executionDate", executionDate);
        query.setParameter("valueDate",     valueDate);
        query.setParameter("amount",        amount);
        query.setParameter("currency",      currency);
        query.setParameter("iban",          iban);

        List<TransactionPO> transactionsList = query.getResultList();
        LOGGER.debug(OBJECT_FOUND_MESSAGELOG + transactionsList.size() + " transactions");
        return transactionsList;
    }

    /**
     *
     * @param bankAccountNativeId
     * @return
     */
    @Override
    public int getTransactionCount(String bankAccountNativeId) {
        LOGGER.debug("Method getTransactionCount has been called ");

        Query query = entityManager.createNamedQuery("Transactions.Count", int.class);
        query.setParameter("iban", bankAccountNativeId);
        int totalCount = query.getResultList().size();

        LOGGER.debug("Total Count: " + totalCount);
        return totalCount;
    }

}
