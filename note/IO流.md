### IO

+ 概念

  在File中，它可以表示系统中的文件或者文件夹的路径，但是不能读写文件里面存储的数据；

  IO流可以用于读写文件中的数据

+ 分类

  根据数据的流向分为：**输入流**和**输出流**。

  * **输入流** ：把数据从`其他设备`上读取到`内存`中的流。 
  * **输出流** ：把数据从`内存` 中写出到`其他设备`上的流。

  格局数据的类型分为：**字节流**和**字符流**。

  * **字节流** ：以字节为单位，读写数据的流，可以操作所有类型的文件
  * **字符流** ：以字符为单位，读写数据的流，只能处理纯文本文件（记事本能打开，且不乱码）

  

### 一、字节流

#### 1. 字节输出流  OutputStream

+ 作用

  操作本地文件的字节输出流，可以把程序中的数据写到本地文件中

+ 操作步骤

  + 创建字节输出流对象
  + 写数据
  + 释放资源

+ 构造方法
  * `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
  * `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。 
  * 当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文件，会**清空**这个文件的数据。
  * 构造方法的第二个参数为一个boolean，**false表示关闭续写，true表示追加写**

+ 写出字节数据

  + 写出字节：`write(int b)` 方法，每次可以写出一个字节数据

  + 写出字节数组：`write(byte[] b)`，每次可以写出数组中的数据

  + 写出指定长度的字节数组：`write(byte[] b, int off, int len)` ，每次写出从off索引开始，len个字节

  + 换行写

    Windows系统里，换行符号是`\r\n`

    Linux系统里，换行符号是`\n`

    Mac系统里，换行符号是`\r`
  
+ 演示

  ```java
  // 使用文件名称创建流对象
  FileOutputStream fos = new FileOutputStream("fos.txt");     
  // 字符串转换为字节数组
  byte[] b = "abcde".getBytes();
  // 使用字节数组写入文件
  fos.write(b);
  // 关闭资源
  fos.close();
  ```

#### 2. 字节输入流  InputStream

+ 作用

  操作本地文件的字节输入流，可以把本地文件中的数据读取到程序中

