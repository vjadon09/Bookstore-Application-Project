package coe528project;

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
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;


public class Customers implements Initializable{
    
    OwnerTable owner = OwnerTable.getInstance();
    
    @FXML
    private Button add;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button back;
    
    @FXML
    private TableColumn<CustomersTable,Integer> points;

    @FXML
    private TableColumn<CustomersTable,String> cust_username;

    @FXML
    private TableColumn<CustomersTable,String> cust_password;

    @FXML
    private TableView<CustomersTable> tables;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;


    public void goBack(ActionEvent event) throws IOException {
          Main m = new Main();
              m.changeScene("Owner.fxml");}

   
    @Override
   public void initialize(URL Url, ResourceBundle resourceBundle) {
   cust_username.setCellValueFactory(new PropertyValueFactory<> ("cust_username"));
   cust_password.setCellValueFactory(new PropertyValueFactory<>("cust_password"));
   points.setCellValueFactory(new PropertyValueFactory<>("points"));
   
   
   ArrayList<CustomersTable> tempCustomerList = owner.getCustomers(); 
    ObservableList<CustomersTable> customersTables = tables.getItems();
    for(CustomersTable customertable: tempCustomerList){
        customersTables.add(customertable);
    }
    tables.setItems(customersTables);
   }
   
   @FXML
   public void addUsername(ActionEvent event) {
    CustomersTable customertable = new CustomersTable(username.getText(),password.getText());
     ObservableList<CustomersTable> customersTable = tables.getItems();   
            customersTable.add(customertable);
            owner.addCustomer(customertable);
            tables.setItems(customersTable);
            System.out.println(customersTable);
   }
    @FXML 
    public void deleteUsername (ActionEvent event){
        int selectedID = tables.getSelectionModel().getSelectedIndex();
        tables.getItems().remove(selectedID);
        owner.deleteCustomer(selectedID);
    }
    
}
    

