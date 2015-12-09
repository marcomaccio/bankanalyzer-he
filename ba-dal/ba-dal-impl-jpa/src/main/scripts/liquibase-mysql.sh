#!/usr/bin/env bash
java -jar $HOME/.m2/repository/org/liquibase/liquibase-core/3.4.1/liquibase-core-3.4.1.jar \
      --driver=com.mysql.jdbc.Driver \
      --classpath=$HOME/.m2/repository/mysql/mysql-connector-java/5.1.18/mysql-connector-java-5.1.18.jar \
      --changeLogFile=../resources/name/marmac/bankanalyzer/dal/db.changelog.xml \
      --url="jdbc:mysql://localhost:3306/bankanalyzer" \
      --username=$1 \
      --password=$2 \
      --logLevel=debug \
      $3 $4