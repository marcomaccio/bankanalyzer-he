package name.marmac.bankanalyzer.model.impl.jpa.nosql;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by marcomaccio on 18/02/2016.
 */
@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
@NamedQueries({
        @NamedQuery(name = "BankAccounts.findAll", query = "SELECT ba from BankAccountPONoSql ba "),
        @NamedQuery(name = "BankAccounts.Count", query = "SELECT COUNT(ba) FROM BankAccountPONoSql ba")
})
public class BankAccountPONoSql {

    private static final    long    serialVersionUID = 1L;
    private static final    Logger  LOGGER = LoggerFactory.getLogger(BankAccountPONoSql.class);

    private                 String  bankName;
    private                 String  holderName;
    private                 String  iban;
    private                 Date    openingDate;

    private                 String  id;
    private                 Long    version;
    private List<TransactionPONoSql> transactions = new ArrayList<TransactionPONoSql>();

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field(name="_id")
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    @Version
    public Long getVersion() {
        return version;
    }

    /**
     *
     * @return
     */
    @Basic
    @Field(name = "bankName")
    public String getBankName() {
            return bankName;
    }

    /**
     *
     * @return
     */
    @Basic
    @Field(name = "iban")
    public String getIban() {
            return iban;
    }

    /**
     *
     * @return
     */
    @Basic
    @Field(name = "holderName")
    public String getHolderName() {
            return holderName;
    }

    /**
     *
     * @return
     */
    @Basic
    @Field(name = "openingDate")
    @Temporal(TemporalType.DATE)
    public Date getOpeningDate() {
            return openingDate;
    }

    /**
     *
     * @return
     */
    public List<TransactionPONoSql> getTransactions() { return this.transactions;}

    /** Setters Methods - START **/

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     *
     * @param iban
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     *
     * @param holderName
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     *
     * @param openingDate
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     *
     * @param transactions
     */
    public void setTransactions(List<TransactionPONoSql> transactions) {
        this.transactions = transactions;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BankAccountPONoSql that = (BankAccountPONoSql) o;
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

        LOGGER.debug("BankAccountPONoSql{" +
                        "bankName='" + bankName + '\'' +
                        ", holderName='" + holderName + '\'' +
                        ", iban='" + iban + '\'' +
                        ", openingDate=" + openingDate +
                        '}');

        return "BankAccountPONoSql{" +
                "bankName='" + bankName + '\'' +
                ", holderName='" + holderName + '\'' +
                ", iban='" + iban + '\'' +
                ", openingDate=" + openingDate +
                '}';
    }
}
