package com.techproed.day13;

import com.techproed.pojos.Data;
import com.techproed.pojos.DummyPojo;
import com.techproed.testBase.DummyTestBase;
import org.junit.Test;

public class GetRequestWithPojo01 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employee/1 url ‘ine bir get request gönderildiğinde , dönen response ‘un,
    //Status kodunun 200 ve response body’nin
    // {
    // "status": "success",
    // "data": {
    //  "id": 1,
    //   "employee_name": "Tiger Nixon",
    //   "employee_salary": 320800,
    //   "employee_age": 61,
    //   "profile_image": ""
    //   },
    //  "message": "Successfully! Record has been fetched."
    //                                }
    //Olduğunu test edin

    @Test
    public void test(){
        spec03.pathParams("parametre1","employee","parametre2",1);

        Data data=new Data(1,"Tiger Nixon",320800,61,"");
        DummyPojo expectedData=new DummyPojo("success",data,"Successfully! Record has been fetched.");




    }
}
