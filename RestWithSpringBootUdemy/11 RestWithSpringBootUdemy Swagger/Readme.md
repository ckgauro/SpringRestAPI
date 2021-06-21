
```
<!-- for Swagger UI support -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<!-- for Swagger Endpoints support -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
```


Test
-------------
[GET] localhost:8080/persons/v1
[Headers]Accept --> application/json

-------------

--Result
````json 
[
{
"id": 1,
"address": "Uberlândia - Minas Gerais - Brasil",
"gender": "Male",
"firstName": "Leandro",
"lastName": "Costa",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/1"
}
]
},
{
"id": 2,
"address": "Uberlândia - Minas Gerais - Brasil",
"gender": "Female",
"firstName": "Gabriela",
"lastName": "Costa",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/2"
}
]
},
{
"id": 5,
"address": "Patos de Minas - Minas Gerais - Brasil",
"gender": "Male",
"firstName": "Flávio",
"lastName": "Costa",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/5"
}
]
},
{
"id": 7,
"address": "Uberlândia - Minas Gerais - Brasil",
"gender": "Female",
"firstName": "Fernanda",
"lastName": "Cardoso da Silva",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/7"
}
]
},
{
"id": 8,
"address": "Patos de Minas - Minas Gerais - Brasil",
"gender": "Male",
"firstName": "Pedro",
"lastName": "Paulo",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/8"
}
]
},
{
"id": 9,
"address": "Patos de Minas - Minas Gerais - Brasil",
"gender": "Male",
"firstName": "Marcos",
"lastName": "Paulo",
"links": [
{
"rel": "self",
"href": "http://localhost:8080/persons/v1/9"
}
]
}
]
````