Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both home and offers page

Given user is on GreenKart Landing Page
When user searched with shortname "Tom" and extracted actual name of product
Then user searched for same shortname in offers page to check if product exist