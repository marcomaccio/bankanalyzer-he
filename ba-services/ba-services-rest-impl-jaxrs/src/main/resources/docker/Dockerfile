#Base
FROM jetty:9.3-jre8

#Mainteiner
MAINTAINER Marco Maccio <marco.maccio@marmac.name>


EXPOSE 8080

# Add the bankanalyzer-he war
ADD maven/bankanalyzer-he.war "$JETTY_BASE/webapps/bankanalyzer-he.war"

