package name.marmac.bankanalyzer.model.impl.jpa.nosql;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * Created by marcomaccio on 19/02/2016.
 */
@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class TransactionPONoSql {

    private static final long   serialVersionUID    = 1L;
    private static final Logger LOGGER              = LoggerFactory.getLogger(TransactionPONoSql.class);

    private              String id;
    private              Long   version;

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
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

}
