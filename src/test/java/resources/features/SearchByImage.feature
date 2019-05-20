Feature: perform a �Search by Image� and visit the third result from images
Background:
  Given I navigate to Google

  @Regression
  Scenario Outline:Get the third image from google search by search by images

    When User search for <SearchText>
    And  User click on search button
    And  User should click on Images to explore more images
    And User should nevigate to third image
    Then User navigates to the configured image result
    Examples:
    |	SearchText        |
    |	"Lion"		      |