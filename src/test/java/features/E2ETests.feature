Feature: E2E API Tests
		 https://reqres.in/
@test
Scenario: GET Single User
    Given I have access to end points
    When I "Get" "GETSingleUser" end point
    Then I get "OK" status
    And I get "200" response
    Then I get the user details

Scenario: GET Users
    Given I have access to end points
    When I "Get" "GETUsers" end point
    Then I get "OK" status
    And I get "200" response
    Then I verify multiple user details are returned
    
Scenario: CREATE User
    Given I have access to end points	
    When I call "Post" for "CreateUser" end point for "Tester" name and "Automation" job
    Then I get "Created" status
    And I get "201" response
    Then I verify user details for "Tester" name and "Automation" job
    
Scenario: UPDATE User using PUT
    Given I have access to end points	
    When I call "Put" for "UpdateUserPUT" end point for "Tester_Update" name and "Automation_Update" job
    Then I get "OK" status
    And I get "200" response
    Then I verify user details for "Tester_Update" name and "Automation_Update" job    
 
Scenario: UPDATE User using PATCH
    Given I have access to end points	
    When I call "Patch" for "UpdateUserPUT" end point for "Tester_Update_Patch" name and "Automation_Update" job
    Then I get "OK" status
    And I get "200" response
    Then I verify user details for "Tester_Update_Patch" name and "Automation_Update" job     

Scenario: DELETE User
    Given I have access to end points
    When I "Delete" "DeleteUser" end point	
    Then I get "No Content" status
    And I get "204" response   
