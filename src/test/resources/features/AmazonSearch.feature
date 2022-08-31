@AmazonFilterFeature
Feature: Filter by televisions brand inside the Amazon website

Background:
    Given User goes to the Amazon page

Scenario: Validate that user can filter by Samsung televisions brand on Amazon website
    When User opens filter menu
    And User selects section "TV, Appliances, Electronics" under category "shop by department"