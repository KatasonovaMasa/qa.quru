package tests.dz_21.models;
import lombok.Data;

@Data
public class CreateTestCaseResponse {
    Integer id;
    String name, statusName, statusColor;
    Boolean automated, external;
    Long createdDate;

//    {
//        "id": 18067,
//            "name": "Johnson Gorczany",
//            "automated": false,
//            "external": false,
//            "createdDate": 1683137990428,
//            "statusName": "Draft",
//            "statusColor": "#abb8c3"
//    }
}
