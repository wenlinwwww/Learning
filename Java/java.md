## JRE & JDK
JDK (java development kit): java开发工具包  
包含：
1. JVM（Java Virtual Machine，它允许Java程序在不同的计算机和操作系统上执行） 
2. 核心类库 
3. 开发工具（javac 编译工具/java 运行工具/jdb 调试工具/jhat 内存分析工具...）

JRE(java runtime environment): java运行环境（因为当你写好代码传别人的时候，有些开发工具并不需要，这些就可以省略）
包含：1. JVM 2. 核心类库 3. 运行工具

### summary
1. JDK 是什么？有哪些内容组成？
   JDK是java开发工具包
   - JVM虚拟机：java程序运行的地方
   - 核心类库：java已经写好的东西
   - 开发工具：javac, java, jdb, jhat...

2. JRE是什么？有哪些内容组成？
   JRE是java运行环境
   JVM, 核心类库，运行工具

3. JDK, JRE, JVM三者的包含关系
   JDK包含了JRE
   JRE包含JVM

## comment注释
- 单行注释（block comment）：//这段是测试
- 多行注释（line comment）：/* 这段是测试 */
- 文档注释（doc comment）：/** 这段是测试 */

## 关键字
关键字全部小写，例如public， class， static， void这些

## Class
用于定义一个类（类是java最基本的组成单元）
注意类名需要和文件名保持一致
```java
public class Helloworld {
    // this is a class
}
```

## 字面量
| 字面量类型 | 说明                             | 举例                    |
| ---------- | -------------------------------- | ----------------------- |
| 整数类型   | 不带小数点的数字                 | 666， -88               |
| 小数类型   | 带小数点的数字                   | 13.14， -5.21           |
| 字符串类型 | 用双引号括起来的内容             | "hello world"，""， " " |
| 字符类型   | 用单引号括起来的，内容只能有一个 | 'A', '0', '你'          |
| 布尔类型   | 布尔值，表示真假                 | true, false             |
| 空类型     | 特殊值，空值                     | null                    |

## 制表符
在打印的时候，把前面的字符串的长度补齐到8，或者8的整数倍。最少补1个空格，最多补8个空格。
主要作用是对齐，比较好看，注意下面例子中\t只管前面字符串是不是8，后面不管
```java
public class HellowWorld {
    public static void main(String[] args) {
        System.out.println("abc" + '\t'); //此时补5个空格，因为字符串是3个
        System.out.println("abc" + '\t' + "age");
        System.out.println("cdf" + '\t' + "10");
    }
}
// 打印结果：
// abc     age
// cdf     10

```

### summary
1. 什么是字面量？
   数据在程序中的书写格式
2. java中有字面量的分类？
   整数，小数，字符串，字符，布尔，空
3. 一些特殊字面量的书写
   制表符：\t
   空类型：null

## 变量
格式：
数据类型 变量名 = 数据值；
注意事项：
- 只能存一个值
- 变量名不允许重复定义
- 一条语句可以定义多个变量
```java
int d = 100, e = 200, f = 300;
```
- 变量在使用前一定要进行赋值(初始化)
- 注意变量作用范围

### practice
```java
public class Bus {
    public static void main(String[] args) {
        // 一开始没有乘客
        int passenger = 0;
        //第一站： 上去1位乘客
        passenger = passenger + 1;
        //第二站： 上去两位乘客，下来一位
        passenger = passenger + 2 - 1;
        //第三站：上去俩，下来1
        passenger = passenger + 2 - 1;
        //第四站：下来1
        passenger = passenger - 1;
        //第五站：上去1
        passenger = passenger + 1;
        //到终点站了，现在车上还有几人
        System.out.println(passenger);
    }
}
```

## 存储规则
所有数据都是二进制存储
计算机三类数据：文本（text），图片（image），声音（sound）

java中表示进制： 
二进制：0b开头
十进制：无前缀
八进制：0开头
十六进制：以0x开头

ASCII码表：字母换数字系列（如果想显示汉字转换数字，可以考虑GB 2321-80编码，虽然后来统一了，就是unicode万国码）

图片存储：
黑白图-灰度图-彩色图

## 数据类型
java中数据类型主要分两种：基本数据类型和引用数据
### 基本数据类型
- 基本数据类型8种：
  - 整数类：
    | 数据类型 | 字节数 | 位数   | 范围               | 有无缓存 |
    | -------- | ------ | ------ | ------------------ | -------- |
    | byte     | 1byte  | 8bit   | -128 ~ 127         | 有缓存   |
    | short    | 2byte  | 16bit  | -32768 ~ 32767     | 有缓存   |
    | int      | 4byte  | 32bit  | -2^31 ~ (2^31 - 1) | 有缓存   |
    | long     | 8byte  | 64bits | -2^63 ~ (2^63 - 1) | 有缓存   |
  - 小数类：
    | 数据类型 | 字节数 | 位数  | 范围                         | 有无缓存 |
    | -------- | ------ | ----- | ---------------------------- | -------- |
    | float    | 4byte  | 32bit | -3.4 x 10^38 ~ 3.4 x 10^38   | 无缓存   |
    | double   | 8byte  | 64bit | -1.7 x 10^308 ~ 1.7 x 10^308 | 无缓存   |
  - 字符
    | 数据类型 | 字节数 | 位数  | 范围      | 有无缓存 |
    | -------- | ------ | ----- | --------- | -------- |
    | char     | 2byte  | 16bit | 0 ~ 65535 | 有缓存   |
  - 布尔
    | 数据类型 | 字节数 | 位数 | 范围          | 有无缓存 |
    | -------- | ------ | ---- | ------------- | -------- |
    | boolean  |        | 1bit | true or false | 有缓存   |

    ps：
    如果要定义long类型的变量，要在数据值的后面加一个L作为后缀(虽然说大小写L都行，但是最好还是大写)
    ```java
    long n = 99999999L;
    System.out.println(n);
    ```

    定义float类型变量的时候，数据值也需要一个F作为后缀(也是大小写都可，建议大写)
    ```java
    float f = 10.1F;
    System.out.println(f);
    ```

    整数和小数取值范围大小：
    double > float > long > int > short > byte

### 引用数据类型
String

### 标识符
给类，方法，变量等起的名字（就是命名规则）
1. 由数字，字母，下划线（_）和美元符（$）组成 例如：_2b是可以的
2. 不能以数字开头
3. 不能是关键字
4. 区分大小写

起名建议：
小驼峰命名：给方法，变量起名
1. 标识符是一个单词的时候，全部小写 例如：name
2. 标识符由多个单词组成的时候，第一个单词首字母小写，其他单词首字母大写 例如：firstName

大驼峰命名：给类名起名字
1. 标识符是一个单词的时候，首字母大写 例如：Student
2. 标识符由多个单词组成的时候，每个单词首字母大写 例如：GoodStudent

### 键盘录入（scanner类）
1. 导包
   `import java.util.Scanner;`
2. 创建对象
   `Scanner sc = new Scanner(System.in);`
3. 接收数据
   `int i = sc.nextInt();`
            or
   `String s = sc.next();` ---- 会读取输入中的一个单词（以空格分隔的字符串）
            or
   `String s = sc.nextLine();` ---- 会读取整行输入
4. 使用完毕后
   `sc.close();`

e.g.
```java
import java.util.Scanner;

public class ScannerDemo {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入数字：");
      int i = sc.nextInt();
      System.out.println(i);
      sc.close();
   }
}
```

小练习：
```java
import java.util.Scanner;

public class ScannerPrac {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入数字1：");
      int num1 = sc.nextInt();
      System.out.println("请输入数字2：");
      int num2 = sc.nextInt();
      System.out.println("输入数字之和：" + num1+mun2);
      sc.close();
   }
}
```

## IDEA
idea 项目结构介绍：  
&nbsp;&nbsp;project（项目）  
&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:red">module（模块）</span>  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; package（包）  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:red">class（类）</span>

idea快捷键：
psvm：快速生成`public static void(String[] args) {}`  
sout: 快速生成`System.out.println();`  
数组名.fori：快速生成这个数组的遍历
数组名.for：快速生成数组的遍历（for each写法）
快速生成construct/getter&setter: alt+insert
ctrl + alt + S: 快速打开Setting  
ctrl + alt + shift + S：快速打开project structure  
shift + F6：rename  
ctrl + alt + L: reformat  
ctrl + alt + M: select your code, and it will auto generate method.
alt + insert: create constructor/ generate getter and setter
ctrl + l + v: auto generate left side
ctrl + b: read source code
ctrl + alt + t: quick generate if/while/... loop for your selected code

idea 修改主题：  
File -> Settings -> Appearance -> theme  
idea 修改字体：  
File -> Settings -> Editor -> font  
idea 修改comment颜色：  
File -> Settings -> Editor -> color schema -> language default -> 找到comments  
idea 自动找包：  
File -> setting -> General -> Auto import -> 选上Add unambiguous imports on the fly和optimize imports on the fly  
idea 忽略大小写：  
File -> setting -> editor -> code completion -> 不勾选match case  
idea 加背景图片：  
File -> Settings -> Appearance -> Appearance -> background image...  

### idea报错
`java: illegal character: '\ufeff'` -- 直接在File -> file property -> remove BOM

## 运算符
运算符：对字面量或者变量进行操作的符号 e.g. `+`
表达式： 用运算符把字面量或者变量连接起来，符合java语法的式子 e.g.`a+b`

### 算术运算符（arithemetic operator）：
| 符号 | 作用 |
| ---- | ---- |
| +    | 加   |
| -    | 减   |
| *    | 乘   |
| /    | 除   |
| %    | 取模 |

ps:
如果有小数参与计算，结果有可能不精确。（例如下面例子2-4）
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(1.1 + 1.1); //2.2
        System.out.println(1.1 + 1.01); //2.1100000000000003
        System.out.println(1.1 - 1.01); //0.09000000000000008
        System.out.println(1.1 * 1.01); //1.1110000000000002
    }
}
```

整数参与计算，只能得到整数结果；如果想要得到小数结果，那必须小数参与运算，例如第二个：
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(10 / 3); //3
        System.out.println(10.0 / 3); //3.3333333333333335
    }
}
```

### 数字相加：
数字进行运算的时候，数据类型不一样不能运算，需要转成一样的才行。
### 隐式转换（自动类型提升）：
- 取值范围小的数值转换成取值范围打的数值。
- 不需要写代码，程序会自动帮忙实现。
- byte short char 三种类型的数据在运算的时候，都会先提升为int，再进行运算。  

**隐式转换原理**：
前面补0；例如byte a=10;转化成int，首先byte 10转成补码是0000 1010，想转成int，直接在前面补0，补成0000 0000 0000 0000 0000 0000 0000 1010即可。

e.g.
```java
int a = 10;
double b = a；

// byte 和 short进行运算
byte c = 10;   //因为byte计算时会先转化成int
short d = 20;
int e = c + d;
// int 和 double，取double
public class Test {
    public static void main(String[] args) {
        int a = 10;
        double b = 12.3;
        double c = a + b;
    }
}

// byte运算时会先提升为int
public class Test {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 20;
        int c = a + b;
    }
}

// int 和 double进行运算，最终结果会是double
public class Test {
    public static void main(String[] args) {
        int a = 10;
        double b = 20.0;
        double c = a + b;
    }
}
```
#### 隐式转换summary
取值范围：
byte < short < int < long < float < double
什么时候转换？
数据类型不一样，不能进行计算的时候，需要转成一样的才可以计算。

