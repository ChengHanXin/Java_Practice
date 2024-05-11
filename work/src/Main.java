import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12,14,23,45,66,68,70,77,90,91};
        //由于数组长度不能修改，所以定义一个新的数组保存结果，长度为原数组长度+1
        int[] res = new int[arr.length + 1];
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int index = arr.length;  //记录用于存放number的位置
        //将这个number插入到arr中，且保持这个数组依然有序
        for (int i = 0 ; i < arr.length ; i++) {
            //找到number在新数组中的位置
            if (number <= arr[i]) {
                index = i;
                break;
            }
        }
        //开始存放
        for (int i = 0 ; i < res.length ; i++) {
            if (i < index) {
                res[i] = arr[i];
            }else if (i == index) {
                res[i] = number;
            }else{
                res[i] = arr[i - 1];
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}