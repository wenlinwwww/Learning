### java的特点
- 面向对象（封装，继承，多态）
- 在引入虚拟机之后，Java 语言在不同的平台上运行不需要重新编译。（Write Once，Run any Where）
- 可靠性、安全性；
- 支持多线程
- 支持网络编程并且很方便（java web）
- 编译与解释并存；（Java 源代码首先被编译器（javac）编译成字节码（.class 文件），字节码是一种平台无关的中间表示。随后，字节码在 Java 虚拟机（JVM）上通过解释器执行，或者在现代 JVM 实现中通过即时编译器（Just-In-Time compiler, JIT）转换成特定平台的机器码执行。）

### JVM、JRE和JDK的关系是什么？
JDK - Java Development Kit： 拥有 JRE 所拥有的一切，还有编译器（javac）和工具（如 javadoc 和 jdb）能够创建和编译程序。  
JRE - Java Runtime Environment：运行已编译 Java 程序所需的所有内容的集合（包括 Java 虚拟机（JVM），Java 类库，java 命令和其他的一些基础构件）不能用于创建新程序。  
JVM - Java Virtual Machine: 运行程序
JDK包含JRE，JRE包含JVM。

### 数据类型
基本数据类型和引用数据类型  
基本数据类型：boolean（布尔型）、float（单精度浮点型）、char（字符型）、byte（字节型）、short（短整型）、int（整型）、long（长整型）和 double （双精度浮点型）共 8 种
引用数据类型： 包括数组、类和接口

### switch 是否能作用在 byte 上，是否能作用在 long 上，是否能作用在 String 上？
除了long，其他都可以

### 访问修饰符public、private、protected、以及不写（默认）时的区别？
default：在同一包内可见，不使用任何修饰符。  
private：在同一类内可见。不能修饰类（外部类）  
public：对所有类可见  
protected：对同一包内的类和所有子类可见。不能修饰类（外部类）

### final、finally、finalize的区别？
- final 用于修饰变量、方法和类。  
  - final 变量：被修饰的变量不可变（必须初始化，类似常量）
  - final 方法：被修饰的方法不允许任何子类重写，子类可以使用该方法。
  - final 类：被修饰的类不能被继承，所有方法不能被重写。
- finally只能在 try/catch 语句中，表示这段语句最终一定被执行（无论是否抛出异常）
- finalize 是在 java.lang.Object 里定义的方法，当一个对象即将从内存中移除时，垃圾回收器会调用这个对象的 finalize() 方法，以便进行清理工作，如释放资源、关闭文件等。（java9开始已被移出）

### ”static”关键字是什么意思？Java中是否可以覆盖(override)一个private或者是static的方法？
成员变量或方法属于类本身，而不是属于类的某个对象。这意味着即使你没有创建类的实例，你也可以访问它的静态成员。  
不能，private是不可见的，只能在定义它们的类内部访问；静态方法是类特有的，不属于类的任何特定实例。

### 为什么要用static关键字？
静态方法和变量可以在不创建对象的情况下访问

### 是否可以在static环境中访问非static变量？
不能，当类被Java虚拟机载入的时候，会对static变量进行初始化。如果你的代码尝试不用实例来访问非static的变量，编译器会报错

### static静态方法能不能引用非静态资源？
不能，静态方法初始化后就存在了，而非静态是new的时候产生的。

### static静态方法里面能不能引用静态资源？
可以，都是初始化的时候加载的

### 非静态方法里面能不能引用静态资源？
可以，new之后产生的可以用类里面的内容。

### 面向对象和面向过程的区别？
面向过程：
- 优点：性能比面向对象高，因为类调用时需要实例化，开销比较大，比较消耗资源
- 缺点：没有面向对象易维护、易复用、易扩展。
面向对象：
- 优点：易维护、易复用、易扩展，由于面向对象有封装、继承、多态性的特性，可以设计出低耦合的系统，使系统更加灵活、更加易于维护。
- 缺点：性能比面向过程低。

### 讲讲面向对象三大特性
封装：客观事物封装成抽象的类，并且类可以把自己的数据和方法只让可信的类或者对象操作，对不可信的进行信息隐藏。
继承：使用现有类的所有功能，并在无需重新编写原来的类的情况下对这些功能进行扩展。（子类继承非私有）
多态：它是指在父类中定义的属性和方法被子类继承之后，可以具有不同的数据类型或表现出不同的行为。（重写）

### 重载（Overload）和重写（Override）的区别是什么？
overload是方法名一样，但是参数不同，返回值类型也可以变；override方法名和参数都要一样，返回值类型必须是一样或者（协变返回型）

### 构造器（constructor）是否可被重写（override）？
不能被继承，不能被重写，可以被重载

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

### 为什么重写 equals 方法必须重写 hashcode 方法 ﻿？
先根据hashcode进行的判断，相同的情况下再根据equals()方法进行判断。如果只重写了equals方法，而不重写hashcode的方法，会造成hashcode的值不同，而equals()方法判断出来的结果为true。

### 为什么java是强类型语言
每种数据在java中都有各自的数据类型，如果不是同一种数据类型，时





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