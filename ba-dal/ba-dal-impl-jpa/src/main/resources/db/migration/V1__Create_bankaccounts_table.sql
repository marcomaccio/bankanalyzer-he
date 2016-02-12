CREATE TABLE BankAccounts (
    pkId        bigint(20) NOT NULL,
    bankName    varchar(100) NOT NULL,
    holderName  varchar(100) NOT NULL,
    iban        varchar(100) NOT NULL,
    openingDate datetime NOT NULL,
    createdDate datetime DEFAULT NULL,
    lastUpdate  datetime DEFAULT NULL,
    version     bigint(20) DEFAULT NULL,
    user        varchar(50) DEFAULT NULL,
  PRIMARY KEY (pkId),
  UNIQUE KEY iban (iban)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;