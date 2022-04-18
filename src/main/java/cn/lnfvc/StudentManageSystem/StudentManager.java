package cn.lnfvc.StudentManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    /*
    1,用输出语句完成主界面的编写
    2.用Scanner实现键盘录入的数据
    3.用switch语句完成操作的选择
    4.用循环完成再次回到主界面
     */
    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            //用输出完成主界面的编写
            System.out.println("-------学生管理系统--------");
            System.out.println("1，添加学生");
            System.out.println("2，删除学生");
            System.out.println("3，修改学生");
            System.out.println("4，查看所有学生");
            System.out.println("5，退出");
            System.out.println("请输入你的选择（1-5）:");
            Scanner sc = new Scanner(System.in);
            //定义一个变量来接受用户输入的数据
            String line = sc.nextLine();
            //用switch语句来做用户选择分支
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
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //虚拟机退出
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    public static void addStudent(ArrayList<Student> array){
        //键盘录入学生对象使需要的数据，显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
        System.out.println("请输入学生学号：");
            sid = sc.nextLine();
        //为了让程序输入完被使用的学号,不退出到主界面还能回到这里,我们使用循环实现
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用,请换个学号");
            }else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象添加到集合中
        array.add(s);
        //给出添加成功提示
        System.out.println("添加学生成功");
    }
    public static void findAllStudent(ArrayList<Student> array){
        //判断集合中是否有数据，如果没有显示提示信息
        if (array.size() == 0){
            System.out.println("无信息，请先添加后再查询");
            //为了不让程序往下执行，加入return返回
            return;
        }
        //显示表头信息
        System.out.println("学生\t\t姓名\t年龄\t居住地");
        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充岁
        for (int i = 0; i < array.size(); i++) {
            //取集合中的数据
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }
    public static void deleteStudent(ArrayList<Student> array){
        //键盘录入要删除的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要删除学生的学号：");
        String sid = sc.nextLine();
        //遍历集合将对应学生对象从集合中删除
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            //if集合里的学号和我键盘录入的学号一致，就索引到集合里数据的位置做删除
            if (s.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在请重新输入");
        }else {
            array.remove(index);
            System.out.println("删除学生成功");
        }

    }
    public static void updateStudent(ArrayList<Student> array){
        //键盘录入要修改的学生学号,显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生学号:");
        String sid = sc.nextLine();
        int index = -1;
        for (int i=0;i<array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                //如果在集合里找到存在的学号,就修改索引的值
                index = i;
                break;
            }
        }
        //如果索引值等于-1说明输入了在集合里不存在的元素
        if (index == -1){
            System.out.println("该信息不存在请重新输入");
            return;
        }
        //键盘录入要修改的学生信息
        System.out.println("请输入学生新姓名:");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄:");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地:");
        String address = sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //遍历集合修改对应的学生信息
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            //判断集合里学号和输入是否相等
            if (student.getSid().equals(sid)){
                //用方法替换新创建的学生对象
                array.set(i,s);
                break;
            }
        }
        //给出修改成功提示
        System.out.println("修改学生信息成功");
    }
    //定义一个方法来判断学号是否被使用
    public static boolean isUsed(ArrayList<Student> array, String sid){
        //如果与集合中的某一个学生学号相同,返回true,如果都不相同,返回false
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s =  array.get(i);
            if (s.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;

    }
}