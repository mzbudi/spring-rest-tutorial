package com.learn.learnspring.schedule;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    public Map<Integer, Schedule> getSchedule(){
        return Map.of(1, new Schedule(1L, "Budinisme"));
    }
}
