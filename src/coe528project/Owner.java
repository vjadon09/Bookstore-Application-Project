package coe528project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class Owner {

    @FXML
    private Button logout;
    @FXML
    private Button books;
    @FXML
    private Button customers;
    
    public void ownerLogout (ActionEvent event) throws IOException {
            Main m = new Main();
            m.changeScene ("Login.fxml");}
    
    public void ownerBooks (ActionEvent event) throws IOException {
           Main m = new Main();
           m.changeScene ("Books.fxml");}

    public void ownerCustomer (ActionEvent event) throws IOException {
           Main m = new Main();
           m.changeScene ("Customers.fxml");}}

