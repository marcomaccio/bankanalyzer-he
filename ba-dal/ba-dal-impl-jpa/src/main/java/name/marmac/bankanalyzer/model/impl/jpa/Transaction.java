package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal      amount;
    private BigDecimal      balance;
    private String          currency;
    private String          category;
    private String          subCategory;
    private BankAccountPO   bankAccount;

    /**
     *
     */
    public Transaction(){}
    /**
     * Public constructor with all parameters
     * @param executionDate the date of execution by the bank of the transaction
     * @param valueDate     the date in which the transaction has been physically done
     * @param description   the transaction description
     * @param amount        the transaction amount (positive for a credit, negative for a debit)
     * @param balance       the bankAccount balance after the transaction has been done
     * @param currency      the currency on which the transaction has been registered by the bank
     * @param category      the category that group the transaction
     * @param subCategory   the subcategory the group the transaction
     * @param bankAccount   the bankAccount at which the transaction is linked
     */
    public Transaction(Date         executionDate,
                       Date         valueDate,
                       String       description,
                       BigDecimal   amount,
                       BigDecimal   balance,
                       String       currency,
                       String       category,
                       String       subCategory,
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
     * @return  the date of execution by the bank of the transaction
     */
    @Override
    @Column(name = "executionDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     *
     * @return  the date in which the transaction has been physically done
     */
    @Override
    @Column(name = "valueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getValueDate() {
        return valueDate;
    }

    /**
     *
     * @return  the transaction description
     */
    @Override
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return  the transaction amount (positive for a credit, negative for a debit)
     */
    @Override
    @Column(name = "amount", nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     *
     * @return  the currency on which the transaction has been registered by the bank
     */
    @Override
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @return  the bankAccount balance after the transaction has been done
     */
    @Override
    @Column(name = "balance", nullable = false)
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     *
     * @return  the category that group the transaction
     */
    @Override
    @Column(name = "category", nullable = true)
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return  the subcategory the group the transaction
     */
    @Override
    @Column(name = "subCategory", nullable = true)
    public String getSubCategory() {
        return subCategory;
    }

    /**
     *
     * @return  the bankAccount at which the transaction is linked
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
     * @param executionDate the date of execution by the bank of the transaction
     */
    @Override
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     *
     * @param valueDate the date in which the transaction has been physically done
     */
    @Override
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     *
     * @param description   the transaction description
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param amount    the transaction amount (positive for a credit, negative for a debit)
     */
    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     *
     * @param currency  the currency on which the transaction has been registered by the bank
     */
    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     *
     * @param balance   the bankAccount balance after the transaction has been done
     */
    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     *
     * @param category the category that group the transaction
     */
    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param subCategory   the subcategory the group the transaction
     */
    @Override
    public void setSubCategory(String subCategory) {
        this.subCategory = category;
    }

    /**
     *
     * @param bankAccount   the bankAccount at which the transaction is linked
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
        return (that.amount.compareTo(amount) == 0) &&
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
