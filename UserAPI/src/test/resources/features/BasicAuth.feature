Feature: User Feature with Basic Authorization

  Background: 
    Given User sets Basic Authorization

  @positive
  Scenario Outline: Check if user able to create a new user with valid endpoint and request body
    Given User creates POST request with valid endpoint and request body
    When User sends HTTPS Request with endpoint from given "<ScenarioName>" and  "<SheetName>"
    Then User receives "<Status>" and "<Message>" with response body

    Examples: 
      | ScenarioName                        | SheetName | Status | Message |
      | CreateUser1                         | User      |    201 | created |
      | CreateUser2_MissingAdditionalFields | User      |    201 | created |

  @negative
  Scenario Outline: Check if user is able to create program with invalid values in request body
    Given User creates POST request with valid endpoint and invalid request body
    When User sends HTTPS Request with endpoint from given "<ScenarioName>" and  "<SheetName>"
    Then User receives "<Status>" and "<Message>" for corresponding Post Negative Scenarios

    Examples: 
      | ScenarioName                  | SheetName | Status | Message                                              |
      | CreateUserWithExistingContact | User      |    409 | Conflict User already exist with same contact number |
      | CreateUserWithExistingEmailId | User      |    409 | Conflict User already exist with same email id       |
      