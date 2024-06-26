### Java基本语法

#### 一、注释和关键字

1. **注释** 		注意：不要进行嵌套注释

   + 单行注释     

     ```java
     //这是单行注释

   + 多行注释

     ```java
     /*这是多行注释*/
     ```

   + 文档注释

     ```java
     /**这是文档注释**/
     ```

2. **关键字**

   关键字即被Java赋予特定含义的英文单词

   | **abstract**   | **assert**       | **boolean**   | **break**      | **byte**   |
   | -------------- | ---------------- | ------------- | -------------- | ---------- |
   | **case**       | **catch**        | **char**      | **class**      | **const**  |
   | **continue**   | **default**      | **do**        | **double**     | **else**   |
   | **enum**       | **extends**      | **final**     | **finally**    | **float**  |
   | **for**        | **goto**         | **if**        | **implements** | **import** |
   | **instanceof** | **int**          | **interface** | **long**       | **native** |
   | **new**        | **package**      | **private**   | **protected**  | **public** |
   | **return**     | **strictfp**     | **short**     | **static**     | **super**  |
   | **switch**     | **synchronized** | **this**      | **throw**      | **throws** |
   | **transient**  | **try**          | **void**      | **volatile**   | **while**  |

#### 二、字面量

​	作用：告诉程序员，数据在程序中的书写格式。

| **字面量类型** | **说明**                                  | **程序中的写法**           |
| -------------- | ----------------------------------------- | -------------------------- |
| 整数           | 不带小数的数字                            | 666，-88                   |
| 小数           | 带小数的数字                              | 13.14，-5.21               |
| 字符           | 必须使用单引号，有且仅能一个字符          | ‘A’，‘0’，   ‘我’          |
| 字符串         | 必须使用双引号，内容可有可无              | “HelloWorld”，“黑马程序员” |
| 布尔值         | 布尔值，表示真假，只有两个值：true，false | true 、false               |
| 空值           | 一个特殊的值，空值                        | 值是：null                 |

~~~java
public class Demo {
    public static void main(String[] args) {
        System.out.println(10); // 输出一个整数
        System.out.println(5.5); // 输出一个小数
        System.out.println('a'); // 输出一个字符
        System.out.println(true); // 输出boolean值true
        System.out.println("欢迎来到黑马程序员"); // 输出字符串
    }
}
~~~

**区分技巧**

1. 不带小数点的数字都是整数类型的字面量。
2. 只要带了小数点，那么就是小数类型的字面量。
3. 只要用双引号引起来的，不管里面的内容是什么，不管里面有没有内容，都是字符串类型的字面量。
4. 字符类型的字面量必须用单引号引起来，不管内容是什么，但是个数有且只能有一个。
5. 字符类型的字面量只有两个值，true、false。
6. 空类型的字面量只有一个值，null。

**特殊类型**

```java
'\t'	制表符		在打印的时候，把前面的字符串长度补齐到8，或8的整数倍。
		System.out.println("name" + '\t' + "age");		name+四个空格+age
    	System.out.println("tom" + '\t' + "23");		tom+五个空格+23
