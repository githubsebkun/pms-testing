Feature: Test smoke scenarios of Parish Management Ssystem (PMS)



  Scenario Outline: Test PMS with valid credentials

    Given Open Chrome(browser) and start application
    When I provide valid uname "<username>" and valid pwd "<password>"
    Then user should be able to login
    Then user should be able to quit and close

    Examples:
      |username            | password   |
      |sunny@gmail.com     | 1234   |
