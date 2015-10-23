package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Entity
@Table(name = "BankAccounts", uniqueConstraints=@UniqueConstraint(columnNames="iban"))
@NamedQueries({
        @NamedQuery(name = "BankAccounts.findAll",      query = "SELECT ba from BankAccount ba "),
        @NamedQuery(name = "BankAccounts.Count",        query = "SELECT COUNT(ba) FROM BankAccount ba"),
        @NamedQuery(name = "BankAccounts.findByPkId",   query = "SELECT ba FROM BankAccount ba WHERE ba.id = :id"),
        @NamedQuery(name = "BankAccounts.findByIBAN",   query = "SELECT ba FROM BankAccount ba WHERE ba.iban = :iban")
})
public class BankAccount implements BankAccountPO {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccount.class);

    private Long    id;
    private Long    version;
    private String  bankName;
    private String  holderName;
    private String  iban;
    private Date    openingDate;
    private Date    createDate;
    private Date    lastUpdate;
    private Set<TransactionPO> transactions = new HashSet<TransactionPO>(0);

    /**
     *
     * @return
     */
    @Override
    @Id
    @Column(name = "pkId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
            return id;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "bankName", nullable = false)
    public String getBankName() {
            return bankName;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "iban", nullable = false)
    public String getIban() {
            return iban;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "holderName", nullable = false)
    public String getHolderName() {
            return holderName;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "openingDate", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getOpeningDate() {
            return openingDate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "createdDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
            return createDate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "lastUpdate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
            return lastUpdate;
    }

    /**
     *
     * @return
     */
    @Override
    @Version
    @Column(name = "version", nullable = true)
    public Long getVersion() {
            return version;
    }

    /**
     *
     * @return
     */
    @Override
    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "bankAccount")
    public Set<TransactionPO> getTransactions(){
            return transactions;
    }

    /** Setters Methods - START **/

    /**
     *
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param bankName
     */
    @Override
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     *
     * @param iban
     */
    @Override
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     *
     * @param holderName
     */
    @Override
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     *
     * @param openingDate
     */
    @Override
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     *
     * @param createdDate
     */
    @Override
    public void setCreatedDate(Date createdDate) {
        this.createDate = createdDate;
    }

    /**
     *
     * @param lastUpdate
     */
    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     *
     * @param version
     */
    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *
     * @param transactions
     */
    @Override
    public void setTransactions(Set<TransactionPO> transactions){
            this.transactions = transactions;
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
            BankAccount that = (BankAccount) o;
            return Objects.equals(holderName, that.holderName) &&
                    Objects.equals(iban, that.iban) &&
                    Objects.equals(openingDate, that.openingDate);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
            return Objects.hash(holderName, iban, openingDate);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        LOGGER.debug("BankAccount{" +
                        "bankName='" + bankName + '\'' +
                        ", holderName='" + holderName + '\'' +
                        ", iban='" + iban + '\'' +
                        ", openingDate=" + openingDate +
                        '}');

        return "BankAccount{" +
                "bankName='" + bankName + '\'' +
                ", holderName='" + holderName + '\'' +
                ", iban='" + iban + '\'' +
                ", openingDate=" + openingDate +
                '}';
    }
}
