package com.example.model;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudyard Moreno on 5/16/17
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit
 */
@Service
public class Transformer {
    public MappingJacksonValue getResultList(Activities activities) throws Exception {
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
        MappingJacksonValue result = new MappingJacksonValue(resultList);
        return result;
    }
}
