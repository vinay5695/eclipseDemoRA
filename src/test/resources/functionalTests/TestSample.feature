Feature: Test functionality of ReqRes Api
For sample testing we should check the functionality of ReqRes api

Scenario: Get List Users
Given Give the domain name of reqres
When send the get request with the resource url
Then validate the response code 

Scenario: Get single User
Given Give the domain name of reqres
When send the get request with the single resource url
Then validate the response code 

Scenario: create new User
Given Give the domain name of reqres
When add user in server
Then validate the post response code

Scenario: delete a User
Given Give the domain name of reqres
When delete user in server
Then validate the response code
