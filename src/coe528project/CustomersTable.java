package coe528project;

import java.util.ArrayList;


public class CustomersTable {
    
    private String cust_username;
    private String cust_password;
    private int points;
    private CustomerState status; 
  
   
    

    public CustomersTable(String cust_username, String cust_password) {
        this.cust_username = cust_username;
        this.cust_password = cust_password;
        this.points = 0;
        this.status = new Silver(); 
        
    }

    public String getCust_username() {
        return cust_username;
    }

    public String getCust_password() {
        return cust_password;
    }

    public int getPoints() {
       
        
        return points;
    }
    
    public void setCust_username(String cust_username) {
        this.cust_username = cust_username;
    }

    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }
    
    public void setPoints(int points) {
        this.points = points;
        updateStatus();
    }
    
    public CustomerState getStatus(){
        return status; 
    }
    
    public void setStatus(CustomerState c){
        status = c; 
    }
    
    public void updateStatus(){
        if(points > 1000 && status instanceof Silver){
           status.changeState(this);
        }
        else if(points < 1000 && status instanceof Gold){
            status.changeState(this);
        }
    }
    
}
  

    
    