### 强制转换： 
取值范围大的数值转换成取值范围小的数值。（不允许直接赋值，如果一定要这么做需要加入强制转换。）  
<span style="color:red">格式</span>： 目标数据类型 变量名 = （目标数据类型）被强制转化的数据；  
强制转换原理：例如int a=300转成byte，首先int 300的补码是0000 0000 0000 0000 0000 0001 0010 1100，转成byte就是去掉前面6bits，变成0010 1100（十进制是44），前面有个重要的0001也被舍弃了，这就是为什么转换会出错。以下是另一种会出错的情况，例如int b=200（补码：0000 0000 0000 0000 0000 0000 1100 1000），去掉前面6bits变成1100 1000（十进制是-56）

```java
double a = 12.3;
int b = (int) a;

//强转会发生错误
int a = 300;
byte b = (byte) a;

//将两个byte相加（最后是int类型），强转成byte
public class ArithemeticOperatorPrac2 {
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        byte result = (byte) (b1 + b2);
        System.out.println(result); // 如果此时把b1改成200，b2改成200，那计算就会发生错误，print-56
    }
}
```

### 字符串相加
```java
"123" + 123 // "123123"
"abc" + true //"abctrue"
```

#### 自增自减运算符
| 符号 | 作用 | 说明        |
| ---- | ---- | ----------- |
| ++   | 加   | 变量的值加1 |
| --   | 减   | 变量的值减1 |
可以写变量前面，也可以写变量后面
```java
int a = 10;
a++; //还有种写法++a;
System.out.println(a)
```

单独使用：++和--不论是放在变量前边还是后边，单独写一行结果是一样的。
参与计算：
a++先用后加（先赋值给b再x自己+1）；++a先加后用（先自增完了在赋值给b）
```java
public class ArithemeticOpearatorPrac3 {
    public static void main(String[] args) {
        int x = 10;
        int y = x++; //y = 10; x = x + 1 = 11
        int z = ++x; //x = x + 1 = 12; z = 12; 
        System.out.println("x:" + x); //12
        System.out.println("y:" + y); //10
        System.out.println("z:" + z); //12
    }
}
```

### 赋值运算符
| 符号 | 作用       | 说明                    |
| ---- | ---------- | ----------------------- |
| =    | 赋值       | int a = 10; 将10赋值给a |
| +=   | 加后赋值   | a += b; 将a+b的值给a    |
| *=   | 乘后赋值   | a *= b; 将a\*b的值给a   |
| /=   | 除后赋值   | a /= b; 将a/b的值给a    |
| %=   | 取余后赋值 | a %= b; 将a%b的值给a    |

ps: 注意所有的+=，-=，/=，*=，%=底层都隐藏了一个强制类型转换
```java
public class ArithemeticOpearatorPrac4 {
    //+=
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        a += b; // a = a+b
        System.out.println(a); //30
        System.out.println(b); //20
        //attention
        short s = 1;
        //等于 short s = (short) (s + 1);
        s += 1;
        System.out.println(s); //2
    }
```

### 关系运算符（比较运算符）
| 符号 | 说明                                                                                     |
| ---- | ---------------------------------------------------------------------------------------- |
| ==   | `a==b`; 判断a和b的<span style="color:red">值</span>是否相等，成立为true，不成立为false   |
| !=   | `a!=b`; 判断a和b的<span style="color:red">值</span>是否不相等，成立为true，不成立为false |
| >    | `a>b`; 判断a是否大于b，成立为true，不成立为false                                         |
| >=   | `a>=b`; 判断a是否大于等于b，成立为true，不成立为false                                    |
| <    | `a<b`; 判断a是否小于b，成立为true，不成立为false                                         |
| <=   | `a<=b`; 判断a是否小于等于b，成立为true，不成立为false                                    |

prac:
键盘录入两个整数，表示1和2的时髦度（手动录入0-10之间的整数，不能录其他的）
如果1的时髦度大于2，相亲成功，输出true，否则false
```java
public class ArithemeticOpearatorPrac5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pls enter first 0-10 integer:");
        int num1 = sc.nextInt();
        System.out.println("pls enter first 0-10 integer:");
        int num2 = sc.nextInt();
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            System.out.println("you type wrong number!");
        }
        boolean res = num1 > num2;
        System.out.println(res);
    }
}
```

### 逻辑运算符
| 符号 | 作用         | 说明                         |
| ---- | ------------ | ---------------------------- |
| &    | 逻辑与（且） | 并且，两边都为真，结果才是真 |
| \|   | 逻辑或       | 或者，两边都为假，结果才是假 |
| ^    | 逻辑异或     | 相同为false，不同为true      |
| ！   | 逻辑非       | 取反                         |
| <<   | 左移         | 向左移动，低位补0            |
| >>   | 右移         | 向右移动，高位补0或1         |
| >>>  | 无符号右移   | 向右移动，高位补0            |

<span style="color:red">后面三个是补码相关，其中左移一次就相当于原数值x2，右移一次相当于除2</span>

```java
//演示一下异或
System.out.println(true ^ true); // return false
System.out.println(true ^ false); // return true
System.out.println(false ^ true); // return true
System.out.println(false ^ false); // return false

//演示一下左移
public class ArithemeticOperatorPrac2 {
    public static void main(String[] args) {
        int a = 200; // 0000 0000 0000 0000 0000 0000 1100 1000
        System.out.println(a << 2); // 0000 0000 0000 0000 0000 0000 1100 1000 00
        // output is 800
    }
}

//演示一下右移
public class ArithemeticOperatorPrac2 {
    public static void main(String[] args) {
        int a = 200; // 0000 0000 0000 0000 0000 0000 1100 1000
        System.out.println(a >> 2); // 00 0000 0000 0000 0000 0000 0000 1100 1000
        // output is 50
    }
}
```

#### 短路逻辑运算符
短路效果就是，例如&&，左边是false那就不用判断了，直接return false，但是普通的&，不一样，就算左边是false，它也会去看一下右边结果，然后再return false。

& \|，无论左边true还是false，右边都要执行。
&& \|\|，如果左边能确定表达式结果，右边不执行，也就是提高了效率

| 符号 | 作用   | 说明                         |
| ---- | ------ | ---------------------------- |
| &&   | 短路与 | 结果和&相同，但是有短路效果  |
| \|\| | 短路或 | 结果和\|相同，但是有短路效果 |

prac：
键盘录入两个整数，如果其中一个为6，最终结果输出true。如果它们的和为6的倍数，最终结果输出true，其他都是false
```java
public class ArithemeticOpearatorPrac6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pls enter a number:");
        int num1 = sc.nextInt();
        System.out.println("pls enter another number:");
        int num2 = sc.nextInt();
        boolean res = num2 == 6 || num1 == 6 || (num1+num2) % 6 == 0;
        System.out.println(res);
    }
}
```

### 三元运算符
<span style="color:red">格式</span>：关系表达式? 表达式1 : 表达式2;  
关系表达式结果为true，则运行表达式1；如果结果为false，就运行后面那个表达式2。
ps: 代码中不能只写三元表达式，它的结果必须要被用，需要给它一个变量，或者直接把它打印了

```java
public class ArithemeticOpearatorPrac6 {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 20;
        int max = n1 > n2? n1 : n2;
        System.out.println(max); // 20
   }
}
```

prac:
动物园有两只老虎，体重通过键盘录入，判断俩老虎体重是否相同
```java
public class ArithemeticOpearatorPrac7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("weight 1:");
        int w1 = sc.nextInt();
        System.out.println("weight 2:");
        int w2 = sc.nextInt();
        String s = w1 == w2? "weight is the same" : "weight is not same";
        System.out.println(s);
    }
}
```

prac2:
比较三个人身高，150cm，210cm，165cm
```java
public class ArithemeticOpearatorPrac8 {
    public static void main(String[] args) {
        int h1 = 150;
        int h2 = 210;
        int h3 = 165;
        int analyse1 = h1 > h2 ? h1 : h2;
        int analyse2 = analyse1 > h3 ? analyse1 : h3;
        System.out.println(analyse2);
    }
}
```

### 运算符优先级
从高到低
| 优先级 | 运算符               |
| ------ | -------------------- |
| 1      | . () {}              |
| 2      | ! ~ ++ --            |
| 3      | \* \/ %              |
| 4      | +  -                 |
| 5      | << >> >>>            |
| 6      | < <= > >= instanceof |
| 7      | ==  !=               |
| 8      | &                    |
| 9      | ^                    |
| 10     | \|                   |
| 11     | &&                   |
| 12     | \|\|                 |
| 13     | ?:                   |
| 14     | = += -= *= /= %= &=  |

### 原码、反码、补码
**原码**：十进制的二进制表现形式，最左边是符号位，0为正，1为负。  
**源码弊端**：利用原码对证书进行计算是不会有问题的。但如果事负数计算，结果就出错，实际运算结果，和预期相反。（说人话就是解决不了负数相加问题，此时出现了反码）  
e.g.   
56 -> 00111000  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;v  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;bit(比特位)  
最大值 01111111 -> +127  
最小位 11111111 -> -127

**反码目的**：为了解决原码不能计算负数的问题而出现。  
**计算规则**：整数的反码不变，负数的反码再原码的基础上，符号位不变，数值取反，0变1，1变0。  
**反码的弊端**：负数运算的时候，如果结果不跨0，是没有任何问题，但如果结果跨0，跟实际结果会有1的偏差。  
e.g.  
-56 --原码--> 10111000  
-56 --反码--> 11000111  
-56+1 --反码--> 11001000   
-55 --原码--> 10110111  
但是反码还是存在问题，例如-5+6  
-5 --反码--> 11111010  
+6 --反码--> 00000110  
-5+6 --反码--> 00000000 （这明显不对，结果成0了，和正确结果就有误差了）  
**产生这种误差的原因**：在反码中，0有两种表达方式11111111和00000000，一旦要算的跨0了，一定会有误差（此时出现了补码，只有在表示负数的时候，在反码的基础+1）  

| 十进制 | 原码     | 反码     | 补码     |
| ------ | -------- | -------- | -------- |
| +0     | 00000000 | 00000000 | 00000000 |
| -0     | 10000000 | 11111111 | 00000000 |
| -1     | 10000001 | 11111110 | 11111111 |
| -2     | 10000010 | 11111101 | 11111110 |
| ...    | ...      | ...      | ...      |
| -127   | 11111111 | 10000000 | 10000001 |
| -128   | no       | no       | 10000000 |

**补码的目的**：为了解决负数计算时跨0问题而出现。  
**计算规则**：整数补码不变，负数补码在反码的基础上+1.另外补码多记录一个特殊值-128，该数据没有原码和补码。  
e.g.
-4+5(补码)
-4 --补码--> 11111100
+5 --补码--> 00000101
+1 --补码--> 00000001  
<span style="color:red">ps：所以在计算机中数字的存储和计算都是补码的形式(因为补码会多一个10000000，规定为-128，这就是为什么byte范围是-128~127)</span>

反观当初的基本数据类型：  
byte类型的10： 0000 1010  
short类型的10：0000 0000 0000 1010  
int类型的10：&nbsp;&nbsp;&nbsp;&nbsp;0000 0000 0000 0000 0000 0000 0000 1010  
long类型的10： 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1010

#### summary
所有的正数原码、反码、补码都是一样的。  
计算机中数字的存储和计算都是补码的形式

## 流程控制语句
### 顺序结构
java默认的执行流程，按照代码的先后顺序，从上到下依次执行。
```java
public class OrderDemo {
    public static void main(String[] args) {
        System.out.println("你");
        System.out.println("好");
        System.out.println("呀");
        System.out.println("！");
        // ouput: 你
        //        好
        //        呀
        //        ！
    }
}
```
### 分支结构
#### if语句格式：  
```java
if (关系表达式1) {  
   语句体1;  
} else if (关系表达式2) {  
   语句体2;   
} else {  
   语句体3;   
}
```

