### 一、Arrays工具类

+ 常用方法

  <div style="text-align:center">
      <img src="images\Array工具类.png" alt="Arrays">
  </div>

+ 方法演示

  ```java
  // toString方法
  int[] arr = {1, 2, 3, 4};
  sout(Array.toString(arr));	// [1,2,3,4]
  
  // binarySearch方法
  // 前提：数组升序排列
  // 返回值：如果元素存在，返回真实索引；如果元素不存在，返回的是 -插入点-1
  
  // sort方法
  // 使用插入排序 + 二分查找实现
  // arr中的元素必须为引用对象，基本数据类型要使用其对应的包装类
  Array.sort(arr, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer 02){
          return o1 - o2;		//升序排列
          return o2 - o1;		//降序排列
      }
  });
  ```

#### 二、Lambda表达式

+ 函数式编程
  + 函数式编程是一种思想特点
  + 它忽略面向对象的复杂语法，**强调做什么，而不是谁去做**

+ 格式

  + lambda是JDK8开始后的一种新语法形式

    ```java
    () -> {
        
    }
    // () 对应着方法的形参
    // -> 固定格式
    // {} 对应着方法的方法体
    
    Array.sort(arr, (Integer o1, Integer 02) -> {
            return o1 - o2;		//升序排列
        }
    });
    ```

+ note

  + lambda表达式可以用来简化匿名内部类的书写
  + Lambda表达式只能简化**函数式接口**的匿名内部类的写法
  + 函数式接口：有且仅有一个抽象方法的接口叫做函数式接口，接口上方可以加@FunctionalInterface注解验证
    + **原因：因为在传递参数的时候省略了接口中的方法名，所以需要接口类中仅有一个抽象方法，这样才可以唯一确定被调用的方法**

+ Lambda省略规则    **可推导即可省略**

  + 参数类型可以省略补写
  + 如果只有一个参数，参数类型可以省略，同时（）也可以省略
  + 如果Lambda表达式的方法体只有一行，大括号、分号、return可以省略补写，需要同时省略

  ```java
  Array.sort(arr, (o1, 02) -> o1 - o2);
  ```

```java
/*定义数组并存储一些字符串，使用Array中的sort方法进行排序
要求（排序规则）：按照字符串的长度进行排序，短的在前面，长的在后面*/
String[] arr = {"a", "aaaa", "aaa", "aa"};
Array.sort(arr, new Comparator<String>(){
   @Override
    public int compare(String o1, String o2){
        return o1.length() - o2.length();
    }
});

// 使用lambda表达式简化代码
Array.sort(arr, (o1, o2) -> o1.length() - o2.length());
```

