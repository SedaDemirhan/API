package com.techproed.day11;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostRequest03 extends JsonPlaceHolderTestBase {
    //https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
    //     }
    //     "userId": 55,
    //     "title": "Tidy your room",
    //     "completed": false
    //   }
    //Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
    //   {
    //     "userId": 55,
    //     "title": "Tidy your room",
    //     "completed": false,
    //     "id": …
    //    }

@Test
    public void test(){
    spec01.pathParam("parametre1","todos");

    JsonPlaceHolderTestData testData=new JsonPlaceHolderTestData();

    JSONObject expectedRequestData=testData.setUpPostData();
    System.out.println(expectedRequestData);

    Response response=given().
            contentType(ContentType.JSON).
            spec(spec01).
            auth().basic("admin","password123").
            body(expectedRequestData.toString()).
            when().
            post("/{parametre1}");
    response.prettyPrint();

    //Matchers class
    response.then().
            assertThat().statusCode(expectedRequestData.getInt("statusCode")).
            body("completed",equalTo(expectedRequestData.getBoolean("completed")),
    "title",equalTo(expectedRequestData.getString("title")),
            "userId",equalTo(expectedRequestData.getInt("userId")));

    //JsonPath ile
    JsonPath json=response.jsonPath();
    Assert.assertEquals(expectedRequestData.getInt("statusCode"),response.getStatusCode());
    Assert.assertEquals(expectedRequestData.getInt("userId"),json.getInt("userId"));
    Assert.assertEquals(expectedRequestData.getString("title"),json.getString("title"));
    Assert.assertEquals(expectedRequestData.getBoolean("completed"),json.getBoolean("completed"));

    //deserilization ile
    HashMap<String,Object>actualDataMap=response.as(HashMap.class);
    System.out.println(actualDataMap);

    Assert.assertEquals(expectedRequestData.getBoolean("completed"),actualDataMap.get("completed"));
    Assert.assertEquals(expectedRequestData.getInt("userId"),actualDataMap.get("userId"));
    Assert.assertEquals(expectedRequestData.getString("title"),actualDataMap.get("title"));




}
}
