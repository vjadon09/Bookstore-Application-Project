package coe528project;

import coe528project.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class CustomerCostScreen extends Customer implements Initializable {

@FXML
private Button logout_2;

@FXML 
private Label points_;

@FXML 
private Label status_;

@FXML
   public void CustomerLogoutFinal (ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene ("Login.fxml");}
   
   
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        points_.setText("Total Cost: $" + own.getCurrentTransactionCost());
        status_.setText("\n\n Points: "+  currentCustomer.getPoints()+ ", "+ "Status: "+ currentCustomer.getStatus());
    }    
    
    
    
}
