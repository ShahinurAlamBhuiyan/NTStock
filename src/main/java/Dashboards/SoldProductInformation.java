package Dashboards;

import Auths.SignIn.UserInformation;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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
    private String retailerName;
    private String dealerEmail;
    private String dealerId;
    private  String dealerName;

    private  String buyingDate;
    private String prevSellTime;

    @Override
    public String toString() {
        return "SoldProductInformation{" +
                "productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productPerPrice='" + productPerPrice + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                '}';
    }

    public String getPrevSellTime() {
        return prevSellTime;
    }

    public SoldProductInformation(String productName, String productId, String productPerPrice, String productQuantity, String productTotalPrice, String retailerEmail, String retailerId, String dealerEmail, String dealerId, String dealerFirstName, String dealerLastName, String buyingDate, String prevSellTime) {
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
        this.prevSellTime = prevSellTime;

        ArrayList<UserInformation> usersInfo = new ArrayList<UserInformation>();
        try{
            File file  = new File("AllTextFiles/All-Users/usersSignUpInfo.txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNext())
            {
                usersInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next()));
            }
            for(UserInformation user : usersInfo){
                if(user.getUserRandomId().equals(retailerId) && user.getEmail().equals(retailerEmail)){
                    this.retailerName = user.getFirstName()+" "+user.getLastName();
                    break;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
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

    public String getRetailerName() {return retailerName;}

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
