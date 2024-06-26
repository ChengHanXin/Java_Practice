package com.xaut.regular;

public class CheckTwo {
    public static void main(String[] args) {
        /*需求
            请编写正则表达式验证用户名是否满足要求。要求:大小写字母，数字，下划线一共4-16位
            请编写正则表达式验证身份证号码是否满足要求。
            简单要求:
                    18位，前17位任意数字，最后一位可以是数字可以是大写或小写的x
            复杂要求:
                    按照身份证号码的格式严格要求。
        	身份证号码:
        		41080119930228457x
        		510801197609022309
        		15040119810705387X
        		130133197204039024
        		430102197606046442*/

        //用户名验证  大小写字母，数字，下划线一共4-16位
        String regexUser = "\\w{4,16}";
        System.out.println("afhua_fJIGHO".matches(regexUser));
        System.out.println("----------------------------------");

        //身份证简单验证  18位，前17位任意数字，最后一位可以是数字可以是大写或小写的x
        //String regexIdSimple = "[1-9]\\d{16}(\\d|X|x)";
        //String regexIdSimple = "[1-9]\\d{16}[\\dXx]";
        String regexIdSimple = "[1-9]\\d{16}(\\d|(?i)x)";   //使用(?i)来忽略大小写
        System.out.println("41080119930228457x".matches(regexIdSimple));
        System.out.println("430102197606046442".matches(regexIdSimple));
        System.out.println("15040119810705387X".matches(regexIdSimple));
        System.out.println("----------------------------------");

        //身份证复杂验证
        //410801 1993 02 28 457x
        //前六位： 不能以0开头，后面跟5个任意数字  [1-9]\\d{5}
        //年份：
        //  前半部分：18  19  20     (18|19|20)
        //  后半部分：00-09  10-19  20-29.....  任意两位数字  \\d{2}
        //月份：  01-09  10 11 12    (0[1-9]|1[012])
        //天数：  01-09  10-19  20-29  30 31  (0[1-9]|[12]\\d|3[01])
        //后四位：任意三位数字，最后一位可以是任意数字、x、X    \\d{3}(\\d|(?i)x)
        String regexIdComplex = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|(?i)x)";
        System.out.println("41080119930228457x".matches(regexIdComplex));
        System.out.println("430102197606046442".matches(regexIdComplex));
        System.out.println("15040119810705387X".matches(regexIdComplex));
    }
}
