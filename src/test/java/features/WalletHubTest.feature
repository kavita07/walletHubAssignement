Feature: Provide user Review

  Background: Launch WalletHUb url
    Given User launches WalletHub URL

@test
  Scenario Outline: Verify user review has updated
    When User navigate to login page and enters credentials for WalletHub login
    Then Verify user login to wallethub successfully
    When User hovers over four star
    Then Verify star ligheten up
    When User clicks on four star
    And User selects policy drodown value "<policyValue>"
    And User writes review with minimum 200
    And User clicks on submit review button
    Then Verify review posted successfully
    When User selects profile menu value "<profileValue>"
    Then Verify review displaying

    Examples: 
      | policyValue      | profileValue |
      | Health Insurance | Profile      |
