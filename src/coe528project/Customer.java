package coe528project;

import coe528project.Main;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Customer implements Initializable{
   OwnerTable own = OwnerTable.getInstance(); 

   protected CustomersTable currentCustomer = own.getCurrentCustomer(); 
   
   
   @FXML
   private TableColumn<Customer,String> bookName_;
   @FXML
   private TableColumn<Customer, Integer> bookPrice_;
   @FXML
   private TableColumn<Customer, CheckBox> select;
   @FXML
   private TableView<BookTable> tabl3;
   @FXML
   private Button logout_;
   @FXML
   private Button Buy;
   @FXML
   private Button BuynRedeem;
   @FXML
   private Label welcome;
   
   
   
   @Override
   public void initialize(URL Url, ResourceBundle resourceBundle) {
   bookName_.setCellValueFactory(new PropertyValueFactory<>("BookName"));
   bookPrice_.setCellValueFactory(new PropertyValueFactory<>("BookPrice"));
   select.setCellValueFactory(new PropertyValueFactory<>("select"));
   ArrayList<BookTable> tempBookList = own.getBooks(); 
    ObservableList<BookTable> bookTables = tabl3.getItems();
    for(BookTable booktable: tempBookList){
        bookTables.add(booktable);
    }
    tabl3.setItems(bookTables);
    
    welcome.setText("Welcome " + currentCustomer.getCust_username() + ". You have " + currentCustomer.getPoints() + " points. Your status is " 
            + currentCustomer.getStatus()+".");
     
   }
     
   @FXML
   public void CustomerBuy (ActionEvent event) throws IOException { 
       
   double cost = 0;
   int currentpoints = currentCustomer.getPoints();  
   int count = 0; 
   for(BookTable x : tabl3.getItems()){
   if(x.getSelect().isSelected()){
    cost += x.getBookPrice();
    own.deleteBook(count);
    count--;
    Platform.runLater(() -> { 
    tabl3.getItems().remove(x);
   });   
   }
   count++;
   }
   currentpoints += (int)cost*10;
   own.setCurrentTransactionCost(cost);
   currentCustomer.setPoints(currentpoints);
   own.updateCustomer(currentCustomer);
   System.out.println(cost+" , "+ currentpoints);
   Main m = new Main();
   m.changeScene ("CustomerCostScreen.fxml");
   }
   
   @FXML
   public void CustomerRedeemAndBuy (ActionEvent event) throws IOException, Exception { 
   double cost1 = 0;
   int currentpoints = currentCustomer.getPoints();  
   int count = 0; 
   int testPoints = 0; 
   double tempCost = 0; 
   for(BookTable x : tabl3.getItems()){
   if(x.getSelect().isSelected()){
    cost1 += x.getBookPrice();
    own.deleteBook(count);
    count--;
    Platform.runLater(() -> { 
    tabl3.getItems().remove(x);
   });   
   }
   count++;
   }
   own.setCurrentTransactionCost(0);
   testPoints = (int) (currentpoints - cost1*100);
   if(testPoints < 0){
       cost1 -= (double) currentpoints/100;
       own.setCurrentTransactionCost(cost1);
       currentCustomer.setPoints((int)cost1 * 10);
   }
   else{
     currentCustomer.setPoints(testPoints);
   }
   own.updateCustomer(currentCustomer);
       Main m = new Main();
       m.changeScene ("CustomerCostScreen.fxml");
   }
     
   @FXML
   public void CustomerLogout (ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene ("Login.fxml");}

}
