package Dashboards;

import static Slides.SlideOne.SlideOne.loggedInUserEmail;
import static Slides.SlideOne.SlideOne.loggedInUserID;

public class SoldProductInformation {
    private  String productName;
    private  String productId;
    private  String productPerPrice;
    private  String productQuantity;
    private  String productTotalPrice;

    private  String retailerId;
    private  String retailerEmail;
    private String dealerEmail;
    private String dealerId;
    private  String dealerName;
    private  String buyingDate;

    @Override
    public String toString() {
        return "SoldProductInformation{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productPerPrice='" + productPerPrice + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                '}';
    }

    public SoldProductInformation(String productName, String productId, String productPerPrice, String productQuantity, String productTotalPrice, String retailerEmail, String retailerId, String dealerEmail, String dealerId, String dealerFirstName, String dealerLastName, String buyingDate) {
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductPerPrice(String productPerPrice) {
        this.productPerPrice = productPerPrice;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductTotalPrice(String productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public void setRetailerEmail(String retailerEmail) {
        this.retailerEmail = retailerEmail;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setBuyingDate(String buyingDate) {
        this.buyingDate = buyingDate;
    }
}
