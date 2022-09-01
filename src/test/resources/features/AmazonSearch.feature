@AmazonFilterFeature
Feature: Filter by televisions brand inside the Amazon website

Background:
    Given User goes to the Amazon page

Scenario: Validate that user can filter by Samsung televisions brand on Amazon website
    When User opens filter menu
    And User selects section "TV, Appliances, Electronics" under category "shop by department"
    And User selects section "Televisions" under category "tv, audio & cameras"
    And User selects "Samsung" under section "Brands"
    And User sorts by "Price: High to Low"
    And User opens result at position "2"
    Then Assert and print About this item section
