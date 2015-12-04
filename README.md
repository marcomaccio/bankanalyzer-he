#BANKANALIZER HE     
![Travis-ci.org](https://travis-ci.org/marcomaccio/bankanalyzer-he.svg?branch=master)
![CodeShip](https://codeship.com/projects/319f4a40-6f58-0133-4513-7ae947dfb2ee/status?branch=master)


	An Head End Application that allows to store Bank Account transactions and allows to make analysis

	This part is the Head End part and exposes the data via RESTful services

##ROADMAP

###Milestone 0 
Project set up and CI&CD life cycle

###Milestone 1 
####GET APIs
	GET /BankAccounts/
	GET /BankAccounts/{id}
	GET /BankAccounts/{id}/transactions/
	GET /BankAccounts/{id}/transactions/{id}

	from a relational db (MariaDB)

###Milestone 2 
####POST APIs
	POST /BankAccounts/
	POST /BankAccounts/{id}
	POST /BankAccounts/{id}/transactions/
	POST /BankAccounts/{id}/transactions/{id}

	from a relational db (MariaDB)

###Milestone 3 
####PUT APIs
	PUT /BankAccounts/
	PUT /BankAccounts/{id}
	PUT /BankAccounts/{id}/transactions/
	PUT /BankAccounts/{id}/transactions/{id}	

	from a relational db (MariaDB)
	
	
#HOW TO BUILD
mvn -U -X -Pall-tests,local-depl-j2se-h2 clean install

#HOT TO RUN JETTY
mvn -U -amd -pl ba-services/ba-services-rest-impl-jaxrs/ -Pall-tests,local-depl-j2se-h2 jetty:run
	
#HOW TO LAUNCH A H2 CONSOLE
java -jar ~/.m2/repository/com/h2database/