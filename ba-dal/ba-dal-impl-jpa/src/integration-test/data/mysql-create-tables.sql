
CREATE TABLE `BankAccounts` (
  `pkId`          bigint(20)    NOT NULL AUTO_INCREMENT,
  `bankName`      varchar(50)  NOT NULL,
  `holderName`    varchar(100)  NOT NULL,
  `iban`          varchar(100)  NOT NULL,
  `openingDate`   datetime     NOT NULL,
  `createDate`    datetime      DEFAULT NULL,
  `lastUpdate`    datetime      DEFAULT NULL,
  `version`       bigint(20)    DEFAULT NULL,
  PRIMARY KEY (`pkId`),
  UNIQUE KEY `iban` (`iban`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Transactions` (
  `pkId`          bigint(20)    NOT NULL AUTO_INCREMENT,
  `executionDate` datetime      NOT NULL,
  `valueDate`     datetime      NOT NULL,
  `description`   varchar(255)  NOT NULL,
  `amount`        decimal(20,3) NOT NULL,
  `currency`      varchar(3)    NOT NULL,
  `balance`       decimal(20,3) NOT NULL,
  `category`      varchar(255)  NOT NULL,
  `subCategory`   varchar(255)  NOT NULL,
  `createdDate`    datetime      DEFAULT NULL,
  `lastUpdate`    datetime      DEFAULT NULL,
  `version`       bigint(20)    DEFAULT NULL,
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;