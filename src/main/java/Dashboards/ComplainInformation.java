package Dashboards;

public class ComplainInformation {
    private String retailerOrDealerFirstName;
    private String retailerOrDealerLastName;
    private String description;
    private String complainerPhoneNo;

    public ComplainInformation(String retailerOrDealerFirstName, String retailerOrDealerLastName, String description) {
        this.retailerOrDealerFirstName = retailerOrDealerFirstName;
        this.retailerOrDealerLastName = retailerOrDealerLastName;
        this.description = description;
        this.complainerPhoneNo = complainerPhoneNo;
    }

    public String getRetailerOrDealerFirstName() {
        return retailerOrDealerFirstName;
    }

    public String getRetailerOrDealerLastName() {
        return retailerOrDealerLastName;
    }

    public String getDescription() {
        return description;
    }

    public String getComplainerPhoneNo() {
        return complainerPhoneNo;
    }
}
