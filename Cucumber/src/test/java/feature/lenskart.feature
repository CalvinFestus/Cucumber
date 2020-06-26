Feature: Lenskart.com

Scenario Outline:: Buy a Lens

Given Go to https://www.lenskart.com/
Given Mouseover on Contact Lenses 
Given Click on Monthly under Explore By Disposability
Given Select brand as Aqualens
Given Click on the first product
Given Click Buy Now
Given Select No of boxes as <box> and Power as <power> for both eyes.
Given Type your <username> in User's name 
When And click Save and continue
Then Print total amount and click Proceed to Checkout

Examples:
|box|power|username|
|2|-1|calvin|