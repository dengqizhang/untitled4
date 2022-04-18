package cn.lnfvc.MyApp;

class Test1 {
    private String book;
    private String name;
    private int xiaoliang;

//    public void read() {
//        System.out.println("书名：" + book);
//        System.out.println("姓名：" + name);
//        System.out.println("月销量：" + xiaoliang);
//    }

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public int getXiaoliang() {
        return xiaoliang;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXiaoliang(int xiaoliang) {
        this.xiaoliang = xiaoliang;
    }

    public Test1()//空参构造
    {
        super();
    }
    public void Test2(String book,String name,int xiaoliang){//有参构造
        System.out.println("书名：" + book);
        System.out.println("姓名：" + name);
        System.out.println("月销量：" + xiaoliang);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.Test2("java基础","zz", Integer.parseInt("123"));
    }
}
