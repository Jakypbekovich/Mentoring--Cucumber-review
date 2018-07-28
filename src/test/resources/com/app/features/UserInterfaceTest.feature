Feature: User Interface for PHP
	@one
  Scenario: Site Title and Dashboard buttons
    Given I logged in the PHP website and entered credentials
    When I see dashboard page buttons are visible
    Then Blog box contains my link

  @one @smoke
  Scenario: Check count of Customers
    Given I logged in the PHP website and entered credentials
    When I go into Bookings Tab
    Then I get count of cutomers
	
  Scenario: Check Text of navigation Bar
    Given I logged in the PHP website and entered credentials
    When I see dashboard page buttons are visible
    #Then I go into "CMS Pages" Tab