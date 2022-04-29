@smoke
Feature: Default

	#test 27 
    @TL-105 @db
    Scenario: connection test27
    Given I am in the homepage of the library app
    When I take borrowed books number
    Then borrowed books number information must match with DB