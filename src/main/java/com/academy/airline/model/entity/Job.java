package com.academy.airline.model.entity;

public enum Job {
    PILOT("pilot"),
    STEWARD("steward"),
    MANAGER("manager"),
    DISPATCHER("dispatcher"),
    HR("hr"),
    DISMISSED("dismissed");
    
    private String jobName;
    private Job(String job) {
        this.jobName = job;
    }

    public String getJob() {
        return jobName;
    }
}
