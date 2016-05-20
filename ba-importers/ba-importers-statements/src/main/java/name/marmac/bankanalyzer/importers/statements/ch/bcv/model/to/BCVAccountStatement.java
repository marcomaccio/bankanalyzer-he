package name.marmac.bankanalyzer.importers.statements.ch.bcv.model.to;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 11/06/2015.
 */
@CsvRecord(separator =",",crlf="UNIX", skipFirstLine = true)
public class BCVAccountStatement implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataField(pos = 1, pattern = "dd.MM.yyyy")
    private Date executionDate;

    @DataField(pos = 2)
    private String transaction;

    @DataField(pos = 3)
    private double debit;

    @DataField(pos = 4)
    private double credit;

    @DataField(pos = 5, pattern = "dd.MM.yyyy")
    private Date valueDate;

    @DataField(pos = 6)
    private double balance;

    @DataField(pos = 7)
    private String category;

    @DataField(pos = 8)
    private String subCategory;

    @DataField(pos = 9)
    private String note;

    /**
     *
     * @return
     */
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     *
     * @param executionDate
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     *
     * @return
     */
    public String getTransaction() {
        return transaction;
    }

    /**
     *
     * @param transaction
     */
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    /**
     *
     * @return
     */
    public double getDebit() {
        return debit;
    }

    /**
     *
     * @param debit
     */
    public void setDebit(double debit) {
        this.debit = debit;
    }

    /**
     *
     * @return
     */
    public double getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     */
    public Date getValueDate() {
        return valueDate;
    }

    /**
     *
     * @param valueDate
     */
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     *
     * @param subCategory
     */
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "BCVAccountStatement{" +
                "executionDate=" + executionDate +
                ", transaction='" + transaction + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", valueDate=" + valueDate +
                ", balance=" + balance +
                ", note='" + note + '\'' +
                '}';
    }

}
