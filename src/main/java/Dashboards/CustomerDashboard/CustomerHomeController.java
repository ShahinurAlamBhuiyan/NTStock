package Dashboards.CustomerDashboard;

import Dashboards.SoldProductInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CustomerHomeController implements Initializable {
    private List<SoldProductInformation> allProducts;
    @FXML
    private GridPane productContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allProducts = new ArrayList<>(productList());
        int column = 0;
        int row = 1;
        try{
            for(SoldProductInformation product : allProducts){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("SingleProducts.fxml"));
                VBox productBox = fxmlLoader.load();
                SingleProductsController singleProductsController = fxmlLoader.getController();
                singleProductsController.setData(product);

                if(column == 4){
                    column = 0;
                    ++row;
                }

                productContainer.add(productBox, column++, row);
                GridPane.setMargin(productBox, new Insets(15));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            isStocker();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    List<SoldProductInformation> products = new ArrayList<>();
    private List<SoldProductInformation> productList(){
            try{
                File file  = new File("AllTextFiles/SoldProducts/AllDealersSoldProducts.txt");
                Scanner fileReader = new Scanner(file);
                while(fileReader.hasNext())
                {
                    products.add(new SoldProductInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(), fileReader.next(), fileReader.next()));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        return products;
    }

    void isStocker() throws ParseException {
        for(int i = 0; i < products.size(); i++){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String currentTime = dtf.format(now);
            String time1 = products.get(i).getPrevSellTime();
            String time2 = currentTime;
//
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long difference = date2.getTime() - date1.getTime(); // 7 min = 7000;
            long diffSeconds = difference / 1000 % 60;
            long diffMinutes = difference / (60 * 1000) % 60;
            long diffHours = difference / (60 * 60 * 1000) % 24;
            long diffDays = difference / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.println(diffSeconds + " seconds.");
            if(diffMinutes > 7){
                System.out.println("Notifications will send to Administrator.");
            }
        }
    }


}
