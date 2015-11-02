package name.marmac.bankanalyzer.dal.impl.properties;

/**
 * Created by marcomaccio on 21/11/2014.
 */
public class DataStoreProperties {

    private String  jdbcDriverName;
    private String  jdbcUrl;
    private String  jdbcUserName;
    private String  jdbcPassword;
    private String  schemaFileName;
    private String  jdbcEncoding;

    /**
     *
     * @return
     */
    public String getJdbcDriverName() {
        return jdbcDriverName;
    }

    /**
     *
     * @param jdbcDriverName
     */
    public void setJdbcDriverName(String jdbcDriverName) {
        this.jdbcDriverName = jdbcDriverName;
    }

    /**
     *
     * @return
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     *
     * @param jdbcUrl
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     *
     * @return
     */
    public String getJdbcUserName() {
        return jdbcUserName;
    }

    /**
     *
     * @param jdbcUserName
     */
    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    /**
     *
     * @return
     */
    public String getJdbcPassword() {
        return jdbcPassword;
    }

    /**
     *
     * @param jdbcPassword
     */
    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    /**
     *
     * @return
     */
    public String getJdbcEncoding() {
        return jdbcEncoding;
    }

    /**
     *
     * @param jdbcEncoding
     */
    public void setJdbcEncoding(String jdbcEncoding) {
        this.jdbcEncoding = jdbcEncoding;
    }

    /**
     *
     * @return
     */
    public String getSchemaFileName() {
        return schemaFileName;
    }

    /**
     *
     * @param schemaFileName
     */
    public void setSchemaFileName(String schemaFileName) {
        this.schemaFileName = schemaFileName;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "JdbcConnectionProperties{" +
                "jdbcDriverName='" + jdbcDriverName + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                ", jdbcUserName='" + jdbcUserName + '\'' +
                ", jdbcEncoding='" + jdbcEncoding + '\'' +
                ", schemaFileName='" + schemaFileName + '\'' +
                '}';
    }
}
