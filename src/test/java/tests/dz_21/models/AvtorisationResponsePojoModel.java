package tests.dz_21.models;

public class AvtorisationResponsePojoModel {
    private String name;
    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    private String id;
    private String createdAt;
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


//     "name": "morpheus",
//             "job": "leader",
//             "id": "738",
//             "createdAt": "2023-04-25T14:34:26.579Z"
}
