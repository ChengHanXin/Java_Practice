### Java常用API

#### 10. JDK7之前事件相关类

+ **Data	时间**

  + 时间相关知识

    + 世界标准时间：

      ​	原来为格林威治时间，简称GMT

      ​	目前世界标准时间（UTC）已经替换为：原子钟     由铯原子的震动频率计算得出

    + 中国标准时间

      中国处于东八区，其标准时间为世界标准时间+8小时

    + 时间单位换算

      1秒  =  1000毫秒		1毫秒  =  1000微秒		1微秒  =  1000纳秒

  + Data类

    是一个JDK写好的Javabean类，用来描述时间，精确到**毫秒**

    + 构造方法

      ```java
      // 1.空参构造
      public Date()		//表示系统当前时间
      // 2.有参构造
      public Date(long date)		//使用指定的毫秒值data，生成Data对象；表示自标准时间+data之后的时间
      ```

    + 常用方法

      ```JAVA
      // 将日期对象转换成对应时间的毫秒值
      public long getTime()
      // 把方法参数给定的毫秒值设置给日期对象
      public void setTime(long time)
      ```

+ **SimpleDateFormat    格式化时间**

  + 作用

    + 格式化：把时间变成我们喜欢的格式
    + 解析：把字符串表示的时间变成Date对象

  + 构造方法

    ```java
    // 空参构造
    public SimpleDateFormat()
    // 带参构造
    /* y--年  M--月  d--日  H--时  m--分  s--秒
    eg: pattern=yyyy年MM月dd日 HH:mm:ss*/
    public SimpleDateFormat(String pattern)		//使用pattern指定格式
    ```

  + 常用方法

    ```java
    // 格式化 （日期对象 -> 字符串）
    public final String format(Date date)
        
    // 解析  （字符串 -> 日期对象）
    public Date parse(String source)
    ```

  + 练习

    ```java
    public static void main(String[] args) throws ParseException {
        //1.利用空参构造创建simpleDateFormat对象，默认格式
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d1 = new Date(0L);
        String str1 = sdf1.format(d1);
        System.out.println(str1);//1970/1/1 上午8:00
        //2.利用带参构造创建simpleDateFormat对象，指定格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String str2 = sdf2.format(d1);
        System.out.println(str2);//1970年01月01日 08:00:00
    
        //1.定义一个字符串表示时间
        String str = "2023-11-11 11:11:11";
        //2.利用空参构造创建simpleDateFormat对象
        // 细节:
        //创建对象的格式要跟字符串的格式完全一致
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        //3.打印结果
        System.out.println(date.getTime());//1699672271000
    }
    ```

+ **Calendar    日历**

  + 作用

    Calendar代表了系统当前时间的日历对象，可以单独修改、获取时间中的年，月，日

    Calendar是一个抽象类，不能直接创建对象，使用一个静态方法来获取

    ```java
    public static Calendar getInstance()
    ```

  + 常用方法

    ```java
    public final Date getTime()		//获取日期对象
    public final setTime(Date date)		//给日历设置日期对象
    public long getTimeInMillis()		//拿到时间毫秒值
    public void setTimeInMillis(long millis)	//给日历设置时间毫秒值
    public int get(int field)		//取日历中的某个字段信息
    public void set(int field, int value)		//修改日历的某个字段信息
    public void add(int field, int amount)		//为某个字段增加/减少指定的值
    ```

#### 11. JDK8新增时间相关类

+ 出现原因

  + 在JDK7中，对时间进行比较，需要字符串-->Date-->getTime  使用毫秒值进行计算和比较。

    在JDK8中，提供了许多计算时间间隔的方法，比较相对简单

  + JDK7中，日期对象可变，在多线程环境中会导致数据安全问题

    JDK8中，日期对象不可变，解决了安全问题
  
+ 相关类
  
  <div style="text-align:center">
      <img src="images\JDK8时间类.png" alt="Math常用方法">
  </div>
  
  

#### 12 .包装类

+ 概念：基本数据类型对应的引用类型。**用一个对象，把基本数据类型给包起来**

  | 基本类型 | 对应的包装类（位于java.lang包中） |
  | -------- | --------------------------------- |
  | byte     | Byte                              |
  | short    | Short                             |
  | int      | **Integer**                       |
  | long     | Long                              |
  | float    | Float                             |
  | double   | Double                            |
  | char     | **Character**                     |
  | boolean  | Boolean                           |

+ Integer类

  | 方法名                                  | 说明                                   |
  | --------------------------------------- | -------------------------------------- |
  | public Integer(int   value)             | 根据 int 值创建 Integer 对象(过时)     |
  | public Integer(String s)                | 根据 String 值创建 Integer 对象(过时)  |
  | public static Integer valueOf(int i)    | 返回表示指定的 int 值的 Integer   实例 |
  | public static Integer valueOf(String s) | 返回保存指定String值的 Integer 对象    |
  | static string tobinarystring(int i)     | 得到二进制                             |
  | static string tooctalstring(int i)      | 得到八进制                             |
  | static string toHexstring(int i)        | 得到十六进制                           |
  | static int parseInt(string s)           | 将字符串类型的整数转成int类型的整数    |

  ```java
  //在使用valueOf方法得到Integer对象时，如果要创建的值在[-128, 127]之间，它会返回同一个对象，即调用n次，n个对象都指向同一块内存地址
  
  //在除了Character包装类外，其余其中都有其对应的parseXxx方法，进行类型转换
  int i = Integer.parseInt("123");
  System.out.println(i);	//123
  
  String str = "true";
  boolean b = Boolean.parseBoolean(str);
  System.out.println(b);	//true
  ```

+ 装箱与拆箱

  - **装箱**：从基本类型转换为对应的包装类对象。

    ```java
    Integer i = new Integer(4);//使用构造函数函数
    Integer iii = Integer.valueOf(4);//使用包装类中的valueOf方法
    ```

  - **拆箱**：从包装类对象转换为对应的基本类型。

    ```java
    int num = i.intValue();
    ```

  ​        由于我们经常要做基本类型与包装类之间的转换，从Java 5（JDK 1.5）开始，基本类型与包装类的装箱、拆箱动作可以自动完成。例如：

      ```java
      Integer i = 4;//自动装箱。相当于Integer i = Integer.valueOf(4);
      i = i + 5;//等号右边：将i对象转成基本数值(自动拆箱) i.intValue() + 5;
      //加法运算完成后，再次装箱，把基本数值转成对象。
      ```

+ note

  ```java
  //键盘输入改进
  /*之前使用next、nextInt、nextDouble接收数据时，遇到空格、回车、制表符的时候就停止了*/
  /*之后约定使用nextLine来接收一整行数据，遇到回车才结束*/
  String line = new Scanner(System.in).nextLine();
  //假如要接收一个整数
  int i = Integer.parseInt(line);
  ```

  