注意：在cmd中补8的倍数，在idea中默认是补4的倍数。
```

#### 三、变量

- 变量名不能重复
- 在一条语句中，可以定义多个变量。但是这种方式影响代码的阅读，所以了解一下即可。
- 变量在使用之前必须要赋值。

案例：

```java
public class VariableDemo2{
	public static void main(String[] args){
		//1.变量名不允许重复
		//int a = 10;
		//int a = 20;
		//System.out.println(a);
		
		//2.一条语句可以定义多个变量
		//了解。
		//int a = 10, b = 20, c = 20,d = 20;
		//System.out.println(a);//?
		//System.out.println(b);//?
		
		
		//3.变量在使用之前必须要赋值
		int a = 30;
		System.out.println(a);
	}
}
```

#### 四、数据存储

**在计算机中，使用二进制存储数据**

+ 二、八、十、十六进制

<div style="text-align:center">
    <img src="images\进制.png" alt="进制">
</div>

+ 进制转换

<div style="text-align:center">
    <img src="images\进制转换1.png" alt="进制转换">
</div>

<div style="text-align:center">
    <img src="images\进制转换2.png" alt="进制转换">
</div>

1. 文本存储

   + 数字，直接转换为二进制存储

   + 英文字母，查询码表，然后转换为二进制存储

   + 汉字，查询码表，然后转换为二进制存储

     ASCII码表 存储英文字母

<div style="text-align:center">
    <img src="images\ASCII码表.png" alt="ASCII">
</div>

​			其他编码表

<div style="text-align:center">
    <img src="images\其他编码表.png" alt="ASCII">
</div>

2. 图片

​	将像素值转换为二进制存储

3. 声音

​	对声音的波形图进行采样，然后转换为二进制存储

<div style="text-align:center">
    <img src="images\声音.png" alt="sound">
</div>

#### 五、数据类型、标识符

1. 数据类型

   + 基本数据类型

   | 数据类型 | 关键字  | 内存占用 |                 取值范围                  |
   | :------: | :-----: | :------: | :---------------------------------------: |
   |   整数   |  byte   |    1     |    负的2的7次方 ~ 2的7次方-1(-128~127)    |
   |          |  short  |    2     | 负的2的15次方 ~ 2的15次方-1(-32768~32767) |
   |          |   int   |    4     |        负的2的31次方 ~ 2的31次方-1        |
   |          |  long   |    8     |        负的2的63次方 ~ 2的63次方-1        |
   |  浮点数  |  float  |    4     |        1.401298e-45 ~ 3.402823e+38        |
   |          | double  |    8     |      4.9000000e-324 ~ 1.797693e+308       |
   |   字符   |  char   |    2     |                  0-65535                  |
   |   布尔   | boolean |    1     |                true，false                |

   ​	注意：在定义long类型变量时，在数值的后面需要加一个L作为后缀。

   ​				在定义float类型变量时，在数值的后面需要加一个F作为后缀。

   + 引用数据类型

2. 标识符

   即给类、方法、变量起的名字

   + 硬性要求

     由数字、字母、下划线和美元符组成

     不能由数字开头

     不能是关键字

     区分大小写

   + 标识符命名规则

     > 小驼峰命名法：方法、变量
     >
     > ​	标识符是一个单词时，全部小写
     >
     > ​	标识符由多个单词组成时，第一个单词首字母小写，其他单词首字母大写
     >
     > 大驼峰命名法：类名
     >
     > ​	标识符是一个单词时，首字母大写
     >
     > ​	标识符由多个单词组成时，每个单词的首字母大写

#### 六、 键盘输入

​	键盘录入的实际功能Java已经帮我们写好了，不需要我们自己再实现了，而Java写好的功能都放在了Scanner这个类中，所以，我们只要直接使用Scanner这个类就可以了。

使用步骤：

​	第一步：

​		导包：其实就是表示先找到Scanner这个类在哪。

​	第二步：

​		创建对象：其实就表示申明一下，我准备开始用Scanner这个类了。

​	第三步：

​		接收数据：也是真正干活的代码。

代码示例：

```java
//导包，其实就是先找到Scanner这个类在哪
import java.util.Scanner;
public class ScannerDemo1{
	public static void main(String[] args){
		//2.创建对象，其实就是申明一下，我准备开始用Scanner这个类了。
		Scanner sc = new Scanner(System.in);
		//3.接收数据
		//当程序运行之后，我们在键盘输入的数据就会被变量i给接收了
		System.out.println("请输入一个数字");
		int i = sc.nextInt();
		System.out.println(i);
	}
}
```

#### 七、运算符和表达式

1. 算术运算符

   分类：

   ```java
   + - * / %
   ```

   运算特点：

   ```java
   + - * :跟小学数学中一模一样没有任何区别.
   ```

   ```java
   /：
   1.整数相除结果只能得到整除，如果结果想要是小数，必须要有小数参数。
   2.小数直接参与运算，得到的结果有可能是不精确的。
   案例：
   System.out.println( 10 / 3);//3
   System.out.println(10.0 / 3);//3.3333333333333335
   ```

   ```java
   %：取模、取余。
      他做的也是除法运算，只不过获取的是余数而已。
   案例：
   System.out.println(10 % 2);//0
   System.out.println(10 % 3);//1
   应用场景：
   //可以利用取模来判断一个数是奇数还是偶数
   System.out.println(15 % 2);//1  奇数
   ```

2. 类型转换

   + 隐式类型抓换

     取值范围小的数值对应的类型——>取值范围大的数值对应的类型

     **注意：byte short char 三种类型的数据在运算的时候，都会直接提升为int，然后进行运算。**

     <div style="text-align:center">
         <img src="images\隐式转换.png" alt="隐式转换">
     </div>

   + 显示类型转换，可能会发生精度丢失

     取值范围大的数值对应的类型——>取值范围小的数值对应的类型

3. 字符串”+“操作，字符“+”操作

   + 字符串相加

   <div style="text-align:center">
       <img src="images\字符串+操作.png" alt="字符串运算">
   </div>

   ```java
   System.out.println(1 + 2 + "abc" + 2 + 1);		//3abc21
   ```

   + 字符相加

     当字符与字符相加，或字符与数字相加，先把字符通过码表转换为数字，然后相加。

4. 自增自减运算符

   ```java
   ++, -- ;	//分别代表自增和自减运算符
   int a = 1;
   int b = a++;	// b=1，此时先赋值，再自增
   int c = ++a;	// c=3，此时先自增，再赋值
   ```

5. 赋值运算符

   <div style="text-align:center">
       <img src="images\赋值运算符.png" alt="赋值运算">
   </div>

   ```java
   // 细节  在运算结束后，会进行强制类型转换，将结果转换为待赋值对象的类型
   short a = 1;
   a += 1;
   System.out.println(a)	// a = 2
   /*此时，a的类型是什么呢？
     a += 1  等价于   a = (short)(a + 1)
     short在进行运算时，会先转换为int类型，那此时a+1的结果就为int类型，不能直接赋值给shrot类	 型的a变量，此时就需要进行强制类型转换。*/  
   ```

6. 关系运算符（比较运算符）

   <div style="text-align:center">
       <img src="images\关系运算符.png" alt="关系运算符">
   </div>

7. 逻辑运算符

   <div style="text-align:center">
       <img src="images\逻辑运算符.png" alt="逻辑运算符">
   </div>

   短路逻辑运算符：当左边的表达式能够确定最终的结果，那么右边就不会参与运行了。

   <div style="text-align:center">
       <img src="images\短路逻辑运算符.png" alt="短路逻辑运算符">
   </div>

   ```java
   int a = 10, b = 10;
   boolean result = ++a < 9 && ++b < 9
   // a = 11, b = 10, result = false
   boolean result = ++a < 20 || ++b < 9
   // a = 11, b = 10, result = true    
   ```

8. 三元运算符

   格式：关系表达式 ？ 表达式1 ：表达式2 ；

   ​			关系表达式为真，则取表达式1；关系表达式为假，则取表达式2。

9. 运算符优先级

   <div style="text-align:center">
       <img src="images\运算符优先级.png" alt="运算符优先级">
   </div>





























