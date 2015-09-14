package name.marmac.bankanalyzer.dal.api;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;

import java.util.List;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface BankAccountsPersistenceServices {

    public BankAccountPO createNewBankAccount();

    public BankAccountPO save(BankAccountPO bankAccountPO);

    public BankAccountPO getBankAccountByNativeId(String nativeId);

    public List<BankAccountPO> getAllBankAccounts();

    public int getBankAccountsCount();


    public TransactionPO createNewTransaction();

    public TransactionPO save(TransactionPO transactionPO);

    public TransactionPO getTransactionByNativeId();

    public List<TransactionPO> getAllTransactionsByBankAccount(String bankAccountNativeId);

    public int getTransactionCount(String bankAccountNativeId);

}
