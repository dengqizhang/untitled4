package cn.lnfvc.tushu;

public class Orderltem {
    //图书名称（bookname），图书单价（price），购买数量（num）
    private String bookName;
    private double price;
    private int num;
    //无参构造器
    public Orderltem(){}

    public Orderltem(String bookName,double price,int num){
        //super方法调用父类构造方法
        //        super();
        this.bookName = bookName;
        this.price = price;
        this.num = num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
