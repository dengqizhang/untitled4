package cn.lnfvc.MyApp;

class Test {
    private int No;
    private String name;
    private String Sex;
    private int Age;
    private int Java;

    public void read() {
        System.out.println("学号：" + No);
        System.out.println("姓名：" + name);
        System.out.println("性别：" + Sex);
        System.out.println("年龄：" + Age);
        System.out.println("java成绩" + Java);
    }

    public Test()//空参构造
    {
        super();
    }

    public int getNo() {
        return No;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return Sex;
    }

    public int getAge() {
        return Age;
    }

    public int getJava() {
        return Java;
    }

    public void setNo(int no) {
        No = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setJava(int java) {
        Java = java;
    }

    public static int getMax(int[] arr) {
        // 定义一个参照物
        int max = arr[0];
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //判断大小
            if (arr[i] > max) {
                max = arr[i];
//                System.out.println("最大值是：" + max);
            }
        }
        return max;
    }

    public static int getkid(int[] arr) {
        // 定义一个参照物
        int max = arr[0];
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //判断大小
            if (arr[i] < max) {
                max = arr[i];
                System.out.println("最大值是：" + max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Test test1 = new Test();
        test1.No = 2138010142;
        test1.name = "htq";
        test1.Sex = "n";
        test1.Age = 19;
        test1.Java = 21;
        test1.read();
        System.out.println("\n");

        Test test2 = new Test();
        test1.No = 2138010141;
        test1.name = "sss";
        test1.Sex = "n";
        test1.Age = 19;
        test1.Java = 90;
        test1.read();
        System.out.println("\n");

        Test test3 = new Test();
        test1.No = 2138010146;
        test1.name = "fefe";
        test1.Sex = "n";
        test1.Age = 19;
        test1.Java = 70;
        test1.read();
        System.out.println("\n");

        Test test4 = new Test();
        test1.No = 2138010145;
        test1.name = "sql";
        test1.Sex = "n";
        test1.Age = 19;
        test1.Java = 30;
        test1.read();
        System.out.println("\n");

        Test test5 = new Test();
        test1.No = 2138010147;
        test1.name = "sql";
        test1.Sex = "n";
        test1.Age = 19;
        test1.Java = 60;
        test1.read();
        System.out.println("\n");

        int a = 21;
        int b = 90;
        int c = 70;
        int d = 30;
        int e = 60;
        int zdq = ((a + b + c + d + e)/5);

            System.out.println("平均成绩是："+zdq);

            int[] arr = {a,b,c,d,e};

            System.out.println("最高成绩是："+ getMax(arr));
            System.out.println("最低成绩是：" + getkid(arr));
        }
    }

