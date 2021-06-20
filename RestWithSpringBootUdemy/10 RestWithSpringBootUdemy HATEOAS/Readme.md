The Spring HATEOAS project is a library of APIs that we can use to easily create REST representations that follow the principle of HATEOAS (Hypertext as the Engine of Application State).

Generally speaking, the principle implies that the API should guide the client through the application by returning relevant information about the next potential steps, along with each response.

**Spring HATEOAS offers three abstractions for creating the URI – RepresentationModel, Link, and WebMvcLinkBuilder.** We can use these to create the metadata and associate it to the resource representation.

```
<dependency>
 <groupId>org.springframework.hateoas</groupId>
 <artifactId>spring-hateoas</artifactId>
</dependency>
```


>  Adding Hypermedia Support to a Resource
The project provides a base class called RepresentationModel to inherit from when creating a resource representation:
public class PersonVO **extends RepresentationModel<PersonVO>** implements Serializable

The PersonVO resource extends from the RepresentationModel class to inherit the add() method. So once we create a link, we can easily set that value to the resource representation without adding any new fields to it.

> Creating Better Links
Another very important abstraction offered by the library is the WebMvcLinkBuilder – which simplifies building URIs by avoiding hard-coded the links.

The following snippet shows from PersonController class building the customer self-link using the WebMvcLinkBuilder class: 

personVO1.add(linkTo(methodOn(PersonController.class).findById(personVO1.getId())).withSelfRel());

Let's have a look:

the linkTo() method inspects the controller class and obtains its root mapping
the slash() method adds the personVOId value as the path variable of the link
finally, the withSelfMethod() qualifies the relation as a self-link



Test
-------------
[GET] localhost:8080/persons/v1
[Headers]Accept --> application/json

-------------

--Result
```` 
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