package com.techproed.day04;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
//https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
//HTTP status kodunun 200
//Content Type'in Json
//Ve Status Line'in HTTP/1.1 200 OK
//Oldugunu test edin

    @Test
   public void test01() {

        //1-Api testi yaparken ilk olarak url(endpoint)belirlenmeli
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2-beklenen sonuç(expected result)oluşturulur
        //bu case de benden body doğrulaması istenmediği için şimdilik beklenen sonuç
        //oluşturmuyoruz

        //3- request gönder
        Response response=given().
                accept(ContentType.JSON).// accept(*aplication/json) yerine kullanılır
                when().get(url);
        response.prettyPrint();
        //4-actual result oluştur
       //rsponse body ile ilgili işlem yapmayacağımız için oluşturmayacağız

        //5-doğrulama yap(assertion)
        System.out.println("status code :"+response.getStatusCode());
        System.out.println("content type :"+response.getContentType());
        System.out.println("status line :"+response.getStatusLine());
        System.out.println(response.getHeaders());

        /*
        Assert.assertEquals(200,response.getStatusCode());
        //expected kısmı bize task olarak verilendir,actual kısmı ise response dan dönen değerdir

       Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
       Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        */
       response.then().
               assertThat().
               statusCode(200).
               contentType(ContentType.JSON).
               statusLine("HTTP/1.1 200 OK");
    }
}
