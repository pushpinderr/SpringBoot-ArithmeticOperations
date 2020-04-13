# SpringBoot-ArithmeticOperations
Arithmetic Operations Service with Basic Authentication

* Spring Boot Service for basic arithmetic operations such as addition and subtraction.

* Exposes two RESTful APIs;
1. POST http://{{service-ip}}/api/add
{
	"x":"100",
	"y":"50"
}

return 200 OK with
{
	"result":"150"
}

2. POST http://{{service-ip}}/api/diff
{
	"x":"100",
	"y":"50"
}

return 200 OK with
{
	"result":"50"
}

* Spring Security Basic Authentication: Autherizes users with Basic Authentication mechanism of Spring Security.

* Design Architecture Style: Hexagonal Architecture where Bootstrap, Domain, & Infrastructure related concerns are abstracted out. Here domain is completely independent of any kind of frameworks including Spring as well so that domain can be ported across anywhere.   

* Exception Handling: Appropriate exception handling for controller advice to the client.

* Test Driven Development Methodologies: Service is developed using TDD approach. Appropriate Unit and Integration tests are written with 100% test coverage.
