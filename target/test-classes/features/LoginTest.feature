Feature: To test the login page functionality
  This feature will test all loginpage testcases

  Scenario: login with valid User and password
    Given I launched BPTravelwebpage  "https://bptravel.blueprism.com/login.html"
    When I enter valid UserName "admin"and Password "admin"
    And clicked the login Button
    Then I validate homepage Url "https://bptravel.blueprism.com/search.html"

  Scenario: login with INvalid User and password
    Given I launched BPTravelwebpage "https://bptravel.blueprism.com/login.html"
    When I enter UserName "adminjmnf" and password "admin12"
    And clicked the login Button
    Then I validate ErrorMessage "Please enter a valid user name and password"
