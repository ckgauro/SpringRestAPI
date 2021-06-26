
**Spring HATEOAS offers three abstractions for creating the URI – RepresentationModel, Link, and WebMvcLinkBuilder.** We can use these to create the metadata and associate it to the resource representation.

```
	<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>3.0.0</version>
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
[GET] localhost:8080/v2/api-docs

-------------

--Result
````
{
    "swagger": "2.0",
    "info": {
    ..... 

````