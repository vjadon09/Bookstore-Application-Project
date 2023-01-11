package coe528project;

public class Silver extends CustomerState {

    Silver() {}

    @Override
    public void changeState(CustomersTable c) {
        c.setStatus(new Gold());
    }
    
    public String toString(){
        return "Silver"; 
    }
    
}
