package tests.dz_21.models;

import lombok.Data;

public @Data class AvtorisationBodyPojoModel {
    private String name, job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
