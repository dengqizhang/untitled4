package cn.lnfvc;

public class BubbleSort {
    //冒泡排序方法
    //1版本
    public static void BubbleSort1(){
        int[] arr = {24,69,89,57,13};
        //每比较一次后减掉被比较后最大值的元素
        for (int x = 0; x < arr.length; x++) {
            for (int i = 0; i < arr.length-1-x; i++) {
                //如果排序前一个元素比后一个元素大，就让他们进行交换
                if (arr[i] > arr[i+1]){
                    //定义一个临时变量来接收交换
                    int temp = arr[i];
                    //完成在temp里对相邻元素大的值的交换
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}
