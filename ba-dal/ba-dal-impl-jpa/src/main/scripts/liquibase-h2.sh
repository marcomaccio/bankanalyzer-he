#!/usr/bin/env bash
java -jar $HOME/.m2/repository/org/liquibase/liquibase-core/3.4.1/liquibase-core-3.4.1.jar \
      --driver=org.h2.Driver \
      --classpath=$HOME/.m2/repository/com/h2database/h2/1.4.190/h2-1.4.190.jar \
      --changeLogFile=../resources/name/marmac/bankanalyzer/dal/db.changelog.xml \
      --url="jdbc:h2:file:~/.bankanalyzer/bankanalyzerDB;AUTO_SERVER=TRUE" \
      --username=$1 \
      --password=$2 \
      --logLevel=debug \
      $3 $4