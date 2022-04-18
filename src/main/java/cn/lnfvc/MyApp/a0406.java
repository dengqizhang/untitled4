package cn.lnfvc.MyApp;

import java.util.Scanner;

public class a0406 {
    public static void main(String[] args) {
//        boolean zzz = zdq(10);

//        int[] shuzu = {11,22,33,44};
////        z(shuzu);
//        int zdq = c(shuzu);
//        System.out.println("数组shuzu的最大值是：" + zdq);

        int[] arr = {11, 22, 33, 44, 55};

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的数据为：");
        int number = scanner.nextInt();

        int idex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                idex = i;
                System.out.println("您找到的元素为："+ idex);
                break;
            }
        }
    }

//        arr[0]=1;
//        arr[1]=1;
//
////        arr[2]= arr[0] + arr[1];
//        for (int i = 2; i < arr.length; i++) {
//            arr[i] = arr[i-2] + arr[i-1];
//        }
//        System.out.println(arr[19]);
//    }
    public static boolean zdq(int nub){
        if (nub % 2 == 0){
            return true;
        }else {
            return false;
        }
    }

        public static void z (String[]shuzu){
            for (int i = 0; i < shuzu.length; i++) {
                System.out.println(shuzu[i]);
            }
        }
        public static int c ( int[] shuzu){
            int max = shuzu[0];
            for (int i = 1; i < shuzu.length; i++) {
                if (shuzu[i] > max) {
                    max = shuzu[i];
                }
            }
            return max;
        }
    }

