package coe528project;


public class Gold extends CustomerState {

    Gold() {
    }
      @Override
    public void changeState(CustomersTable c) {
        c.setStatus(new Silver());
    }
    
    public String toString(){
        return "Gold"; 
    }
}
