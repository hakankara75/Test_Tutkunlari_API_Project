package get;

import baseUrl.HerokuApp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get_01 extends HerokuApp_BaseUrl {
    /*
 https://restful-booker.herokuapp.com/booking/34
 HTTP Status Code'unun 200
 Content Type'ın "application/json; charset=utf-8"
 Status Line'ın "HTTP/1.1 200 OK
 Server'ın' "Cowboy"
 Connection'ın "keep-alive"
 oldugunu dogrular
*/

    @Test
    public void first() {
        //1- set the url
        String url= "https://restful-booker.herokuapp.com/booking/75";

        //2- set the expected data

        //3- send the request and get the response
        Response response =given().get(url);
        response.prettyPrint();

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Server","Cowboy")
                .header("Connection", "keep-alive")
                .time(lessThan(3000L));

    }

    @Test
    public void second() {
        //1- set url
//String url= "https://restful-booker.herokuapp.com/booking/75";
        specHeroku.pathParams("first","booking", "second", 5);

        //3- send request and get response
        Response response =given(specHeroku).get("{first}/{second}");
        response.prettyPrint();

        //4- do assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary")
                        ,"lastname",equalTo("Jones"));

    }
}
