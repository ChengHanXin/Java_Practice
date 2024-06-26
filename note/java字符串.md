### 字符串

#### 一、概述

​	1. String代表字符串，Java中所有字符串文字都被实现为此类的实例，也就是说，Java中所有的双引号字符串，都是String类的对象。String类在Java.lang包下，所以使用的时候不用导包，因为Java.lang是基础包。

2. 特点

   + 字符串对象不可变，它们的值在创建后不能被更改（其对象不可变，但是字符串变量可以修改）
   + 虽然String的值不可变，但是它们可以被共享
   + 字符串效果上相当于字符数组（char[]），但是底层原理是字节数组（byte[]）

3. 构造方法

    | 方法名                      | 说明                                      |
     | --------------------------- | ----------------------------------------- |
     | public   String()           | 创建一个空白字符串对象，不含有任何内容    |
     | public   String(char[] chs) | 根据字符数组的内容，来创建字符串对象      |
     | public   String(byte[] bys) | 根据字节数组的内容，来创建字符串对象      |
     | String s =   “abc”;         | 直接赋值的方式创建字符串对象，内容就是abc |

    + 注意：
    
      以“”方式直接赋值的字符串，只要字符完全一样，无论在代码中出现几次，JVM都只会建立一个String对象，并在字符串池中维护；

<div style="text-align:center">
    <img src="images\字符串直接赋值内存图.png" alt="内存分配" width="100%" height="100%">
</div>

​			通过new创建的字符串对象，每一次new都会申请一个内存空间，虽然内容可能相同，但是地址值不同；

<div style="text-align:center">
    <img src="images\字符串new创建内存图.png" alt="内存分配" width="100%" height="100%">
</div>

#### 二、字符串比较

1. "=="比较的是什么？

   + 当比较双方为基本数据类型时，比较的是具体的值
   + 当比较双方为引用数据类型时，比较的是对象地址

2. equals

   ```java
   public boolean equals(String s)     比较两个字符串内容是否相同、区分大小写
   public boolean equalsIgnoreCase(String s)	忽略大小写
   ```

#### 三、StringBuilder

​	**StringBuilder可以看作是一个容器，创建之后里面的内容是可变的**

​	当进行字符串拼接和字符串反转时，可以使用StringBuilder对象

```java
//当我们进行字符串拼接时，当进行很多次时
String s = "";
for (int i = 0; i < 9999999; i++){
    s += "abc";
}
//这样就会很慢，因为字符串对象是不可修改的，所以在每次循环时，都会在堆内存中新建一个字符串对象用来保存中间结果，这样导致运行十分缓慢

//而StringBuilder是可变对象，我们可以直接在原对象上进行修改，大大加快运行速度
```

1. 构造方法

   ```java
   public StringBuilder()		//无参构造，创建一个空白可变字符串对象，不含任何内容
   public StringBuilder(String str)	//带参构造，根据字符串内容，来创建可变字符串对象
   ```

2. 常用方法

   ```java
   public StringBuilder append(任意类型)	//添加数据，并返回对象本身
   public StringBuilder reverse()		//反转容器中的内容
   public int length()		//返回长度
   public String toString()	//通过该方法可以把StringBuilder转换为String
   ```

   + note 

     ```java
     StringBuilder sb = new StringBuilder();
     System.out.println(sb);		//打印的是属性值而不是地址值
     //其实对于字符串的其他对象来说，也都会直接打印属性值，这是因为它重写了toString()方法
     ```

#### 四、StringJoiner

​	与StringBuilder类似，也可以看作是一个容器，创建之后里面的内容是可变的

​	可以提高字符串的操作效率，JDK8出现

1. 构造方法

   ```java
   public StringJoiner(间隔符号)	//创建一个StringJoiner对象，指定拼接时的间隔符号
   public StringJoiner(间隔符号，开始符号，结束符号)	//指定间隔、开始、结束符号
   ```

2. 常用方法

   ```java
   public StringJoiner add(添加的内容)	//添加数据，并返回对象本身
   public int length()		//返回长度（字符出现的个数）
   public String toString()	//返回一个字符串
   ```



#### 五、字符串原理

1. 字符串拼接

   拼接时，如果没有变量参与，如`String = "a" + "b"`在编译的时候，就会将"a" + "b"拼接为"ab"；

   <div style="text-align:center">
       <img src="images\字符串拼接.png" alt="字符串" width="100%" height="100%">
   </div>

2. 字符串原理

   <div style="text-align:center">
       <img src="images\字符串原理.png" alt="字符串" width="100%" height="100%">
   </div>