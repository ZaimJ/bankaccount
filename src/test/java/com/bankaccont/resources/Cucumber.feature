Feature: doing operations
  Client should be able to submit POST request to deposit an amount on his account
  Client should be able to submit POST request to withdraw an amount from his account
  Client should be able to submit POST request to transfer an amount from his account to a receiver account
  Client should be able to submit GET request to retrieve list of operations done from his account
  Client should be able to submit GET request to retrieve list of operations done from onther account to his own account

  Scenario: Should be able to deposit an amount
    Given I fill in my account number
    And I fill in the amount with 1200
    When I press "DO A DEPOSIT OPERATION"
    Then I will get "deposit done"

  Scenario: Should be able to withdraw an amount
    Given I fill in my account number
    And I fill in the amount with 1200
    When I press "DO A WITHDRAW OPERATION"
    Then I will get "withdraw done"

  Scenario: Should be able to transfer an amount
    Given I fill in my account number
    And I fill in the receiver account number
    And I fill in the amount with 1200
    When I press "DO A TRANSFER OPERATION"
    Then I will get "transfer done"


  Scenario: Should be able to retrieve operation done from sender account
    Given I fill in my account number
    When I press "GET OPERATIONS DONE FROM MY ACCOUNT"
    Then I will get "operations from your account : "


  Scenario: Should be able to retrieve operation done coming to sender account
    Given I fill in my account number
    When I press "GET OPERATIONS COMING TO MY ACCOUNT"
    Then I will get "operations from your account : "





