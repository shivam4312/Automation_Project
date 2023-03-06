Feature: Add Address 
Scenario Outline: To validate add address functionality
Given user is on login page
When user enter "<username>" and "<password>" and click login button 
Then user clicks on My Account then Address
Then user enter "<firstname>" , "<lastName>" , "<Email>"  , "<cityname>" , "<addressCity>" , "<postalCode>" and "<pNumber>" and click save button




Examples:
|username|password|firstname|lastName|Email|cityname|addressCity|postalCode|pNumber|
|shivam4312@gmail.com|asdfghjkl|Shivam|Raj|shivam4312@gmail.com|Chennai|wipro-street,chennai|600119|9658741680|