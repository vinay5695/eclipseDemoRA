package stepDefinitons;


import POJO.employee;
import dataProvider.configReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.*;

public class Tests {
	
	private static final String baseUrl =configReader.getInstance().getBaseUrl();
	private RequestSpecification reqspec;
	private Response response;

	@Given("Give the domain name of reqres")
	public void give_the_domain_name_of_reqres() {		
		RestAssured.baseURI="https://reqres.in/api/users";
		reqspec=RestAssured.given();
	}
	@When("send the get request with the resource url")
	public void send_the_get_request_with_the_resource_url() {
		response =reqspec.get("/api/users?page=2");
	}
	@Then("validate the response code")
	public void validate_the_response_code() {
		Assert.assertEquals(200, response.getStatusCode());
		employee emp=response.as(employee.class);
	    Assert.assertEquals(emp.getId(), 2);
	}

	@When("send the get request with the single resource url")
	public void send_the_get_request_with_the_single_resource_url() {
		response =reqspec.get("/2");
	}
	
	@When("add user in server")
	public void add_user_in_server() {
		
		employee emp=new employee();
		emp.setId(9);
		emp.setfirstName("mark");
		emp.setlastName("man");

		reqspec.header("content-type","application/json");
		reqspec.body(emp);
		response=reqspec.post();
	}
	
	@Then("validate the post response code")
	public void validate_the_post_response_code() {
		Assert.assertEquals(201, response.getStatusCode());
	}

	@When("delete user in server")
	public void delete_user_in_server() {
		response =reqspec.get("/api/users/2");
	}







}
