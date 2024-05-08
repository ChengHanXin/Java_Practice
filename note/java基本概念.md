### Java基本概念

#### 一、特点

1. **面向对象**

   面向过程：C；

   面向对象：C++，Java；

2. **是一门静态语言**

   在编译期间就能够知道数据类型的语言，在运行前就能够检查类型的正确性，一旦类型确定后就不能再更改，如C/C++，Java，C#等。

   相对应的动态语言在编写时不需要指定变量的类型，在运行时确定数据类型，如Python，JavaScript等。

​		因此来说，静态语言的执行效率高于动态语言。

3. **平台独立性和可移植性**

   高级语言的编译运行方式：

   > + 编程：java编写.java代码；c编写.c代码；python编写.py代码
   > + 编译：将.java，.c，.py的代码转换成机器认识的过程
   > + 运行：让机器执行编译后的指令

   高级语言的编译运行方式：

   + 编译型：不同的平台有不同的编译器，不同的操作系统、不同的硬件都需要重新编译。

     <div style="text-align:center">
         <img src="images\编译型.png" alt="编译型">
     </div>

   + 解释型：不整体翻译，在运行过程中按行翻译。

     <div style="text-align:center">
         <img src="images\解释型.png" alt="解释型">
     </div>

   + 混合型：先整体编译，然后在不同的平台上按行运行。

   <div style="text-align:center">
       <img src="images\混合型.png" alt="混合型">
   </div>

​	**跨平台原理：**

1. **字节码：** Java 源代码经过编译器编译后生成字节码（Bytecode），而不是特定于某种硬件平台或操作系统的机器码。字节码是一种中间代码，它与特定平台无关，可以在任何安装了 Java 虚拟机的平台上运行。
2. **Java 虚拟机（JVM）：** Java 虚拟机是 Java 的核心组成部分，它负责在特定平台上加载和执行字节码。JVM 将字节码解释成特定平台的机器码，并在运行时管理内存、处理异常、进行垃圾回收等。由于 Java 虚拟机存在于不同的操作系统上，因此只需编写一次字节码，就可以在任何支持 Java 的平台上运行。

<div style="text-align:center">
    <img src="images\跨平台原理.png" alt="跨平台">
</div>

#### 二、JDK和JRE

<div style="text-align:center">
    <img src="images\JDK_JRE.png" alt="跨平台">
</div>

​	JVM（Java Virtual Machine），Java虚拟机

​	核心类库：Java已经写好的东西，如system等等

​	开发工具：javac，java，jdb，jhat等等

​	JRE（Java Runtime Environment），Java运行环境，包含了JVM和Java的核心类库和运行工具（java）

​	JDK（Java Development Kit）称为Java开发工具，包含了JRE和开发工具

​	总结：JDK包含JRE，JRE包含JVM

