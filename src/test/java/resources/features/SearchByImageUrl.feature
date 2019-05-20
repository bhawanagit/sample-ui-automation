Feature: perform a �Search by Image� and visit the third result from images

Background:
  Given I navigate to Google

  @2
   Scenario Outline:Get the third image from google search by search by images Url
    When User click on Images text
    And User click on camera icon
    Then User add the url
    And  User click on search by image button
    And User verify the configured image result
    Then User should nevigate to third image result
     Examples:
        |	SearchText        |
        |	"https://www.publicdomainpictures.net/pictures/40000/t2/lion-head-portrait.jpg"		      |
