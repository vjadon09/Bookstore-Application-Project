package coe528project;
import javafx.scene.control.CheckBox;

public class BookTable {
    
    private String bookName;
    private double bookPrice;
    private CheckBox select;

    public BookTable(String bookName, double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.select = new CheckBox();
    }

    public String getBookName() {
        return bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    public CheckBox getSelect(){
        return select;
    }
    
    public void setSelect(CheckBox s){
        this.select = s;
    }
    
}
