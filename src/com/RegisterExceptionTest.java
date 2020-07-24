package com;

import java.util.Scanner;

/**
 * 自定义一个异常类，并进行测试
 * 【要求】模拟注册的操作，如果用户名已存在，就抛出异常
 *
 * 分析：1.使用数组保存已经注册过的用户名（数据库）
 *       2.使用Scanner获取用户输入的注册的用户名（前端、页面）
 *       3.定义一个方法，对用户输入的注册名进行判断
 *              遍历存储的已经注册过的用户名
 *              使用获取到的用户名和用户输入的用户名进行比较
 *                      true:
 *                          用户名已存在，抛出异常信息
 *                      false:
 *                          继续遍历比较
 *              如果循环结束了，还没找到重复的用户名，就提示“注册成功”
 */
public class RegisterExceptionTest {

    //1.使用数组保存已经注册过的用户名（数据库）
    static String[] usernames = { "张三", "李四", "王五"};
    public static void main(String[] args) throws RegisterException {
        //2.使用Scanner获取用户输入的注册的用户名（前端、页面）
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名：");
        String username = sc.next();

        checkUsername(username);
    }

    //3.定义一个方法，对用户输入的注册名进行判断
    public static void checkUsername(String username) throws RegisterException {
        //遍历存储的已经注册过的用户名
        for (String name : usernames) {
            //使用获取到的用户名和用户输入的用户名进行比较
            if(name.equals(username)) {
                //该用户名已存在
                throw new RegisterException("亲，该用户名已存在");
            }
        }
        //遍历结束，表示该用户名不存在，可以注册
        System.out.println("恭喜您，注册成功！");
    }
}

//自定义异常类
class RegisterException extends Exception{
    //空参构造
    public RegisterException() {
        super();
    }
    //带异常信息的构造方法
    public RegisterException(String message) {
        super(message);
    }
}