注意事项：
1. 大括号开头可以另起一行写，但建议写在第一行末尾
2. 语句体中，如果只有一句代码，大括号可以忽略不写（最好还是写）
3. 如果对一个布尔类型的变量判断，不需要用==


```java
public class IfSatetment {
    public static void main(String[] args) {
        int num = 20;
        //超过两行就会报错
        if (num >= 10) System.out.println("larger than 10");
    }
}

public class IfSatetment {
        boolean flag = true;
        // boolean 可以不写==
        if (flag) System.out.println("flag is true");
    }
}

public class IfSatetment {
    //键盘录入酒量，大于2就赞美
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("your alcohol volume:");
        int v = sc.nextInt();
        if (v > 2) {
            System.out.println("nice volume");
        } else  {
            System.out.println("not good");
        }
    }
}
```
#### switch语句格式：  

```java
switch(表达式) {  
   case 值1:  
      语句体1;  
      break;  
   case 值1:  
      语句体2;  
      break;  
   ...  
   default:  
      语句体n+1;  
      break;  
}  
```
有case匹配就执行case内语句体，遇到break就结束，都不匹配就执行default内语句体。
ps：case后面的值只能说字面量，不是能是变量；case给出的值不允许重复。  
e.g.
```java
public class SwitchPrac {
    public static void main(String[] args) {
        String noodles = "lanzhou noodle";
        switch(noodles) {
            case "hot dry noodle":
                System.out.println("eat hot dry noodle");
                break;
            case "lanzhou noodle":
                System.out.println("eat lanzhou noodle");
                break;
            case "shanxi oil noodle":
                System.out.println("eat shanxi oil noodle");
                break;
            default:
                System.out.println("fast noodle");
        }
    }
}
```
prac:
```java
public class SwitchPrac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pls type the number of week:");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("running");
                break;
            case 2:
                System.out.println("swimming");
                break;
            case 3:
                System.out.println("walking");
                break;
            case 4:
                System.out.println("bicycle");
                break;
            case 5:
                System.out.println("boxing");
                break;
            case 6:
                System.out.println("climbing");
                break;
            case 7:
                System.out.println("eating");
                break;
            default:
                System.out.println("do not have this day");
                break;
        }
    }
}
```

#### switch其他知识：  
- default的位置和省略：不一定写在最下面，可以写在任意位置，只是习惯写在最下面；default可以省略，语法不会有问题，但是不建议省略。  
- case穿透：省略了每个case的break会导致这个问题。一般情况下是如果case匹配上了，那就会执行对应的语句体，此时发现break就结束整个switch语句。但如果没有发现break，就会继续执行下一个case语句，一直到遇到break或遇到大括号位置。（如果多个case的语句体重复了，那就会考虑case穿透取简化代码）  
- switch新特性（jdk12及以上才有）：具体格式看下面代码
```java
// switch新特性
public class SwitchPrac4 {
    public static void main(String[] args) {
        int num = 1;
        switch (num) {
            //如果大括号内只有一行代码，大括号也可以省略，参考第一个case和后面几个case区别
            case 1 -> {
                System.out.println("1");
            }
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            default -> System.out.println("noting");
        }
    }
}
```
e.g.
```java
//case穿透例子
//最后结果是is 10和is 20
public class SwitchPrac3 {
    public static void main(String[] args) {
        int num = 10;
        switch (num) {
            case 1:
                System.out.println("is 1");
                break;
            case 10:
                System.out.println("is 10"); //继续往下，进入下一个case
            case 20:
                System.out.println("is 20");
                break; //遇到break，结束switch
            default:
                System.out.println("not 1, 10, 20");
        }
    }
}
```

prac2：
键盘输入数字，其中1-5代表是工作日，6-7是周末
```java
public class SwitchPrac5 {
    public static void main(String[] args) {
        // 1-5: work day; 6-7: weekend
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a weekday number:");
        int week = sc.nextInt();
        switch (week) {
            case 1, 2, 3, 4, 5 -> System.out.println("workday");
            case 6, 7 -> System.out.println("weekend");
        }
    }
}
```

#### summary
switch和if格式各自的使用场景：  
if: 一般用于对范围的判断。  
switch：把有限个数据一一列举出来，让我们任选其一。（我觉得枚举的时候喜欢用switch）

### 循环结构
#### for loop结构：
```java
for (初始化语句; 条件判断语句; 条件控制语句) {
   循环体语句;
}
```
e.g.
```java
for (int i = 0; i < 10; i++) {
   System.out.println("hello")
}
for (int i = 1; i <= 10; i++) {
   System.out.println("hello")
}
```

#### while结构：
```java
初始化;
while (条件判断语句) {
   循环体语句;
   条件控制语句;
}
```

#### do...while loop格式：
```java
初始化;
do {
   循环语句；
   条件控制语句；
} while(条件判断语句);
```
先执行后判断（初始化 - 循环语句 - 条件控制语句 - 条件判断语句 - true的化去循环语句，false就去其他）

#### for each格式：
```java
// ElementType 是集合中元素的类型，collection 是要遍历的数组或集合
for (ElementType element : collection) {
    // 在这里使用 element 进行操作
}
```
一般用于遍历数组
e.g.
```java
public class ForEachLoopExample {
    public static void main(String[] args) {
        // 遍历数组
        int[] array = {1, 2, 3, 4, 5};
        for (int num : array) {
            System.out.println(num);
        }
        
        // 遍历 ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
```

#### summary
for和while的对比：  
相同：运行规则都是一样的  
区别：  
- for loop中，控制循环的变量，因为归属for循环的语法结构中，在for loop结束之后，就不能再被访问了。  
- while loop中，控制循环的变量，对于while loop来说不归属语法结构中，在while loop结束后，该变量还可以继续使用  
（简单来说，就是for里面的i不能出for loop使用，但是while里面的i因为是定义在外面的，所以可以出循环使用）  
使用场景：for loop一般在知道大概的循环次数或者循环范围时使用；while在不太清楚需要具体循环多少次时，但知道循环停止条件用。

prac:
回文数：给你一个整数x，如果x是一个回文整数，打印true，否则false。（回文数只类似，121，12321这种）
```java
public class ForDemo4 {
    //leetcode回文数
    public static void main(String[] args) {
        int x = 12321;
        // for compare
        int temp = x;
        int num = 0;
        while (x != 0) {
            //从右往左获取每一位数
            int g = x % 10;
            //修改x值
            x /= 10;
            //把当前获取的数字拼接到最右边
            num = num * 10 + g;
        }
        System.out.println(temp == num);
    }
}
```

prac2:
给定两个整数，被除数和除数都是整数，且不超int范围；江良树相除，要求不适用乘法，除法和%运算符，得到商和余数
```java
public class ForDemo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(1);
        int n1 = sc.nextInt();
        System.out.println(2);
        int n2 = sc.nextInt();
        int count = 0;
        int rest = n1;
        while (rest >= n2) {
            count ++;
            rest -= n2;
        }
        System.out.println("quotient is " + count);
        System.out.println("remainder is " + rest);
    }
}
```

### 无限循环
#### 三种格式：
```java
// if infinity loop
for (;;) {
   System.out.println("xxx");
}

// while infinity loop (normally using this one)
while(true) {
   System.out.println("xxx");
}

//do...while infinity loop
do {
   System.out.println("xxx");
} while(true);
```
ps:  
无限循环下面不能再写其他代码了，因为无限循环停不下来，无法执行循环后的代码，

### 跳转控制循环
在循环的过程中，跳转到其他语句执行。
continue: 跳过本次循环，继续执行下次循环。
break:结束整个循环。

e.g.
```java
// continue用法
public class JumpOutLoop {
    public static void main(String[] args) {
        //跳过某次循环
        for (int i = 1; i <= 5 ; i++) {
            if (i == 3) {
                //结束本次循环，继续下次循环
                continue;
            }
            System.out.println("eating:" + i + "food");
        }
    }
}

// break用法
public class JumpOutLoop2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5 ; i++) {
            if (i == 3) {
                //如果在此时打印，结果会是1，2，3
                System.out.println(i);
                //结束整个循环
                break;
            }
            //如果在此处打印结果会是1，2
//            System.out.println(i);
        }
    }
}
```

#### 循环practice
prac1：  
逢7过：任意一个数开始报数，报数包含7或7的倍数就说过，打印出1-100间满足条件的数
```java
public class LoopPrac {
    //逢7过游戏
    public static void main(String[] args) {
        int i = 1;
        while(i <= 100) {
            if (i % 7 == 0 || i / 10 % 10 == 7 || i % 10 == 7) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
```

prac2: 键盘录入一个大于等于2的整数，计算并返回x的平方根，结果只保留整数部分。
```java
public class LoopPrac2 {
    public static void main(String[] args) {
      // while method
        int num = 10;
        int i = 0;
        int count = 0;
        while (count <= num) {
            i++;
            count = i * i;
        }
        System.out.println(i-1);

        // for method
         for (int j = 1; j <= num ; j++) {
            if (i * i == num) {
                System.out.println(i);
            } else if (i * i > num) {
                System.out.println(i-1);
            }
        }
    }
}
```

prac3:
判断是否为质数
```java
public class LoopPrac3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pls enter a positive integer:");
        int num = sc.nextInt();
        boolean flag = true;
        if (num == 1 || num == 0) {
            System.out.println("this is not a prime number.");
        }
        for (int i = 2; i < num ; i++) {
            if (num % i == 0) {
                flag = false;
                System.out.println("This is not a prime number.");
                break;
            }
        }
        if (flag) {
            System.out.println("This is a prime number.");
        }
    }
}
```

##### 如何生成随机数：
1. 生成任意随机数
2. 让你想要的范围减去一个值，例如7-15，都减去7，变成0-8
3. 尾部+1，变成0-9
4. `int number = r.nextInt(9) + 7;`

prac4: 
猜随机数
```java
public class LoopPrac4 {
    public static void main(String[] args) {
        Random r = new Random();
        //random的范围一定是从0开始的，到你写的数字-1结束（包头不包尾，包左不包右）
        int i = r.nextInt(100) + 1; //1-100
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("pls type your guess number:");
            int num = sc.nextInt();
            if (num > i) {
                System.out.println("larger than random number");
            } else if (num < i) {
                System.out.println("smaller than random number");
            } else {
                System.out.println("match!");
                break;
            }
        }
    }
}
```

## 数组
### 数组介绍
数组是一种容器，可以用来储存<span style="color:red">同种数据类型</span>的多个值。（一般可以结合隐式转换考虑，例如int类数组可以存byte，short，int）

### 数组的定义和静态初始化
格式1：  
<span style="color:red">数据类型</span>[] <span style="color:lightblue">数组名</span>  
`int[] array`  

格式2：  
<span style="color:red">数据类型</span> <span style="color:lightblue">数组名</span>[]  
`int array[]`  

#### 数组的静态初始化
初始化：在内存中，为数组容器开辟空间，并将数据存入容器中的过程。  
完整格式：<span style="color:red">数据类型[] 数组名 = new 数据类型[] {元素1, 元素2, 元素3...};</span>  
简化格式：<span style="color:red">数据类型[] 数组名 = {元素1，元素2，元素3...};  
e.g. `int[] array = new int[] {11, 22, 33}`  
`int[] array = {11, 22, 33}`

### 数组的地址值：表示数组在内存中的位置。
```java
int[] arr = {1,2,3};
System.out.println(arr); // [I@6d03e736 -> 地址值
```
`[I@6d03e736`其中`[`表示当前是一个数组，`I`表示数组里面的数据元素都是int类型，`@`间隔符号（无特殊含义），`6d03e736`数组真正的地址值（十六进制），但习惯性叫一整坨是地址值。

### 数组元素访问
索引：也叫下标或者角标。  
索引特点：从0开始，逐个+1增长，连续不间断。  
格式：`数组名[索引]`
最大索引：数组长度 - 1

