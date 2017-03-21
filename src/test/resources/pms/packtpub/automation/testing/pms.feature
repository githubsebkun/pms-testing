Feature: Test smoke scenarios of Parish Management Ssystem (PMS)



  Scenario: Test PMS with valid credentials

    Given Open Chrome(browser) and start application
    When I provide valid  username and password
    Then user should be able to login