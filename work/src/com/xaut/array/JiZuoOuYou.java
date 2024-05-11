package com.xaut.array;

public class JiZuoOuYou {
    public static void main(String[] args) {
        /*定义一个数组其中包含多个数字。
        用自己的方式最终实现，奇数放在数组的左边，偶数放在数组的右边。
        （可以创建其他数组，不必须在原数组中改变）*/

        int[] arr = {2, 1, 3, 6, 8};
        //方案一：定义一个新数组，将原数组的奇数放在新数组的左边，偶数放在右边
//        int[] arr2 = new int[arr.length];
//        int left = 0;
//        int right = arr.length - 1;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % 2 == 1){
//                arr2[left] = arr[i];
//                left++;
//            }else {
//                arr2[right] = arr[i];
//                right--;
//            }
//        }

        //方案二：在原数组的基础上进行调整，找到左边的偶数，和右边的奇数交换位置
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] % 2 == 0) {
                if (arr[j] % 2 == 0) {
                    continue;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
