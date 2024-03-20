package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;


public class HerokuApp_BaseUrl {

    protected RequestSpecification specHeroku;

    @BeforeMethod
            public void setup(){
        specHeroku= new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();

    }



}
