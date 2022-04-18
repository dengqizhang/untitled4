package cn.lnfvc.tushu;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    //生成全局的Scanner对象sc，方便每次输出时调用
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        //创建一个订单对象order
        Order order = new Order();
        //创建一个自定义Book泛型的ArrayList集合book
        ArrayList<Book> book = new ArrayList<Book>();
        //创建book集合中的元素对象
        book.add(new Book("1","java教程",30.6,30));
        book.add(new Book("2","jsp 指南",42.1,40));
        book.add(new Book("3","SSH 架构",47.3,15));

        System.out.println("=========图书列表=========");
        System.out.println("图书列表===图书名称==单价==库存");
        //对集合book进行遍历，输出其元素对象的属性
        for (Book book2 : book) {
            System.out.println(book2.getBookID()+"--------"+book2.getBookName()+"--"+book2.getPrice()+"--"+book2.getStorage());
        }
        //调用buy方法，传入order对象以及book集合
        buy(order,book);
    }
    /**
     * @buy方法，提供购买处理
     * @param order
     * @param book
     */
    public static void buy(Order order,ArrayList<Book> book) {
        System.out.println("请输入购买图书编号:");
        String bookID = sc.next();
        System.out.println("请输入购买该图书数量:");
        int num = sc.nextInt();
        //对传入的book集合进行遍历
        for(int i=0;i<book.size();i++) {
            //如果输入的图书编号与集合中的某个元素对象的图书编号相同
            if(bookID.equals(book.get(i).getBookID())) {
                //且此元素对象的库存大于购买数，购买数大于0
                if(book.get(i).getStorage()>=num && num>0) {
                    //则在order对象的items属性列表中，新建一个OrderItem类型元素对象，将相对应的图书名称、价格、购买数量作为其属性
                    order.items.add(new Orderltem(book.get(i).getBookName(),book.get(i).getPrice(),num));
                    //将book集合相应对象的库存减去购买数量
                    book.get(i).setStorage(book.get(i).getStorage()-num);
                }else if(num>book.get(i).getStorage()){
                    //如果输入的购买数量大于库存，则输出库存不足
                    System.out.println("库存不足");
                    break;
                }else {
                    //否则无消费
                    System.out.println("无消费！");
                }
            }
        }

        System.out.println("是否继续购买！y/n:");
        String anwser = sc.next();
        //如果判断是否继续购买
        if(anwser.equalsIgnoreCase("y")) {
            //是，则调用buy自身
            buy(order,book);
        }else {
            //否，调用order订单方法
            order(order,book);
        }

    }
    /**
     * @order方法，提供打印订单处理
     * @param order
     * @param book
     */
    public static void order(Order order,ArrayList<Book> book) {
        System.out.println("          图书订单                     ");
        System.out.println("图书订单号:"+order.orderID);
        System.out.println("图书名称          购买数量       图书单价");
        System.out.println("--------------------------");
        //对order对象中的items集合属性进行判断，是否为空
        if(order.items.isEmpty()) {
            //为空则
            System.out.println("无任何消费！");
        }else {
            //不为空则遍历items集合属性
            for (Orderltem M : order.items) {
                //输出items集合中元素对象的属性
                System.out.println(M.getBookName()+"           "+M.getNum()+"       "+M.getPrice());
                //汇总购买总额
                order.total +=M.getNum()*M.getPrice();
            }
        }

        System.out.println("--------------------------");
        System.out.println("订单总额：                          "+order.total);
        System.out.println("日期："+order.date);
    }
}
