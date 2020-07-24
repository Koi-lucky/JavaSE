package extendstest;

import java.util.Scanner;

/*
java.lang.String类代表字符串。
API当中说：Java程序中的所有字符串字面值（如“abc”）都作为此类的实例体现。
其实就是说：程序中的所有双引号字符串，都是String类的对象。（就算没有new，也照样是）


字符串的特点;
1.字符串的内容永不变，【重点】
2.正是因为字符串不可改变，所以字符串是可以共享使用的。
3.字符串效果上相当于是char[]字符数组，但底层原理是byte[]字节数组。

创建字符串的常见3+1种方式：
三种构造方法：
public String();创建一个空白字符串
public String(char[] array);根据字符数组的内容，来创建对应的字符串
public String(byte[] array);根据字节数组的内容，来创建对应的字符串
一种直接创建：
String str = "hello";//右边直接用双引号

【注意】：不管用不用new,直接写上双引号，就是字符串对象
 */
public class StringMethod {
    public static void main(String[] args) {
        //创建一个空白字符串
        String str1 = new String();
        System.out.println("第一个字符串是：" + str1);

        //根据字符数组的内容来创建字符串
        char[] charArray = {'A','B','C'};
        String str2 = new String(charArray);
        System.out.println("第二个字符串是：" + str2);

        //根据字节数组的内容来创建字符串
        byte[] byteArray = {97,98,99};//数组里面放的是字节数（地址值），97——> a的ASCII值
        String str3 = new String(byteArray);
        System.out.println("第三个字符串是：" + str3);

        //直接用双引号创建字符串
        String str4 = "滴滴滴滴";
        System.out.println("第四个字符串是：" + str4);
    }
}


/*

字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。（字符串常量池中存放的是数据的地址值，常量池存放在堆中）
new了之后，就跟常量池没关系了，地址值直接在堆中。

对于基本类型来说，==是进行数值的比较；
对于引用类型来说，==是进行【地址值】的比较。

【注意事项】：
1.对于引用类型来说，==进行的是地址值的比较
2.双引号直接写的字符串在常量池中，new的不在池当中，跟池没关系。
 */
class StringMethod02 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a','b','c'};
        String str3 = new String(charArray);
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str3 == str2);//false

    }
}


/*
==是进行对象的地址值比较，如果确实需要字符串的内容比较，可以使用两个方法：

public boolean equals(Object obj):参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true;否则返回false.
【注意事项】：
1.任何对象都能用Object进行接收;
2.equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样；
3.如果比较双方一个常量一个变量，推荐把常量字符串写在前面。
推荐写法："abc".equals(str)         不推荐写法：str.equals("abc")

public boolean equalsIngnoreCase(String str):忽略大小写，直接进行内容比较。

 */
class StringEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H','e','l','l','o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals("Hello"));//true
        System.out.println("Hello".equals(str1));//true

        String str4 = "hello";
        System.out.println(str1.equals(str4));//false
        System.out.println("===================");

        String str5 = null;
        System.out.println("abc".equals(str5));//推荐写法：false
 //       System.out.println(str5.equals("abc"));//不推荐写法：报错，空指针异常NullPointreException
        System.out.println("===================");


        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB));//false,严格区分大小写
        System.out.println(strA.equalsIgnoreCase(strB));//true,忽略大小写


        //注意：只有英文字母区分大小写，其他一概不管
        System.out.println("abc一123".equalsIgnoreCase("abc壹123"));//false
    }
}

/*
String当中与获取相关的常用方法有：

public int length():获取字符串当中含有的字符个数，拿到字符串长度
public String concat(String str):将当前字符串和参数字符串拼接成为返回值新的字符串
public char charAt(int index):获取指定索引位置的单个字符。（索引从0开始）
public int indexOf(String str):查找参数字符串在本来字符串当中第一次出现的索引位置，如果没有则返回值-1.
 */
class StringGet {
    public static void main(String[] args) {
        //获取字符串的长度
        int length = "biudjkadjzxcbjkbjobd".length();
        System.out.println("字符串的长度是：" + length);

        //拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str1);//Hello，原封不动
        System.out.println(str2);//World原封不动
        System.out.println(str3);//HelloWorld，新的字符串
        System.out.println("=================");

        //获取指定索引位置的单个字符串
        char ch = "Hello".charAt(1);
        System.out.println("在1号索引位置的字符是：" + ch);//e
        System.out.println("=================");

        //查找参数字符串在本来字符串当中出现的第一次索引位置
        //如果根本没有，返回值-1
        String original = "HelloWorldHelloWorldHelloWorld";
        int index = original.indexOf("llo");
        System.out.println("第一次索引值为：" + index);//2

        System.out.println("HelloWorld".indexOf("abc"));//-1
    }
}


/*
字符串的截取方法：

public String substring(int index):截取从参数位置一直到字符串末尾，返回新的字符串
public String substring(int begin int end);截取从begin开始，一直到end结束，中间的字符串。
【备注】：[begin,end),包含左边，不包含右边.左开右闭区间的范围。
 */
