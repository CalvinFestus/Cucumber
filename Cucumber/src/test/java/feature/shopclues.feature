Feature: Shop Clues

Scenario: Search a Product 

Given Go to https://www.shopclues.com/
Given Mouseover on women and click Casual Shoes
Given Select Color as Black
Given Check whether the product name contains the word black, If so, add the product name and price in to Map
Given Check Display the count of shoes which are more than 500 rupees
Given Click the highest price of the shoe
Given Get the current page URL and check with the product ID
Given Copy the offercode 
Given Select size, color and click ADD TO CART
When Mouse over on Shopping cart and click View Cart 
Then Type Pincode as 600126 click Submit and Place Order
Then Close the Shop Clues