存储格式：`数组名[索引] = 具体数据/变量`
注意，一旦覆盖之后，原来的数据就不存在了。
e.g.  
```java
        int[] age = {11,22,33};
        //get array value
        int first = age[0];
        System.out.println(first); // 11
        // store or change array value
        age[0] = 5;
        System.out.println(age[0]); // 5
```

### 数组遍历
将数组中所有内容取出来（取出数据的过程，不要局限理解为遍历就是打印）

```java
//数组遍历求和
public class ArrayPrac2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(sum);
    }
}
```
### 数组动态初始化
初始化时只指定数组长度，由系统为数组分配初始值。  
格式：数据类型[] 数组名 = new 数据类型[<span style="color:lightblue">数组长度</span>];  
e.g. `int[] arr = new int[5];`  
数组默认初始化：
- 整数类型默认是`0`；
- 小数类型默认是`0.0`；
- 字符类型默认是`/u0000`也就是空格；
- 引用数据类型默认是`null`。

#### summary
动态初始化：手动指定数组长度，由系统给出默认初始化值。
   - 只明确元素个数，不明确具体数值，推荐使用动态初始化。
静态初始化：手动指定数组元素，系统会根据元素个数，计算出数组长度。
   - 需求中明确了要操作的具体数据，直接静态初始化即可。

### 数组内存图
#### Java内存分配：
栈：方法运行时使用的内存，比如main方法运行，进入方法栈中执行（程序的主入口-main方法 开始执行时会进栈，代码执行完毕会出栈）  
堆：储存对象或者数组，new来创建，都存储在堆内存（new出来的东西会在这块内存中开辟空间并产生地址）  
方法区（jdk8之后叫元空间）：存储可以运行的class文件  
本地方法栈：JVM在使用操作系统功能的时候使用，和开发无关  
寄存器：给CPU使用  
（从jdk8开始取消方法区，新增元空间，将以前的方法区一部分拆到堆，一部分拆到元空间）

e.g.  
```java
public static void main(String[] args) { <----- 先进入栈
   int a = 10;
   int b = 10;
   int c = a + b;
   System.out.println(c);
}
```
#### 数组内存图
```java
public static void main(String[] args) { <----- 先进入栈
   int[] arr = new int[5]; <----- 等号左边是在栈定义arr，右边是在堆里面，因为堆里面是有地址值的，所有堆会把地址值告诉栈，这样栈可以通过地址值和堆进行对应。
   System.out.println(arr);
   System.out.println(arr[0]);
   System.out.println(arr[1]);

   arr[0] = 11;
   arr[1] = 22;
   System.out.println(arr[0]);
   System.out.println(arr[1]);
   System.out.println("-----------");
   int[] arr2 = {22,33,44}; <------- 和上面一样的，都是栈放，堆也放，这俩用地址值链接
   System.out.println(arr2);
   System.out.println(arr2[0]);
}
```
#### summary
1. 只要是new出来的一定是在堆里面开辟空间，且这个空间是有地址的。
2. 如果new了多次，那么在堆里有多个小空间，每个小空间都有各自数据。

#### 数组中特殊情况：
两个数组指向同一个空间的内存图
```java
public static void main(String[] args) { <----- 先进栈
int[] a = {11,22}; <--- int[] a进入栈，{11,22}进入堆
int[] b = a; <---- int[] b进入栈，右边是把上一个步骤的地址值复制给arr2，这样arr1和arr2指向同一个地址。
System.out.println(arr1[0]);- arr1和arr2打印的是同一个值
System.out.println(arr1[0]);- arr1和arr2打印的是同一个值

arr2[0] = 33; <----- 把堆里面0索引对应值变成33
System.out.println(arr1[0]); <----- 通过栈找到堆数据是33
System.out.println(arr2[0]); <----- 通过栈找到堆数据也是33
}
```

### 数组常见问题
当访问了数组中不存在的索引，就会引发索引越界异常。  
`index 10 out of bounds for length 5`  
避免方法：记住最小索引为0，最大为arr.length-1  

### 数组常见操作
#### 求最值（找出数组最大值）：
  1. 定义一个max变量`int max = arr[0];`
  2. 遍历数组获取每个元素
  3. 让数组中每一个元素和max比较，不断更新max值
  ```java
  //注意此处max不写等于0，是因为如果数组都是负数，那就不好办了。
  for (int i = 1; i < arr.length; i++) {
     if (arr[i] > max) {
        max = arr[i];
     }
  }
  ```
#### 求和：
放10个1-100随机数到数组
求出数组的和
求出数组平均数
统计有多少数据比平均值小
```java
public class ArrayPrac6 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;;
            sum += arr[i];
        }
        int avg = sum/(arr.length);
        System.out.println("sum: " + sum);
        System.out.println("average: " + avg);
        for (int i : arr) {
            if (i < avg) {
                count++;
            }
        }
        System.out.println("smaller than avg: " + count);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```

#### 交换数组：
定义一个数组，存入1，2，3，4，5。
交换前：1，2，3，4，5
交换后：5，2，3，4，1
```java
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        //双指针
        for (int i = 0, j = arr.length - 1; i < j; i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
```

#### 打乱数组数据：
定义一个数组，存入1-5，打乱数组所有数据顺序。
```java
    public static void main(String[] args) {
//        定义一个数组，存入1-5，打乱数组所有数据顺序。
        Random r = new Random();
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            int order = r.nextInt(5);
            int temp = arr[i];
            arr[i] = arr[order];
            arr[order] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
```

### 二维数组
数组中存数组  
当需要把数组分组管理的时候，需要用到二维数组。
#### 初始化方式
- 静态初始化：  
    格式： <span style="color:red">数据类型[][]数组名 = new 数据类型[][]{{value1， value2},{value1， value2}}</span>  
    e.g. int[][] arr = new int[][]{{22,33}, {44,55}};  

    简写方式：<span style="color:red">数据类型[][]数组名 = {{value1， value2},{value1， value2}}</span>  
    e.g. int[][] arr = {{1,2}, {3,4}};   

    ps: 两个一维数组长度可以不一样；虽然格式也可以写成int arr[][] = {{1,2}, {3,4}};  但是最好还是别这么写  

    ```java
    //为了方便阅读数组，建议下面写法：
    int[][] arr = {
        {1,2,3},
        {4,5,6,7}
    };

    //获取二维数组元素
    System.out.println(arr[0]); //获取二维数组中第一个数组的地址值
    System.out.println(arr[0][0]); //获取二维数组中第一个数组的第一个元素

    //遍历二维数组
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++>) {
            System.out.println(arr[i][j]);
        }
    }
    ```

- 动态初始化：  
    格式：数据类型[][] 数组名 = new 数据类型[m][n];  
         其中m表示这个二维数组，可以存放多少个一维数组，  
         n表示每个一维数组，可以存放多少元素。  
    e.g. int[][] arr = new int[3][5];
    赋值：`arr[2][3] = 4;`

二维数组特殊情况：
```java
int[][] arr = new int[2][]; //没有定义一维数组具体多少值
int[] arr1 = {1,2};
int[] arr2 = {3,4,5};
arr[0] = arr1;
arr[1] = arr2;
```

prac:  
```java
//某商场每个季度的营业额如下：
/* 第一季度：22,66,44
*  第二季度：77,33,88
* 第三季度：25,45,65
* 第四季度：11,66,99
* 计算出每个季度的总营业额和全年的总营业额
*/
```

## 方法（method）
是程序中最小的执行单元。  
什么时候用：重复。或者有独立功能的代码抽到方法中  
好处：提高代码复用性；提高代码的可维护性  
方法的定义格式：
```java
public static 返回值类型 方法名(参数) {
   方法体;
   return 返回值;
}
```
### 无返回值方法（void）
void方法表示方法不会返回值（也就是不会return，但是打印什么的还是可以的）
格式：
```java
public static void methodName() {
   your code in here;
}
```
e.g.  
```java
public static void playGame() {
   System.out.println("xxxx");
}
```
void调用：`methodName();`  
e.g. `playGame();`  
ps：方法需要写在main的外面，class的里面；方法需要先定义后调用，否则会报错。

```java
public class Method {
    public static void main(String[] args) {
        //调用void方法
        playGame();
    }

    //定义void方法
    public static void playGame() {
        System.out.println("xxxxx");
        System.out.println("11111");
        System.out.println("22222");
        System.out.println("33333");
    }
}

public class Method3 {
    //在方法里面定义两个变量，并求和打印
    public static void main(String[] args) {
        getSum();
    }
    public static void getSum() {
        int num1 = 10;
        int num2 = 11;
        int sumOf = num1 + num2;
        System.out.println(sumOf);
    }
}
```
#### void带参数的方法定义和调用
格式：  
```java
public static void methodName(parameter, para2) {
   your code in here;
}
```
e.g.  
```java
public static void method(int number, int number2) {
   xxxxxx;
}
```
ps: 方法调用时，参数的数量与类型必须与方法定义中小括号里面的变量一一对应，否则会报错。

```java
public class Method4 {
    public static void main(String[] args) {
        getSum(10,20);
    }
    public static void getSum(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println(sum);
    }
}
```
### 形参和实参（parameters & arguments）
```java
public class Example {
    public static void printSum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        
        printSum(num1, num2); // 这里的 num1 和 num2 是实参，传递给 printSum 方法的参数
    }
}
```
printSum方法中的a和b是形参，它们在方法定义中声明。而在main方法中，num1和 num2是实参，它们是在方法调用时传递给printSum方法的值。（简单来说就是定义方法是括号里面的变量都是形参，main中定义值的是实参）

prac:
```java
// 计算长方形周长
public class Method5 {
    public static void main(String[] args) {
        calRectangle(10,5);
    }
    public static void calRectangle(double length, double width) {
        double perimeter = 2 * (length + width);
        System.out.println("perimeter is " + perimeter);
    }
}

//求圆面积
public class Method6 {
    public static void main(String[] args) {
        circleAre(3);
    }
    public static void circleAre(double r) {
        double area = Math.PI * r * r;
        System.out.println("circle area is " + area);
    }
}
```
### 带返回值方法
格式：  
```java
public static 返回值类型 methodName(parameter, para2) {
   your code in here;
   return 返回值;
}
```
#### 调用方法：
直接调用：方法名（实参）；`getSum(20);`  
赋值调用：整数类型 变量名 = 方法名(实参); `int num = getSum(20,10);`  
输出调用：System.out.println(方法名（实参）);

### summary
什么时候用到有返回值方法？
在调用处根据方法的结果，去编写另一段代码。

- 方法不调用就不执行
- 方法与方法之间是平级关系，不能互相嵌套定义（就是不能在方法里面在在一个方法例如public main里面写一个public void）
- 方法执行顺序和编写顺序无关。
- 方法的返回值类型为void，表示该方法没有返回值，没有返回值的方法可以省略return语句不写。如果要编写return，后面不能跟具体的数据。（例如void方法里面写一个return; -- 这个表示void方法结束）

### 方法重载
- 在同一个类当中，定义了多个<span style="color:red">同名的方法</span>，这些同名的方法具有同种的功能。
- 每个方法具有<span style="color:red">不同的参数类型或参数个数</span>，这些同名的方法，就构成了重载关系。
- 简单来说就是，同一个类，方法名相同，参数不同的方法，与返回值无关（也就是public static后面是啥是不看的，只看方法名和括号里面是不是不一样，详情见例子）。
  - 参数不同：个数不同，类型不同，顺序不同。  

ps：参数顺序不同也可以构成重载，但是不建议

e.g.  
```java
//以下例子，两个fn方法不构成overload
public class Method {
    public static void fn(int a) {
        xxxx;
    }
    public static int fn(int a) {
        xxxx;
    }
} 

//以下列子，两个fin方法构成overload关系
public class Method2 {
    public static float fin(int a) {
        xxxx;
    }
    public static int fin(int a, int b) {
        xxxx;
    }
} 
```
额外小知识：  
`System.out.print(i);` 先打印i，在进行换行  
`System.out.println(i);` 只打印i，不换行  
`System.out.println();`不打印任何数据，只做换行处理

JVM怎么判断你要是用哪个方法：会通过参数的不同来区分同名的方法。

prac1：
```java
// 设计一个方法用于数组遍历，要求遍历结果在一行[11,22,3,6,2]
public class Method7 {
    public static void main(String[] args) {
        int[] list = {22,3,6,9,14,17};
        allList(list);
    }
    public static void allList(int[] a) {
        System.out.print("[");
        for (int i:a) {
            if (i == a[a.length-1]) {
                System.out.print(i);
            } else {
                System.out.print(i + ",");
            }
        }
        System.out.print("]");
    }
}
```

prac2:
```java
//设计一个方法，求数组最大值，并返回最大值
public class Method8 {
    public static void main(String[] args) {
        int[] arr = {4,3,10,8,99};
        System.out.println(max(arr));
    }
    public static int max(int[] a) {
        int max = a[0];
        for (int i:a) {
            if (max <= i) {
                max = i;
            }
        }
        return max;
    }
}
```

prac3:
```java
//定义一个方法判断数组中某一个数是否存在，将结果返回给调用处。
public class Method9 {
    public static void main(String[] args) {
        int[] arr = {1,3,45,7,3,6};
        int n = 7;
        System.out.println(isExist(arr,n));
    }
    public static boolean isExist(int[] a, int b) {
        for (int i:a) {
            if (b == i) {
                return true;
            }
        }
        return false;
    }
}
```

prac4:
```java
//定义一个方法copyOfRange(int[] arr, int from, int to);
//将数组arr中从索引from（包含from）开始。到索引to结束（不包含to）的元素复制到新的数组，将数组返回。
public class Method10 {
    public static void main(String[] args) {
        int[] arr = {5,9,19,43,8,34,76};
        for (int i:copyOfRange(arr, 2, 5)) {
            System.out.print(i + " ");
        }
    }
    public static int[] copyOfRange(int[] arr, int from, int to) {
        int[] newArr = new int[to-from];
        int index = 0;
        for (int i = from; i < to; i++) {
            newArr[index] = arr[i];
            index++;
        }
        return newArr;
    }
}
```

### 方法的内存
#### 方法调用的基本内存原理
方法被调用后就会进栈执行。

#### 方法传递基本数据类型和引用数据类型的内存原理
传递基本数据类型时，传递的是真实数据，形参的改变，不影响实际参数的值。
传递引用数据类型时，传递的是<span style="color:red">地址值</span>，形参的改变，影响实际参数的值。

## 面向对象Object-oriented
那对应的东西做对应的事。

### 类和对象
#### 类
类（设计图）：是对象共同特征的描述。
对象：是真实存在的具体东西。
java中必须先设计类，才能获得对象。

#### 如何定义类：
类名里面需要包括：(和以前不一样，方法可以不需要加static)
1. 成员变量（代表属性，一般是名词）
2. 成员方法（代表行为，一般是动词）
3. 构造器
4. 代码块
5. 内部类
  
e.g.  
```java
public class Phone{ <---- 类名
    String brand;
    double price;
    public void call() {

    }
    public void playGame() {

    }
}
```
#### 如何得到类的对象
类名 对象名 = new 类名();
e.g. `Phone p = new Phone();`

#### 如何使用对象
访问属性：对象名.成员变量
访问行为：对象名.方法名(...)

#### 类的几个补充注意事项
- 用来描述一类事物的类，叫做<span style="color:red">Javabean类</span>
  在javabean类中，是不写main方法的。
- 以前编写main方法的类叫做<span style="color:red">测试类</span>
  可以在测试类中创建javabean类的对象并进行赋值调用

定义类的时候注意：
- 类名首字母大写，需要见名知意，驼峰模式
- 一个java文件中可以定义多个class类，且只能一个类是public修饰，而且public修饰的类名必须成为代码文件名。<span style="color:red">实际开发中建议还是一个文件定义一个class类</span>
- 成员变量的完整定义格式：<span style="color:red">修饰符 数据类型 变量名称 = 初始化值；</span>一般无需指定初始化值，存在默认值。

#### 对象的成员变量的默认值规则
```
数据类型                 明细                    默认值
基              byte, short, int, long             0
本                  float, double                 0.0
类                      boolean                  false
型

引用类型    Class, interface, Array, String      null
```

### 封装 Encapsulation
定义：就是用类设计对象处理某个事物的数据时，应该把要处理的数据，以及处理这些数据的方法涉及到以恶搞对象中去。  
如何正确设计对象的属性和方法  
需求：定义一个类描述人  
属性：姓名，年龄  
行为：吃饭，睡觉  

需求：人画圆
```java
public class Person {}
public Circle {
    double radius;
    public void draw(){
        sout(radius)
    }
}
```
对象代表什么，就得封装对应的数据，并提供对应的行为
#### 封装的好处
- 数据隐藏：封装允许你将数据属性标记为私有（private），只能通过类的公共方法来访问，这样可以防止不合法的修改或直接访问，确保数据的完整性和安全性。

- 接口一致性：通过封装，你可以定义类的公共接口，这是外部代码与类交互的唯一方式。这使得代码更容易理解和维护，因为只需要关注公共方法而不必担心内部实现的改变。

- 隐藏实现细节：封装使得类的内部实现细节可以自由修改，而不会影响外部代码。这提高了代码的可维护性，允许你在不破坏现有接口的情况下进行改进。

- 隔离错误：封装可以帮助隔离错误，因为外部代码不能直接访问或修改内部状态。如果出现问题，你可以更容易地定位问题并进行修复。

- 简化代码：封装使得类的使用更简单，外部代码不需要了解类的内部实现细节，只需调用公共方法即可。这可以降低使用类的复杂性，提高代码的可读性。

#### 封装的设计规范
合理隐藏，合理暴露（利用private和set/get method）

#### private关键字
- 是一个权限修饰符
- 可以修饰成员（变量和方法）
- 被private修饰的成员只能在本类中才能访问
- 针对private修饰的成员变量，如果需要被其他类使用，提供相应操作（get和set方法）
```java
public class Girl{
    private String name;
    private int age;
    private String gender;
}
```
但是上述有一个问题，想要调用Girl girl = new Girl();
无法传参了，下面是解决方法：
```java
public class Girl{
    private int age;
    public void setAge(int a) {
        if (a >= 18 and a <= 50) {
            age = a;
        } else {
            sout("error age");
        }
    }

    public int getAge() {
        return age;
    }
}
```
一般设置了private变量都会写一个set和get方法，通常set都是void，get就是看private变量什么属性

#### 为什么要用private
因为如果不使用private，就会造成随意赋值的操作，例如s1.score = -99;这显然是不合理赋值，所以必须使用private限制直接赋值，但可以写一个set method来进行筛选赋值

### 实体类
特殊形式的类：
1. 这个类中的成员变量都要private，并对外提供相应的getXX，setXX的方法。
2. 类中必须有一个公共的无参构造器。
特点：
成员变量必须private，且要为他们提供get，set方法，必须有无参数构造器。
仅仅只是一个用来保存数据的java类，可以用它创建对象，保存某个事物的数据。

应用场景：  
实体类对应的时软件开发里现在比较流行的开发方式，数据和数据的业务处理相分离。
### this 关键字
如果不用this，当两个变量名字相同，那就会返回null
#### 成员变量和局部变量
```java
public class Girl {
    private int age = 20; //成员变量
    public void method() {
        int age = 10; //局部变量
        sout(age); //此时返回10，如果改成this.age那就是返回20
    }
}
```
就近原则，谁离我近，我就使用哪个变量
如果使用this，那就是使用成员变量，而不是局部变量了

### 构造器
```java
public class Student{
    修饰符 类名（参数）{
        方法体；
    }
    public Student(){}
    public Student(int age, String name) {}
}
```
特点：
1. 方法名与类名相同，大小写也要一致
2. 没有具体返回值，连void都没有
3. 没有具体的返回值（不能由return带回结果数据）  

注意：
1. 创建对象的时候，由虚拟机调用，不能手动调用构造方法
2. 每创建一次对象，就会调用一次构造方法
3. 如果没有写任何方法，虚拟机会默认给一个无参数构造器
4. 如果定义了构造器，那系统将不会提供默认构造器

构造器的重载(overload)：  
带参构造器，与无参数构造器，两者方法名相同，但是参数不同，这就是构造器重载。 

推荐：  
无论是否适用，都手动书写构造器，和带全部参数的构造器。

#### 构造器总结
作用：
创造对象的时候，有虚拟机自动调用，给成员变量进行初始化  
构造器有几种？各自作用？  
无参数构造器：初始化对象  
有参数构造器：初始化时，给对象赋值  

### 标准Javabean
规则：
类名要见名知意
成员变量使用private
提供至少两个构造器
提供每个成员变量对应的get和set方法

### 局部变量和成员变量对比
1. 在类的位置不同：成员变量（类中，方法外）；局部变量（常见于方法内）
2. 初始化值不同：成员变量（有默认值，不需要初始化赋值）；局部变量（没有默认值，使用之前必须初始化赋值）
3. 内存位置不同：成员变量（存在于堆内存-因为严格意义上来说是new出来的）；局部变量（存在于栈内存）
4. 作用域不同：成员变量（整个对象）；局部变量（在所归属的大括号内）
5. 生命周期不同：成员变量（与对象同生共死）；局部变量（方法调用而生，方法结束而死）

### static
静态，可以修饰成员变量、成员方法。
成员变量按照有无static修饰，分为两种：
- 类变量：有static修饰，属于类，在计算机里只有一份，会被类的全部对象共享。
- 实例变量（对象的变量）：无static修饰，属于每个对象的。

// TODO ---------------------------------------------------------------------

```java
public class Student {
    //类变量（访问：类名.类变量）
    static String name;

    //实例变量
    int age;
}
```

### 面向对象（object oriented programming）总结
面向：拿或者找
对象：东西
面向对象：把现实世界中的事物看成一个一个对象来解决问题-万物皆对象（拿或者找东西过来解决编程）
好处：让代码符合人类的思维习惯，编程程序更简单，更容易理解。

类（设计图）：相同事物共同特质的描述
对象：对象是类的具体实例
ps：在java中要先定义类，才能得到对象。

定义类：
1. 类名驼峰法
2. 一个java文件可以定义多个类，但是只能有一个类是public修饰，而且这个类必须和java文件名一样

## API
1. 同一个包下的程序，可以直接访问。
2. 访问其他包下的程序，必须导包才可以访问
3. 自己的程序中调用java提供的程序，也需要先导包才可以使用；注意java.lang包下的程序是不需要我们导包的，可以直接使用。
4. 访问多个其他包下的程序，这些程序名义又一样的情况下，默认只能导入一个程序，另一个程序必须带包名和类名来访问。
### String
是什么？可以做什么？  
代表字符串，可以用来创建对象封装字符串数据，并对其进行处理。  

String类创建对象封装字符串数据的方式有几种？  
1. 直接使用双引号`"hello world"`
2. new String类，调用构造器初始化字符串对象

