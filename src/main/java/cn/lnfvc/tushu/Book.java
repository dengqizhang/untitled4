package cn.lnfvc.tushu;

public class Book {
    //图书编号（bookID），图书名称（bookName），图书单价（price），库存数量（storage）
    private String bookID;
    private String bookName;
    private double price;
    private int storage;

    //无参构造方法
    public Book(){
    }

    public Book(String bookID,String bookName,double price,int storage){
        super();
        this.bookID = bookID;
        this.bookName = bookName;
        this.price = price;
        this.storage = storage;

    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
