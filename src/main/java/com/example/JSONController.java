package com.example;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * JSON Controller
 */

import com.example.model.Activities;
import com.example.model.Transformer;
import com.example.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JSONController {

    private final Transformer transformer;

    public JSONController(Transformer transformer) {
        this.transformer = transformer;
    }

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.detailed+json")
    @JsonView(Views.DetailView.class)
    public MappingJacksonValue getActivitiesSimplifyDetailed(@RequestBody Activities activities) throws Exception {
        MappingJacksonValue result = transformer.getResultList(activities);
        result.setSerializationView(Views.DetailView.class);
        return result;
    }

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.compact+json")
    @JsonView(Views.ListView.class)
    public MappingJacksonValue getActivitiesSimplifyCompact(@RequestBody Activities activities) throws Exception {
        MappingJacksonValue result = transformer.getResultList(activities);
        result.setSerializationView(Views.ListView.class);
        return result;
    }
}
