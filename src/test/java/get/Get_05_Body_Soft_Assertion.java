package get;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;

public class Get_05_Body_Soft_Assertion {
           /*
   Given
       https://fakerestapi.azurewebsites.net/api/v1/Activities
   When
  I send a GET request to the Url
And
    Content type is "application/json; charset=utf-8; v=1.0"
Then
    HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    There should be 30 activities
And
    "Activity 3" should be one of the activity title
And
    2, 7, and 9 should be among the id's
*/

    @Test
    public void testName() {

        //1- set the url
        String url = "https://fakerestapi.azurewebsites.net/api/v1/Activities";

        //2- set the expected data

        //3- send the request and get the response
        Response response = given().accept("text/plain; v=1.0").get(url);
        response.prettyPrint();

        //4- do assertion
        JsonPath jsonPath = response.jsonPath();
        List<Object> ids = jsonPath.getList("id");
        int idCount = ids.size();
        System.out.println("Number of ids = " + idCount);

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", hasSize(idCount),
                        "id", hasItems(2, 7, 9),
                        "title", hasItem("Activity 3"),
                        "title", hasItems("Activity 30", "Activity 26", "Activity 15"),
                        "completed", hasItems(false, true));


    }
}