+ 操作步骤

  + 创建字节输入流对象

    * `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
    * `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  
    * 如果文件不存在，程序直接报错

  + 读数据

    + `read`方法，每次可以读取一个字节的数据，**提升为int类型**，读取到文件末尾，返回`-1`

    + `read(byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的**有效字节个数**，读取到末尾时，返回`-1`；**返回值为本次读到了多少个字节数据**

    + 一次读取一个字节，读出来的是数据在ASCII上对应的数据
    + 读到文件末尾了，read方法返回-1

  + 释放资源

+ 循环读取

  ```java
  // 使用文件名称创建流对象
  FileInputStream fis = new FileInputStream("read.txt");
  // 定义变量，保存数据
  int b ；
  // 循环读取
  // (b = fis.read()) 在while判断中使用一个变量接收，然后在循环体中使用这个变量
  // 如果不这样做，在判断时调用一次read方法；在使用时，再调用一次read方法，会导致读取错误
  // 因为，read方法每次会返回当前指向的数据，并将指针后移一位
  while ((b = fis.read())!=-1) {
      System.out.println((char)b);
  }
  // 关闭资源
  fis.close();
  ```

+ 文件拷贝

  ```java
  // 1.创建流对象
  // 1.1 指定数据源
  FileInputStream fis = new FileInputStream("D:\\test.jpg");
  // 1.2 指定目的地
  FileOutputStream fos = new FileOutputStream("test_copy.jpg");
  
  // 2.读写数据
  // 2.1 定义数组
  byte[] b = new byte[1024];
  // 2.2 定义长度
  int len;
  // 2.3 循环读取
  while ((len = fis.read(b))!=-1) {
      // 2.4 写出数据  (b, 0, len)读多少，写多少，因为最后一次可能装不满字节数组
      fos.write(b, 0 , len);
  }
  
  // 3.关闭资源
  fos.close();
  fis.close();
  ```

  

#### 编码

+ GBK编码规则

  + 英文编码规则

  <div style="text-align:center">
      <img src="images\GBK_En.png" alt="编码">
  </div>

  + 中文编码规则

    + 为了区分开中英文，汉字编码使用1开头，英文编码使用0开头

    <div style="text-align:center">
        <img src="images\GBK_Ch.png" alt="编码">
    </div>

+ Unicode编码规则

  + 英文使用一个字节存储；中文使用三个字节存储
  + UTF-8是Unicode字符集的一种编码方式

  <div style="text-align:center">
      <img src="images\Unicode.png" alt="编码">
  </div>

+ 乱码出现的原因

  + 读取数据时没有读完整个汉字

    此时，由于汉字占三个字节，而一次又只读了一个字节就行了解码，导致乱码出现

    <div style="text-align:center">
        <img src="images\乱码-1.png" alt="编码">
    </div>

  + 编码和解码时的方式不统一

    + 正常过程

    <div style="text-align:center">
        <img src="images\乱码-21.png" alt="编码">
    </div>

    + 编码、解码规则不统一导致乱码

      <div style="text-align:center">
          <img src="images\乱码-22.png" alt="编码">
      </div>

+ 防止乱码出现

  + 不适用字节流去读取文本文件

  + 编码和解码时使用同一个码表，同一个编码方式

    

#### 编解码方式

+ Java编解码

  <div style="text-align:center">
      <img src="images\编解码.png" alt="编码">
  </div>

### 二、字符流

+ 原理

  字符流  =  字节流  +  字符集

+ 特点

  + 输入流`Reader`：一次读一个字节，遇到中文时，**一次读多个字节**

  + 输出流`Write`：底层把数据按照指定的编码方式进行编码，变成字节再写到文件中
  + 只能处理纯文本文件

  

#### 2.1 FileReader

+ 使用步骤

  + 创建字符输入流对象

    - `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象。   
    - `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称。 

  + 读取数据

    + `read`方法，每次可以读取一个字符的数据，**提升为int类型**，读取到文件末尾，返回`-1`，循环读取

      按字节进行读取，遇到中文，一次读多个字节，读取后解码，返回一个整数 、

      

    + `read(char[] cbuf)`，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回`-1`

      相当于空参的read方法  +  强制类型转换

    ```java
    // 使用文件名称创建流对象
    FileReader fr = new FileReader("read.txt");
    // 定义变量，保存有效字符个数
    int len ；
    // 定义字符数组，作为装字符数据的容器
    char[] cbuf = new char[2];
    // 循环读取
    while ((len = fr.read(cbuf))!=-1) {
        System.out.println(new String(cbuf));
    }
    // 关闭资源
    fr.close();
    ```

  + 释放资源 

#### 2.2 FileWrite

+ 构造方法

  <div style="text-align:center">
      <img src="images\FileWrite构造方法.png" alt="编码">
  </div>

+ 成员方法

  <div style="text-align:center">
      <img src="images\FileWrite成员方法.png" alt="编码">
  </div>

#### 2.3 字符流原理解析

+ 创建字符输入流对象

  底层：关联文件，并创建缓冲区（长度为8192的**字节数组**）

+ 读取数据

  + 判断缓冲区中是否有数据可以读取

  + 缓冲区中没有数据：就从文件中获取数据，装到缓冲区，每次尽可能装满缓冲区

    如果文件中没有数据了，就返回-1

  + 缓冲区中有数据：就从缓冲区中读取

    空参的read方法：一次读取一个字节，遇到中文一次读多个字节，把字节解码并转成十进制返回

    有参的read方法：把读取字节，解码，强转三步合并了，强转之后的字符放到数组中



### 三、其他流

#### 1. 缓冲流

+ 分类

  <div style="text-align:center">
      <img src="images\缓冲流分类.png" alt="编码">
  </div>

#### 1.1 字节缓冲流

+ 原理：底层自带了长度为**8192字节数组**的缓冲区提高性能

+ 构造方法

  + 将基本流包装成高级流，提高读取数据的性能

  * `public BufferedInputStream(InputStream in)` ：创建一个 新的缓冲输入流。 
  * `public BufferedOutputStream(OutputStream out)`： 创建一个新的缓冲输出流。

#### 1.2 字符缓冲流

+ 原理：底层自带了长度为**8192字符数组**的缓冲区提高性能

+ 对于字符流提升不明显，因为原来的字符流中带有缓冲区

+ 构造方法

  * `public BufferedReader(Reader in)` ：创建一个 新的缓冲输入流。 
  * `public BufferedWriter(Writer out)`： 创建一个新的缓冲输出流。

+ 特有方法

  * BufferedReader：`public String readLine()`: 读一行文字，遇到回车换行结束；

    如果没有数据可读，返回null。 

  * BufferedWriter：`public void newLine()`: 写一行行分隔符，由系统属性定义符号，跨平台的换行。 

#### 2. 转换流

+ 作用：字符流和字节流之间的桥梁

#### 2.1 InputStreamReader类  

转换流`java.io.InputStreamReader`，是Reader的子类，是从字节流到字符流的桥梁。它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。 

* `InputStreamReader(InputStream in)`: 创建一个使用默认字符集的字符流。 
* `InputStreamReader(InputStream in, String charsetName)`: 创建一个指定字符集的字符流。

构造举例，代码如下： 

```java
InputStreamReader isr = new InputStreamReader(new FileInputStream("in.txt"));
InputStreamReader isr2 = new InputStreamReader(new FileInputStream("in.txt") , "GBK");
```

#### 2.2 OutputStreamWriter类  

  转换流`java.io.OutputStreamWriter` ，是Writer的子类，是从字符流到字节流的桥梁。使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。 

   构造方法

  - `OutputStreamWriter(OutputStream in)`: 创建一个使用默认字符集的字符流。 
  - `OutputStreamWriter(OutputStream in, String charsetName)`: 创建一个指定字符集的字符流。

  构造举例，代码如下： 

  ```java
  OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream("out.txt"));
  OutputStreamWriter isr2 = new OutputStreamWriter(new FileOutputStream("out.txt") , "GBK");
  ```

   指定编码写出

  ```java
  public class OutputDemo {
      public static void main(String[] args) throws IOException {
        	// 定义文件路径
          String FileName = "E:\\out.txt";
        	// 创建流对象,默认UTF8编码
          OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
          // 写出数据
        	osw.write("你好"); // 保存为6个字节
          osw.close();
        	
  		// 定义文件路径
  		String FileName2 = "E:\\out2.txt";
       	// 创建流对象,指定GBK编码
          OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream(FileName2),"GBK");
          // 写出数据
        	osw2.write("你好");// 保存为4个字节
          osw2.close();
      }
  }
  ```

#### 3. 序列化流

Java 提供了一种对象**序列化**的机制。用一个字节序列可以表示一个对象，该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。 

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。`对象的数据`、`对象的类型`和`对象中存储的数据`信息，都可以用来在内存中创建对象。

#### 3.1 ObjectOutputStream类

`java.io.ObjectOutputStream ` 类，将Java对象的原始数据类型写出到文件,实现对象的持久存储。

##### 构造方法

* `public ObjectOutputStream(OutputStream out) `： 创建一个指定OutputStream的ObjectOutputStream。

构造举例，代码如下：  

```java
FileOutputStream fileOut = new FileOutputStream("employee.txt");
ObjectOutputStream out = new ObjectOutputStream(fileOut);
```

##### 序列化操作

1. 一个对象要想序列化，必须满足两个条件:

* 该类必须实现`java.io.Serializable ` 接口，`Serializable` 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出`NotSerializableException` 。
* 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用`transient` 关键字修饰。

```java
public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
      	System.out.println("Address  check : " + name + " -- " + address);
    }
}
```

2.写出对象方法

* `public final void writeObject (Object obj)` : 将指定的对象写出。

```java
public class SerializeDemo{
   	public static void main(String [] args)   {
    	Employee e = new Employee();
    	e.name = "zhangsan";
    	e.address = "beiqinglu";
    	e.age = 20; 
    	try {
      		// 创建序列化流对象
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.txt"));
        	// 写出对象
        	out.writeObject(e);
        	// 释放资源
        	out.close();
        	fileOut.close();
        	System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列化。
        } catch(IOException i)   {
            i.printStackTrace();
        }
   	}
}
输出结果：
Serialized data is saved
```

#### 3.2 ObjectInputStream类

ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。 

##### 构造方法

* `public ObjectInputStream(InputStream in) `： 创建一个指定InputStream的ObjectInputStream。

##### 反序列化操作1

如果能找到一个对象的class文件，我们可以进行反序列化操作，调用`ObjectInputStream`读取对象的方法：

- `public final Object readObject ()` : 读取一个对象。

```java
public class DeserializeDemo {
   public static void main(String [] args)   {
        Employee e = null;
        try {		
             // 创建反序列化流
             FileInputStream fileIn = new FileInputStream("employee.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn);
             // 读取一个对象
             e = (Employee) in.readObject();
             // 释放资源
             in.close();
             fileIn.close();
        }catch(IOException i) {
             // 捕获其他异常
             i.printStackTrace();
             return;
        }catch(ClassNotFoundException c)  {
        	// 捕获类找不到异常
             System.out.println("Employee class not found");
             c.printStackTrace();
             return;
        }
        // 无异常,直接打印输出
        System.out.println("Name: " + e.name);	// zhangsan
        System.out.println("Address: " + e.address); // beiqinglu
        System.out.println("age: " + e.age); // 0
    }
}
```

**对于JVM可以反序列化对象，它必须是能够找到class文件的类。如果找不到该类的class文件，则抛出一个 `ClassNotFoundException` 异常。**  





#### 4. 打印流

