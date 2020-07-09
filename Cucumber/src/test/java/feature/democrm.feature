Feature: Demo CRM 

Scenario: Functionality of CRM

Given Go to https://demo.1crmcloud.com/
Given Give username as admin and password as admin
Given Choose theme as Claro Theme and Click Login
Given Go to Sales and Marketing and click Sales Home
Given Click Create contact
Given Select Title and type First name, Last Name, Email and Phone Numbers
Given Select Lead Source as Public Relations and Business Roles
Given Fill the Primary Address, City, State, Country and Postal Code and click Save
Given Click create and Leads
Given Fill First & Last name, Status as In Process, Title as Manager and Department as Sales
Given Select Lead as Public Relations and fill department, Email and Phone Number
Given Click Save and View
Given Mouse over on Today's Activities and click Meetings
Given Type Subject as Project Status Status as Planned and Time as tomorrow 8 pm
Given Click Add paricipants, add your created Lead name and click Save
When Click contacts under Sales and Marketting, search the lead Name and click the name from the result
Then Check weather the Meeting is assigned to the contact.
And Close the Browser