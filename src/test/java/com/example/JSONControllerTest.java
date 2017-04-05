package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Test JSON Controller
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JSONController.class)

public class JSONControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testDetailedView() throws Exception{
        String jsonRequest = getJSON("/request.json");

        MockHttpServletRequestBuilder request = post("/activities/simplify")
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/vnd.galvanize.detailed+json")
                .content(jsonRequest);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId", is(1467)))
                .andExpect(jsonPath("$[0].user", is("someuser")))
                .andExpect(jsonPath("$[0].email", is("personal@example.com")))
                .andExpect(jsonPath("$[0].date", is("2017-04-02 01:32")))
                .andExpect(jsonPath("$[0].statusText", is("Just went snowboarding today!")))
                .andExpect(jsonPath("$[1].userId", is(98732)))
                .andExpect(jsonPath("$[1].user", is("otheruser")))
                .andExpect(jsonPath("$[1].email", is("otherprimary@example.com")))
                .andExpect(jsonPath("$[1].date", is("2017-04-02 01:32")))
                .andExpect(jsonPath("$[1].statusText", is("Great times!")))
        ;
    }

    @Test
    public void testCompactView() throws Exception{
        String jsonRequest = getJSON("/request.json");

        MockHttpServletRequestBuilder request = post("/activities/simplify")
                .contentType(MediaType.APPLICATION_JSON)
                .accept("application/vnd.galvanize.compact+json")
                .content(jsonRequest);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user", is("someuser")))
                .andExpect(jsonPath("$[0].date", is("2017-04-02 01:32")))
                .andExpect(jsonPath("$[0].statusText", is("Just went snowboarding today!")))
                .andExpect(jsonPath("$[1].user", is("otheruser")))
                .andExpect(jsonPath("$[1].date", is("2017-04-02 01:32")))
                .andExpect(jsonPath("$[1].statusText", is("Great times!")))
        ;
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
