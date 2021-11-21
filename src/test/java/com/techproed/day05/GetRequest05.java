package com.techproed.day05;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest05 {
    //http://dummy.restapiexample.com/api/v1/employees url'ine
    //    accept type'i "application/json" olan GET request'i yolladigimda
    //    gelen response'un
    //    status kodunun 200                                                                                        ve content type'inin "application/json"
    //   ve employees sayisinin 24
    //   ve employee'lerden birinin "Ashton Cox"
    //   ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin

@Test
    public void test(){

    String url="http://dummy.restapiexample.com/api/v1/employees";
    Response response =given().
            accept("application/json").
            when().
            get(url);
    response.prettyPrint();
    response.then().assertThat().statusCode(200).contentType("application/json").
            body("data.profile_image", hasSize(24),
                    "data.employee_name",hasItem("Ashton Cox"),
                    "data.employee_age" ,hasItems(21,61,23));

    //body("data.id", Matchers.hasSize(" value ")) : key olarak verilen degisken’in sayisinin value’ya
    // esit olup olmadigini kontrol eder.

    //body("data.employee_name",Matchers.hasItem(" value ")) : key olarak verilen degisken’in aldigi
    // degerlerin icinde value var midiye kontrol eder.
    // Value birden fazla ise hasItems kullanip value’lari vigulle yanyana yazilabilir



}


}
