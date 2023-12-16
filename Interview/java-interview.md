### 创建string两种方法的区别：
- 双引号给出的字符串对象，存在于堆内存中的常量池，相同内容只会存储一份。（节约内存；方便所有人共享） - `String a = "hello"`  
- new字符串对象，每new一次都会在堆内存中产生一个字符串对象 - `String a = new String("hello")`  

### 为什么说双引号的String存储一份可以大家共享呢？
因为String是不可变字符串，改不了就只能共享

### 如下所示，为什么都是加运算，但是结果不相等？
```java
String s1 = "abc";
String s2 = "ab";
String s3 = s2 + "c";
sout(s1 == s3); // return false

String s1 = "abc";
String s2 = "a" + "b" + "c";
sout(s1 == s2); // return true
```
首先，s3是通过连接s2和"c"形成的。即使它的值与s1相同，但它是在运行时通过字符串连接创建的，因此它不会自动存储在字符串常量池中，而是在堆上创建一个新的字符串对象。
因为java存在编译优化机制，在编译时，自动把`"a" + "b" + "c"`转成`"abc"`，也就是s1和s2引用了内存中相同的对象。

### 对比字符串的时候使用`==`和`a.equals(b)`有什么区别？什么时候用`==`，什么时候用`a.equals(b)`？
`==`对比的是对象的内存地址，而`a.equals(b)`对比的是两个对象的值（字符串内容）  
基本数据类型比较的时候，用`==`；而判断俩对象内容是否一致的时候，就用`a.equals(b)`

### 集合容器中存储的每个对象是什么东西？
存的在堆内存中的地址。





Why would we choose to override the default equality comparer?
Worst case Big O for quick sort algorithm?


感觉比较注重OOD

Code needs to compile and no build error.这和平时很多人准备的大厂白板coding 不太一样。

优点： 算法问题不算难 实际中能碰到的
缺点： 只能使用Java, 现搜syntax 浪费时间, 占用展示真正problem solving 能力的时间
平时可以多注意积累的方面：

OOD
Java common data structure & manipulation
IDE shortcut to improve speed

另外一个coding session 更多的是present you with a problem, talk about the algorithm steps in English, and analyze time and space complexity

System Design 不是我的强项, 其中我被问到的一点是设计了一个API之后，根据大概的load estimateion 计算下有how much数据travel across the network



反思：

练习Agogrithm Big O analysis, Space and time complexity
平时的项目多总结design经验, 联系预估数据量大小
Communication, ask questions to clarify

技术面1:JVM结构及如何优化内存

垃圾回收原理

多线程基础知识

数据结构基础知识

你使用的Java版本以及它的特性

##
2. 解释quick sort的工作原理

3. oops基础