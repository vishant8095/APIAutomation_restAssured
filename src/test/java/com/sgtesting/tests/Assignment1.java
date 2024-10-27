package com.sgtesting.tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignment1 {
	public static String employeeid=null;
	@Test(priority=2)
	public void createemployee()
	{
		try
		{
			System.out.println("thise step deals with creation of employee data in database");
			RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees";
			RequestSpecification httprequest=   RestAssured.given();
			String filepath="./DataFiles/Employee_data.json";
		
			File jsonpath=new File(filepath);
			httprequest.header("Content-Type", "application/json");
			httprequest.body(jsonpath);
			Response response= httprequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
			//display employeee id
			JsonPath jpath=response.jsonPath();
			 employeeid=     jpath.getString("id");
			 System.out.println("Employee: "+employeeid);
			 System.out.println("complited");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void  displayemployee()
	{
		System.out.println("thise step deals with creation all emloyee deatails");
		try {
	        RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees/"+employeeid;
            RequestSpecification httpRequest=RestAssured.given();
            //specify the header
            httpRequest.header("Content-Type","application/json");
            //execute GET http request.get();
            Response response=httpRequest.get();
            String content=response.asPrettyString();
            System.out.println(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	@Test(priority=3)
	public void deleteEmployee()
	{
		try
		{
			System.out.println("thise step deals with delete the employee data");
			   RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees/"+employeeid;
	            RequestSpecification httpRequest=RestAssured.given();
	            //specify the header
	            httpRequest.header("Content-Type","application/json");
	            //execute GET http request.get();
	            Response response=httpRequest.delete();
	            String content=response.asPrettyString();
	            System.out.println(content);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
