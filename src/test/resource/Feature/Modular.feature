 
Feature: To test services functionality
Background:
Given user is on the homepage of Asian Paints website
When hover over the "Services" menu



@interior
Scenario: To view interior painting

When click on the painting services  option
And scrolldown the painting services
And click on interior wall painting
And scrolldown the page 
And click on royale glitz
Then It displays the royale glitz



@Contractor
Scenario Outline: To find a contractor

When click on the find a contractor option
And enter a valid <pincode>
And click on search
And Scrolldown the page contractor page 
Then It gives the contractor details accordingly given pincode
Examples:
 |pincode|
 |400060|
	

	
@valid
  Scenario Outline: Fill out and submit book a call
		When click on the Modular Kitchen option
		And scroll down the page towards book a call
		And customer details are <enquire-name>, <enquire-emai>, <enquire-mobile> and <enquire-pincode>
		And click on the BOOK A CALL button
		Then call is booked successfully
 
	Examples:
	|enquire-name|enquire-emai|enquire-mobile|enquire-pincode|
	|Nikhitha    |nikhitharaveendar@gmail.com |7386295734|400060|
	
	
	
@Invalid
 Scenario Outline: Fill out the details and submit book a call
		When user should click on the modular kitchen option
		And  user should scroll down the page to book a call
		And  user details are <enquire-name>, <enquire-email>, <enquire-mobile> and <enquire-pincode>
		And user should click on the book a call button
		Then user call is is not able to book the call
 
Examples:
	|enquire-name|enquire-email|enquire-mobile|enquire-pincode|
	|Nikhitha    |nikhitharaveendar@gmail.com |khjiutl|415539|
	
	
@ContractorDetails 
Scenario Outline: To download the details
When user is click Find a Contractor
And user is able to find contractor by their area <area>
And user should click on search for details 
Then show the contractors belongs to their area
Examples:
 |area|
 |Hyderabad Nampally|