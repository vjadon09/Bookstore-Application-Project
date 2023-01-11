package coe528project;

import java.util.ArrayList; 
import java.io.File; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.io.OutputStreamWriter;
import java.util.Scanner; 

public class OwnerTable {
    
    File bookDatabase = new File("books.txt");
    File customerDatabase = new File("customers.txt");
    private static OwnerTable instance;    
    private ArrayList<BookTable> activeBookList = new ArrayList<BookTable>(); 
    private ArrayList<CustomersTable> activeCustomerList = new ArrayList<CustomersTable>(); 
    private String username = "admin";
    private String password = "admin";
    private CustomersTable currentCustomer; 
    private double currentTransactionCost; 
    
    private OwnerTable(){
        try{
            Scanner reader = new Scanner(bookDatabase);
        while(reader.hasNextLine()){
            String currentLine = reader.nextLine();
            currentLine = currentLine.trim(); 
            int indexOfDivisions = currentLine.lastIndexOf(",");
            String bookTitle = currentLine.substring(0, indexOfDivisions);
            double bookPrice = Double.parseDouble(currentLine.substring(indexOfDivisions + 1)); 
            BookTable booktable = new BookTable(bookTitle, bookPrice);
            activeBookList.add(booktable);
        }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }
        try{
            Scanner read = new Scanner(customerDatabase); 
        while(read.hasNextLine()){
            String currentLine = read.nextLine();
            currentLine = currentLine.trim(); 
            int indexOfPassword = currentLine.lastIndexOf(",Password:"); 
            int indexOfPoints = currentLine.lastIndexOf(",Points:");
            String username = currentLine.substring(0, indexOfPassword);
            String password = currentLine.substring(indexOfPassword + 10, indexOfPoints); 
            int points = Integer.parseInt(currentLine.substring(indexOfPoints + 8));
            CustomersTable customerstable = new CustomersTable(username, password);
            customerstable.setPoints(points);
            activeCustomerList.add(customerstable);
        }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }
    }
    
    public static OwnerTable getInstance(){
        if(instance == null){
            instance = new OwnerTable();
        }
        return instance; 
    }
    
    public void addBook(BookTable b){
        activeBookList.add(b);
        try {
             
            BufferedWriter writer = new BufferedWriter(new FileWriter(bookDatabase, true));
            writer.write(b.getBookName() + "," + b.getBookPrice()); 
            writer.newLine(); 
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
    
    public void addCustomer(CustomersTable c){
        activeCustomerList.add(c);
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(customerDatabase, true));
            writer.write(c.getCust_username()+ ",Password:" + c.getCust_password() + ",Points:" + c.getPoints()); 
            writer.newLine(); 
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
    
    public void deleteBook(int bookIndex){
        activeBookList.remove(bookIndex); 
        bookDatabase.delete(); 
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(bookDatabase));
            for(BookTable b: activeBookList){
                writer.write(b.getBookName() + "," + b.getBookPrice()); 
                writer.newLine();
            } 
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
    
    public void deleteCustomer(int customerIndex){
        activeCustomerList.remove(customerIndex); 
        bookDatabase.delete(); 
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(customerDatabase));
            for(CustomersTable c: activeCustomerList){
                writer.write(c.getCust_username()+ ",Password:" + c.getCust_password() + ",Points:" + c.getPoints()); 
                writer.newLine();
            } 
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
    
    public ArrayList<BookTable> getBooks(){
        return activeBookList; 
    }
    
    public ArrayList<CustomersTable> getCustomers(){
        return activeCustomerList; 
    }

    public String getPassword(){
        return password; 
    }
    
    public String getUsername(){
        return username; 
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setCurrentCustomer(CustomersTable c){
        currentCustomer = c; 
    }
    
    public CustomersTable getCurrentCustomer(){
        return currentCustomer; 
    }
    
    public double getCurrentTransactionCost(){
        return currentTransactionCost;
    }
    
    public void setCurrentTransactionCost(double c){
        currentTransactionCost = c; 
    }
    
    public void updateCustomer(CustomersTable cust){
        int count = 0;
        for(CustomersTable c: activeCustomerList){
            if(c == cust){
                CustomersTable tempCust = c; 
                deleteCustomer(count);
                addCustomer(tempCust);
                return; 
            }
            count++; 
        }
    }
}
