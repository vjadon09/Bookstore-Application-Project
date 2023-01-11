package coe528project;

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
import java.io.File; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner; 

public class Books implements Initializable{
    

      OwnerTable owner = OwnerTable.getInstance(); 
    
    @FXML
    private Button add;
    
    @FXML
    private Button delete;
    
    @FXML
    private Button back;

    @FXML
    private TableColumn<BookTable,String> bookName;

    @FXML
    private TableColumn<BookTable,Double> bookPrice;

    @FXML
    private TableView<BookTable> table;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField price;
    
    public void goBack(ActionEvent event) throws IOException {
       Main m = new Main();
           m.changeScene("Owner.fxml");}
    
   
   
   public void initialize(URL Url, ResourceBundle resourceBundle) {
    bookName.setCellValueFactory(new PropertyValueFactory<BookTable, String> ("BookName"));
    bookPrice.setCellValueFactory(new PropertyValueFactory<BookTable, Double>("BookPrice"));

    ArrayList<BookTable> tempBookList = owner.getBooks(); 
    ObservableList<BookTable> bookTables = table.getItems();
    for(BookTable booktable: tempBookList){
        bookTables.add(booktable);
    }
    table.setItems(bookTables);
   }
   
   @FXML
   public void addBooks(ActionEvent event) {  
        BookTable booktable = new BookTable(name.getText(),Double.parseDouble(price.getText()));

    owner.addBook(booktable);
     ObservableList<BookTable> bookTables = table.getItems();
            bookTables.add(booktable);
            table.setItems(bookTables);
   }
 
    @FXML 
    public void deleteBooks(ActionEvent event){
        int selectedID = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedID);
        owner.deleteBook(selectedID); 
    }
}
    


    
    
    
    
    

