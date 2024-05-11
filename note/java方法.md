### Java方法

#### 一、方法的概念

​	方法是程序中最小的执行单元。

+ 注意：
  + 方法必须先创建才可以使用，该过程称为方法定义
  + 方法创建后并不是可以直接运行，需要手动调用

#### 二、方法的定义和使用

1. 定义格式

   ```java
   public static 返回值类型 方法名(参数1, 参数2,...){
       方法体;
       return 数据;
   }
   ```

   + public static		修饰符
   + 返回值类型          方法操作完成之后返回数据的数据类型
   + 方法名                  调用方法时使用的标识
   + 参数                      由数据类型和变量名组成，多个参数之间使用逗号隔开
   + 方法体                  完成功能的代码块
   + return                  如果方法操作完成，有数据返回，用于把数据返回给调用者

2. 调用格式

   ```java
   方法名(参数1, 参数2,...);
   ```

3. 形参和实参

   在定义方法的时候，其中的参数称为形参；

   在调用方法的时候，其中的参数称为实参；

4. 方法重载

   + 概念

     方法重载值同一个类中定义的多个方法之间的关系，满足下列条件的多个方法构成重载

     + 多个方法在一个类中
     + 多个方法具有相同的方法名
     + 多个方法的参数类型不同、或数量不同、或顺序不同（即不同类型的顺序不同——[int a, double b]和[double a, int b]即为顺序不同）

   + 注意：

     + 重载仅对应方法的定义，与方法的调用无关
     + 重载仅针对同一个类中方法的名称与参数进行识别，与返回值无关，即不能通过返回值来判定两个方法是否相互构成重载

   + 正确示例：

   ```java
   public class MethodDemo {
   	public static void fn(int a) {
       	//方法体
       }
       public static int fn(double a) {
       	//方法体
       }
   }
   
   public class MethodDemo {
   	public static float fn(int a) {
       	//方法体
       }
       public static int fn(int a , int b) {
       	//方法体
       }
   }
   ```

   + 错误示例：

   ```java
   public class MethodDemo {
   	public static void fn(int a) {
       	//方法体
       }
       public static int fn(int a) { 	/*错误原因：重载与返回值无关*/
       	//方法体
       }
   }
   
   public class MethodDemo01 {
       public static void fn(int a) {
           //方法体
       }
   } 
   public class MethodDemo02 {
       public static int fn(double a) { /*错误原因：这是两个类的两个fn方法*/
           //方法体
       }
   }
   ```

#### 三、方法的内存

​	方法都存在栈内存中，在定义方法时相当于压栈，而当执行方法时相当于出栈。

    ```java
    public class MethodDemo {
        public static void main(string[] args){
            eat();
        }
        public static void eat() {
            study();
            system.out.println("吃饭");
            sleep();
        }
        public static void sleep(){
            system.out.print1n("睡觉");
        }
        public static void study(){
            system.out.print1n("学习");
        }     
    }
    
    /*
    	1.main方法先进栈
    	2.main方法调用了eat方法，故此时eat方法进栈
    	3.eat方法先调用study方法，故此时study方法也进栈
    	4.进入study方法执行打印语句，此时study方法执行完毕，弹出栈内存,返回调用处
    	5.执行eat中的打印语句，然后调用sleep方法，故此时sleep方法入栈
    	6.执行sleep方法中的打印语句，此时sleep方法执行完毕，弹出栈内存，返回调用处
    	7.此时代码返回到了eat方法，而eat方法执行完比，弹出栈内存，返回main方法
    	8.main方法执行完毕，弹出栈内存，整个流程执行完毕。
    
    */
    ```

#### 四、基本数据类型和引用数据类型

1. 基本数据类型

   数据值是存储在自己的空间中，赋值给其他变量，也是赋的真实的值。

2. 引用数据类型

   数据值是存储在其他空间中，自己空间中存储的是地址值

   赋值给其他变量，赋的是地址值

#### 五、方法的值传递

​	传递基本数据类型时，传递的是真实的数据，形参的改变，不影响实际参数的值

​	传递引用数据类型时，传递的是地址值，形参的改变，影响实际参数的值