#### String提供的常用字符串数据操作方法
`length()` : 获取字符串长度  
`charAt(int index)` ： 获取某个索引位置处的字符返回  
`toCharArray()` ：价格当前字符串换成字符数组返回  
`equals(object anObject)` ：判断当前字符串与另一个字符串的内容一样，一样返回true  
`equalsIgnoreCase(String anotherString)` ：判断当前字符串与另一个字符串的内容是否一样（忽略大小写）  
`substring(int beginIndex, int endIndex)` ：根据开始和结束索引进行截取，得到新的字符串（包前不包后）  
`substring(int beginIndex)` ：从传入的索引处截取，截取到末尾，得到新的字符串返回  
`replace(CharSequence target, CharSequence replacement)` ：使用新值，将字符串中的旧值替换，得到新的字符串  
`contains(CharSequence s)` ：判断字符串中是否包含某个字符串  
`startsWith(String prefix)` ：判断字符串是否以某个字符串内容开头，是返回true，反之false  
`endsWith(String suffix)` ：判断字符串是否以某个字符串内容结尾，是返回true，反之false  
`split(String regex)` ：把字符串按照某个字符内容分割，并返回字符串数组回来  

e.g.
```java
    public static void main(String[] args) {
        String s = "itemString";
        String s2 = "itEMstring";
        String res = new String("itemString");
        // length()
        System.out.println(s.length()); //10
        System.out.println(s.charAt(4)); //S
        System.out.println(s.toCharArray()[1]); //t
        System.out.println(s.equals(res)); //true
        System.out.println(s.equalsIgnoreCase(s2)); //true
        System.out.println(s.substring(0, 4)); //item
        System.out.println(s.substring(4)); //String
        String s3 = "This is silly content!";
        System.out.println(s3.replace("silly", "***")); //This is *** content!
        System.out.println(s.contains("item")); //true
        System.out.println(s.startsWith("item")); //true
        System.out.println(s.startsWith("string")); //false
        System.out.println(s.endsWith("String")); //true
        String[] a = s3.split(" ");
        for (String string : a) {
            System.out.println(string);
        }
        //This
        //is
        //silly
        //content!
    }
```

#### String注意事项
1. String对象的内容不可改变，被称为不可变字符串对象（immutable）
2. 只要是以"..."方式写出的字符串对象哎，会存储在字符串常量池（堆内存里的），且相同内容的字符串只储存一份。但通过new方式创建字符串对象，每new一次就会产生一个新的对象放在堆内存中。（这样设计是为了节约内存）
3. jdk7以上StringTable(串池)从方法区移动到堆内存（new出来的对象都在这里）

总结：
直接赋值的是在字符串常量池里面的，这个池子是通用的，但是new出来的是进入堆了的，和StringTable(串池)不是一个地址。
```java
String s1 = new String("abc");
String s2 = "abc";
sout(s1 == s2); //false
```
practice 1:
参考下面例子，首先main先进栈内存，然后看s1的值有没有存在串池，此时发现没用存在，那就在堆内存的StringTable（串池）创建一个地址，之后看s2是不是new，不是，而且串池里面已经有这个地址了，就直接复用就行。这样可以节约内存。
```java
public class demo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
    }
}
```

practice 2:
```java
public class Test {
    public static void main(String[] args) {
        //进入常量池
        String s1 = "abc";
        String s2 = "ab";
        //有运算的时候会进堆里面(s2是一个变量，没办法做到自动转化，所以会进堆)
        String s3 = s2 + "c";
        System.out.println(s1 == s3); //false

        //在常量池
        String s4 = "abc";
        String s5 = "a" + "b" + "c"; //编译器会直接转化成abc
        System.out.println(s4 == s5); //true
    }
}
```

practice 3:
如下所示，栈内存先是方法main，然后看ch，创建新的，堆内存存abc及它三个字母地址，栈内存存一个ch并将堆内存地址0x0011写上，再到s1，因为new了一个对象，要去堆内存开一个新的空间，传这个地址0x0022给栈内存的s1；再看s2，也是new了一个对象，要去堆内存开一个新的空间，传这个新地址0x0033给栈内存的s2.
```java
public class demo {
    public static void main(String[] args) {
        char[] ch = ('a', 'b', 'c');
        String s1 = new String(ch);
        String s2 = new String(ch);
    }
}
```

practice 4:
- charAt(int index)根据索引返回字符串
- length()返回字符串长度，注意数组长度写法a.length;字符串长度写法a.length()
- 大小写ascii码 or `str >= 'a' && str <= 'z'` or `str >= 'A' && str <= 'Z'`,注意这样写有个问题，因为是自动转换ascii码表，所以0-9会有变化，就要写成`str >= '0' && str <= '9'`

practice 5:
数组int[] arr = [1,2,3];
返回结果：[1,2,3]
```java
    public static String arrToString(int[] arr) {
        if (arr == null) {
            return "";
        }
        if (arr.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                result += arr[i];
                result += ", "
            } else {
                result += arr[i];
            }
            
        }
        return result + "]";
    }
```

practice 6:
输入abc，返回cba
```java
    public static String arrConverse(String str) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        String result;
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);  
        }
        return result;
    }
```
#### String 对比
`==`对比的是什么？  
- 如果是基本数据类型：那就是对比数据值。
  ```java
    int a = 10;
    int b = 10;
    sout(a==b); //return true
  ```
- 如果是引用数据类型，就是对比地址值。
    ```java
    String a = new String("abc");
    String b = new String("abc");
    sout(a==b); //return false
  ```

### StringBuilder
什么是StringBuilder？  
是一个容器，创建后内容可变。  
作用：提高字符串操作效率
e.g.  
```java
String a = "ab";
String b = "bc";
String c = "cd";
StringBuilder sb = new StringBuilder();
sb.append(a);
sb.append(b);
sb.append(c);
sout(sb.toString());
```
构造方法：  
- StringBuilder() 
- StringBUilder(String str)  
常用方法：
- append(任意类型)
- reverse()
- length()
- toString()

ps:打印StringBuilder是打印属性值，不是地址值，因为是java已经写好的类。

什么时候会用到StringBuilder？  
字符串拼接或反转的时候。

practice 1:
字符串12321，是对称字符串返回true，而112233不是，返回false.
(思路：反过来和正着是一样的，就是对称)
```java
public static Boolean syn(String str) {
    StringBuilder sb = new StringBuilder(str).reverse().toString();
    return str.equals(sb);
}
```
practice 2:
数组int[] arr = [1,2,3];
返回结果：[1,2,3]
```java
public static String combine(int[] arr) {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < arr.length; i++ ) {
        if (i == arr.length - 1) {
            sb.append(arr[i]);
        } else {
            sb.append(arr[i]).append(", ");
        }
    }
    return sb.append("]").toString();
}
```

### StringJoiner
和StringBuilder差不多，jdk8才出现。
StringJoiner构造方法：  
StringJoiner(间隔符号);  
StringJoiner(间隔符号, 开始符号, 结束符号);  

成员方法:  
add() - 和builder的append差不多  
length() - 所有字符总个数  
toString()  

practice 1:  
数组int[] arr = [1,2,3];
返回结果：[1,2,3]
```java
public static String combine(int[] arr) {
    StringJoiner sj = new StringJoiner(", ","[", "]");
    for (int i = 0; i < arr.length; i++) {
        sj.add(arr[i] + "");
    }
    return sj
}
```
### summary
1. 字符串的比较使用==比较好吗？为什么？什么时候使用==？
不好，==比较地址，容易出问题，建议用equals；基本数据类型的变量或者值应该使用==比较

2. 开发中比较字符串推荐使用什么方式比较？
用equals方法或者equalsIgnoreCase

3. =和new的不同：
=创建出来的是存在堆内存的串池里面，而new是直接在堆内存开辟一个空间。

4. StringBuilder和StringJoiner的区别：
- StringBuilder: 
  - 一个可变的操作字符串容器。
  - 高效拼接字符串，还能反转内容。

- StringJoiner：
  - 高效拼接字符串，算半个StringBuilder升级版。

5. 字符串拼接的底层原理：
- 如果是`String s = 'a'+'b'+'c';`,会触发优化机制，自动整合成一个（复用串池字符串）。 自动编译成：String s = "abc";
- 如果是有加值的，`String s = 'a'; String s1 = s+'b'; String s2 = s1+'c';`, 流程图：串池里有a和b，然后new StringBuilder， 利用append方法加入新的字符串。 每行都创建一个StringBuilder。注意一个+至少两个对象。
jdk8新机制预估，系统预估拼接之后的总大小，把要拼接的内容放在数组中，产生一个新字符串(类似new出来)。建议是拼接string最好不要用+，用StringBuilder或者StringJoiner。
注意，StringBuilder的容量就是int最大值。

6. StringBuilder源码
- 创建一个字节数组，默认容量16（不是长度，是容量，容量是最多放多少，长度是已经放了多少）  
- 如果容量不够，它会自己扩容，老容量*2+2=34. 如果超出扩容，例如现在36，那就将现在容量变成36，以实际长度为准。  
- StringBuilder.capacity()可以看容量。

## ArrayList
对容器进行操作都有那些方法：
增删改查

ArrayList()构造器初始容量为10，但是随着内容变多，会自动扩容

### arraylist常用方法
`add(E e)` :将特定元素添加到集合的末尾
`add(int index, E element)` :再次集合中的指定位置插入指定的元素
`get(int index)` :返回指定索引处的元素
`size()` :返回合集中的元素个数
`remove(int index)` :删除指定元素处的元素，返回被删除的元素
`remove(Object o)` :删除指定元素处的元素，返回删除是否成功
`set(int index, E element)` :修改指定索引，返回被修改的元素

ps：关于删除部分，如果要删除的数据，在list中出现多次，默认删除最先出现的那个。

e.g.
```java
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("123world");
        list.add("768");
        list.add("hello");
        System.out.println(list); //[hello, 123world, 768, hello]

        list.add(1, "MySQL");
        System.out.println(list); //[hello, MySQL, 123world, 768, hello]

        String s = list.get(1);
        System.out.println(s); // "MySQL"

        System.out.println(list.size()); //5

        System.out.println(list.remove(1));
        System.out.println(list); //[hello, 123world, 768, hello]

        System.out.println(list.remove("hello"));
        System.out.println(list); //true
        //[123world, 768, hello]

        System.out.println(list.set(1, "Java develop")); //768
        System.out.println(list); //[123world, Java develop, hello]
    }
}
```
#### summary
1. 集合是什么？有什么特点？
一种容器，用来储存数据；集合的大小可变
2. ArrayList是什么？怎么使用？
集合中最常用的，ArrayList是泛型类，可以约束储存的数据类型
创建对象，调用无参数构造器初始化对象：public ArrayList（）；
调用相应的增删改查数据的方法
3. ArrayList提供了哪些常用方法？
如上所示

practice:
从集合中删除元素(两种方法)
```java
public class Cart {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println(list);
        // method 1
        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);
            if (a.contains("枸杞")) {
                list.remove(a);
                i--;
            }
        }

        // method 2
        for (int i = list.size()-1; i >= 0; i--) {
            String a = list.get(i);
            if (a.contains("枸杞")) {
                list.remove(a);
            }
        }
        System.out.println(list);
    }
}
```
summary：
遍历集合，并删除指定元素，如何不出bug：
方法1：每次删除一个数据后，索引-1
方法2：倒叙遍历

#### String和ArrayList总结
##### String常用方法：
- 判断字符串内存：
  - equals()
  - equalsIgnoreCase()
- 字符串每个字符：`a.charAt(i)`
- 字符串中的第i个字母：`chars[i]`
- 截取字符串：
  - `substring(int beginIndex)`
  - `substring(int beginIndex, int endIndex)`
- 根据replacement替换target部分内容：`replace(CharSequence target, CharSequence replacement)`
- 字符串是否包含s：`contains(CharSequence s)`
- 根据某个字符分割字符串：`splite(String s)`

