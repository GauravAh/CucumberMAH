Feature: SignUp and Login Functionality

Scenario: User should be able to Login MAH with valid details
Given User should be on landing page
When Click on Login icon
And Click mouse over SignIn button
And Page redirected to new tab
And Enter Emailid
And Enter Password
And Wait for chat section to appear
And Enter message in chat window

Scenario: Test login with HashMap
Given User should be on landing page
When Click on Login icon
And Click mouse over SignIn button
And Page redirected to new tab
And NEnter Emailid
And NEnter Password

@sanity
Scenario Outline: Test login with DataScenarios
Given User should be on landing page
When Click on Login icon
And Click mouse over SignIn button
And Page redirected to new tab
And Enter Login Emailid as "<emailid>"
And Enter Login Password as "<password>"

Examples:
|emailid|password|
|qqaa@gmail.com|77445566|
|aaqq@gmail.com|441414141|

@smoke @sanity
Scenario: Test login with DataTable
Given User should be on landing page
When Click on Login icon
And Click mouse over SignIn button
And Page redirected to new tab
And Enter Login Emailid and Password
|emailid|password|
|jjuu@gmail.com|11225566|
|kkuu@gmail.com|88774455|







