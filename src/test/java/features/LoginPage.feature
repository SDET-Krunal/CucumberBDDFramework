Feature: "Application Login"

  Scenario Outline: "User is able to login with valid credentials"
    Given User is on application login page
    When User enters username as "<username>" and password as "<password>"
    Then User should get navigated to application Home page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: "Locked out user is not able to login into application"
    Given User is on application login page
    When User enters username as "<username>" and password as "<password>"
    Then Locked out user should get an error while login into application

    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |
