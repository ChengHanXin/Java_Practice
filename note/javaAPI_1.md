### Java常用API

#### 1. Math

+ 常用方法

  <div style="text-align:center">
      <img src="images\Math.png" alt="Math常用方法">
  </div>

+ 方法演示

  ```java
  public class MathDemo01 {
      public static void main(String[] args) {
          // public static int abs(int a)         返回参数的绝对值
          System.out.println("-2的绝对值为：" + Math.abs(-2));
          System.out.println("2的绝对值为：" + Math.abs(2));
          //当负数没有对应的正数时，会出现错误，如int的取值范围[-2147483648,2147483647]
          //对-2147483648取绝对值还是其本身，因为2147483648存不下了
  
          // public static double ceil(double a)  返回大于或等于参数的最小整数
          System.out.println("大于或等于23.45的最小整数位：" + Math.ceil(23.45));
          System.out.println("大于或等于-23.45的最小整数位：" + Math.ceil(-23.45));
  
          // public static double floor(double a) 返回小于或等于参数的最大整数
          System.out.println("小于或等于23.45的最大整数位：" + Math.floor(23.45));
          System.out.println("小于或等于-23.45的最大整数位：" +  Math.floor(-23.45));
  
          // public static int round(float a)     按照四舍五入返回最接近参数的int
          System.out.println("23.45四舍五入的结果为：" + Math.round(23.45));
          System.out.println("23.55四舍五入的结果为：" + Math.round(23.55));
  
          // public static int max(int a,int b)   返回两个int值中的较大值
          System.out.println("23和45的最大值为: " + Math.max(23, 45));
  
          // public static int min(int a,int b)   返回两个int值中的较小值
          System.out.println("12和34的最小值为: " + Math.min(12 , 34));
  
          // public static double pow (double a,double b)返回a的b次幂的值，如果b小于1，		则相当于开根号
          System.out.println("2的3次幂计算结果为: " + Math.pow(2,3));
  
          // public static double random()返回值为double的正值，[0.0,1.0)
          System.out.println("获取到的0-1之间的随机数为: " + Math.random());
      }
  }
  ```

  ```java
          -2的绝对值为：2
          2的绝对值为：2
          大于或等于23.45的最小整数位：24.0
          大于或等于-23.45的最小整数位：-23.0
          小于或等于23.45的最大整数位：23.0
          小于或等于-23.45的最大整数位：-24.0
          23.45四舍五入的结果为：23
          23.55四舍五入的结果为：24
          23和45的最大值为: 45
          12和34的最小值为: 12
          2的3次幂计算结果为: 8.0
          获取到的0-1之间的随机数为: 0.7322484131745958
  ```



#### 2. System

+ 常用方法

  <div style="text-align:center">
      <img src="images\System.png" alt="System常用方法">
  </div>

+ 方法演示

  ```java
  public class SystemDemo3 {
      public static void main(String[] args) {
          //public static void arraycopy(数据源数组，起始索引，目的地数组，起始索引，拷贝个数) 数组拷贝
          //细节:
          //1.如果数据源数组和目的地数组都是基本数据类型，那么两者的类型必须保持一致，否则会报错
          //2.在拷贝的时候需要考虑数组的长度，如果超出范围也会报错
          //3.如果数据源数组和目的地数组都是引用数据类型，那么子类类型可以赋值给父类类型
  
          Student s1 = new Student("zhangsan", 23);
          Student s2 = new Student("lisi", 24);
          Student s3 = new Student("wangwu", 25);
  
          Student[] arr1 = {s1, s2, s3};
          Person[] arr2 = new Person[3];
          //把arr1中对象的地址值赋值给arr2中
          System.arraycopy(arr1, 0, arr2, 0, 3);
  
          //遍历数组arr2
          for (int i = 0; i < arr2.length; i++) {
              Student stu = (Student) arr2[i];
              System.out.println(stu.getName() + "," + stu.getAge());
          }
      }
  }
  
  class Person {
      private String name;
      private int age;
  
      public Person() {
      }
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
  
      public int getAge() {
          return age;
      }
      public void setAge(int age) {
          this.age = age;
      }
      public String toString() {
          return "Person{name = " + name + ", age = " + age + "}";
      }
  }
  
  class Student extends Person {
  
      public Student() {
      }
  
      public Student(String name, int age) {
          super(name, age);
      }
  }
  ```

  

#### 3. Runtime

+ 常用方法

  <div style="text-align:center">
      <img src="images\Runtime.png" alt="Runtime常用方法">
  </div>

+ 方法展示

  ```java
  public class RunTimeDemo1 {
      public static void main(String[] args) throws IOException {
          /*
              public static Runtime getRuntime() 当前系统的运行环境对象
              public void exit(int status) 停止虚拟机
              public int availableProcessors() 获得CPU的线程数
              public long maxMemory() JVM能从系统中获取总内存大小(单位byte)
              public long totalMemory() JVM已经从系统中获取总内存大小(单位byte)
              public long freeMemory() JVM剩余内存大小(单位byte)
              public Process exec(string command) 运行cmd命令
          */
          //1.获取Runtime的对象
          //Runtime r1 =Runtime.getRuntime();
  
          //2.exit 停止虚拟机
          //Runtime.getRuntime().exit(0);
          //System.out.println("看看我执行了吗?");
  
          //3.获得CPU的线程数
          System.out.println(Runtime.getRuntime().availableProcessors());//8
          //4.总内存大小,单位byte字节
          System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);//4064
          //5.已经获取的总内存大小,单位byte字节
          System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);//254
          //6.剩余内存大小
          System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);//251
  
          //7.运行cmd命令
          //shutdown :关机
          //加上参数才能执行
          //-s :默认在1分钟之后关机
          //-s -t 指定时间 : 指定关机时间
          //-a :取消关机操作
          //-r: 关机并重启
          Runtime.getRuntime().exec("shutdown -s -t 3600");
      }
  }
  ```



#### 4. Object、Objects

+ 构造方法

  ```java
  public Object()			//只有空参构造方法
  ```

  在每个类的构造方法中，会默认先调用父类的空参构造。为什么不调用有参构造呢？因为顶级父类中只有空参构造。

+ 成员方法

  + toString

    ```java
    public String toString() {		// Object类中toString方法的源码定义
    	return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }	//在Object中会返回一个字符串，对象+@+对象地址
    ```

    ```java
    //而由于打印出的地址对开发人员意义不大，所以通常会在每个类中重写该方法，
    //为外界提供该对象的属性值
    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
    ```

    ```java
    //直接输出一个对象，会默认调用该对象的toString方法
    ```

  + equals

    ```java
    //Object会直接比较两个对象的地址值，相同返回true，否则返回false
    public boolean equals(Object obj) {		// Object类中的equals方法的源码
        return (this == obj);
    }
    ```

    ```java
    //同理，比较两个对象的地址值是否一样，对开发人员意义不大，可以重写该方法
    @Override
    //该类为Student
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);	// 比较的是对象的name属性值和age属性值
    }
    ```

  + clone

    https://www.cnblogs.com/p201821460026/p/16732070.html

    > + 浅克隆会把引用数据类型的变量地址直接拷贝，相当于两个对象的成员变量共用同一块内存
    >
    >   <div style="text-align:center">
    >       <img src="images\浅克隆.png" alt="克隆">
    >   </div>
    >
    > + 深克隆会新建一个该引用数据类型变量，将源对象的该成员变量的数值复制过去
    >
    >   <div style="text-align:center">
    >       <img src="images\深克隆.png" alt="克隆">
    >   </div>

  ```java
  public class ObjectDemo4 {
      public static void main(String[] args) throws CloneNotSupportedException {
          // protected object clone(int a) 对象克隆 
  
          //1.先创建一个对象
          int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
          User u1 = new User(1, "zhangsan", "1234qwer", "girl11", data);
  
          //2.克隆对象
          //细节:
          //方法在底层会帮我们创建一个对象,并把原对象中的数据拷贝过去。
          //书写细节:
          //1.重写Object中的clone方法
          //2.让javabean类实现Cloneable接口
          //3.创建原对象并调用clone就可以了
          //User u2 =(User)u1.clone();
  
          //验证一件事情：Object中的克隆是浅克隆
          //想要进行深克隆，就需要重写clone方法并修改里面的方法体
          //int[] arr = u1.getData();
          //arr[0] = 100;
  
          //以后一般会用第三方工具进行克隆
          //1.第三方写的代码导入到项目中
          //2.编写代码
          //Gson gson =new Gson();
          //把对象变成一个字符串
          //String s=gson.toJson(u1);
          //再把字符串变回对象就可以了
          //User user =gson.fromJson(s, User.class);
  
          //int[] arr=u1.getData();
          //arr[0] = 100;
  
          //打印对象
          //System.out.println(user);
  
      }
  }
  
  //Cloneable
  //如果一个接口里面没有抽象方法
  //表示当前的接口是一个标记性接口
  //现在Cloneable表示一旦实现了，那么当前类的对象就可以被克降
  //如果没有实现，当前类的对象就不能克隆
  public class User implements Cloneable {
      private int id;
      private String username;
      private String password;
      private String path;
      private int[] data;
  
      public User() {
      }
  
      public User(int id, String username, String password, String path, int[] data) {
          this.id = id;
          this.username = username;
          this.password = password;
          this.path = path;
          this.data = data;
      }
  
  
      public String toString() {
          return "角色编号为：" + id + "，用户名为：" + username + "密码为：" + password + ", 游戏图片为:" + path + ", 进度:" + arrToString();
      }
  
      public String arrToString() {
          StringJoiner sj = new StringJoiner(", ", "[", "]");
  
          for (int i = 0; i < data.length; i++) {
              sj.add(data[i] + "");
          }
          return sj.toString();
      }
  
      @Override
      protected Object clone() throws CloneNotSupportedException {
          //调用父类中的clone方法
          //相当于让Java帮我们克隆一个对象，并把克隆之后的对象返回出去。
  
          //先把被克隆对象中的数组获取出来
          int[] data = this.data;
          //创建新的数组
          int[] newData =new int[data.length];
          //拷贝数组中的数据
          for (int i = 0; i < data.length; i++) {
              newData[i] = data[i];
          }
          //调用父类中的方法克隆对象
              User u=(User)super.clone();
          //因为父类中的克隆方法是浅克隆，替换克隆出来对象中的数组地址值
          u.data =newData;
          return u;
      }
  }
  
  ```



#### 5. BigInteger

+ 构造方法

  ```java
  public BigInteger(int num, Random rnd) 		//获取随机大整数，范围：[0 ~ 2的num次方-1]
  public BigInteger(String val) 				//获取指定的大整数
  public BigInteger(String val, int radix) 	//获取指定进制的大整数
      
  //下面这个不是构造，而是一个静态方法获取BigInteger对象
  public static BigInteger valueOf(long val) 	//静态方法获取BigInteger的对象，内部有优化
  ```

+ 小结

  + 如果BigInteger表示的数字没有超出long的范围，可以用静态方法获取。
  + 如果BigInteger表示的超出long的范围，可以用构造方法获取。
  + 对象一旦创建，BigInteger内部记录的值不能发生改变。
  + 只要进行计算都会产生一个新的BigInteger对象

+ 成员方法

  ```java
  public BigInteger add(BigInteger val)					//加法
  public BigInteger subtract(BigInteger val)				//减法
  public BigInteger multiply(BigInteger val)				//乘法
  public BigInteger divide(BigInteger val)				//除法
  public BigInteger[] divideAndRemainder(BigInteger val)	 //除法，获取商和余数
  public  boolean equals(Object x) 					    //比较是否相同
  public  BigInteger pow(int exponent) 					//次幂、次方
  public  BigInteger max/min(BigInteger val) 				//返回较大值/较小值
  public  int intValue(BigInteger val) 					//转为int类型整数，超出范围数据有误
  ```

+ 底层存储方式

  在计算机中，所有的数据都是以一串串的 0 和 1 表示，数据类型是由编程语言决定的。

  `BigInteger` 存储数据的原理如下：

  以数字 `27679116119564327424` 为例

  1. 将传入的数字使用二进制补码表示；

     本例，转换后得到 `1_100000000000000000000000000000000000_000000000000000000000000000000000000`；

  2. 将该补码以 32 位（`int`表示范围）为一组，拆开后各自转成十进制；

     转换后得到数组 `1, -2147483648, 0`；

  3. 将数组保存在成员数组 `mag` 中，并用 `int signum` 记录数字符号；

     注：`signum == -1` 为负数，`signum == 0` 为零，`signum == 1` 为正数。

  而数组的最大长度为 `int` 上限（约为 21 亿），数组元素都为 `int`，每一个元素能表示的数字约为 42 亿个，则 `BigInteger` 所能存储的理论最大数字约为 (4.2×108)2.1×108(4.2×108)2.1×108 。因此可认为，`BigInteger` 所能表示的最大数接近无限。

  <div style="text-align:center">
      <img src="images\bigInteger的底层原理.png" alt="克隆">
  </div>

#### 6. BigDecima

+ why？

  可以看出，小数由于存储的原因，在计算中会出现精度丢失的情况。

  <div style="text-align:center">
      <img src="images\小数.png" alt="小数">
  </div>

+ 构造方法

  ```java
  public BigDecima(double val) 		//使用一个double的小数获取BigDecima对象
  public BigDecima(String val) 		//获取指定的小数
      
  //下面这个不是构造，而是一个静态方法获取BigDecima对象
  public static BigDecima valueOf(double val) 	//静态方法获取BigDecima的对象，内部有优化
  ```

  + note
    1. 如果要表示的数字不大，没有超过double的取值范围，建议使用静态方法
    2. 如果要表示的数字比较大，超出了double的取值范围，建议使用构造方法
    3. 如果传递的是0-10之间的**整数**，那么方法会返回已经创建好的对象，不会重新new

+ 成员方法

    BigDecimal对象不可变，运算之后会产生一个新的  BigDecimal对象

  + note

    使用除法的时候，如果除不尽，使用`public BigDeciaml divide(BigDeciaml val)`会报错；此时要使用`public BigDeciaml divide(BigDeciaml val， 精确几位， 舍入模式)`。

  <div style="text-align:center">
      <img src="images\BigDecimal方法.png" alt="小数">
  </div>

+ 存储方式

  把数据看成字符串，遍历得到里面的每一个字符，把这些字符在ASCII码表上的值，都存储到数组中。

  <div style="text-align:center">
      <img src="images\bigDecimal的底层原理.png" alt="小数">
  </div>
  
  

#### 8. 正则表达式

+ 作用：

  ​        正则表达式可以校验字符串是否满足一定的规则，并用来校验数据格式的合法性；

  ​		在一段文本中查找满足要求的内容

+ 字符类  只匹配一个字符

  1. \[abc\]：代表a或者b，或者c字符中的一个。
  2. \[^abc\]：代表除a,b,c以外的任何字符。
  3. [a-z]：代表a-z的所有小写字符中的一个。
  4. [A-Z]：代表A-Z的所有大写字符中的一个。
  5. [0-9]：代表0-9之间的某一个数字字符。
  6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
  7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。 

+ 逻辑运算符

  1. &&：并且

  2. |    ：或者

  3. \  ：转义字符 

     ```java
     [a-z&&[^bc]] == [ad-z]
     ```

+ 预定义字符  只匹配一个字符

  1. "." ： 匹配任何字符。
  2. "\d"：任何数字[0-9]的简写；
  3. "\D"：任何非数字\[^0-9\]的简写；
  4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
  5. "\S"： 非空白字符：\[^\s\] 的简写
  6. "\w"：单词字符：[a-zA-Z_0-9]的简写
  7. "\W"：非单词字符：\[^\w\]

+ 数量词

  1. X? : 0次或1次
  2. X* : 0次到多次
  3. X+ : 1次或多次
  4. X{n} : 恰好n次
  5. X{n,} : 至少n次
  6. X{n,m}: n到m次(n和m都是包含的)

