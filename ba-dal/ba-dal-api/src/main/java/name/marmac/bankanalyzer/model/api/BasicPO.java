package name.marmac.bankanalyzer.model.api;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 23/10/2015.
 */
public interface BasicPO extends Serializable {

    /**
     *
     * @return
     */
    public String getId();

    /**
     *
     * @param id
     */
    public void setId(String id);

    /**
     *
     * @return
     */
    public Date getCreatedDate();

    /**
     *
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate);

    /**
     *
     * @return
     */
    public Date getLastUpdate();

    /**
     *
     * @param lastUpdate
     */
    public void setLastUpdate(Date lastUpdate);

    /**
     *
     * @return
     */
    public Long getVersion();

    /**
     *
     * @param version
     */
    public void setVersion(Long version);

    /**
     *
     * @return
     */
    public String getUser();

    /**
     *
     * @param user
     */
    public void setUser(String user);
}
