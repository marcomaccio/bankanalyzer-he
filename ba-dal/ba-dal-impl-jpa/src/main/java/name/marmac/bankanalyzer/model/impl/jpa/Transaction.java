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
        @NamedQuery(name = "Transactions.findAll",              query = "SELECT t from Transactions t "),
        @NamedQuery(name = "Transactions.Count",                query = "SELECT COUNT(t) FROM Transactions t"),
        @NamedQuery(name = "Transactions.findByPkId",           query = "SELECT t FROM Transactions t WHERE t.id = :id"),
        @NamedQuery(name = "Transactions.findByTransactionHash",query = "SELECT t FROM Transactions ba WHERE t.transHash = :transHash")
})
public class Transaction implements TransactionPO {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Transaction.class);

    private Long    id;
    private Long    version;


    @Override
    @Id
    @Column(name = "pkId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return null;
    }

    @Override
    public Date getExecutionDate() {
        return null;
    }

    @Override
    public Date getValueDate() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public float getAmount() {
        return 0;
    }

    @Override
    public String getCurrency() {
        return null;
    }

    @Override
    public float getBalance() {
        return 0;
    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public String getSubCategory() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    /** Setters Methods - START **/

    @Override
    public void setExecutionDate(Date executionDate) {

    }

    @Override
    public void setValueDate(Date valueDate) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public void setAmount(float amount) {

    }

    @Override
    public void setCurrency(String currency) {

    }

    @Override
    public void setBalance(float balance) {

    }

    @Override
    public void setCategory(String category) {

    }

    @Override
    public void setSubCategory(String subCategory) {

    }
}
