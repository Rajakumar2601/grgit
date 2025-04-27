
@loginOutline
Feature: To test login page functionality using scenario Outline
          this feature will login page test case 

  Scenario Outline: login with valid different Username and password
    Given I launched  BP travel page
    When I enter Username "<username>" and password "<password>"
    And I clicked login button
    Then I verify homepage Url"<url>"

    Examples: 
      |username | password |url  |
      | admin |    admin | https://bptravel.blueprism.com/search.html |
      |admin2 |   admin | https://bptravel.blueprism.com/search.html   |
