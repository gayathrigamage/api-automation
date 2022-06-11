Feature: Category Details Verification


  Scenario Outline: Verify category name(Scenario 1 : Verify category name in category Id "<categoryId>")
    Given user wants to access API with "<categoryId>"
    When user clicks search and waits for results
    Then user gets a set of results with status code 200

    And in the search response, category name should be "<categoryName>"

    Examples:
      | categoryId | categoryName   |
      | 6327       | Carbon credits |


  Scenario Outline: Verify category relist status(Scenario 2 : Verify category relist status in category Id "<categoryId>")
    Given user wants to access API with "<categoryId>"
    When user clicks search and waits for results
    Then user gets a set of results with status code 200

    And in the search response, category relist status should be "<categoryRelistStatus>"

    Examples:
      | categoryId | categoryRelistStatus |
      | 6327       | true                 |

  Scenario Outline: Verify category promotion details(Scenario 3 : Verify category promotion element description in category Id "<categoryId>")
    Given user wants to access API with "<categoryId>"
    When user clicks search and waits for results
    Then user gets a set of results with status code 200

    And in the search response, promotion element "<name>" should contains "<promoEleDescription>"

    Examples:
      | categoryId | name    | promoEleDescription       |
      | 6327       | Gallery | Good position in category |