class StringSub {
    public static void main(String[] args) {
        //
        String str1 = "HelloWorld";
        String str2 = str1.substring(5);
        System.out.println(str1);//HelloWorld,原封不动
        System.out.println(str2);//World,新的字符串
        System.out.println("================");

        String str3 = str1.substring(4,7);
        System.out.println(str3);//oWo
        System.out.println("================");

        //下面这种写法，字符串的内容仍然是没有改变的！
        //下面有两个字符串，"Hello","Java"
        //strA当中保存的是地址值
        //本来地址值是Hello的0x666
        //后来地址值变成了Java的0x999
        String strA = "Hello";
        System.out.println(strA);//Hello
        strA = "Java";
        System.out.println(strA);//Java
    }
}



/*
String当中与转换相关的常用方法有：

public char[] toCharArray():将当前字符串拆分成为字符数组作为返回值。
public byte[] getBytes():获得当前字符串底层的字节数组。
public String replace(CharSequence oldString,CharSequence newString):
将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串。
 */
class StringConvert {
    public static void main(String[] args) {
        //转换成为字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);//H
        System.out.println(chars.length);//5
        System.out.println("=============");

        //转换成为字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("==============");


        //字符串的内容替换
        String str1 = "How do you do ?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1);//How do you do ?
        System.out.println(str2);//H*w d* y*u d* ?

        String language1 = "会不会玩啊！你大爷的！你大爷的！！你大爷的！！！";
        String language2 = language1.replace("你大爷的","****");
        System.out.println(language2);//会不会玩啊！****！****！！****！！！

    }
}



/*
分割字符串的方法：
public String[] split(String regex):按照参数的规则，将字符串切分成为若干部分。

【注意事项】：
split方法的参数其实是一个“正则表达式”，今后会学到；
【重点】【特殊写法】今天要注意的是：如果按照英文句点"."进行切分，必须写"\\."(两个反斜杠)

 */
class StringSplit {
    public static void main(String[] args) {
        String str1 = "aaa,bbb,ccc";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("===============");

        String str2 = "aaa bbb ccc";
        String[] array2 = str2.split(" ");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("===============");


        String str3 = "xxx.yyy.zzz";
  //      String[] array3 = str3.split(".");//不加\\的写法，无法切分
        String[] array3 = str3.split("\\.");//想要用英文句点"."来分割字符串，就必须加两个反斜杠(\\)
  //      System.out.println(array3.length);//不加\\的字符串长度为0
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
}



/*
拼接字符串
定义一个方法，把数组{1,2,3}按照指定个格式拼接成一个字符串。格式参照如下：[word1#word2#word3]。

分析：
1.首先准备一个int[]数组，内容是：1,2,3,4
2.定义一个方法，用来将数组变成字符串
三要素：
返回值类型：String
方法名称：getArray
参数列表：int[]
3.格式：[word1#word2#word3]
用到：for循环、字符串拼接、每个数组元素之前都有一个word字样、分隔使用的是#、区分一下是不是最后一个
4.调用方法，得到返回值，并打印结果字符串。

 */
class StringPractise {
    public static void main(String[] args) {
        //定义一个int[]类型的数组
        int[] array = {1,2,3,4};

        //调用方法
        String result = getArray(array);
        //打印输出结果
        System.out.println(result);

    }
    /*
    *写方法是把数组中的元素按照指定的格式拼接成一个字符串
    *两个明确：
    * 返回值类型：String
    * 参数列表：int[] array
    *
     */
    public static String getArray(int[] array) {
        //创建字符串str
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            //遍历数组，并拼接字符串
            if(i == array.length-1) {
                str = str.concat("word" + array[i] + "]");
       //         str = str + "word" + array[i] + "]";//这样写也行
            } else {
                str = str.concat("word" + array[i] + "#");
       //        str = str + "word" + array[i] + "#";//这样写也行
            }
        }
        return str;
    }
}



/*
统计字符个数
键盘录入一个字符，统计字符串中大、小写字母、数字字符、其他字符的个数.
种类有：大写字母、小写字母、数字、其他字符

解题思路：
1.键盘输入——>Scanner；
2.键盘输入的是字符串，那么String str = sc.next();
3.定义四个变量，分别表示四种字符串各自出现的次数；
4.需要对字符串一个字、一个字检查，String-->char[],方法就是toCharArray()；
5.遍历字符数组，对当前字符的种类进行判断，并且用四个变量进行++动作；
6.打印输出四个变量，分别代表四种字符出现的次数。
 */
class StringCount {
    public static void main(String[] args) {
        //键盘录入一个字符串数据
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个字符串：");
        String input = sc.next();//获取键盘输入的一个字符串

        //定义四个统计变量，初始化值都为0
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        //对字符串逐字检查，将String转换为char类型，所用到的方法就是toCharArray()
        char[] charArray = input.toCharArray();
        //遍历字符串，得到每一个字符
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            //拿字符进行判断
            if('A'<= ch && ch <= 'Z') {
                countUpper++;
            } else if('a' <= ch && ch <= 'z') {
                countLower++;
            }else if('0' <= ch && ch <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }
        //输出结果
        System.out.println("大写字母的个数为：" + countUpper);
        System.out.println("小写字母的个数为：" + countLower);
        System.out.println("数字的个数为：" + countNumber);
        System.out.println("其他字符的个数为：" + countOther);

    }
}