Feature: validate login functionality of amazon application
Scenario: user enters product and click search button
Given user launch edge browser
When user enter amazon url
And user enter product name and click search button
		|mobile|tv|
		|redmi note 12 |readme tv|  
		|samsung s25|samsung tv|
		|vivo v11|lg tv|
