package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BankAccountPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
@Entity
@Table(name = "BankAccounts", uniqueConstraints=@UniqueConstraint(columnNames="iban"))
@NamedQueries({
        @NamedQuery(name = "BankAccounts.findAll",      query = "SELECT ba from BankAccounts ba "),
        @NamedQuery(name = "BankAccounts.Count",        query = "SELECT COUNT(ba) FROM BankAccounts ba"),
        @NamedQuery(name = "BankAccounts.findByPkId",   query = "SELECT ba FROM BankAccounts ba WHERE ba.id = :id"),
        @NamedQuery(name = "BankAccounts.findByIBAN",   query = "SELECT ba FROM BankAccounts ba WHERE ba.iban = :iban")
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
        public String getIBAN() {
                return iban;
        }

        @Override
        @Column(name = "holderName", nullable = false)
        public String getHolderName() {
                return holderName;
        }

        @Override
        @Column(name = "openingDate", nullable = false)
        public Date getOpeningDate() {
                return openingDate;
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
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        @Override
        public void setIBAN(String iban) {
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

}
