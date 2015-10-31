package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Entity
@Table(name = "Transactions", uniqueConstraints=@UniqueConstraint(columnNames={"executionDate","valueDate","amount","currency","bankacc_id"}))
@NamedQueries({
        @NamedQuery(name = "Transactions.findAllByBankAccount",             query = "SELECT t from Transaction t WHERE t.bankAccount.iban = :iban"),
        @NamedQuery(name = "Transactions.findAllByBankAccountAndValueDate", query = "SELECT t FROM Transaction t WHERE (t.valueDate=:valueDate) AND (t.bankAccount.iban=:iban)"),
        @NamedQuery(name = "Transactions.findAllByKeyValues",               query = "SELECT t FROM Transaction t WHERE (t.executionDate = :executionDate) AND (t.valueDate=:valueDate) AND (t.amount=:amount) AND (t.currency=:currency) AND (t.bankAccount.iban=:iban)"),
        @NamedQuery(name = "Transactions.Count",                            query = "SELECT COUNT(t) FROM Transaction t WHERE t.bankAccount.iban = :iban")
})
public class Transaction extends BaseJPAObject implements  TransactionPO {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);

    private Date            executionDate;
    private Date            valueDate;
    private String          description;
    private float           amount;
    private float           balance;
    private String          currency;
    private String          category;
    private String          subCategory;
    private BankAccountPO   bankAccount;

    /**
     * Public Empty constructor
     */
    public Transaction() {}

    /**
     * Public constructor with all parameters
     * @param executionDate
     * @param valueDate
     * @param description
     * @param amount
     * @param balance
     * @param currency
     * @param category
     * @param subCategory
     * @param bankAccount
     */
    public Transaction(Date executionDate,
                       Date valueDate,
                       String description,
                       float amount,
                       float balance,
                       String currency,
                       String category,
                       String subCategory,
                       BankAccountPO bankAccount) {

        this.executionDate  = executionDate;
        this.valueDate      = valueDate;
        this.description    = description;
        this.amount         = amount;
        this.balance        = balance;
        this.currency       = currency;
        this.category       = category;
        this.subCategory    = subCategory;
        this.bankAccount    = bankAccount;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "executionDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "valueDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getValueDate() {
        return valueDate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "amount", nullable = false)
    public float getAmount() {
        return amount;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "balance", nullable = false)
    public float getBalance() {
        return balance;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "category", nullable = true)
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "subCategory", nullable = true)
    public String getSubCategory() {
        return subCategory;
    }

    /**
     *
     * @return
     */
    @Override
    @ManyToOne(targetEntity = BankAccount.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "bankacc_id", nullable = false)
    public BankAccountPO getBankAccount() {
        return bankAccount;
    }

    /** Setters Methods - START **/

    /**
     *
     * @param executionDate
     */
    @Override
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     *
     * @param valueDate
     */
    @Override
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     *
     * @param description
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param amount
     */
    @Override
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     *
     * @param currency
     */
    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @param balance
     */
    @Override
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     *
     * @param category
     */
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param subCategory
     */
    @Override
    public void setSubCategory(String subCategory) {
        this.subCategory = category;
    }

    /**
     *
     * @param bankAccount
     */
    @Override
    public void setBankAccount(BankAccountPO bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Float.compare(that.amount, amount) == 0 &&
                Objects.equals(executionDate, that.executionDate) &&
                Objects.equals(valueDate, that.valueDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(bankAccount, that.bankAccount);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(executionDate, valueDate, amount, currency, bankAccount);
    }

    @Override
    public String toString() {
        LOGGER.debug("Transaction{" +
                        "executionDate="    + executionDate +
                        ", valueDate="      + valueDate     +
                        ", description='"   + description   + '\'' +
                        ", amount="         + amount        +
                        ", balance="        + balance       +
                        ", currency='"      + currency      + '\'' +
                        ", category='"      + category      + '\'' +
                        ", subCategory='"   + subCategory   + '\'' +
                        ", bankAccount="    + bankAccount   +
                        '}');

        return "Transaction{"       +
                "executionDate="    + executionDate +
                ", valueDate="      + valueDate     +
                ", description='"   + description   + '\'' +
                ", amount="         + amount        +
                ", balance="        + balance       +
                ", currency='"      + currency      + '\'' +
                ", category='"      + category      + '\'' +
                ", subCategory='"   + subCategory   + '\'' +
                ", bankAccount="    + bankAccount   +
                '}';
    }
}
