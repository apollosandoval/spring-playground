package com.galvanize.springplayground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(JSONResponseController.class)
public class JSONResponseControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getPersonObjectTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders
            .get("/json/person")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .contentType(MediaType.APPLICATION_JSON_UTF8);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName", is("Dwayne")))
            .andExpect(jsonPath("$.lastName", is("Johnson")));
  }

  @Test
  public void getPeopleArrayTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders
            .get("/json/people")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .contentType(MediaType.APPLICATION_JSON_UTF8);

    this.mvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
            .andExpect(jsonPath("$[0].lastName", is("Johnson")))
            .andExpect(jsonPath("$[1].firstName", is("Ron")))
            .andExpect(jsonPath("$[1].lastName", is("Swanson")));
  }

}