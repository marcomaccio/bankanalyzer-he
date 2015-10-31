package name.marmac.bankanalyzer.dal.api;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;

import java.util.Date;
import java.util.List;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface BankAccountsPersistenceServices {

    /**
     *
     * @return
     */
    public BankAccountPO createNewBankAccount();

    /**
     *
     * @param bankAccountPO
     * @return
     */
    public BankAccountPO save(BankAccountPO bankAccountPO);

    /**
     *
     * @param nativeId
     * @return
     */
    public BankAccountPO getBankAccountByNativeId(String nativeId);

    /**
     *
     * @return
     */
    public List<BankAccountPO> getAllBankAccounts();

    /**
     *
     * @return
     */
    public int getBankAccountsCount();

    /**
     *
     * @return
     */
    public TransactionPO createNewTransaction();

    /**
     *
     * @param transactionPO
     * @return
     */
    public TransactionPO save(TransactionPO transactionPO);

    /**
     *
     * @param bankAccountNativeId
     * @return
     */
    public List<TransactionPO> getAllTransactionsByBankAccount(String bankAccountNativeId);

    /**
     *
     * @param valueDate
     * @return
     */
    public List<TransactionPO> getAllTransactionsByBankAccountAndValueDate(String iban, Date valueDate);

    /**
     *
     * @param executionDate
     * @param valueDate
     * @param amount
     * @param currency
     * @param iban
     * @return
     */
    public List<TransactionPO> getTransactionByKeyValues(Date executionDate, Date valueDate, float amount, String currency, String iban);

    /**
     *
     * @param bankAccountNativeId
     * @return
     */
    public int getTransactionCount(String bankAccountNativeId);

}
