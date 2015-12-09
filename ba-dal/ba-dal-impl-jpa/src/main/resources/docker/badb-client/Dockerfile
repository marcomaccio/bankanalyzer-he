#Base
FROM java:8u66-jdk

#Mainteiner
MAINTAINER Marco Maccio <marco.maccio@marmac.name>


ADD maven/liquibase.jar /usr/src/badb-client/lib

WORKDIR /usr/src/badb-client

RUN java -jar $HOME/.m2/repository/org/liquibase/liquibase-core/3.4.1/liquibase-core-3.4.1.jar \
               --driver=com.mysql.jdbc.Driver \
               --classpath=$HOME/.m2/repository/mysql/mysql-connector-java/5.1.18/mysql-connector-java-5.1.18.jar \
               --changeLogFile=../resources/name/marmac/bankanalyzer/dal/db.changelog.xml \
               --url="jdbc:mysql://bankanalyzerdb:3306/bankanalyzer" \
               --username=$1 \
               --password=$2 \
               --logLevel=debug \
               update
CMD ["java", "Main"]