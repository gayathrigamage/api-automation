package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import metadata.Constants;
import metadata.PropertyLoader;

import static io.restassured.RestAssured.given;

/**
 * This class implements all the step definitions of the steps written in the feature file
 *
 * @author Gayathri Gamage
 * Date 11 June 2022
 */
public class SearchStepDefinition implements En {

    public static RequestSpecification requestSpecification;
    public static Response response;

    /**
     * Constructor
     */
    public SearchStepDefinition() {

        Given("^user wants to access API with \"([^\"]*)\"$", (String categoryId) -> {
            requestSpecification = given().pathParam("CategoryId", categoryId);
        });

        When("^user clicks search and waits for results$", () -> {
            String url = PropertyLoader.getAllProperties().getProperty(Constants.CATEGORY_SEARCH_END_POINT);
            response = requestSpecification.when().get(url);
        });

    }

}
