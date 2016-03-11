package name.marmac.bankanalyzer.model.impl.jpa.nosql;

import name.marmac.bankanalyzer.model.api.BasicPO;
import org.eclipse.persistence.nosql.annotations.Field;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marcomaccio on 10/03/2016.
 */
public class BaseNoSqlObject implements BasicPO {

    private static final long serialVersionUID = 1L;

    private String    id;
    private Long    version;
    private Date    createdDate;
    private Date    lastUpdate;
    private String  user = "";


    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field(name="_id")
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    @Basic
    @Field(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    @Basic
    @Field(name = "lastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    @Version
    @Basic
    @Field(name = "version")
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    @Basic
    @Field(name = "user")
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }
}
