package name.marmac.bankanalyzer.services.rest.server.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 10/09/2015.
 */
public class BankAccountsServicesProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountsServicesProperties.class);

    private String host             = null;
    private String port             = null;
    private String servletContext   = null;
    private String servicePath      = null;
    private String serviceVersion   = null;
    private String serviceInterface = null;
    private String resourcePath     = null;

    /*

     */
    public String getHost() {
        return host;
    }

    /**
     *
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     *
     * @return
     */
    public String getPort() {
        return port;
    }

    /**
     *
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     *
     * @return
     */
    public String getServletContext() {
        return servletContext;
    }

    /**
     *
     * @param servletContext
     */
    public void setServletContext(String servletContext) {
        this.servletContext = servletContext;
    }

    /**
     *
     * @return
     */
    public String getServicePath() {
        return servicePath;
    }

    /**
     *
     * @param servicePath
     */
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    /**
     *
     * @return
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     *
     * @param serviceVersion
     */
    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    /**
     *
     * @return
     */
    public String getServiceInterface() {
        return serviceInterface;
    }

    /**
     *
     * @param serviceInterface
     */
    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    /**
     *
     * @return
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     *
     * @param resourcePath
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        LOGGER.debug("BankAccountsServicesProperties{" +
                        "host='" + host + '\'' +
                        ", port='" + port + '\'' +
                        ", servletContext='" + servletContext + '\'' +
                        ", servicePath='" + servicePath + '\'' +
                        ", serviceVersion='" + serviceVersion + '\'' +
                        ", serviceInterface='" + serviceInterface + '\'' +
                        ", resourcePath='" + resourcePath + '\'' +
                        '}');

        return "BankAccountsServicesProperties{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", servletContext='" + servletContext + '\'' +
                ", servicePath='" + servicePath + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", serviceInterface='" + serviceInterface + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                '}';
    }

}
