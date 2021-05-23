### @ControllerAdvice
@ControllerAdvice is a specialization of the @Component annotation which allows to handle exceptions across the whole application in one global handling component. It can be viewed as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.

It declares @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.

### ResponseEntityExceptionHandler
ResponseEntityExceptionHandler is a convenient base class for @ControllerAdvice classes that wish to provide centralized exception handling across all @RequestMapping methods through @ExceptionHandler methods. It provides an methods for handling internal Spring MVC exceptions. It returns a ResponseEntity in contrast to DefaultHandlerExceptionResolver which returns a ModelAndView.


### @ResponseStatus
@ResponseStatus marks a method or exception class with the status code and reason message that should be returned. The status code is applied to the HTTP response when the handler method is invoked, or whenever the specified exception is thrown. It overrides status information set by other means, like ResponseEntity or redirect:


### @PathVariable
@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. If the method parameter is Map<String, String> then the map is populated with all path variable names and values.

### @GetMapping

@GetMapping annotation maps HTTP GET requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).

### ResponseEntity

ResponseEntity represents an HTTP response, including headers, body, and status. While @ResponseBody puts the return value into the body of the response, ResponseEntity also allows us to add headers and status code.


----------
# Test Result

#### Test  

- Test1 in PostMan 

##### Sum
localhost:8080/sum/2/34

``` 
35.0
```

- Test1 in PostMan

##### Sum
localhost:8080/subtraction/5/4

``` 
1.0
```


- Test1 in PostMan

##### Sum
localhost:8080/multiplication/2/3

``` 
6.0
```


- Test1 in PostMan

##### Sum
localhost:8080/division/12/3

``` 
4.0
```


- Test1 in PostMan

##### Sum
localhost:8080/mean/2/34

``` 
18.0
```

- Test1 in PostMan

##### Sum
localhost:8080/squareRoot/4

``` 
2.0
```

----------------

##### Exception part 

localhost:8080/squareRoot/sdf
``` 
{
    "timestamp": "2021-05-23T03:32:46.449+00:00",
    "message": "Please set a numeric value!",
    "details": "uri=/squareRoot/sdf"
}
```
