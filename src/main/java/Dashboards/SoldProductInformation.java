package Dashboards;

public class SoldProductInformation {
    private String productName;
    private String productId;
    private String productPerPrice;
    private String productQuantity;
    private String productTotalPrice;

    private String retailerId;
    private String retailerEmail;
    private String buyingDate;

    public SoldProductInformation(String productName, String productId, String productPerPrice, String productQuantity, String productTotalPrice,  String retailerEmail,String retailerId, String buyingDate) {
        this.productName = productName;
        this.productId = productId;
        this.productPerPrice = productPerPrice;
        this.productQuantity = productQuantity;
        this.productTotalPrice = productTotalPrice;
        this.retailerEmail = retailerEmail;
        this.retailerId = retailerId;
        this.buyingDate = buyingDate;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductPerPrice() {
        return productPerPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getProductTotalPrice() {
        return productTotalPrice;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public String getRetailerEmail() {
        return retailerEmail;
    }

    public String getBuyingDate() {
        return buyingDate;
    }
}
