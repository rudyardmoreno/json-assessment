package com.example;

/*
 * Created by Rudyard Moreno on 3/30/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * JSON Controller
 */

import com.example.model.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class JSONController {

    public List<Result> getResultList(Activities activities) throws Exception {
        List<Result> resultList = new ArrayList<Result>();

        for (Activity activity : activities.getActivities()) {
            Result result = new Result();

            result.setUserId(activity.getUser().getId());
            result.setUser(activity.getUser().getUsername());
            result.setEmail(activity.getUser().getPrimaryEmail().getAddress());
            result.setDate(activity.getStatus().getDate());
            result.setStatusText(activity.getStatus().getText());

            resultList.add(result);
        }

        return resultList;
    }

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.detailed+json")
    @JsonView(Views.DetailView.class)
    public List<Result> getActivitiesSimplifyDetailed(@RequestBody Activities activities) throws Exception {
        return getResultList(activities);
    }

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.compact+json")
    @JsonView(Views.ListView.class)
    public List<Result> getActivitiesSimplifyCompact(@RequestBody Activities activities) throws Exception {
        return getResultList(activities);
    }
}
