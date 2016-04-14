package name.marmac.bankanalyzer.dal.impl.jpa.nosql;

import name.marmac.bankanalyzer.model.impl.jpa.nosql.BankAccountPONoSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by marcomaccio on 19/02/2016.
 */
@Transactional
@Repository("BankAccountsPersistenceServiceNoSql")
public class BankAccountsPersistenceServicesImplJPANoSQL {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsPersistenceServicesImplJPANoSQL.class);

    @PersistenceContext(unitName = "bankanalyzer-punit-nosql", type = PersistenceContextType.EXTENDED)
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
     * @param bankAccount
     * @return
     */
    public BankAccountPONoSql save(BankAccountPONoSql bankAccount){
        if (bankAccount.getId() != null) {
            entityManager.merge(bankAccount);
            entityManager.flush();
        } else {
            entityManager.persist(bankAccount);
        }
        return bankAccount;
    }

    public BankAccountPONoSql getBankAccountByNativeId(String nativeId) {
            LOGGER.debug("Method getBankAccountByNativeId has been called with iban=" + nativeId);

        BankAccountPONoSql bankAccount = null;

            Query query = entityManager.createNamedQuery("BankAccounts.findByIBAN", BankAccountPONoSql.class);
            query.setParameter("iban", nativeId);

            List<BankAccountPONoSql> resultList = query.getResultList();
            LOGGER.debug( resultList.size() + " bankaccounts");
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
    public List<BankAccountPONoSql> getAllBankAccounts() {
        LOGGER.debug("Method getAllBankAccounts has been called ");
        List<BankAccountPONoSql> bankAccountList = entityManager.createNamedQuery("BankAccounts.findAll").getResultList();

        LOGGER.debug(bankAccountList.size() + " bankaccounts");
        return bankAccountList;
    }

}
