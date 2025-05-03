Feature: Contact Us Feature

 Background:
  Given user has already logged in to application
   |username|password|
   |nabanita@gmail.com|test123@|

@Regression
Scenario Outline: Contact Us scenario with different sets of data
 Given user navigates to contact us page
 When user fills the form given sheetName "<SheetName>" and rownum <RowNumber>
 And user clicks on Submit button
 Then It shows a success message "Success! Your details have been submitted successfully."

 Examples:
 | SheetName| RowNumber|
 | contactUs|    0     |
 | contactUs|    1     |