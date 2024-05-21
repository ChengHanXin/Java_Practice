### Java流程控制

#### 一、原码、反码、补码   计算机中的存储和计算都以补码的形式进行!!!

1. 原码

   即将数字转换为二进制，其中左边第一位表示符号位，0代表正数，1代表负数。

   ```java
   5的原码为：0000 0101；
   -5的原码为：1000 0101；
   ```

2. 反码

   为了解决原码不能计算负数的问题

   ```java
   -5 + 1 = - 4
   使用原码计算：
       1000 0101
       0000 0001
     = 1000 0110 = - 6    这不合常理！！！
   使用反码计算：
       1111 1010
       0000 0001
     = 1111 1011
    其对应的原码为：1000 0100 = - 4
   ```

   **转换规则：**

   ​	正数的反码就是其原码；

   ​	负数的反码为在其原码的基础上，符号位不变，其余位取反。

   **反码的弊端：**

   ​	由于符号位的存在，0会有两种形式：+0和-0。所以当负数计算跨零时，会丢失一个数

   ```java
   -5 + 6 = 1
   使用反码计算：
       1111 1010
       0000 0110
     = 0000 0000
    其对应的原码为：0000 0100 = 0
   由于存在两种形式的0，导致负数在跨零的时候，会丢失1。
   ```

   <div style="text-align:center">
       <img src="images\反码.png" alt="反码弊端">
   </div>

3. 补码

   为了解决反码在计算负数跨零时的问题，产生了补码。

   计算规则：
           正数的补码不变，负数的补码在其反码基础上+1

   ​        另外补码还能多记录一个特殊的值-128，该数据在1个字节下，没有原码和反码。

   <div style="text-align:center">
       <img src="images\补码.png" alt="补码">
   </div>

```java
practice
  int a = 200;	//0000 0000 0000 0000 0000 0000 1100 1000
  byte b = (byte)a;		//1100 1000
  System.out.println(b);		//b = - 56
注意：
    此时的b = 1100 1000是补码的形式！！！
    其对应的反码 = 补码-1 = 1100 0111
    其对应的原码 = 1011 1000 = - 56
```

4. 其他运算符

   <div style="text-align:center">
       <img src="images\其他运算符.png" alt="其他运算符">
   </div>

#### 二、判断语句：if语句

```java
格式：
if (关系表达式) {
    语句体;	
}
```
```java
格式：
if (关系表达式) {
    语句体1;	
} else {
    语句体2;	
}
```

```java
格式：
if (关系表达式1) {
    语句体1;	
} else if (关系表达式2) {
    语句体2;	
} 
…
else {
    语句体n+1;
}
```

#### 三、switch语句

~~~java
switch (表达式) {
   	case 1:
    	语句体1;
    	break;
    case 2:
    	语句体2;
    	break;
    ...
    default:
    	语句体n+1;
    	break;
   }
注意：
    表达式的取值可以是byte、short、int、char，JDK5以后可以是枚举，JDK7以后可以是String。
        case后面的值只能是字面量，不能是变量。
        case给出的值不允许重复。
    ```
~~~

**扩展知识：**

+ default的位置和省略情况

  default可以放在任何位置，也可以省略，其作用类似于if中的else

+ case穿透

  不写break会引发穿透现象

+ switch在JDK12的新特性

  ```java
  int number = 10;
  switch (number){
      case 1 -> System.out.println("一");
      case 2 -> System.out.println("二");
      case 3 -> System.out.println("三");
      default -> System.out.println("其他")；
  }
  ```

+ switch和if第三种格式各自的使用场景

  当我们需要把有限个数据列举出来，选择其中一个执行的时候，用switch语句；

  当我们需要对一个范围进行判断的时候，用if的第三种格式

  ```java
  /*
  	需求：键盘输入星期数，输出工作日和休息日。
  	（1-5）工作日，（6-7）休息日
  */
  //1.键盘输入星期数
  Scanner sc = new Scanner(System.in);
  System.out.println("请输入星期：");
  int week = sc.nextInt();
  //2.使用switch进行匹配
  switch (week){
      case 1:
          System.out.println("工作日")；
      case 2:
          System.out.println("工作日")；
      ......
      //使用case穿透简化代码
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
          System.out.println("工作日")；
          break；
      case 6：
      case 7:
          System.out.println("休息日")；
          break；
  }
  //使用JDK12简化代码书写
  switch (week){
  	case 1, 2, 3, 4, 5 -> {System.out.println("工作日");}
      case 6, 7 -> {System.out.println("休息日");}
      default -> {System.out.println("没有这个星期");}
  }
  ```

#### 四、循环结构

1. **for循环**

   ```java
   for (初始化语句;条件判断语句;条件控制语句) {
   	循环体语句;
   }
   ```

2. **while循环**

   ```java
   初始化语句;
   while(条件判断语句){
   	循环体;
   	条件控制语句;
   }
   ```

3. **for和while对比**

   for循环中，知道循环次数或者循环的范围；

   while循环中，不知道循环的次数和范围，只知道循环的结束条件；

4. **do while**

   ```java
   初始化语句;
   do{
       循环体;
       条件控制语句;
   }while(条件判断语句);
   ```

5. **循环控制语句**

   + continue

     跳过本次循环，继续执行下次循环

   + break

     结束整个循环

   

