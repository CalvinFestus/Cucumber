Feature: Ajio

Scenario: Search

Given Go to https://www.ajio.com/
Given Mouseover on Women, CATEGORIES and click on Kurtas
Given Click on Brands and choose Ajio
Given Check all the results are Ajio
Given Set Sort by the result as Discount
Given Select the Color and click ADD TO BAG
Given Verify the error message Select your size to know your estimated delivery date
Given Select size and click ADD TO BAG
Given click on Enter pin-code to know estimated delivery date
When Enter the pincode as 603103 and click Confirm pincode
Then Print the message and click Go to  Bag
Then Click on Proceed to Shipping and clode the browser