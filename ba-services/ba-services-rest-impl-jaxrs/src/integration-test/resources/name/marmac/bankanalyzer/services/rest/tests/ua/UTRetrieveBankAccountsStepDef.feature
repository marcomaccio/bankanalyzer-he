Feature: BankAnalyzer can retrieve BankAccounts

  Scenario: It's possible to retrieve all the Bank Account
      Given the username and password
        | username  | pippo.disney@disney.com |
        | password  | 'Topolino123!' |
      When the client request a list of bankaccount
      Then the response is a list containing 3 bankaccounts