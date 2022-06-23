Feature: Facebook workflow validation

  Background: Launch facebook url
    Given User launches facebook URL

@test
  Scenario Outline: Verify login to facebook and post a status messge
    When User enters user name and password for facebook login
    And User clicks on SignIn button
    Then Verify user login successfull
    And User posts message "<message>"
    Then Verify text "<message>" displayed

    Examples: 
      | message     |
      | hello world |
