package name.marmac.bankanalyzer.model.api;

import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface TransactionPO extends BasicPO {

    /**
     *
     * @return
     */
    public Date getExecutionDate();

    /**
     *
     * @return
     */
    public Date getValueDate();

    /**
     *
     * @return
     */
    public String getDescription();

    /**
     *
     * @return
     */
    public float getAmount();

    /**
     *
     * @return
     */
    public String getCurrency();

    /**
     *
     * @return
     */
    public float getBalance();

    /**
     *
     * @return
     */
    public String getCategory();

    /**
     *
     * @return
     */
    public String getSubCategory();

    /**
     *
     * @return
     */
    public BankAccountPO getBankAccount();


    /** Setters Methods - START **/

    /**
     *
     * @param executionDate
     */
    public void setExecutionDate(Date executionDate);

    /**
     *
     * @param valueDate
     */
    public void setValueDate(Date valueDate);

    /**
     *
     * @param description
     */
    public void setDescription(String description);

    /**
     *
     * @param amount
     */
    public void setAmount(float amount);

    /**
     *
     * @param currency
     */
    public void setCurrency(String currency);

    /**
     *
     * @param balance
     */
    public void setBalance(float balance);

    /**
     *
     * @param category
     */
    public void setCategory(String category);

    /**
     *
     * @param subCategory
     */
    public void setSubCategory(String subCategory);

    /**
     *
     * @param bankAccount
     */
    public void setBankAccount(BankAccountPO bankAccount);

}
