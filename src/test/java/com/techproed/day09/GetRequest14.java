package com.techproed.day09;
import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyTestBase {

    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.
    @Test

    public void test(){
        spec03.pathParam("parametre1","employees");

        DummyTestData expectedObje=new DummyTestData();
        HashMap<String,Integer> expectedDataMap=expectedObje.setupTestData02();
        System.out.println(expectedDataMap);

        Response response= given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");
       // response.prettyPrint();

        //Deserilization Yöntemi

        HashMap<String,Integer>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedDataMap.get("statusCode"),(Integer) response.getStatusCode());

        //En yüksek maaşın 725000 olduğunu,




    }


}
