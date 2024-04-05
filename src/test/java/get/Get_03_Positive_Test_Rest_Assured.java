package get;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get_03_Positive_Test_Rest_Assured {


    @Test
    public void positiveTest() {
        // 1- set the url
        String url="https://jsonplaceholder.typicode.com/todos/75";

        //2- set the expected data


        //3- send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //4- do assertion Rest Assured ile (JsonPath)
        JsonPath jsonPath=response.jsonPath();

        int expectedStatusCode=200;
        int actualStatusCode=response.statusCode();

        assertEquals(expectedStatusCode,actualStatusCode);

        int expectedUserId=4;
        assertEquals(expectedUserId,jsonPath.getInt("userId"));

        int expectedId=75;
        assertEquals(expectedId,jsonPath.getInt("id"));

        String expectedTitle="occaecati adipisci est possimus totam";
        assertEquals(expectedTitle,jsonPath.getString("title"));

        boolean expectedCompleted=false;
        assertEquals(expectedCompleted,jsonPath.getBoolean("completed"));




    }
}
