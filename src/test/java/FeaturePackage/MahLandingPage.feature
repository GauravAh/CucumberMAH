
Feature: MAH order form functionality

Scenario: User should be able to place an order with valid details
Given User should be on MAH landing page
When Entered Emailid
And Subject
And Select valid date
And Select time from dropdown
And Enter Phone phoneno
And Enter description
And Attach a file
And Click on Free Assistance button
Then Page should be redirected to the dashboard page