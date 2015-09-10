package name.marmac.bankanalyzer.services.rest.server.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServletContext() {
        return servletContext;
    }

    public void setServletContext(String servletContext) {
        this.servletContext = servletContext;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public String toString() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountsServicesProperties that = (BankAccountsServicesProperties) o;
        return Objects.equals(host, that.host) &&
                Objects.equals(port, that.port) &&
                Objects.equals(servletContext, that.servletContext) &&
                Objects.equals(servicePath, that.servicePath) &&
                Objects.equals(serviceVersion, that.serviceVersion) &&
                Objects.equals(serviceInterface, that.serviceInterface) &&
                Objects.equals(resourcePath, that.resourcePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, servletContext, servicePath, serviceVersion, serviceInterface, resourcePath);
    }
}
