package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        //先给定逆波兰表达式
        //为了方便，将逆波兰表达式的数字和符号用空格隔开
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //先将表达式放入栈中去
        //将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("表达式为：" + list);
        int res = calculate(list);
        System.out.println("计算结果为：" + res);
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将表达式分割
        String[] splitString = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String ele : splitString) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建一个栈，就一个
        Stack<String> stack = new Stack<>();
        //遍历ls
        for(String item : ls) {
            //这里使用正则表达式来取出数
            if(item.matches("\\d+")) {//+表示匹配多位数
                //入栈
                stack.push(item);
            } else {
                //弹出两个数，并进行运算，最后再将其入栈
                int num2 = Integer.parseInt(stack.pop().trim());
                int num1 = Integer.parseInt(stack.pop().trim());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                } else if(item.equals("-")) {
                    res = num1 - num2;
                } else if(item.equals("*")) {
                    res = num1 * num2;
                } else if(item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！！");
                }
                //将结果入栈
                stack.push(" " + res);//结果是数字，要将其转换为字符串才能进行入栈，直接给数拼接一个空字符串
            }
        }
        //最后留在栈中的数据即为结果
        return Integer.parseInt(stack.pop().trim());
    }
}
