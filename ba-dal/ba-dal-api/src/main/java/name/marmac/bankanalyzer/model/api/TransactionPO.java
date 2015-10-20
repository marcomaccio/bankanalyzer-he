package name.marmac.bankanalyzer.model.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface TransactionPO extends Serializable {


    public Long getId();

    public Date getExecutionDate();

    public Date getValueDate();

    public String getDescription();

    public float getAmount();

    public String getCurrency();

    public float getBalance();

    public String getCategory();

    public String getSubCategory();

    public BankAccountPO getBankAccount();

    /**
     *
     * @return
     */
    public Date getCreatedDate();

    /**
     *
     * @return
     */
    public Date getLastUpdate();

    /**
     *
     * @return
     */
    public Long getVersion();


    /** Setters Methods - START **/

    public void setId(Long id);

    public void setExecutionDate(Date executionDate);

    public void setValueDate(Date valueDate);

    public void setDescription(String description);

    public void setAmount(float amount);

    public void setCurrency(String currency);

    public void setBalance(float balance);

    public void setCategory(String category);

    public void setSubCategory(String subCategory);

    public void setBankAccount(BankAccountPO bankAccount);

    /**
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate);

    /**
     *
     * @param lastUpdate
     */
    public void setLastUpdate(Date lastUpdate);

    /**
     *
     * @param version
     */
    public void setVersion(Long version);

}
