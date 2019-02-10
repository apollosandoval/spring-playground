package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JSONResponseController {

  @GetMapping("/person")
  public Person getPerson() {
    Person person = new Person("Dwayne", "Johnson");
    return person;
  }

  @GetMapping("/people")
  public List<Person> getPeople() {
    Person person1 = new Person("Dwayne", "Johnson");
    Person person2 = new Person("Ron", "Swanson");
    Person person3 = new Person("Jeremy", "Jermaine");

    return Arrays.asList(person1, person2, person3);
  }



}
