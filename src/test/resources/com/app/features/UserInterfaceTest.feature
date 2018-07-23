
Feature: User Interface for PHP

  Scenario: Site Title and Dashboard buttons
    Given I logged in the PHP website and entered credentials
    When I see dashboard page buttons are visible
    Then Blog box contains my link
@one
Scenario: Check count of Customers
	Given I logged in the PHP website and entered credentials
	When I go into Bookings Tab
	Then I get count of cutomers