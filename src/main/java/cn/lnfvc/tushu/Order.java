package cn.lnfvc.tushu;

import javafx.scene.chart.PieChart;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Order {
    //在这个类里写入，订单号（orderid），订单总额（total），订单日期（date），订单项列表（items）
    //创建Random包下的Random对象，作用是一个随机数器，避免订单号重复
    Random r = new Random();
    //随机一个四位数的整数型值，并将其转换为字符串，与10086链接起来，赋值给订单号orderid属性
    public String orderID = "10086"+String.valueOf(r.nextInt(8999)+1000);
    double total;
    //Date对象用来处理日期和时间，创造一个日期和时间的字符串
    Date date = new Date();
    //这是一个集合列表属性
    ArrayList<Orderltem> items = new ArrayList<Orderltem>();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Orderltem> getItems() {
        return items;
    }

    public void setItems(ArrayList<Orderltem> items) {
        this.items = items;
    }
}
