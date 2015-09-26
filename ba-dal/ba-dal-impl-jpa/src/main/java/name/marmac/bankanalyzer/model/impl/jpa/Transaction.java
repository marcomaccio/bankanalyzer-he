package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Entity
@Table(name = "Transactions", uniqueConstraints=@UniqueConstraint(columnNames="transHash"))
@NamedQueries({
        @NamedQuery(name = "Transactions.findAllByBankAccount", query = "SELECT t from Transaction t "),
        @NamedQuery(name = "Transactions.Count",                query = "SELECT COUNT(t) FROM Transaction t"),
        @NamedQuery(name = "Transactions.findByPkId",           query = "SELECT t FROM Transaction t WHERE t.id = :id")
})
public class Transaction implements TransactionPO {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);

    private Long    id;
    private Long    version;
    private Date    executionDate;
    private Date    valueDate;
    private String  description;
    private float   amount;
    private float   balance;
    private String  currency;
    private String  category;
    private String  subCategory;
    private Date    createDate;
    private Date    lastUpdate;



    @Override
    @Id
    @Column(name = "pkId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    @Column(name = "executionDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getExecutionDate() {
        return executionDate;
    }

    @Override
    @Column(name = "valueDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getValueDate() {
        return valueDate;
    }

    @Override
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Override
    @Column(name = "amount", nullable = false)
    public float getAmount() {
        return amount;
    }

    @Override
    @Column(name = "currency", nullable = false)
    public String getCurrency() {
        return currency;
    }

    @Override
    @Column(name = "balance", nullable = false)
    public float getBalance() {
        return balance;
    }

    @Override
    @Column(name = "category", nullable = true)
    public String getCategory() {
        return category;
    }

    @Override
    @Column(name = "subCategory", nullable = true)
    public String getSubCategory() {
        return subCategory;
    }

    @Override
    @Column(name = "createDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createDate;
    }

    @Override
    @Column(name = "lastUpdate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    @Override
    @Version
    @Column(name = "version", nullable = true)
    public Long getVersion() {
        return version;
    }

    /** Setters Methods - START **/

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setSubCategory(String subCategory) {
        this.subCategory = category;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createDate = createdDate;
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

}
