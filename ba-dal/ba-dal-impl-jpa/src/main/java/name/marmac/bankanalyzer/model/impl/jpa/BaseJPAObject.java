package name.marmac.bankanalyzer.model.impl.jpa;

import name.marmac.bankanalyzer.model.api.BasicPO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marcomaccio on 23/10/2015.
 */
@MappedSuperclass
public class BaseJPAObject implements BasicPO {

    private static final long serialVersionUID = 1L;

    private Long    id;
    private Long    version;
    private Date    createdDate;
    private Date    lastUpdate;
    private String  user = "";

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
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "createdDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     *
     * @param createdDate
     */
    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "lastUpdate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     *
     * @param lastUpdate
     */
    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate=lastUpdate;
    }

    /**
     *
     * @return
     */
    @Override
    @Column(name = "user", nullable = false)
    public String getUser() {
        return this.user;
    }

    /**
     *
     * @param user
     */
    @Override
    public void setUser(String user) {
        this.user=user;
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
     * @param version
     */
    public void setVersion(Long version){
        this.version=version;
    }

}
