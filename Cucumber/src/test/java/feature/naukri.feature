Feature: Naukri.com

Scenario: Handle Windows in Naukri

Given Open naukri.com
When Get the company names from each pop up window and close it
When Click on the upload cv button and upload some random image.
Then the error message printed