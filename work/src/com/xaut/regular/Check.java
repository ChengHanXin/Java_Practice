package com.xaut.regular;

public class Check {
    public static void main(String[] args) {
        /*需求：
            请编写正则表达式验证用户输入的手机号码是否满足要求。
            请编写正则表达式验证用户输入的邮箱号是否满足要求。
            请编写正则表达式验证用户输入的电话号码是否满足要求。
            验证手机号码 13112345678 13712345667 13945679027 139456790271
            验证座机电话号码 020-2324242 02122442 027-42424 0712-3242434
            验证邮箱号码 3232323@qq.com zhangsan@itcast.cnn dlei0009@163.com dlei0009@pci.com.cn*/

        //13112345678 13712345667 13945679027 139456790271
        //String regexPhone = "1[3-9][0-9]{9}";
        String regexPhone = "1[3-9]\\d{9}";
        System.out.println("13112345678".matches(regexPhone));

        //020-2324242 02122442 027-42424 0712-3242434
        //一:区号@\\d{2,3}
        //      0:表示区号一定是以0开头的
        //      \\d{2,3}:表示区号从第二位开始可以是任意的数字，可以出现2到3次。
        //二:- ?表示次数，日次或一次
        //三:号码 号码的第一位也不能以日开头，从第二位开始可以是任意的数字，号码的总长度:5-10位
        String regexZuo = "0\\d{2,3}-?[1-9]\\d{4,9}";
        System.out.println("02122442".matches(regexZuo));

        //3232323@qq.com zhangsan@itcast.cnn dlei0009@163.com dlei0009@pci.com.cn
        //第一部分:@的左边 \\w+
        //      任意的字母数字下划线，至少出现一次就可以了
        //第二部分:@ 只能出现一次
        //第三部分:
        //      3.1         .的左边[\\w&&[^_]]{2,6}
        //                  任意的字母加数字，总共出现2-6次(此时不能出现下划线)
        //      3.2         . \\.
        //      3.3         大写字母，小写字母都可以，只能出现2-3次[a-zA-Z]{2,3}
        //      我们可以把3.2和3.3看成一组，这一组可以出现1次或者两次
        String regexEmail = "\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println("dlei0009@pci.com.cn".matches(regexEmail));

    }
}