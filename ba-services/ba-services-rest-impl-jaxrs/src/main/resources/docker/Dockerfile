#Base
FROM java:7-jdk

#Mainteiner
MAINTAINER Marco Maccio <marco.maccio@marmac.name>

# Install packages
RUN apt-get update && \
    apt-get update --fix-missing && \
    apt-get install -y wget

# Download and install jetty
ENV JETTY_VERSION 7.4.5
ENV RELEASE_DATE v20110725


#release 9+ http://download.eclipse.org/jetty/stable-9/dist/jetty-distribution-${JETTY_VERSION}.${RELEASE_DATE}.tar.gz
RUN wget http://archive.eclipse.org/jetty/${JETTY_VERSION}.${RELEASE_DATE}/dist/jetty-distribution-${JETTY_VERSION}.${RELEASE_DATE}.tar.gz  && \
    tar -xzvf jetty-distribution-${JETTY_VERSION}.${RELEASE_DATE}.tar.gz && \
    rm -rf jetty-distribution-${JETTY_VERSION}.${RELEASE_DATE}.tar.gz && \
    mv jetty-distribution-${JETTY_VERSION}.${RELEASE_DATE}/ /opt/jetty

# Configure Jetty user and clean up install
RUN useradd jetty && \
    chown -R jetty:jetty /opt/jetty && \
    rm -rf /opt/jetty/webapps.demo

ENV BA_VERSION 1.0.0
ENV BA_RELEASE_TYPE BUILD-SNAPSHOT

EXPOSE 8080

# Add the BankAnalyzer-HE WAR
ADD target/ba-services-rest-impl-jaxrs-1.0.0.BUILD-SNAPSHOT.war /opt/jetty/webapps/

# Set defaults for docker run
WORKDIR /opt/jetty
CMD ["java", "-jar", "start.jar", "jetty.home=/opt/jetty"]
