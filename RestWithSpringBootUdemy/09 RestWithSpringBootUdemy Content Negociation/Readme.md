In HTTP, content negotiation is the mechanism that is used for serving different representations of a resource at the same URI, so that the user agent can specify which is best suited for the user (for example, which language of a document, which image format, or which content encoding).

#WebMvcConfigurer

https://www.baeldung.com/spring-mvc-tutorial

Test
-------------
[GET] localhost:8080/persons/v1
[Headers]Accept --> application/xml
--Result
<List>
<item>
<id>1</id>
<firstName>Leandro</firstName>
<lastName>Costa</lastName>
<address>Uberlândia - Minas Gerais - Brasil</address>
<gender>Male</gender>
</item>
<item>
<id>2</id>
<firstName>Gabriela</firstName>
<lastName>Costa</lastName>
<address>Uberlândia - Minas Gerais - Brasil</address>
<gender>Female</gender>
</item>
<item>
<id>5</id>
<firstName>Flávio</firstName>
<lastName>Costa</lastName>
<address>Patos de Minas - Minas Gerais - Brasil</address>
<gender>Male</gender>
</item>
<item>
<id>7</id>
<firstName>Fernanda</firstName>
<lastName>Cardoso da Silva</lastName>
<address>Uberlândia - Minas Gerais - Brasil</address>
<gender>Female</gender>
</item>
<item>
<id>8</id>
<firstName>Pedro</firstName>
<lastName>Paulo</lastName>
<address>Patos de Minas - Minas Gerais - Brasil</address>
<gender>Male</gender>
</item>
<item>
<id>9</id>
<firstName>Marcos</firstName>
<lastName>Paulo</lastName>
<address>Patos de Minas - Minas Gerais - Brasil</address>
<gender>Male</gender>
</item>
</List>


