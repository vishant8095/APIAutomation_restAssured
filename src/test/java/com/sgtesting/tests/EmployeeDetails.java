package com.sgtesting.tests;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class EmployeeDetails {
    @Test
    public void main()
    {
        try
        {
            RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees";
            RequestSpecification httpRequest=RestAssured.given();
            //specify the header
            httpRequest.header("Content-Type","application/json");
            //execute GET http request.get();
            Response response=httpRequest.get();
            String content=response.asPrettyString();
            System.out.println(content);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }



}
