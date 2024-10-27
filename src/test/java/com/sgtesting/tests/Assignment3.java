package com.sgtesting.tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignment3 {

	public static String employeeid1=null;
	@Test(priority=1)
	public void createemployee1()
	{
		try
		{
			System.out.println("thise step deals with creation of employee data in database");
			RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees";
			RequestSpecification httprequest=   RestAssured.given();
			String filepath="./DataFiles/Employee_data1.json";
			File jsonpath=new File(filepath);
			httprequest.header("Content-Type", "application/json");
			httprequest.body(jsonpath);
			Response response= httprequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
			//display employeee id
			JsonPath jpath=response.jsonPath();
			 employeeid1=     jpath.getString("id");
			 System.out.println("Employee: "+employeeid1);
			 System.out.println("complited");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		@Test(priority=2)
		public void  displayemployee1()
		{
			System.out.println("this step deals with fetch employee data");
			try {
		        RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees/"+employeeid1;
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
		
		
		@Test(priority=1)
		public void modify_Employee()
		{
			try
			{
				System.out.println("thise step deals with creation of employee data in database");
				RestAssured.baseURI="http://localhost:8082/sgtesting/api/v1/employees"+employeeid1;
				RequestSpecification httprequest=   RestAssured.given();
				String filepath="./DataFiles/updated_employee_details.json";
				File jsonpath=new File(filepath);
				httprequest.header("Content-Type", "application/json");
				httprequest.body(jsonpath);
				Response response= httprequest.put();
				String content=response.asPrettyString();
				System.out.println(content);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