+ 分组

  <div style="text-align:center">
      <img src="images\分组.png" alt="分组">
  </div>

  ```java
  regex = "[1-9]\\d{16}(\\d|(?i)x)"
  其中(\\d|(?i)x)称为一个组；每个组是有组号的，也就是序号
      从1开始，连续不间断
      以左括号为基准，最左边的是第一组，其次为第二组，以此类推
      	如"(\\W+(\\d+))(\\D+)"就有三个组
      	第一组为"(\\W+(\\d+))"，第二组为"(\\d+)"，第三组为"(\\D+)" 
  ```

  **\\\组号:表示把第X组的内容拿出来用一次（正则表达式内部）**

  ```java
  //需求1:判断一个字符串的开始字符和结束字符是否一致?只考虑一个字符
  //举例: a123a b456b 17891 &abc& a123b(false)
  // \\组号:表示把第X组的内容再出来用一次
  String regex1 = "(.).+\\1";
  System.out.println("a123a".matches(regex1));
  System.out.println("b456b".matches(regex1));
  System.out.println("--------------------------");
  
  //需求2:判断一个字符串的开始部分和结束部分是否一致?可以有多个字符
  //举例: abc123abc b456b 123789123 &!@abc&!@ abc123abd(false)
  String regex2 = "(.+).+\\1";
  System.out.println("abc123abc".matches(regex2));
  System.out.println("b456b".matches(regex2));
  System.out.println("---------------------");
   
  //需求3:判断一个字符串的开始部分和结束部分是否一致?开始部分内部每个字符也需要一致
  //举例: aaa123aaa bbb456bbb 111789111 &&abc&&
  //(.):把首字母看做一组
  // \\2:把首字母拿出来再次使用
  // *:作用于\\2,表示后面重复的内容出现日次或多次
  String regex3 = "((.)\\2*).+\\1";
  System.out.println("aaa123aaa".matches(regex3));
  System.out.println("bbb456bbb".matches(regex3));
  ```

  **$组号:表示把第X组的内容拿出来用一次（正则表达式外部）**

  ```java
  // 特点：不占用组号
  // 如这种情况会报错，因为?:属于非捕获分组，不占用组号；\\1由于识别不到第一组，就会报错
  String regex1 ="[1-9]\\d{16}(?:\\d|x|x)\\1"	
  ```

  ```java
  String str = "我要学学编编编编程程程程程程";
  //需求:把重复的内容 替换为 单个的
  //学学                学
  //编编编编            编
  //程程程程程程        程
  //  (.)表示把重复内容的第一个字符看做一组
  //  \\1表示第一字符再次出现
  //  + 至少一次
  //  $1 表示把正则表达式中第一组的内容，再拿出来用
  String result = str.replaceAll("(.)\\1+", "$1");
  System.out.println(result);
  ```

#### 9. 爬虫

```java
public class RegexDemo9 {
    public static void main(String[] args) {
        /*
            有如下文本，按要求爬取数据。
                Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，
                因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台
            需求1:爬取版本号为8，11.17的Java文本，但是只要Java，不显示版本号。
            需求2:爬取版本号为8，11，17的Java文本。正确爬取结果为:Java8 Java11 Java17 Java17
            需求3:爬取除了版本号为8，11.17的Java文本，
        */
        String s = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
            "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        //1.定义正则表达式
        //?理解为前面的数据Java
        //=表示在Java后面要跟随的数据
        //但是在获取的时候，只获取前半部分
        //需求1:
        //?理解为前面的数据Java，=表示Java后面要跟随的数据，但是在获取的时候，只获取前半部分
        String regex1 = "((?i)Java)(?=8|11|17)";
        //需求2:
        String regex2 = "((?i)Java)(8|11|17)";
        //这种方法类似于需求1的写法，不过获取的是全部
        String regex3 = "((?i)Java)(?:8|11|17)";
        //需求3:
        String regex4 = "((?i)Java)(?!8|11|17)";
        
		//使用静态方法获取正则表达式对象
        Pattern p = Pattern.compile(regex4);
        //获取文本匹配器的对象，拿着m去读取大串s，找到符合p规则的字串
        Matcher m = p.matcher(s);
        while (m.find()) {  
            //find方法会记录满足规则子串的开始索引和结束索引+1
            //group方法根据底层记录的索引去截取对应的小串
            System.out.println(m.group());
        }
    }
}
```

+ 贪婪爬取（默认）

  在爬取数据的时候尽可能的多获取数据

+ 非贪婪爬取   +?  *?

  在爬取数据的时候尽可能的少获取数据

  ```java
  str = "abbbbbbbbbbbbaaaaaaaaaaaaaaaaaa"
  ab+:
          贪婪爬取:abbbbbbbbbbbb
          非贪婪爬取:ab
  ```

+ 正则表达式在字符串中的使用

  ```java
  //参数regex表示正则表达式。可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
  public String[] split(String regex)
  //参数regex表示一个正则表达式。可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。 
  public String replaceAll(String regex,String newStr)
  
  String s = "小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠";
  //细节:
  //方法在底层跟之前一样也会创建文本解析器的对象
  //然后从头开始去读取字符串中的内容，只要有满足的，那么就切割。
  String[] arr = s.split("[\\w&&[^_]]+");
  for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
  }
  
  //细节:
  //方法在底层跟之前一样也会创建文本解析器的对象
  //然后从头开始去读取字符串中的内容，只要有满足的，那么就用第一个参数去替换。
  String result1 = s.replaceAll("[\\w&&[^_]]+", "vs");
  System.out.println(result1);
  ```

  
