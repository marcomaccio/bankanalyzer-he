package name.marmac.bankanalyzer.model.api;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface TransactionPO extends BasicPO {

    /**
     *
     * @return  the date of execution by the bank of the transaction
     */
    Date getExecutionDate();

    /**
     *
     * @return  the date in which the transaction has been physically done
     */
    Date getValueDate();

    /**
     *
     * @return  the transaction description
     */
    String getDescription();

    /**
     *
     * @return the transaction amount (positive for a credit, negative for a debit)
     */
    BigDecimal getAmount();

    /**
     *
     * @return the currency on which the transaction has been registered by the bank
     */
    String getCurrency();

    /**
     *
     * @return the bankAccount balance after the transaction has been done
     */
    BigDecimal getBalance();

    /**
     *
     * @return  the category that group the transaction
     */
    String getCategory();

    /**
     *
     * @return the subcategory the group the transaction
     */
    String getSubCategory();

    /**
     *
     * @return  the bankAccount at which the transaction is linked
     */
    BankAccountPO getBankAccount();


    /** Setters Methods - START **/

    /**
     *
     * @param executionDate the date of execution by the bank of the transaction
     */
    void setExecutionDate(Date executionDate);

    /**
     *
     * @param valueDate the date in which the transaction has been physically done
     */
    void setValueDate(Date valueDate);

    /**
     *
     * @param description   the transaction description
     */
    void setDescription(String description);

    /**
     *
     * @param amount    the transaction amount (positive for a credit, negative for a debit)
     */
    void setAmount(BigDecimal amount);

    /**
     *
     * @param currency  the currency on which the transaction has been registered by the bank
     */
    void setCurrency(String currency);

    /**
     *
     * @param balance   the bankAccount balance after the transaction has been done
     */
    void setBalance(BigDecimal balance);

    /**
     *
     * @param category  the category that group the transaction
     */
    void setCategory(String category);

    /**
     *
     * @param subCategory   the subcategory that group the transaction
     */
    void setSubCategory(String subCategory);

    /**
     *
     * @param bankAccount   the bankAccount at which the transaction is linked
     */
    void setBankAccount(BankAccountPO bankAccount);

}
