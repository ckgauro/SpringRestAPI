### @Service

@Service - indicates that an annotated class is a service class.

--------------

## Test Code

- [Get] single person
   - localhost:8080/persons/1
     <img src="images/get.png">

- [Get] List of persons
   - localhost:8080/persons

- [Post] person
    - localhost:8080/persons
    ``` 
   {
        "id": 3,
        "firstName": "raj",
        "lastName": "Berge",
        "address": "1431 Kilback Lodge, Earnestview, SC 77807-1342",
        "gender": "Female"
    }  
  ```

- [Put] person
    - localhost:8080/persons

 ``` 
   {
        "id": 3,
        "firstName": "raj",
        "lastName": "Berge",
        "address": "1431 Kilback Lodge, Earnestview, SC 77807-1342",
        "gender": "Female"
    }  
  ```

- [Delete] person
    - localhost:8080/persons