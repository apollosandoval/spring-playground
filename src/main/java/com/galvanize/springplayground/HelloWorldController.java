package com.galvanize.springplayground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello World!";
  }

  @GetMapping("/math/pi")
  public String getPi() {
    return "3.141592653589793";
  }

  @GetMapping("/math/calculate")
  public String calculate(@RequestParam String operation, @RequestParam int x, @RequestParam int y) {
    String sum = "";
    try {
      switch(operation) {
        case "add":
          sum = String.format("%s + %s = %s", x, y, x+y);
          break;
        case "multiply":
          sum = String.format("%s x %s = %s", x, y, x*y);
          break;
        case "subtract":
          sum = String.format("%s - %s = %s", x, y, x-y);
          break;
        case "divide":
          sum = String.format("%s / %s = %s", x, y, x/y);
          break;
        default:
          sum = String.format("%s + %s = %s", x, y, x+y);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return sum;
  }

  @PostMapping("/math/sum")
  public String multiSum(@RequestParam MultiValueMap<String, Integer> querystring) {

    String result = querystring.toString();
    return result;
  }


}
