package get;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Get_02_Negative_Test_Hard_Assertion {


    @Test
    public void testName() {
/*
Given
  https://restful-booker.herokuapp.com/booking/224234
When
  User send Get Request to the endpoint
Then
  Status Code is 404
And
  Status-text is "HTTP/1.1 404 Not Found"
And
  Response body include "Not Found"
And
  Response body does not include "Hakan Kara"
And
  Header Server is "Cowboy"
And
Header Connection is "keep-alive"
*/

        //1- set the url  bu endpointe get talebi yapacagiz
        String url= "https://restful-booker.herokuapp.com/booking/224234";

        //2-set the expected data

        //3- send the request and get the response
        //bir talep gonderecegiz (given ile)  karsiya ve onun cevabini alacagiz
        //get() ile gidilip hakkinda bilgi istenilen end point gonderilir
        Response response= given().get(url);
        //response DB'den (karsidan) gelen cevaptir ve icinde data bulunur
        response.prettyPrint();

        //4- do assertion gelen response dogrulanacak
        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(equalTo("Not Found"))
                .body(not("Hakan Kara"))
                .header("Server","Cowboy")
                .header("Connection", "keep-alive");

        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
        assertEquals("Not Found", response.getBody().asString());
        assertNotEquals("Hakan Kara", response.getBody().asString());
        assertEquals("Cowboy", response.getHeader("Server"));
        assertEquals("keep-alive", response.getHeader("Connection"));
    }
}
