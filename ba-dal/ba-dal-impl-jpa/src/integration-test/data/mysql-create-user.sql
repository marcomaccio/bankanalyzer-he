CREATE DATABASE bankanalyzer CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER `bankanalyzer` IDENTIFIED BY `sonar`;
GRANT ALL ON bankanalyzer.* TO `bankanalyzer`@`%` IDENTIFIED BY `sonar`;
GRANT ALL ON bankanalyzer.* TO `bankanalyzer`@`localhost` IDENTIFIED BY `sonar`;
FLUSH PRIVILEGES;