package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * This class implements all the assertions which cover the acceptance criteria written in the feature files
 *
 * @author Gayathri Gamage
 * Date 11 June 2022
 */
public class Assertions implements En {

    ValidatableResponse validatableResponse;

    public Assertions() {
        Then("^user gets a set of results with status code (\\d+)$", (Integer statusCode) -> {
            validatableResponse = SearchStepDefinition.response.then().statusCode(statusCode);
        });
        And("^in the search response, category name should be \"([^\"]*)\"$", (String categoryName) -> {
            validatableResponse.body("Name", equalTo(categoryName));
        });
        And("^in the search response, category relist status should be \"([^\"]*)\"$", (String categoryRelistStatus) -> {
            validatableResponse.body("CanRelist", equalTo(Boolean.valueOf(categoryRelistStatus)));
        });
        And("^in the search response, promotion element \"([^\"]*)\" should contains \"([^\"]*)\"$", (String promoEleName, String promoEleDescription) -> {

            /* *** Travers to Promotions node and collect all the 'Name' elements *** */
            List<String> promoEleNameList = validatableResponse.extract().path("Promotions.Name");
            /* *** Gets the index of the given element 'Name' *** */
            int index = promoEleNameList.indexOf(promoEleName);
            /* *** Picks the element description related to the given 'Name' node and asserts that description value contains the given text  *** */
            validatableResponse.body("Promotions[" + index + "].Description", containsString(promoEleDescription));
        });


    }
}
