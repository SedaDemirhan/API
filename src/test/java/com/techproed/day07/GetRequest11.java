package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest11 extends JsonPlaceHolderTestBase {
    //https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
    // Dönen response un
    // Status kodunun 200, dönen body de,
    //       "completed": değerinin false
    //       "title”: değerinin “quis ut nam facilis et officia qui”
    //       "userId" sinin 1 ve header değerlerinden
    // "Via" değerinin “1.1 vegur” ve
    //       "Server" değerinin “cloudflare” olduğunu test edin…
@Test
    public void test(){
    spec01.pathParams("parametre1","todos",
            "parametre2",2);

    //expected data test datamız.Bizim test datalarımız key ve value şeklinde olduğu için hash map kullnaıyoruz
    //Hash map değer atamak için de put ile key ve value değerleri ile giriyiruz(post man de urı girilerek kontrol ediyoruz)
    //Assertion yaparken map kullanarak assertion yapıcaz.Syfamızı daha dinamik hale getirmek için bu işlemleri yapıyıruz

    HashMap<String,Object>expectedData=new HashMap<String,Object>();

    expectedData.put("statusCode",200);
    expectedData.put("via","1.1 vegur");
    expectedData.put("completed",false);
    expectedData.put("Server","cloudflare");
    expectedData.put("userId",1);
    expectedData.put("title","quis ut nam facilis et officia qui");

    System.out.println(expectedData);

    Response response=given().
            accept("application/json").
            spec(spec01).
            when().
            get("/{parametre1}/{parametre2}");

    //1.yöntem Matchers class ile assertion işlemi yaptık
    response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
            //expected datamızı obje olarak oluşturduğumuz için status code type casting yaparak ınteger çeviriyoruz
            headers("via", equalTo(expectedData.get("via")),
                    "Server",equalTo(expectedData.get("Server"))).
            body("userId",equalTo(expectedData.get("userId")),
                    "title",equalTo(expectedData.get("title")),
                    "completed",equalTo(expectedData.get("completed")));
//2.yöntem
    JsonPath jsonPath=response.jsonPath();

    //json path kullanarak header 'lara ulaşamyız o nedenle response kullanırız.json path sadece  body deki değerleri kapsar
    Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
    Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
    Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
    Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
    Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));
    Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));

//3.yöntem deserialization
    //---object mapper
    //---pojo class

}

}


