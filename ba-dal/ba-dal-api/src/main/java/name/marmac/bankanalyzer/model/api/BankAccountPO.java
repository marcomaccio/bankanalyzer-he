package name.marmac.bankanalyzer.model.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public interface BankAccountPO extends Serializable {

    /** SETTERS METHODS**/
    /**
     *
     * @return
     */
    public Long getId();

    /**
     *
     * @return
     */
    public String getBankName();

    /**
     *
     * @return
     */
    public String getIban();

    /**
     *
     * @return
     */
    public String getHolderName();

    /**
     *
     * @return
     */
    public Date getOpeningDate();

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

    /** SETTERS METHODS**/

    /**
     *
     * @param id
     */
    public void setId(Long id);

    /**
     *
     * @param bankName
     */
    public void setBankName(String bankName);

    /**
     *
     * @param iban
     */
    public void setIban(String iban);

    /**
     *
     * @param holderName
     */
    public void setHolderName(String holderName);

    /**
     *
     * @param openingDate
     */
    public void setOpeningDate(Date openingDate);

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
