package name.marmac.bankanalyzer.dal.impl.jpa.nosql.properties;

/**
 * Created by marcomaccio on 19/02/2016.
 */
public class DataStoreProperties {

    private String nosqlHost;
    private String nosqlPort;
    private String nosqlDatabase;

    public String getNosqlHost() {
        return nosqlHost;
    }

    public void setNosqlHost(String nosqlHost) {
        this.nosqlHost = nosqlHost;
    }

    public String getNosqlPort() {
        return nosqlPort;
    }

    public void setNosqlPort(String nosqlPort) {
        this.nosqlPort = nosqlPort;
    }

    public String getNosqlDatabase() {
        return nosqlDatabase;
    }

    public void setNosqlDatabase(String nosqlDatabase) {
        this.nosqlDatabase = nosqlDatabase;
    }

}
