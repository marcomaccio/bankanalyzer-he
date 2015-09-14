package name.marmac.bankanalyzer.dal.impl.jpa;

import name.marmac.bankanalyzer.dal.api.BankAccountsPersistenceServices;
import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import name.marmac.bankanalyzer.model.impl.jpa.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Transactional
@Repository("BankAccountsPersistenceService")
public class BankAccountsPersistenceServicesImplJPA implements BankAccountsPersistenceServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsPersistenceServicesImplJPA.class);

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

    @Override
    public BankAccountPO createNewBankAccount() {
        LOGGER.debug("Method createNewBankAccount has been called ");
        BankAccountPO newBankAccount = new BankAccount();
        newBankAccount.setCreatedDate(new Date());
        newBankAccount.setLastUpdate(new Date());

        LOGGER.debug("The new empty BankAccount has been created " + newBankAccount.toString());
        return newBankAccount;
    }

    @Override
    public BankAccountPO save(BankAccountPO bankAccountPO) {
        return null;
    }

    @Override
    public BankAccountPO getBankAccountByNativeId(String nativeId) {
        LOGGER.debug("Method getBankAccountByNativeId has been called with iban="+ nativeId);

        BankAccount bankAccount = null;

        Query query = entityManager.createNamedQuery("BankAccounts.findByIBAN", BankAccount.class);
        query.setParameter("iban", nativeId);

        List<BankAccount> resultList = query.getResultList();
        LOGGER.debug("The PL has found N. " + resultList.size());
        if (!resultList.isEmpty())
        {
            bankAccount = resultList.get(0);
        }
        return bankAccount;
    }

    @Override
    public List<BankAccountPO> getAllBankAccounts() {
        LOGGER.debug("Method getAll has been called ");
        List<BankAccountPO> bankAccountList = entityManager.createNamedQuery("BankAccounts.findAll").getResultList();

        LOGGER.debug("The PL has found N. " + bankAccountList.size() + " customers");
        return bankAccountList;
    }

    @Override
    public int getBankAccountsCount() {
        return 0;
    }

    @Override
    public TransactionPO createNewTransaction() {
        return null;
    }

    @Override
    public TransactionPO save(TransactionPO transactionPO) {
        return null;
    }

    @Override
    public TransactionPO getTransactionByNativeId() {
        return null;
    }

    @Override
    public List<TransactionPO> getAllTransactionsByBankAccount(String bankAccountNativeId) {
        return null;
    }

    @Override
    public int getTransactionCount(String bankAccountNativeId) {
        return 0;
    }
}
