#BANKANALIZER HE     
![Travis-ci.org](https://travis-ci.org/marcomaccio/bankanalyzer-he.svg?branch=master)
![CodeShip](https://codeship.com/projects/319f4a40-6f58-0133-4513-7ae947dfb2ee/status?branch=master)
[![DepShield Badge](https://depshield.sonatype.org/badges/marcomaccio/bankanalyzer-he/depshield.svg)](https://depshield.github.io)


	An Head End Application that allows to store Bank Account transactions and allows to make analysis

	This part is the Head End part and exposes the data via RESTful services

## ROADMAP

### Milestone 0 
Project set up and CI&CD life cycle

### Milestone 1 
#### GET APIs
	GET /BankAccounts/
	GET /BankAccounts/{id}
	GET /BankAccounts/{id}/transactions/
	GET /BankAccounts/{id}/transactions/{id}

	from a relational db (MariaDB)

### Milestone 2 
#### POST APIs
	POST /BankAccounts/
	POST /BankAccounts/{id}
	POST /BankAccounts/{id}/transactions/
	POST /BankAccounts/{id}/transactions/{id}

	from a relational db (MariaDB)

### Milestone 3 
#### PUT APIs
	PUT /BankAccounts/
	PUT /BankAccounts/{id}
	PUT /BankAccounts/{id}/transactions/
	PUT /BankAccounts/{id}/transactions/{id}	

	from a relational db (MariaDB)
	
	
# HOW TO BUILD
mvn -U -X -Pall-tests,local-depl-j2se-h2 clean install

# HOT TO RUN JETTY
mvn -U -amd -pl ba-services/ba-services-rest-impl-jaxrs/ -Pall-tests,local-depl-j2se-h2 jetty:run
	
# HOW TO LAUNCH A H2 CONSOLE
java -jar ~/.m2/repository/com/h2database/

# HOW TO DEPLOY IN JETTY
## LINUX:

export BANKANALYZER_SRC_HOME=/path_to/bankanalyzer-he
export JETTY_HOME=/path_to_jetty/

cp $BANKANALYZER_SRC_HOME/ba-services/ba-services-rest-impl-jaxrs/target/ba-services-rest-impl-jaxrs-${version}.war $JETTY_HOME/webapps/ && \\
mv $JETTY_HOME/webapps/ba-services-rest-impl-jaxrs-${version}.war $JETTY_HOME/webapps/bankanalyzer.war




# OAUTH2 & CXF
OAUTH2 flow is called authorization Code and it involves 3 parties:
 * the end user,
 * the 3rd party service (called client)
 * the resource server that is protected by the OAUTH2 filters
 
Workflow
Typically a client offers a service feature that an end user requests.
The service feature requires the end user to access one or more protected resources on behalf of this user which are located at the resource server.
