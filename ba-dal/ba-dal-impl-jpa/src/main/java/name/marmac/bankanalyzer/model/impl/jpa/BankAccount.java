package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import name.marmac.bankanalyzer.model.api.TransactionPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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

        @Override
        @Id
        @Column(name = "pkId", nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        public Long getId() {
                return id;
        }

        @Override
        @Column(name = "bankName", nullable = false)
        public String getBankName() {
                return bankName;
        }

        @Override
        @Column(name = "iban", nullable = false)
        public String getIban() {
                return iban;
        }

        @Override
        @Column(name = "holderName", nullable = false)
        public String getHolderName() {
                return holderName;
        }

        @Override
        @Column(name = "openingDate", nullable = false)
        @Temporal(TemporalType.DATE)
        public Date getOpeningDate() {
                return openingDate;
        }

        @Override
        @Column(name = "createdDate", nullable = true)
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

        @Override
        @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "bankAccount")
        public Set<TransactionPO> getTransactions(){ return transactions;}

        /** Setters Methods - START **/

        @Override
        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        @Override
        public void setIban(String iban) {
            this.iban = iban;
        }

        @Override
        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        @Override
        public void setOpeningDate(Date openingDate) {
            this.openingDate = openingDate;
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

        @Override
        public void setTransactions(Set<TransactionPO> transactions){

                this.transactions = transactions;
        }

}