##### Arraylist
特点：是集合，大小可变，类型可以不固定，适合当元素个数不能确定时用
##### 泛型
集合都是支持泛型的，e.g.`ArrayList<E>`也就是啥类型都能接受  
如果想要固定类型那就：`ArrayList<String> list = new ArrayList()`  
集合和泛型都不支持基本数据类型，只能支持引用数据类型例如里面只能写Integer不能写int。`ArrayList<Integer> list = new ArrayList()`
注意：以后定义集合都应该采用泛型（实在不行用object也行）
##### Arraylist常用方法
- `add(E e)`
- `get(int index)`
- `size()`
- `remove(int index)`
- `set(int index, E element)`

注意：集合容器中存储的每个对象是什么东西？存的在堆内存中的地址。

### Static
如果要用static修饰：
- 被static 修饰的成员变量（静态变量）
  - 特点：被该类所以对象共享；静态变量是随着类的加载而加载的，优先于对象的出现；不属于对象，属于类。
  - 调用方式：
    - 类名调用（推荐这个）
      `Student.teacherName = "wilson"; Student student = new Student();`
    - 对象名调用

- 被static修饰的成员方法（静态方法）
  - 特点：多用在测试类和工具类中；javabean类中很少用
  - 调用方法：
    - 类名调用（推荐）
    - 对象名调用

static String teacherName;先存在堆内存（静态区）；方法main在栈内存  
什么时候使用static？  
当多个对象共享同一个变量的时候，就加上static。  

类的种类：
- Javabean：用来指描述一类事物的类，比如，Student，Teacher，Dog等。
- 测试类：用来检查其他类是否书写正确的，带有main方法的类，程序入口。
- 工具类：不是用来描述一类事物的，而是帮我们做一些事情的类。

工具类： 
1. 类名要知其意
2. 私有化构造方法
3. 方法定义为静态

#### Summary
- 静态方法只能访问静态变量和静态方法（因为静态方法会访问静态区，但是非静态区的变量不存在静态区；顺便静态变量属于类，现在对象都没创建那肯定引用不了的）
- 非静态方法可以访问静态变量或者静态方法，也可以访问非静态成员变量和非静态成员方法。
- 静态方法中是没用this关键字。

简单来说就是：静态方法中，只能访问静态。非静态方法可以访问所有。静态方法中没有this关键字。

### 继承 Inheritance
什么时候用继承？
当类与类之间，存在相同的内容，并满足子类是父类的一种。

继承的格式：
public class 子类 extends 父类 {}

继承后子类的特点：
- 可以使用父类的属性和行为，可以在父类基础上增加其他功能。
- Java只支持单继承不支持多继承。（一个子类不能继承多个父类，一个子类只能继承一个父类）
- 但是可以多层继承，子类A继承父类B，父类B可以继承父类C。（此时子类A是类C的间接类）
- 每个类都直接或间接继承于Object类。
- 子类只能访问父类非私有成员（也就是private类是没法访问）

设计继承核心：
- 共性内容抽取
- 子类是父类的一种
- 画图的时候从下往上画，写代码从父类往子类写

practice 1:  
A: 吃饭，喝水，抓老鼠  
B：吃饭，喝水，抓老鼠  
C：吃饭，喝水，看家，拆家  
D：吃饭，喝水，看家，乱跑  

继承划分：  
步骤1：  
猫（吃饭，喝水，抓老鼠）：A和B  
狗（吃饭，喝水，看家）：C（拆家）和D（乱跑）  

步骤2：  
宠物（吃饭，喝水）：猫（抓老鼠）和狗（看家）  

子类到底能继承父类中哪些内容？  
- 内存图  

| 分类 | 私有是否 | private |
|------|--------|---------|
| 构造方法 | 非私有 不能（被子类继承）| private不能（被子类继承）|
| 成员变量 | 非私有 能 |  private能 |
| 成员方法 | 非私有 能 | private不能 |

#### summary
成员变量的访问特点：就近原则 - 谁离我近，我就用谁  
e.g.  
```java
public class Fu {
    String name = "Fu";
}
public class Zi extends Fu {
    String name = "Zi";
    public void show() {
        String name = "zi";
        sout(name);
    }
}

// print out zi
```

e.g. 2  
```java
public class Fu {
    String name = "Fu";
}
public class Zi extends Fu {
    String name = "Zi";
    public void show() {
        String name = "zi";
        sout(name);
        sout(this.name);
        sout(super.name)
    }
}
```
##### summary
先在局部位置找(varible)，本类成员位置找(this.variable)，父类成员位置找(super.variable)，逐级往上。

成员方法的访问特点：  
和成员变量是一样的。  
e.g. 1  
```java
public class Fu {
    String name = "Fu";
    public void test1() {}
    public void test2() {}
}
public class Zi extends Fu {
    String name = "Zi";
    public void show() {
        String name = "zi";
        this.test1();
        this.test2();

        super.test1();
        super.test2();
    }
}
```

#### 构造方法特点
- 父类中的构造方法不会被子类继承
- 子类所有的构造方法默认先访问父类中的无参构造，在执行自己。(因为子类在初始化的时候，有可能会使用到父类中的数据，如果父类没用完成初始化，子类将无法使用父类的数据。)
- 子类初始化之前，一定要调用父类构造方法先完成父类数据空间的初始化。（这也就是为啥子类一开始第一行都是`super()`，不写也存在）
- 默认先访问父类中无参的构造方法，在执行自己的，如果想要访问父类有参构造，必须手动书写。
```java
//parent
public class Fu {
    String name;
    int age;
    public Fu(){}
    public Fu(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
//child
public class Zi extends Fu {
    public Zi() {

    }
}
```

### this和super的总结
- this: 理解为一个变量，表示当前方法调用者的地址值。
```java
public class Student {
    String name;
    int age;
    public void show() {
        sout(name+"..."+age);
    }
    //相当于public void show(Student this)
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "abc";
        s.age = 12;
        s.show();
    }
}
```
- super: 代表父类储存空间。

|关键字|访问成员变量|访问成员方法|访问构造器方法|  
|-----|----------|-------------|------------|
|this|this.成员变量<br>访问本类成员变量|this.成员方法(...)<br>访问本类成员方法|this(...)<br>访问本类构造方法|
|super|super.成员变量<br>访问父类成员变量|usper.成员方法(...)<br>访问父类成员方法|super(...)<br>访问父类构造方法|

### 方法重写：
当父类的方法不能满足子类现在的需求时，需要进行方法重写。  
格式：`@Override`  
本质：是基于继承结构的
|内容|A类|B类|C类|
|----|---|---|---|
|方法名|method2|method2|method1 & method2|
|虚方法表|C:method1 & A:method2|C:method1 & B:method2| method1 & method2|
#### summary
1. 重写方法的名称，形参列表必须与父类中的一致。
2. 子类重写父类方法时，访问权限子类必须大于等于父类（`空着不写<protected<public`）
3. 子类重写父类方法时，返回值类型子类必须小于父类（建议：重写的方法尽量和父类保持一致）
4. 私有方法和静态方法还有final的不能被重写（其实就是这俩没办法被添加到虚方法表。所以说只有能被添加到虚方法表的，才能被重写）
e.g.  
假设这里有父类Animal和子类Dog&Cat。父类不能写public Dog巴拉巴拉，然后子类写public Animal巴拉巴拉。
```java
public class Person {
    public Animal eat() {
        return null;
    }
    public Dog eat() {
        return null;
    } // will show error
}
class Student extends Person {
    public Animal eat() {
        return null;
    }
    public Dog eat() {
        return null;
    }
    public Cat eat() {
        return null;
    }
}
```
### 多态 Polymorphism
同种类型的对象，表现出不同的形态。  
格式：父类类型 对象名称 = 子类对象;  
前提：  
- 有继承关系
- 有父类引用指向子类对象
- 有方法重写

#### 多态调用成员特点
- 变量调用：编译看左边，运行看左边。
```java
Animal a = new Dog();
a.name; //返回Animal里面的name值
a.show();//返回Dog里面的show方法内容
//看左边的父类有没有这个变量，有的话，编译成功，没用就error。
```
- 方法调用：编译看左边，运行看右边。（因为如果子类对父类方法进行重写，在虚方法表里面是会把以前的父类方法覆盖的）

注意：先加载object类，在加载父类，在加载子类

#### 多态优势
- 再多态形式下，右边对象可以实现解耦合，便于扩展和维护
```java
Person p = new Student();
p.work();
```
- 定义方法的时候，使用父类型作为参数，可以接受所有子类对象，体现多态的扩展性和便利。

弊端：  
- 不能使用子类的特有功能。
解决方法：
- 自动类型转换
`Person p = new Student(); `
- 强制类型转换
`Student s = (Student) p`

强制类型转换能解决什么问题？  
- 可以转换成真正的子类类型，从而调用子类独有功能。
- 转换类型与真实对象类型不一致会报错。
- 转换的时候，用`instanceof`进行判断

```java
class Animal {
    public void eat() {
        sout("animal eats something.")
    }
}

class Dog extends Animal {
    @Override
    public void eat() {
        sout("dog eats bone.")
    }
    public void lookHome() {
        sout("stay at home.")
    }
}
class Cat extends Animal {
    @Override
    public void eat() {
        sout("cat eats fish.")
    }
    public void catchMouse() {
        sout("catch mouse")
    }
}

public class Test {
    psvm{
        Animal a = new Dog();
        a.eat(); //"dog eats bone."
        //多态不能调用子类特有的功能
        //也就是a.lookHome()之类的是没有的。

        //解决方案：
        //变回子类型就行
        //注意：转换不能瞎转，例如转成Cat
        //Cat c = (Cat) a;
        //c.catchMouse();
        Dog d = (Dog) a; 
        d.lookHome();

        //jdk14新特性
        //先判断a是不是Dog类型，如果是，强转为Dog类型，之后的变量名为d；false就无事发生。
        a instanceof Dog d;
    }
}
```

### 包 package
命名规则：需要全部英文小写（可以是公司域名反写+包的作用）  
使用其他类时，需要使用全类名。  
作用：类似文件夹，管理不同功能的java类

### final
不希望别人改变的时候使用
- 使用在方法：不能被chongxie
- 使用在类：不能被继承
- 使用在变量：只能被赋值一次（常量）
注意：常量命名需要全部单词大写，多个单词用下划线隔开。例如`final int MAX_NUMBER = 24;`  
如果final修饰基本类型：那存储的数据值不能变；如果修饰引用数据类型，那变量存储的地址值不能变。String内部代码已经加了final，所有final String也不可改。

### 权限修饰符
作用范围：从小到大`private<空着不写<protected<public`
|修饰符|同一个类中|同一个包中其他类|不同包下的子类|不同包下的无关类|
|------|----------|--------------|-------------|---------------|
|private|yes||||
|空着不写|yes|yes|||
|protected|yes|yes|yes||
|public|yes|yes|yes|yes|

- private: 只能自己用
- 默认：只能本包用
- protected：其他包的子类可以用
- public：都能用

### 代码块
- 局部代码块：写在方法大括号里面的（本质是节约内存，但是现在不需要了）
- 构造代码块：就是写在类里面，优先于构造方法执行。（现在基本不用了）
```java
public class Student{
    String name; 
    int age;
    {sout("hello")} //结构代码块
    public void show() {
        
    }
}
```
- 静态代码块：随着类的加载而加载，自动触发只执行一次（一般初始化的时候用）
`static {sout("abc")}`

### 抽象类
- 抽象方法：将共性的行为（方法）抽取到父类之后。由于每一个子类执行的内容时不一样的，所以，在父类中不能确定具体的方法体。
- 抽象类：如果一个类中存在抽象方法，那么该类就必须声明为抽象类。
- 抽象方法格式：`public abstract 返回值类型 方法名(参数列表);` 不写方法体
- 注意事项：
  - 抽象类不能实例化（不能创建对象）。
  - 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类。
  - 可以有构造方法
  - 抽象类的子类
    - 要么重写抽象类中所有抽象方法
    - 要么是抽象类

