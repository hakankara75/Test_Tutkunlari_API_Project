package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_04_Body_Hard_Assertion {
          /*
   Given
       https://fakerestapi.azurewebsites.net/api/v1/Activities/1
   When
  I send a GET request to the Url
And
    accept  is "text/plain; v=1.0"
Then
    HTTP Status Code should be 200
And
    Response format should be "application/json; charset=utf-8; v=1.0"
And
    "id" is 1
And
    "title" is "Activity 1",
And
    "dueDate" is "2024-05-21T17:36:31.9123672+00:00"
And
    "completed" is false
*/

    @Test
    public void testName() {

        // 1- set the url
        String url= "https://fakerestapi.azurewebsites.net/api/v1/Activities/1";

        //2- set the expected data

        //3- send the request and get the response
        Response response =given().accept("text/plain; v=1.0").get(url);
        response.prettyPrint();

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8; v=1.0")
                .body("id", equalTo(1))
                .body("title", equalTo("Activity 1"))
                .body( "completed", equalTo(false) );



    }
}
