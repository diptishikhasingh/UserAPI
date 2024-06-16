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
  Scenario Outline: Check if user is able to create user with invalid values in request body
    Given User creates POST request with valid endpoint and invalid request body
    When User sends HTTPS Request with endpoint from  given "<ScenarioName>" and  "<SheetName>"
    Then User receives "<Status>" and "<Message>" for corresponding Post Negative Scenarios

    Examples: 
      | ScenarioName                          | SheetName | Status | Message                                                                         |
      | CreateUserWithExistingContact         | User      |    409 | Conflict User already exist with same contact number                            |
      | CreateUserWithExistingEmailId         | User      |    409 | Conflict User already exist with same email id                                  |
      | CreateUserWithEmptyFirstname          | User      |    400 | Bad request user FirstName is mandatory and should contains alphabets only      |
      | CreateUserWithEmptyLastName           | User      |    400 | Bad request User Last Name is mandatory and should contains alphabets only      |
      | CreateUserWithEmptyContact            | User      |    400 | Bad request                                                                     |
      | CreateUserWithEmptyEmailId            | User      |    400 | Bad request User email Id is required and should be in proper email format      |
      | CreateUserWithAlphaNumericFirstName   | User      |    400 | Bad request user FirstName is mandatory and should contains alphabets only      |
      | CreateUserWithAlphaNumericLastName    | User      |    400 | Bad request User Last Name is mandatory and should contains alphabets only      |
      | CreateUserWithWrongFormatEmailId      | User      |    400 | Bad request User email Id is required and should be in proper email format      |
      | CreateUserWithInvaliidDatatypeContact | User      |    400 | Bad request Phone Number is required and should contains 10 numeric values only |
      | CreateUserWithNullFirstname           | User      |    400 | Bad request user FirstName is mandatory and should contains alphabets only      |
      | CreateUserWithNullLastName            | User      |    400 | Bad request User Last Name is mandatory and should contains alphabets only      |
      | CreateUserWithNullContact             | User      |    400 | Bad request Phone Number is required and should contains 10 numeric values only |
      | CreateUserWithNullEmailId             | User      |    400 | Bad request User email Id is required and should be in proper email format      |
      | CreateUserWithMissingFirstname        | User      |    400 | Bad request user FirstName is mandatory and should contains alphabets only      |
      | CreateUserWithMissingLastName         | User      |    400 | Bad request User Last Name is mandatory and should contains alphabets only      |
      | CreateUserWithMissingContact          | User      |    400 | Bad request Phone Number is required and should contains 10 numeric values only |
      | CreateUserWithMissingEmailId          | User      |    400 | Bad request User email Id is required and should be in proper email format      |
      | CreateUserWithUnexpectedExtraField    | User      |    400 | Bad request                                                                     |

  @negative
  Scenario: Check if user is able to create a user with valid URL and invalid endpoint
    Given User creates POST request with valid URL and invalid endpoint
    When User sends HTTPS Request with invalid endpoint with request body
    Then User should get the  Status Code 400 Not Found

  @negative
  Scenario: Check if user is able to create a user with valid endpoint and invalid method
    Given User creates POST request with valid endpoint and invalid method
    When User send invalid HTTPS Request with endpoint and request body
    Then User should get the Status Code 405 Method Not Allowed