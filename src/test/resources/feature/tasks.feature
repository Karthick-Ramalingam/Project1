Feature: to validate login functionality of facebook application

Background:
Given user launch edge browser

Scenario Outline: to validate login with invalid username and invalid password
When user enter valid url
And user enter "<username>" and "<password>"
Then user click login button

Examples:   
		|username|password|
		|java|java@123|
		|python|python@123|
		|cucumber|123456|

Scenario: to validate login with valid username and valid password
When user enter valid url
And user enter valid username and valid password
Then user click login button 


