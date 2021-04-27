package com.learn.learnspring.schedule;

public class Schedule {
    private Long uuid;
    private String schedule_name;


    public Schedule(Long uuid, String schedule_name) {
        this.uuid = uuid;
        this.schedule_name = schedule_name;
    }


    public Long getUuid() {
        return this.uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getSchedule_name() {
        return this.schedule_name;
    }

    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }


    @Override
    public String toString() {
        return "{" +
            " uuid='" + getUuid() + "'" +
            ", schedule_name='" + getSchedule_name() + "'" +
            "}";
    }

}
