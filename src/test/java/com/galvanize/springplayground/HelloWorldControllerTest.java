package com.galvanize.springplayground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloWorldControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void helloWorldTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/helloworld/");

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("Hello World!"));
  }

  @Test
  public void getPiTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/helloworld/math/pi");

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("3.141592653589793"));
  }

  @Test
  public void calculateAddTest() throws Exception {
    String operation = "/helloworld/math/calculate?operation=add&x=4&y=6";
    RequestBuilder request = MockMvcRequestBuilders.get(operation);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("4 + 6 = 10"));
  }

  @Test
  public void calculateMultiplyTest() throws Exception {
    String operation = "/helloworld/math/calculate?operation=multiply&x=4&y=6";
    RequestBuilder request = MockMvcRequestBuilders.get(operation);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("4 x 6 = 24"));
  }

  @Test
  public void calculateSubtractTest() throws Exception {
    String operation = "/helloworld/math/calculate?operation=subtract&x=4&y=6";
    RequestBuilder request = MockMvcRequestBuilders.get(operation);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("4 - 6 = -2"));
  }

  @Test
  public void calculateDivideTest() throws Exception {
    String operation = "/helloworld/math/calculate?operation=divide&x=30&y=5";
    RequestBuilder request = MockMvcRequestBuilders.get(operation);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("30 / 5 = 6"));
  }

  @Test
  public void multiSumTest() throws Exception {
    String operation = "/helloworld/math/sum?n=4&n=5&n=6";
    RequestBuilder request = MockMvcRequestBuilders.post(operation);

    this.mvc.perform(request)
            .andExpect(status().isOk());
  }

}