设计抽象类：
|品种|属性|行为|
|----|----|---|
|frog|name, age|eat bug; drink|
|dog|name,age|eat bone; drink|
|sheep|name,age|eat grass; drink|
多种吃，就可以写抽象方法
Animal(name,age; drink, eat) -> frog(eat bugs)/dog(eat bone)/sheep(eat grass)
`code see abstractDemo2`

#### summary
抽象类作用：抽取共性时，无法确定方法体，就把方法定义为抽象的，强制让子类按照某种格式重写。

### 接口 Interface
定义接口：`public interface 接口名 {}`  
接口不能实例化  
实现接口：`public class Abc implements 接口名 {}`  
接口的子类（实现类）
要么重写接口中的所有抽象方法，要么是抽象类

注意：
- 接口和类的实现关系，可以单实现，也可以多实现`public class Abc implements 接口1, 接口2{}`
- 实现类还可以继承一个类的同时实现多个接口`public class Abc extends parent implements interface1, interface2 {}`

#### 接口成员特点
- 成员变量
  - 只能是常量，默认修饰符public static final
- 构造方法
  - 无
- 成员方法
  - 只能是抽象方法，默认修饰符：public abstract

### 接口和类的关系
- 类和类的关系
  - 继承关系，只能单继承，不能多继承，但可以多层继承
- 类和接口的关系
  - 实现关系，可以但单实现，也可以多实现，还可以在继承一个类的同时实现多个接口（多个接口有重名的只写一个就ok）
- 接口和接口的关系
  - 继承关系，可以单继承，也可以多继承（如果实现类实现类最下面的子接口，那么就需要重写所有的抽象方法）

#### 补充
jdk7以前：接口中只能定义抽象方法  
jdk8新特性：接口中可以定义有方法体的方法。（默认，静态）  
jdk9新特性：接口中可以定义私有方法。  

为什么要改？  
因为以前是只要接口发生变化，所有implement都要改变，很不方便

jdk8之后的接口新增方法：  
- 允许在接口中定义默认方法，需要使用关键字default修饰
  - 作用：解决接口升级问题。
  - 接口中默认方法定义格式：
    - 格式`public default 返回值类型 方法名（参数列表）{}`
    - 规范`public default void show(){}`
  - 接口中默认方法的注意事项：
    - 默认方法不是抽象方法，所以不强制被重写，但是如果被重写，重写的时候去掉default关键字。
    - public可以省略，default不能省略。
    - 如果实现多个接口，多个接口存在相同名字的默认方法，子类就必须对该方法进行重写（不管子类用不用这个方法，因为idea分不清你到底是要调用哪个interface里面的方法，所以干脆强制重写）。
```java
public interface Inter {
    abstract void method();
    default void show() {
        System.out.println("This is a default method");
    }
}
```
- 允许在接口中定义静态方法，需要用static修饰
  - 接口中静态方法定义格式：
    - 格式`public static 返回值类型 方法名（参数列表）{}`
    - 范例`public static void show() {}`
  - 接口中静态方法注意事项：
    - 静态方法只能通过接口名调用，不能通过实现类或者对象名调用
    - public可以省略，static不能省略
```java
public class Test {
    public static void main(String[] args) {
        Inter.show();
    }
}

public interface Inter {
    public static void show() {
        System.out.println("this is static method");
    }
}

```

jdk9新增方法  
接口中私有方法定义
- 格式1`private 返回值类型 方法名（参数）{}`
- 范例1`private void show(){}`
- 格式2`private static 返回值类型 方法名（参数）{}`
- 范例2`private static void show() {}`
```java
//例如以下情况就可以用private
public interface Inter {
    private void method() {
        sout("here exits 100 lines code")
    }
}
```

#### 适配器设计模式 Adapter design pattern
- 设计模式(design pattern)：一套反复使用，多数人知晓的，经过分类编目的，代码设计经验总结。使用设计模式是为了可重复代码，让代码更容易被他人理解，保障代码可靠性，程序重要性。
- 什么时候使用适配器？
  - 当一个接口抽象方法过多，但是我只想使用其中一部分的时候
  - 步骤：1. 添加一个中间类（XXXAdapter），实现对应接口，对接口中的抽象方法进行空实现，让真正的实现类继承中间类，并重写需要用的方法。为了避免其他类创建适配器类的对象，中间的适配器类用abstract进行修饰。
```java
public abstract class InterAdapter implements Inter{
    @Override
    public void method() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }

    @Override
    public void method5() {

    }
}

public interface Inter {
    void method();
    void method2();
    void method3();
    void method4();
    void method5();
}

public class InterImpl extends InterAdapter {
    @Override
    public void method5() {
        System.out.println("print method 5");
    }
}
```
### 内部类
在一个类里面，在定义一个类。  
e.g. 在A类的内部定义B类，B类就被称为内部类  
规则：
- 内部类表示的事物是外部类的一部分。
- 内部类单独出现没用任何意义。

特点：
- 内部类可以直接访问外部类的成员，包括私有。
- 外部类要访问内部类的成员，必须创建对象。
```java
public class Outer { //外部其他类
    public class Inner { //内部类

    }
}
```
practice1  
```java
public class Car {
    String carName;
    int carAge;
    int carColor;
    class Engine {
        String engineName;
        int engineAge;
    }
}
```
#### 成员内部类
可以被修饰符修饰，例如private, 不写，protected, public, static等  
注意，jdk16之前不能定义静态变量，之后可以

创建内部类对象：
- 在外部类编写方法，对外提供内部类对象。
- 直接创建`外部类格式.内部类名 对象名 = 外部类对象.内部类对象;`

#### 静态内部类
- 只能访问外部类中的静态变量和静态方法，如果想要访问非静态的需要创建对象。  
- 创建静态内部类对象的格式：`外部类名.内部类名 = new 外部类名.内部类名();`
- 调用非静态方法格式：先创建对象，用对象调
- 调用静态方法格式：`外部类.内部类名.方法名();`
- 例子看oopinnerclassdemo2

#### 匿名内部类

本质上就是隐藏了名字的内部类。
格式：
```java
new class/interface name {
    override method;
};

new Inter() {
    public void show() {

    }
};
```

practice 1:  
```java
public class Test {
    public static void main(String[] args) {
        new Swim() {

            @Override
            public void swim() {
                System.out.println("new interface override");
            }
        };
    }
}

public interface Swim {
    void swim();
}

```
#### 局部内部类
1. 将内部类定义在方法里面的就叫局部内部类，类似于方法里面的局部变量
2. 外界是无法直接使用，需要在方法内部创建对象并使用。
3. 该类可以直接访问外部类成员，也可以访问方法的局部变量。
demo看oppinnerclassdemo3

#### summary of inner class
什么是内部类？  
写在一个类里面的类。  

什么时候用到内部类？  
B类表示的事物是A类的一部分，且B单独存在没有意义。（例如：汽车发动机，ArrayList迭代器，人的心脏等）

### 常用API
#### Math
|method|方法名|说明|
|------|------|----|
|public static int|abs(int a)|绝对值 absolute value|
|public static double|ceil(double a)|向上取整 round up|
|public static double|floor(double a)|向下取整 round down|
|public static int|round(float a)|四舍五入 round|
|public static int|max(int a, int b)|两个数取较大值 max number|
|public static int|min(int a, int b)|两个数取较x小值 min number|
|public static double|pow(double a, double b)|a的b次幂的值 a^b|
|public static double|sqrt(double a)|a的平方根 |
|public static double|cbrt(double a)|a的立方根 |
|public static double|random()|返回值为double的随机值,`range[0.0,1.0}`|

```java
Math.abs(-88); //88
//此处有个小bug,int取值范围 -2147483648 - 2147483647
//如果没有正数与负数对应，那么结果就会有误（因为正数比负数少一个
//如果超过int范围可以用Math.absExact()
Math.absExact(-2147483648); //它会报错

Math.pow(4,0.5); //如果第二个数是0-1之间的小数，那就删根号。例如现在就是平方根号4
Math.pow(2,-2); //1/(2^2),相当于0.25

Math.floor(Math.randow() * 100) + 1;
```

practice 1: 判断一个数是否为质数
```java
//最快方法，判断是否能被平方根左边数整除就行。
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
```

practice 2：一个n位自然数等于自身各个数位上数字的n次幂之和
e.g. 1^3 + 5^3 + 3^3 = 153; 1^4 + 6^4 + 3^4 + 4^3 = 1634

#### System
|方法名|说明|
|------|---|
|public static void exit(int status)|终止当前运行的java虚拟机|
|public static long currentTimeMillis(int status)|放回当前系统时间毫秒值形式|
|public static void arraycopy(数据原数组, 起始索引，目的地数组，起始索引，拷贝个数)|数组拷贝|

- 计算机时间原点：1970年1.1 00:00:00  
- 注意：arraycopy必须两组数组基本数据类型一致；如果数组超出长度也会报错；子类数据类型可以赋值给父类
- 1 second = 1000 millisecond
```java
System.exit(0);//虚拟机正常停止
System.exit(1);//虚拟机异常停止

long start = System.currentTimeMillis();//一般用来算一下运行时间
long end = System.currentTimeMillis();
sout(end - start);

int[] arr1 = {1,2,3,4,5,6};
int[] arr2 = new int[10];
System.arraycopy(arr1, 0, arr2, 0, 10)
```
#### Runtime
|方法名|说明|
|------|---|
|public static Runtime getRunTime()|当前系统的运行环境对象|
|public void exit(int status)|停止虚拟机|
|public int availableProcessors()|获取CPU的线程数|
|public long maxMemory()|JVM能从系统中获取总内存大小（单位byte）|
|public long totalMemory()|JVM已经从系统中获取总内存大小（单位byte）|
|public long freeMemory()|JVM剩余内存大小（单位byte）|
|public Process exec(String command)|运行cmd命令|
```java
import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime r1 = Runtime.getRuntime();
        System.out.println(r1.availableProcessors());
        System.out.println(r1.maxMemory() / 1024 / 1024);
        System.out.println(r1.totalMemory() / 1024 / 1024);
        System.out.println(r1.freeMemory() / 1024 / 1024);
        r1.exec("notepad");
        //cmd command: shutdown
        // -s: will shutdown computer after 1 second
        // -s -t: 指定关机时间
        // -a: 取消关机操作
        // -r: 关机并重启
        // r1.exec("shutdown -s -t 3600")
        // r1.exec("shutdown -a")
        r1.exit(0);
        System.out.println("for check");
    }
}
```

#### Object
|方法名|说明|
|------|---|
|public Object()|空参构造|
|public String toString()|返回对象的字符串表示形式|
|public boolean equals(Object obj)|对比两个给对象是否相等|
|public Object clone(int a)|克隆对象|

`System.out.println()`：其中System是一个类名；out是其中的静态变量；println()是方法；参数表示打印的内容；总结：当我们打印一个对象的时候，底层会调用toString方法，把对象变成字符串, 然后再打印到控制台。  
默认情况下，打印对象是打印对象地址值，想显示属性值，就override toString

equals:
- 如果没用override equals方法，那默认使用object中的方法对比，比较的是地址值是否相等
- 如果相对比属性值，那就override equals
```java
String s = "abc";
StringBuilder sb = new StringBuilder("abc");
sout(s.equals(sb)); // false
//看String里面的equals，因为对比不同对象，所以直接返回false
sout(sb.equals(s)); // false
//看StringBuilder里面有没有equals方法，如果没用直接就是object离equals方法。Object里面对比地址值，所以这俩肯定不对。
```
#### shallow copy

#### deep copy

#### Objects

#### BigInterger

#### BigDecima

#### Regular expression