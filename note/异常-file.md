### 异常

+ 分类
  + Error：代表系统级别的错误，是给sun公司使用的，开发人员不用管他
  + Exception：叫做异常，代表程序可能出现的问题
    + RuntimeException及其子类：**运行时异常**，编译阶段不会出现异常提醒（如数组索引越界异常）
    + 其他异常：**编译时异常**，编译阶段就会出现异常提醒（如日期解析异常）

<div style="text-align:center">
    <img src="images\异常分类.png" alt="Arrays">
</div>

+ 作用

  + 用来查询bug的关键参考信息
  + 可以作为方法内部的一种特殊返回值，以便通知调用者底层的执行情况

+ 异常处理方式

  + JVM默认的处理方式

    + 把异常的名称，异常原因及异常出现的位置等信息输出在控制台
    + 程序停止执行，下面的代码不再执行 

  + 自己处理（捕获异常）

    + 格式

       ```java
       try{
           可能出现异常的代码;
       }catch(异常类名 变量名){
           异常处理代码;
       }finally{
           不管是否有异常，这里面的代码都会被执行，除非jvm退出
           // 如就可以把文件操作中的关闭操作放在这里
       }
       ```

    + 目的：当代码出现异常时，可以让程序继续往下执行 

    + 举例

      ```java
      int[] arr = {1, 2, 3, 4, 5};
      
      try{
          // 出现何种异常，程序就会在这里创建一个相应的异常对象 new ArrayIndexOutOfBoundsException()； 
          //拿着这个对象与catch中的对象比较，看括号中的变量是否可以接收这个对象；
          //如果能被接收，表示该异常被捕获，执行catch中相应的代码
          //当catch中的代码执行完毕，继续执行try...catch...下面的代码 
          System.out.println(arr[6]);
      } catch(ArrayIndexOutOfBoundsException e){
          System.out.println(e);
      }
      
      System.out.println("我执行了哦");
      ```

    + 灵魂四问

      1. 如果try中没有遇到问题，代码怎么执行？

         会把try中所有的代码执行完毕，不会执行catch中的代码

      2. 如果try中可能遇到多个问题，怎么执行？

         会写多个catch与之对应

         ```java
         try{
             System.out.println(arr[6]);
             System.out.println(10/0);
         } catch(ArrayIndexOutOfBoundsException e){
             System.out.println("数组越界");
         } catch (ArithmeticException e){
             sout("除数不能为0")
         }...
         ```

         如果我们要捕获的多个异常，存在父子关系，那么**父类一定要写在后面**

         这是因为，在捕获异常时，是从上到下依次去匹配catch中的异常。如果父类写在上面，那么其子类对应的异常就会直接被父类异常所捕获，我们对其针对设计的异常处理方法就不会执行。

      3. 如果try中的问题没有被捕获，怎么执行？

         此时，catch没有捕获到异常，最终会交给虚拟机进行处理

      4. 如果try中遇到了问题，那么try下面的代码还会执行吗？

         不会

         ```java
         int[] arr = {1, 2, 3, 4, 5};
         // try中异常第一次被捕获后，其后续的代码不会执行，会直接跳转到对应的catch中，执行代码，然后执行try...catch后面的代码
         try{
             System.out.println(arr[6]);
             System.out.println(10.0/0);  // 不会执行
         } catch(ArrayIndexOutOfBoundsException e){
             System.out.println(e);
         } catch(ArithmeticException e){  // 不会执行
             System.out.println(e);
         }
         
         System.out.println("我执行了哦");
         ```

  + 抛出处理

    <div style="text-align:center">
        <img src="images\异常抛出处理.png" alt="异常">
    </div>

    ```java
    int[] arr = {};
    int max = 0;
    try {
        max = getMax(arr);
    } catch (NullPointerException e) {
        e.printStackTrace();
    } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
    }
    System.out.println(max);
    System.out.println("代码还可以执行");
    
    }
    
    public static int getMax(int[] arr) throws NullPointerException, ArrayIndexOutOfBoundsException {
        //        if (arr == null){
        //            throw new NullPointerException("arr is null");
        //        }
        //        if (arr.length == 0){
        //            throw new ArrayIndexOutOfBoundsException("arr is empty");
        //        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    ```

+ 异常中的常见方法

  Throwable的成员方法

  * `public String getMessage()`:获取异常的描述信息；
  * `public String toString()`:获取异常的类型和异常描述信息(不用)；
    * `public void printStackTrace()`:打印异常的跟踪栈信息并输出到控制台；


  * 自定义异常

+ + 意义：为了让控制台的报错信息更加见名知意

  + 构建步骤：

    + 定义异常类

    + 写继承关系

    + 空参构造

    + 带参构造



  ### File

+ 概念

  File对象表示一个路径，可以是文件路径，也可以是文件夹路径

  这个路径可以是存在的，也允许不存在

+ 构造方法

  - `public File(String pathname) ` ：通过将给定的**路径名字符串**转换为抽象路径名来创建新的 File实例。  
  - `public File(String parent, String child) ` ：从**父路径名字符串和子路径名字符串**创建新的 File实例。
  - `public File(File parent, String child)` ：从**父路径对应文件对象和子路径名字符串**创建新的 File实例。  

+ 成员方法

  + 判断功能的方法
    - `public boolean exists()` ：此File表示的文件或目录是否实际存在。
    - `public boolean isDirectory()` ：此File表示的是否为目录。
    - `public boolean isFile()` ：此File表示的是否为文件。

  + 获取功能的方法

    - `public String getAbsolutePath() ` ：返回此File的绝对路径名字符串。

    - ` public String getPath() ` ：将此File转换为路径名字符串。 （返回定义文件时使用的路径）

    - `public String getName()`  ：返回由此File表示的文件（包含后缀）或目录的名称。  

    - `public long length()`  ：返回由此File表示的文件的长度（字节数量）。 

      该方法只能获取文件的大小，不能直接获取文件夹的大小

  + 创建删除功能的方法

    - `public boolean createNewFile()` ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。 
      + 如果当前路径表示的文件不存在，则创建成功，返回true；否则返回false
      + 如果父级路径不存在，方法出现IOException异常
      + 该方法创建的一定是文件，如果路径中不包含后缀名，则创建一个没有后缀的文件
    - `public boolean delete()` ：删除由此File表示的文件或目录。  
      + 如果删除的是文件，直接删除，不走回收站
      + 如果删除的是空文件夹，直接删除，不走回收站
      + 如果删除的是有内容的文件夹，则删除失败
    - `public boolean mkdir()` ：创建由此File表示的目录。
    - `public boolean mkdirs()` ：创建由此File表示的目录，包括任何必需但不存在的父目录。

  + 遍历

    - `public String[] list()` ：返回一个String数组，表示该File目录中的所有子文件或目录。

    - `public File[] listFiles()` ：返回一个File数组，表示该File目录中的所有的子文件或目录。  

      + 不会递归访问所有文件和文件夹，只会返回当前路径下的所有，不会进去再访问

      + 当调用者File表示的路径不存在时，返回null
      + 当调用者File表示的路径是文件时，返回null
      + 当调用者File表示的路径是一个空文件夹时，返回一个长度为0的数组
      + 当调用者File表示的路径是一个有内容的文件夹时，将里面所有文件和文件夹的路径放在File数组中返回
      + 当调用者File表示的路径是一个有隐藏文件的文件夹时，会包含隐藏文件返回
      + 当调用者File表示的路径需要权限才能访问时，返回null

      

  

  

