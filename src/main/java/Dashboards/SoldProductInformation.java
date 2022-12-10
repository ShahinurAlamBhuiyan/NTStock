package Dashboards;

import static Slides.SlideOne.SlideOne.loggedInUserEmail;
import static Slides.SlideOne.SlideOne.loggedInUserID;

public class SoldProductInformation {
    private final String productName;
    private final String productId;
    private final String productPerPrice;
    private final String productQuantity;
    private final String productTotalPrice;

    private final String retailerId;
    private final String retailerEmail;
    private String dealerEmail;
    private String dealerId;
    private final String dealerName;
    private final String buyingDate;

    public SoldProductInformation(String productName, String productId, String productPerPrice, String productQuantity, String productTotalPrice,  String retailerEmail,String retailerId,  String dealerEmail,String dealerId,String dealerFirstName,String dealerLastName, String buyingDate) {
        this.productName = productName;
        this.productId = productId;
        this.productPerPrice = productPerPrice;
        this.productQuantity = productQuantity;
        this.productTotalPrice = productTotalPrice;
        this.retailerEmail = retailerEmail;
        this.retailerId = retailerId;
        this.buyingDate = buyingDate;
        this.dealerEmail = dealerEmail;
        this.dealerId = dealerId;
        dealerName = dealerFirstName + " " + dealerLastName;
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

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getBuyingDate() {
        return buyingDate;
    }
}
