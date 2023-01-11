package coe528project;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login{
public Login(){}

@FXML
private TextField username;
@FXML
private PasswordField password;
@FXML
private Label verifyLogin;
@FXML
private Button button;

 @FXML
 private void loginUser(ActionEvent event) throws IOException {
     
     OwnerTable owner = OwnerTable.getInstance();
     
 Main m = new Main();
    ArrayList<CustomersTable> tempCustomerList = owner.getCustomers();
    int count = 0; 
    for(CustomersTable c: tempCustomerList){
            if(username.getText().equals(c.getCust_username()) && password.getText().equals(c.getCust_password())) {
                owner.setCurrentCustomer(c);
               
                verifyLogin.setText("Correct");
                m.changeScene("Customer.fxml");
        }
        count++;
    }
    if(username.getText().equals(owner.getUsername()) && password.getText().equals(owner.getPassword())) {
         verifyLogin.setText("Correct");
         
        m.changeScene("Owner.fxml");
    }
    else if(username.getText().isEmpty() && password.getText().isEmpty()) {
        verifyLogin.setText("Incorrect. ");
    }
    else{
        verifyLogin.setText("Incorrect");
}}}