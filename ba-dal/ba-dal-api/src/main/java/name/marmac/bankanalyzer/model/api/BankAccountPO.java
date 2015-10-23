package name.marmac.bankanalyzer.model.api;

import java.util.Date;
import java.util.Set;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface BankAccountPO extends BasicPO {

    /** GETTER METHODS**/

    /**
     *
     * @return
     */
    public String getBankName();

    /**
     *
     * @return
     */
    public String getIban();

    /**
     *
     * @return
     */
    public String getHolderName();

    /**
     *
     * @return
     */
    public Date getOpeningDate();

    /**
     *
     * @return
     */
    public Set<TransactionPO> getTransactions();


    /** SETTERS METHODS**/

    /**
     *
     * @param bankName
     */
    public void setBankName(String bankName);

    /**
     *
     * @param iban
     */
    public void setIban(String iban);

    /**
     *
     * @param holderName
     */
    public void setHolderName(String holderName);

    /**
     *
     * @param openingDate
     */
    public void setOpeningDate(Date openingDate);

    /**
     *
     * @param transactions
     */
    public void setTransactions(Set<TransactionPO> transactions);

}