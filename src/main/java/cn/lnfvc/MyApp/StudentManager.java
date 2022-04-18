package cn.lnfvc.MyApp;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        //因为在添加，删除，修改，都需要访问集合数据进行操作，所以在进入main方法时就创建
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("------学生管理系统-----");
            System.out.println("     1,添加学生");
            System.out.println("     2,删除学生");
            System.out.println("     3,修改学生");
            System.out.println("     4,查看所有学生");
            System.out.println("     5,退出");
            System.out.println("请输入您的选择(1-5):");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //jvm退出，代表循环强制退出
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    //添加学生信息
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号:");
        String sid = sc.nextLine();//接收输入值
        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();//接收输入值
        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();//接收输入值
        System.out.println("请输入学生居住地:");
        String address = sc.nextLine();//接收输入值
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student student = new Student();
        student.setSid(sid);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        //将学生对象添加到集合中
        array.add(student);
        //给出添加成功提示
        System.out.println("添加学生成功");
    }
    //查看学生信息
    public static void findAllStudent(ArrayList<Student> array){
        if(array.size() == 0){
            System.out.println("无信息，请添加学生后查询");
            //退出程序执行
            return;
        }

        //显示表头信息
        System.out.println("学号\t姓名\t年龄\t居住地");
        //将集合中的数据取出按照对应格式显示学生信息，年龄显示为岁
        for (int i = 0; i < array.size(); i++) {
            //循环数组后得到学生值
                Student s = array.get(i);
                //获取到数组里各个位置的数据
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }
    //删除学生信息
    public static void deleteStudent(ArrayList<Student> array){
        //键盘录入要删除的学生学号，显示提示信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号：");
        String sid = scanner.nextLine();
        //为了防止在删除前用户输入了集合中不存在的学号，先对输入值做判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        //将数组循环中的i用变量index记录
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在请重新输入");
        }else {
            array.remove(index);
            System.out.println("删除学生成功");
        }
        //遍历集合将元素删除
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);//得到每个值的对象
            //如果数组里的sid和键盘录入的sid相同
            if (s.getSid().equals(sid)){
                //删除数组单个元素的方法
                    array.remove(i);
                System.out.println("删除成功");
                    break;
            }
        }
        //给出删除成功提示
    }
    //修改学生信息
    public static void updateStudent(ArrayList<Student> array){
        //键盘录入要修改的学生学号，显示提示信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String sid = scanner.nextLine();

        //键盘录入要修改的学生信息
        System.out.println("请输入学生新姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = scanner.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = scanner.nextLine();

        //创建学生对象存入集合
        Student s = new Student();
        //实例化
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //遍历集合修改对应的学生信息
        for (int i = 0; i < array.size(); i++) {
            //获取集合里的每个元素
            Student student = array.get(i);
            //如果键盘输入的sid和我集合里的sid一样就修改,用新建好的学生对象替换
            if (student.getSid().equals(sid)){
                //调用方法把新的对象替换
                array.set(i,s);
                break;
            }
        }
        //给出修改成功提示
        System.out.println("修改学生成功");
    }
}
