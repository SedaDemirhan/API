package com.techproed.day12;




import com.techproed.testBase.jsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class PatchRequest01 extends jsonPlaceHolderTestBase {
    //https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
    //   {
    //
    //      "title": "API calismaliyim"
    //
    //     }
    //Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
    //{
    // "userId": 10,
    // "title": "API calismaliyim"
    // "completed": true,
    // "id": 198
    //}

    @Test
    public void test(){
        spec01.pathParams("parametre1","todos","parametre2",198);

        JsonPlaceHolderTestData testData=new JsonPlaceHolderTestData();
       JSONObject requestData= testData.setUpPatchRequestData();
       JSONObject expectedData=testData.setUpPatchExpectedData();

       //request gönder
        Response response = given().accept("application/json").spec(spec01).auth().
                basic("admin","password123").body(requestData.toString())
                .when().patch("/{parametre1}/{parametre2");
            response.prettyPrint();

        //deserilization ile
        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getBoolean("completed"),actualDataMap.get("completed"));
        Assert.assertEquals(expectedData.getInt("userId"),actualDataMap.get("userId"));
        Assert.assertEquals(expectedData.getString("title"),actualDataMap.get("title"));
        Assert.assertEquals(expectedData.getString("id"),actualDataMap.get("id"));












    }




}
